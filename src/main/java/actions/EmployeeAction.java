package actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import constants.PropertyConst;
import services.EmployeeService;

/**
 * Action class that process relative to employee
 */
public class EmployeeAction extends ActionBase {

	private EmployeeService service;

	/**
	 * Run method
	 */
	@Override
	public void process() throws ServletException, IOException {
		try {
			service = new EmployeeService();

			//Do the method
			invoke();
		}finally {
			service.close();
		}

	}

	/**
	 * Displays list screen
	 * @throws ServletException
	 * @throws IOException
	 */
	public void index() throws ServletException, IOException{
		//Check whether administrator
		if (checkAdmin()) {
			//Acquire data for displays at list screen that specified number of page
			int page = getPage();
			List<EmployeeView> employees = service.getPerPage(page);

			//Acquire number of all employees data
			long employeeCount = service.countAll();

			putRequestScope(AttributeConst.EMPLOYEES, employees);	//Acquired employee data
			putRequestScope(AttributeConst.EMP_COUNT, employeeCount);	//Number of all employee data
			putRequestScope(AttributeConst.PAGE, page);	//Number of page
			putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE);	//Number of record at one page

			//When set flush message at the session then move to request scope and remove from the session
			String flush = getSessionScope(AttributeConst.FLUSH);
			if(flush != null) {
				putRequestScope(AttributeConst.FLUSH, flush);
				removeSessionScope(AttributeConst.FLUSH);
			}

			//Displays list screen
			forward(ForwardConst.FW_EMP_INDEX);
		}
	}

	/**
	 * Displays new register screen
	 * @throws ServletException
	 * @throws IOException
	 */
	public void entryNew() throws ServletException, IOException{

		//Check whether administrator
		if (checkAdmin()) {
			putRequestScope(AttributeConst.TOKEN, getTokenId());	//The token for anti-CSRF
			putRequestScope(AttributeConst.EMPLOYEE, new EmployeeView());	//Empty Employee instance

			//Displays new register screen
			forward(ForwardConst.FW_EMP_NEW);
		}
	}

	/**
	 * Registering new employee
	 * @throws ServletException
	 * @throws IOException
	 */
	public void create()throws ServletException, IOException{
		//Check anti-CSRF token and whether administrator
		if (checkToken() && checkAdmin()) {
			//Create instance of employee information based on parameter value
			EmployeeView ev = new EmployeeView(
				null,	getRequestParam(AttributeConst.EMP_CODE),
				getRequestParam(AttributeConst.EMP_NAME),
				getRequestParam(AttributeConst.EMP_PASS),
				toNumber(getRequestParam(AttributeConst.EMP_ADMIN_FLG)),
				null,	null,	AttributeConst.DEL_FLAG_FALSE.getIntegerValue());

			//Acquire pepper string from the application scope
			String pepper = getContextScope(PropertyConst.PEPPER);

			//Registering the employee information
			List<String> errors = service.create(ev, pepper, getSessionScope(AttributeConst.LANGUAGE));

			if(errors.size() > 0) {
				//when errors occurred at registration

				putRequestScope(AttributeConst.TOKEN, getTokenId());	//The token for anti-CSRF
				putRequestScope(AttributeConst.EMPLOYEE, ev);	//Input employee information
				putRequestScope(AttributeConst.ERR, errors);		//List of errors
				putRequestScope(AttributeConst.LINK, request.getRequestURL() + "?action=Employee&command=entryNew");	//Set as post link

				//Re-display new register screen
				forward(ForwardConst.FW_EMP_NEW);
			}else {
				//When no errors occurred at registration

				//Set message about registration successful at the session
				putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage(getSessionScope(AttributeConst.LANGUAGE)));

				//Redirect to list screen
				redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);
			}
		}

	}

	/**
	 * Displays detail screen
	 * @throws ServletException
	 * @throws IOException
	 */
	public void show() throws ServletException, IOException{
		//Check whether administrator
		if (checkAdmin()) {
			//Acquire employee data with ID as condition
			EmployeeView ev = service.findOne(toNumber(getRequestParam(AttributeConst.EMP_ID)));

			if(ev == null || ev.getDeleteFlag() == AttributeConst.DEL_FLAG_TRUE.getIntegerValue()) {
				//If chouldn't acquire the data, or logical deleted then displays error screen
				forward(ForwardConst.FW_ERR_UNKNOWN);
				return;
			}

			putRequestScope(AttributeConst.EMPLOYEE, ev); //Acquired employee information

			//Displays detail screen
			forward(ForwardConst.FW_EMP_SHOW);
		}
	}

	/**
	 * Displays edit screen
	 * @throws ServletException
	 * @throws IOException
	 */
	public void edit() throws ServletException, IOException{

		//Check whether administrator
		if (checkAdmin()) {
			//Acquires an employee data with The ID as condition
			EmployeeView ev = service.findOne(toNumber(getRequestParam(AttributeConst.EMP_ID)));

			if (ev == null || ev.getDeleteFlag() == AttributeConst.DEL_FLAG_TRUE.getIntegerValue()) {
				//Displays error screen if couldn't acquire the data or logical deleted it
				forward(ForwardConst.FW_ERR_UNKNOWN);
				return;
			}

			putRequestScope(AttributeConst.TOKEN, getTokenId());	//The token for anti-CSRF
			putRequestScope(AttributeConst.EMPLOYEE, ev);	//Acquired employee information

			//Displays edit screen
			forward(ForwardConst.FW_EMP_EDIT);
		}
	}

	/**
	 * Updating
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update() throws ServletException, IOException{

		//Anti-CSRF token check and whether administrator
		if (checkToken() && checkAdmin()) {
			int admin_flag = 0;
			List<String> errors = new ArrayList<>();
			if (((EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP)).getId() == toNumber(getRequestParam(AttributeConst.EMP_ID))) {
				if (toNumber(getRequestParam(AttributeConst.EMP_ADMIN_FLG)) != 1) {
//					errors.add(MessageConst.E_EMP_CANNOT_CHANGE_RIGHT.getMessage(getSessionScope(AttributeConst.LANGUAGE)));
					admin_flag = 1;
				}

			}else {
				admin_flag = toNumber(getRequestParam(AttributeConst.EMP_ADMIN_FLG));
			}
			//Create the instance of employee information based on the parameter's value
			EmployeeView ev = new EmployeeView(
				toNumber(getRequestParam(AttributeConst.EMP_ID)),
				getRequestParam(AttributeConst.EMP_CODE),
				getRequestParam(AttributeConst.EMP_NAME),
				getRequestParam(AttributeConst.EMP_PASS),
				admin_flag,
				null,	null,	AttributeConst.DEL_FLAG_FALSE.getIntegerValue());

			//Acquires pepper string from the application scope
			String pepper = getContextScope(PropertyConst.PEPPER);

			if (errors.size() == 0) {
				try {
					//Update employee information
					errors = service.update(ev, pepper, getSessionScope(AttributeConst.LANGUAGE));
				}catch(NullPointerException e) {	//If specified ID does not exist
					//Redirect to the list screen
					redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);
					return;
				}
			}

			if(errors.size() > 0) {
				//In case errors occurred at updating

				putRequestScope(AttributeConst.TOKEN, getTokenId());	//The token for anti-CSRF
				putRequestScope(AttributeConst.EMPLOYEE, ev);	//Input employee information
				putRequestScope(AttributeConst.ERR, errors);	//List of errors
				putRequestScope(AttributeConst.LINK, request.getRequestURL() + "?action=Employee&command=edit&id=" + ev.getId());	//Set as post link

				//Re-displays edit screen
				forward(ForwardConst.FW_EMP_EDIT);
			}else {
				//In case no errors occurred at updating

				//Set update complete flush message at the session
				putSessionScope(AttributeConst.FLUSH, MessageConst.I_UPDATED.getMessage(getSessionScope(AttributeConst.LANGUAGE)));

				//Redirect to the list screen
				redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);
			}
		}
	}

	/**
	 * Logical deleting
	 * @throws ServletException
	 * @throws IOException
	 */
	public void destroy() throws ServletException, IOException{
		//Anti-CSRF token check and whether administrator
		if(checkToken() && checkAdmin()) {
			int emp_id;
			if (((EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP)).getId() == (emp_id = toNumber(getRequestParam(AttributeConst.EMP_ID)))) {
//				EmployeeView ev = service.findOne(toNumber(getRequestParam(AttributeConst.EMP_ID)));
//				List<String> errors = new ArrayList<>();
//				errors.add(MessageConst.E_EMP_CANNOT_DELETE.getMessage(getSessionScope(AttributeConst.LANGUAGE)));
//				putRequestScope(AttributeConst.TOKEN, getTokenId());	//The token for anti-CSRF
//				putRequestScope(AttributeConst.EMPLOYEE, ev);	//Acquired employee information
//				putRequestScope(AttributeConst.ERR, errors);	//List of errors
//				putRequestScope(AttributeConst.LINK, request.getRequestURL() + "?action=Employee&command=edit&id=" + ev.getId());	//Set as post link
//
//				//Re-displays edit screen
//				forward(ForwardConst.FW_EMP_EDIT);
//				return;

				//Redirect to the list screen
				redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);
				return;
			}
//			try {
				//Logical delete the employee data with ID as condition
				if(service.destroy(emp_id)) {
					//Set delete complete flush message at the session
					putSessionScope(AttributeConst.FLUSH, MessageConst.I_DELETED.getMessage(getSessionScope(AttributeConst.LANGUAGE)));
				}
//			}catch (NullPointerException e) {
//				//Redirect to the list screen
//				redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);
//				return;
//			}

			//Redirect to the list screen
			redirect(ForwardConst.ACT_EMP, ForwardConst.CMD_INDEX);
		}
	}

	/**
	 * Check whether logging in employee is administrator and displays error screen if it not an administrator
	 * true: Administrator  false: Not an administrator
	 * @throws ServletException
	 * @throws IOException
	 */
	private boolean checkAdmin() throws ServletException, IOException{
		//Acquire logging in employee information at the session
		EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

		//Displays error screen if not administrator
		if (ev.getAdminFlag() != AttributeConst.ROLE_ADMIN.getIntegerValue()) {
			forward(ForwardConst.FW_ERR_UNKNOWN);
			return false;
		}else {
			return true;
		}
	}

}
