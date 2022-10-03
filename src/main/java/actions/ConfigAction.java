package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.ConfigureView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.MessageConst;

public class ConfigAction extends ActionBase {

	@Override
	public void process() throws ServletException, IOException {

		//Run method
		invoke();

	}

	/**
	 * Update user's configure
	 * @throws ServletException
	 * @throws IOException
	 */
	public void edit() throws ServletException, IOException{
		//[Temporary] We must configure the databese for configure function
		putRequestScope(AttributeConst.TOKEN, getTokenId());	//The token for anti-CSRF
		ConfigureView cv = getSessionScope(AttributeConst.CONFIG);	//Get ConfigureView from the session if there.
		if (cv == null) {
			cv = new ConfigureView("", "", "", "UTC+09:00");	//Empty Employee instance
//			putSessionScope(AttributeConst.CONFIG_COLOR, "");
//			putSessionScope(AttributeConst.CONFIG_BG, "");
//			putSessionScope(AttributeConst.CONFIG_LANGUAGE, "");
//			putSessionScope(AttributeConst.CONFIG_TIMEZONE, "UTC+09:00");

		}
		putRequestScope(AttributeConst.CONFIG, cv);
		forward(ForwardConst.FW_CONFIG);
	}

	/**
	 * Update user's configure
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update() throws ServletException, IOException{
		//[Temporary] We must configure the databese for configure function
		//check the token for anti-CSRF
		if (checkToken()) {
			ConfigureView cv = new ConfigureView(
				getRequestParam(AttributeConst.CONFIG_COLOR),
				getRequestParam(AttributeConst.CONFIG_BG),
				getRequestParam(AttributeConst.CONFIG_LANGUAGE),
				getRequestParam(AttributeConst.CONFIG_TIMEZONE));
			//[Locked]We must implement the ConfigureValidator.class
			putSessionScope(AttributeConst.CONFIG, cv);

			putSessionScope(AttributeConst.FLUSH, MessageConst.I_CONFIG_UPDATED.getMessage());
			redirect(ForwardConst.ACT_TOP, ForwardConst.CMD_INDEX);
			return;
		}
		forward(ForwardConst.FW_ERR_UNKNOWN);

	}

}
