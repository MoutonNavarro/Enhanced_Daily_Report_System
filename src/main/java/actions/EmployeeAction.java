package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
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
		service = new EmployeeService();

		//Do the method
		invoke();

		service.close();

	}

	/**
	 * Displays list screen
	 * @throws ServletException
	 * @throws IOException
	 */
	public void index() throws ServletException, IOException{
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

	/**
	 * Displays new register screen
	 * @throws ServletException
	 * @throws IOException
	 */
	public void entryNew() throws ServletException, IOException{

		putRequestScope(AttributeConst.TOKEN, getTokenId());	//The token for anti-CSRF
		putRequestScope(AttributeConst.EMPLOYEE, new EmployeeView());	//Empty Employee instance

		//Displays new register screen
		forward(ForwardConst.FW_EMP_NEW);
	}

}
