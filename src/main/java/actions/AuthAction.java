package actions;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;

import actions.views.ConfigureView;
import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.DeclaredLanguage;
import constants.ForwardConst;
import constants.LanguageClassConst;
import constants.MessageConst;
import constants.PropertyConst;
import services.ConfigureService;
import services.EmployeeService;

/**
 * Action class that process relative to authentication
 */
public class AuthAction extends ActionBase {

	private EmployeeService service;

	/**
	 * Run a method
	 */
	@Override
	public void process() throws ServletException, IOException {

		try {
			service = new EmployeeService();

			//Run a method
			invoke();
		}finally {
			service.close();
		}

	}

	/**
	 * Displays login screen
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showLogin() throws ServletException, IOException{
		//Set the token for anti-CSRF
		putRequestScope(AttributeConst.TOKEN, getTokenId());

		//In case registered flush message at the session then move to the request scope and delete from the session
		String flush = getSessionScope(AttributeConst.FLUSH);
		if (flush != null) {
			putRequestScope(AttributeConst.FLUSH, flush);
			removeSessionScope(AttributeConst.FLUSH);
		}

		//Displays login screen
		forward(ForwardConst.FW_LOGIN);
	}

	/**
	 * Do logging in process
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login() throws ServletException, IOException{

		String code = getRequestParam(AttributeConst.EMP_CODE);
		String plainPass = getRequestParam(AttributeConst.EMP_PASS);
		String pepper = getContextScope(PropertyConst.PEPPER);

		//Authentication whether the employee is valid
		Boolean isValidEmployee = service.validateLogin(code, plainPass, pepper);

		if (isValidEmployee) {
			//In case authentication is success

			//Anti-CSRF token check
			if(checkToken()) {
				//Acquire DB data of logged in employee
				EmployeeView ev = service.findOne(code, plainPass, pepper);
				//Set logged in employee at the session
				putSessionScope(AttributeConst.LOGIN_EMP, ev);
				//Set language enum from the configure
				try (ConfigureService cs = new ConfigureService();){
					ConfigureView cv;
					if (getSessionScope(AttributeConst.LANGUAGE_POST) == null) {
							if (null != (cv = cs.findOne(ev.getId()))){
								putSessionScope(AttributeConst.LANGUAGE, DeclaredLanguage.getByConfigureView(cv));
							}
						//Set flush message at the session: Login successful
						putSessionScope(AttributeConst.FLUSH, MessageConst.I_LOGINED.getMessage(getSessionScope(AttributeConst.LANGUAGE)));
					}

				}
				//Redirect to the top page
				redirect(ForwardConst.ACT_TOP, ForwardConst.CMD_INDEX);
			}
		}else {
			//In case authentication failure

			//Set the token for the anti-CSRF
			putRequestScope(AttributeConst.TOKEN, getTokenId());
			//Raise the authentication failure error message flag
			putRequestScope(AttributeConst.LOGIN_ERR, true);
			//Set input employee code
			putRequestScope(AttributeConst.EMP_CODE, code);
			putRequestScope(AttributeConst.LINK, request.getRequestURL() + "?action=Auth&command=showLogin");	//Set as post link

			//Displays login screen
			forward(ForwardConst.FW_LOGIN);
		}
	}

	/**
	 * Do logging out process
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout() throws ServletException, IOException{
		if (getSessionScope(AttributeConst.LANGUAGE_POST) != null) {	//Initialize the logged out employee's configuration if the employee had changed the display language when the employee never been accessed configuration.
			try (ConfigureService cs = new ConfigureService();){
				int id;
				if (null == cs.findOne(id = ((EmployeeView)getSessionScope(AttributeConst.LOGIN_EMP)).getId())) {
					LanguageClassConst lcc = getSessionScope(AttributeConst.LANGUAGE);
					LocalDateTime ldt = LocalDateTime.now();
					ConfigureView cv = new ConfigureView(id, ldt, ldt, lcc.getLanguageCode(), lcc.getLanguageCountry(), "UTC+09:00", "", (byte)2, "default", false, false, "", "", false);	//Empty Configure instance
					cs.create(cv);	//Initialize the employee's configuration
				}

			}
		}
		//Delete login employee's parameter at the session
		removeSessionScope(AttributeConst.LOGIN_EMP);
		removeSessionScope(AttributeConst.CONFIG);

		//Append flush message when logged out at the session
		putSessionScope(AttributeConst.FLUSH, MessageConst.I_LOGOUT.getMessage(getSessionScope(AttributeConst.LANGUAGE)));

		//redirect to the login screen
		redirect(ForwardConst.ACT_AUTH, ForwardConst.CMD_SHOW_LOGIN);
	}

}
