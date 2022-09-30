package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
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

}
