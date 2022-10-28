package actions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.ConfigureView;
import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.JpaConst;
import constants.LanguageClassConst;
import constants.MessageConst;
import services.ConfigureService;

public class ConfigAction extends ActionBase {

	private ConfigureService service;

	@Override
	public void process() throws ServletException, IOException {
		try {
			service = new ConfigureService();

			//Run method
			invoke();

		}finally{
			service.close();
		}

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
		if (cv == null && null == (cv = service.findOne(((EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP)).getId()))) {
			LocalDateTime ldt = LocalDateTime.now();
			int id = ((EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP)).getId();
			cv = new ConfigureView(id, ldt, ldt, "eng", "usa", "UTC+09:00", "", (byte)2, "default", false, false, "", "", false);	//Empty Configure instance
			service.create(cv);	//The initialization timing may change after update
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
		//check the token for anti-CSRF
		ConfigureView cv = null;
		if (checkToken() && null != (
				cv = service.findOne(((EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP)).getId())
				)){
			//[Locked] We must implements the language constants
			cv.setLanguage(getRequestParam(AttributeConst.CONFIG_LANGUAGE));
			//[Locked] We must implements the time zone function
//			cv.setTime_zone(getRequestParam(AttributeConst.CONFIG_TIMEZONE));
			cv.setUser_color(getRequestParam(AttributeConst.CONFIG_COLOR));
			//[Locked] We must tunes colour management
//			cv.setUser_background(getRequestParam(AttributeConst.CONFIG_BG));
			//[Unlocked]ConfigureValidator.class has been implemented
			List<String> errors = service.update(cv, getSessionScope(AttributeConst.LANGUAGE));
			if (LanguageClassConst.getByLanguageName(getRequestParam(AttributeConst.CONFIG_LANGUAGE)) == null) {	//Temporary
				errors.add(MessageConst.E_NO_SUCH_LANGUAGE.getMessage(getSessionScope(AttributeConst.LANGUAGE)));	//
			}																																			//
			if (errors.size() > 0) {
				putRequestScope(AttributeConst.TOKEN, getTokenId());	//The token for anti-CSRF
				putRequestScope(AttributeConst.CONFIG, cv);	//Input the report information
				putRequestScope(AttributeConst.ERR, errors);	//List of errors

				//Re-displays edit screen
				forward(ForwardConst.FW_CONFIG);
				return;
			}


			if (((EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP)).getAdminFlag() == JpaConst.ROLE_ADMIN) {
				putSessionScope(AttributeConst.CONFIG, cv);
			}
			putSessionScope(AttributeConst.LANGUAGE, LanguageClassConst.getByConfigureView(cv));
			removeSessionScope(AttributeConst.LANGUAGE_POST);

			putSessionScope(AttributeConst.FLUSH, MessageConst.I_CONFIG_UPDATED.getMessage(getSessionScope(AttributeConst.LANGUAGE)));
			System.out.println(((LanguageClassConst)getSessionScope(AttributeConst.LANGUAGE)).getDisplayName());
			redirect(ForwardConst.ACT_TOP, ForwardConst.CMD_INDEX);
			return;
		}
		forward(ForwardConst.FW_ERR_UNKNOWN);

	}

}
