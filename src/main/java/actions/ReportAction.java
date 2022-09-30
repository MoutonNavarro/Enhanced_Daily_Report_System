package actions;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import services.ReportService;

/**
 * Action class that do process relative to reports
 */
public class ReportAction extends ActionBase {

	private ReportService service;

	/**
	 * Do the method
	 */
	@Override
	public void process() throws ServletException, IOException {

		service = new ReportService();

		//Do method
		invoke();
		service.close();

	}

	/**
	 * Displays list screen
	 * @throws ServletException
	 * @throws IOException
	 */
	public void index() throws ServletException, IOException{
		//Acquires report data for displays list screen of number of specified page
		int page = getPage();
		List<ReportView> reports = service.getAllPerPage(page);

		//Acquires number of all report data
		long reportsCount = service.countAll();

		putRequestScope(AttributeConst.REPORTS, reports);	//Acquired report data
		putRequestScope(AttributeConst.REP_COUNT, reportsCount);	//Number of all report data
		putRequestScope(AttributeConst.PAGE, page);	//Number of page
		putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE);	//Number of record for displays at one page

		//If there is set flush message at the session then move to request scope and delete from the session
		String flush = getSessionScope(AttributeConst.FLUSH);
		if(flush != null) {
			putRequestScope(AttributeConst.FLUSH, flush);
			removeSessionScope(AttributeConst.FLUSH);
		}

		//Displays list screen
		forward(ForwardConst.FW_REP_INDEX);
	}

	/**
	 * Displays new registration screen
	 * @throws ServletException
	 * @throws IOException
	 */
	public void entryNew() throws ServletException, IOException{

		putRequestScope(AttributeConst.TOKEN, getTokenId());	//the token for anti-CSRF

		//Set the report's date = today's date to empty instance of report information
		ReportView rv = new ReportView();
		rv.setReportDate(LocalDate.now());
		putRequestScope(AttributeConst.REPORT, rv);	//Report instance with set only date

		//Displays new registration screen
		forward(ForwardConst.FW_REP_NEW);
	}

	/**
	 * Do registration
	 * @throws ServletException
	 * @throws IOException
	 */
	public void create() throws ServletException, IOException{

		//Anti-CSRF token check
		if (checkToken()) {

			//Set today's date if there isn't input date at the report
			LocalDate day = null;
			if(getRequestParam(AttributeConst.REP_DATE) == null
				|| getRequestParam(AttributeConst.REP_DATE).equals("")) {
				day = LocalDate.now();
			}else {
				day = LocalDate.parse(getRequestParam(AttributeConst.REP_DATE));
			}
			//Acquire logged in employee from the session
			EmployeeView ev = (EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP);

			//Create an instance of the report based on the parameter's value
			ReportView rv = new ReportView(
				null,
				ev,	//Register logged in employee as a report creator
				day,
				getRequestParam(AttributeConst.REP_TITLE),
				getRequestParam(AttributeConst.REP_CONTENT),
				null,
				null);

			//Register the report information
			List<String> errors = service.create(rv);

			if(errors.size() > 0) {
				//Errors occurred at registration

				putRequestScope(AttributeConst.TOKEN, getTokenId());	//The token for anti-CSRF
				putRequestScope(AttributeConst.REPORT, rv);	//Input the report information
				putRequestScope(AttributeConst.ERR, errors);	//List of errors

				//Re-display the new registration screen
				forward(ForwardConst.FW_REP_NEW);
			}else {
				//In case no errors occurred

				//Set flush message of registration complete at the session
				putSessionScope(AttributeConst.FLUSH, MessageConst.I_REGISTERED.getMessage());

				//Redirect to the list screen
				redirect(ForwardConst.ACT_REP, ForwardConst.CMD_INDEX);
			}
		}

	}
}
