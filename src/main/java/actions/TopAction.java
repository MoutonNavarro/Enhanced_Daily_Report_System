package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import services.ReportService;

/**
 * Action class that processing relative to the top page
 */
public class TopAction extends ActionBase {

	private ReportService service;

	/**
	 * Run index method
	 */
	@Override
	public void process() throws ServletException, IOException {

		service = new ReportService();

		//Run method
		invoke();

		service.close();

	}

	/**
	 * Displays list screen
	 */
	public void index() throws ServletException, IOException{

		//Acquire logged in employee information from the session
		EmployeeView loginEmployee = (EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP);

		//Acquire report data created by logged in employee for the specified number of pages to be displayed on the list screen
		int page = getPage();
		List<ReportView> reports = service.getMinePerPage(loginEmployee, page);

		//Acquires number of report data created by logged in employee
		long myReportsCount = service.countAllMine(loginEmployee);

		putRequestScope(AttributeConst.REPORTS, reports);	//Acquired report data
		putRequestScope(AttributeConst.REP_COUNT, myReportsCount);	//Number of reports created by logged in employee
		putRequestScope(AttributeConst.PAGE, page);	//Number of page
		putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE);	//Number of records displays at one page


		//If set flush message at the session then move these to the request scope and delete from the session
		String flush = getSessionScope(AttributeConst.FLUSH);
		if (flush != null) {
			putRequestScope(AttributeConst.FLUSH, flush);
			removeSessionScope(AttributeConst.FLUSH);
		}

		//Displays list screen
		forward(ForwardConst.FW_TOP_INDEX);
	}

}
