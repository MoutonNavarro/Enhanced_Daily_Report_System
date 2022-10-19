package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.MessageConst;
import services.ClapService;

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
			int rep_id = toNumber(getRequestParam(AttributeConst.REP_ID));	//Acquire report ID
			int emp_id = ((EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP)).getId();
			List<String> errors = service.doReaction(rep_id, emp_id, JpaConst.CLAP_REACT_CLAP);
			if (errors.size() > 0) {
				putSessionScope(AttributeConst.ERR, errors);	//List of errors
			}else {
				putSessionScope(AttributeConst.FLUSH, MessageConst.I_CLAPPED.getMessage());
			}
			//Redirect to the list screen
			redirect(ForwardConst.ACT_REP, ForwardConst.CMD_INDEX);
			return;
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
				putSessionScope(AttributeConst.FLUSH, MessageConst.I_UNDID_CLAP.getMessage());
			}
			//Redirect to the list screen
			redirect(ForwardConst.ACT_REP, ForwardConst.CMD_INDEX);
			return;
		}
		forward(ForwardConst.FW_ERR_UNKNOWN);

	}

}
