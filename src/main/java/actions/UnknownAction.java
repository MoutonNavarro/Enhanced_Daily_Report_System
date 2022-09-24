package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import constants.ForwardConst;

/**
 * Action class that do process when error occurred
 */
public class UnknownAction extends ActionBase {

	/**
	 * Displays common error screen "Page is not found"
	 */
	@Override
	public void process() throws ServletException, IOException {
		//Displays error screen
		forward(ForwardConst.FW_ERR_UNKNOWN);
	}

}
