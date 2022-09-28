package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import constants.AttributeConst;
import constants.ForwardConst;

/**
 * Action class that processing relative to the top page
 */
public class TopAction extends ActionBase {

	/**
	 * Run index method
	 */
	@Override
	public void process() throws ServletException, IOException {

		//Run method
		invoke();

	}

	/**
	 * Displays list screen
	 */
	public void index() throws ServletException, IOException{
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
