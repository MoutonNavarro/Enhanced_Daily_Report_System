package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.ReportView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import services.ClapService;
import services.ReportService;

public class ClapAction extends ActionBase {

	private ClapService service;

	@Override
	public void process() throws ServletException, IOException {
		try {
			service = new ClapService();

			//Run method
			invoke();

		}finally{
			service.close();
		}

	}

	/**
	 * Do reaction
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doReaction() throws ServletException, IOException{
		//check the token for anti-CSRF
		if (checkToken()){
			ReportView rv = null;
			{
				ReportService rs = null;
				try {
					rs = new ReportService();
					rv = rs.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));
				}finally {
					rs.close();
				}
			}
			if (rv != null) {	//The input report is exists
				int rep_id = rv.getId();	//Report ID
				int emp_id = ((EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP)).getId();
				List<String> errors = service.doReaction(rep_id, emp_id, JpaConst.CLAP_REACT_CLAP);
				if (errors.size() > 0) {
					putSessionScope(AttributeConst.ERR, errors);	//List of errors
				}else {
					putSessionScope(AttributeConst.FLUSH, MessageConst.I_CLAPPED.getMessage(getSessionScope(AttributeConst.LANGUAGE)));
				}
				//Redirect to the detail screen
				redirectInternal(ForwardConst.ACT_REP, ForwardConst.CMD_SHOW, rv.getId());
				return;
			}else {
				redirectInternal(ForwardConst.ACT_REP, ForwardConst.CMD_SHOW, toNumber(getRequestParam(AttributeConst.REP_ID)));
				return;
			}
		}
		forward(ForwardConst.FW_ERR_UNKNOWN);

	}

	/**
	 * Undo reaction
	 * @throws ServletException
	 * @throws IOException
	 */
	public void undoReaction() throws ServletException, IOException{
		//check the token for anti-CSRF
		if (checkToken()){
			int rep_id = toNumber(getRequestParam(AttributeConst.REP_ID));	//Acquire report ID
			int emp_id = ((EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP)).getId();
			List<String> errors = service.undoReaction(rep_id, emp_id);
			if (errors.size() > 0) {
				putSessionScope(AttributeConst.ERR, errors);	//List of errors
			}else {
				putSessionScope(AttributeConst.FLUSH, MessageConst.I_UNDID_CLAP.getMessage(getSessionScope(AttributeConst.LANGUAGE)));
			}
			//Redirect to the detail screen
			redirectInternal(ForwardConst.ACT_REP, ForwardConst.CMD_SHOW, toNumber(getRequestParam(AttributeConst.REP_ID)));
			return;
		}
		forward(ForwardConst.FW_ERR_UNKNOWN);

	}

	/**
	 * Construct URL and do redirect with ID
	 * @param action Value that set to the parameter
	 * @param command Value that set to the parameter
	 * @param id Value that set to the parameter
	 * @throws ServletException
	 * @throws IOException
	 */
	private void redirectInternal(ForwardConst action, ForwardConst command, int id) throws ServletException, IOException{
		//Construct the URL
		String redirectUrl = request.getContextPath() + "/?action=" + action.getValue();
		if (command != null) {
			redirectUrl = redirectUrl + "&command=" + command.getValue() + "&id=" + id;
		}

		//Redirect to the URL
		response.sendRedirect(redirectUrl);
	}

}
