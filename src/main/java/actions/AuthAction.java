package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import constants.AttributeConst;
import constants.ForwardConst;
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
		service = new EmployeeService();

		//Run a method
		invoke();

		service.close();
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

}
