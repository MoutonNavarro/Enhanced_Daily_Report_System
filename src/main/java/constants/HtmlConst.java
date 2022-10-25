package constants;

import colors.ColorNameEnum;
import constants.interfaces.Html;

public enum HtmlConst {
	//General
	LANGUAGE("English(US)"),
	HTML_LANGUAGE("en"),

	//Base
	TEXT_NAME("Name"),
	TEXT_DATE("Date"),
	TEXT_TITLE("Title"),
	TEXT_ACTION("Operation"),
	TEXT_SEEDETAIL("See Detail"),
	TEXT_EMPLOYEE("Employee"),
	TEXT_EMPLOYEE_CODE("Employee code"),
	TEXT_PASSWORD("Password"),
	TEXT_CLAPS("Claps"),
	TEXT_NUMBER_OF_ALL_ITEMS("(All: ${count})"),
		TEXT_NUMBER_OF_ALL_ITEMS_L("(All: "),
		TEXT_NUMBER_OF_ALL_ITEMS_R(")"),
	TEXT_DISCRIPT_MAIN("The enhanced daily report management system by Mouton Navarro."),
	TEXT_DO_LOGIN("Login"),
	TEXT_CONTENT("Content"),
	TEXT_DATE_REGISTERED("Date registered"),
	TEXT_DATE_UPDATED("Date updated"),
	TEXT_SUBMIT("Submit"),
	TEXT_SEND("Send"),
	TEXT_BACK_TOP("Back to top page"),
	TEXT_GO_TOP("Go to top page"),
	TEXT_FORM_ERR("There is errors in input content."),

	//Report
	TEXT_REP_NUMBER_OF_ALL_ITEMS("(All: ${reports_count})"),
		TEXT_REP_NUMBER_OF_ALL_ITEMS_L("(All: "),
		TEXT_REP_NUMBER_OF_ALL_ITEMS_R(")"),
	TEXT_REP_SUBMIT_NEW("Register new daily report"),
	TEXT_REP_MINE("[Your daily report list]"),
	TEXT_REP_BACK_LIST("Back to the list"),

	//jsps
	//app.jsp
	//Header
	TEXT_HEAD_DAILY("Daily report management system"),
	TEXT_HEAD_DAILY_TITLE("Daily report management system"),
	TEXT_HEAD_MNGEMP("Manage employees"),
	TEXT_HEAD_MNGREP("Manage daily reports"),
	TEXT_HEAD_USERNAME("	Hi!&nbsp;<c:out value=\"${sessionScope.login_employee.name}\" />&nbsp;&nbsp;&nbsp;"),
		TEXT_HEAD_USERNAME_L("	Hi!&nbsp;"),
		TEXT_HEAD_USERNAME_R("&nbsp;&nbsp;&nbsp;"),
	TEXT_HEAD_SETTING("Setting"),
	TEXT_HEAD_LOGOUT("Logout"),


	//Footer
	TEXT_DISPLAY_LANG("English"),

	//topPage/index.jsp
	TEXT_WELCOME("Welcome to the daily report management system!"),

	//error/unknown.jsp
	TEXT_UNKNOWN("The page does not exist"),
	TEXT_UNKNOWN_FOLLOW("The following page does not exist <c:out value='${followPage}' />"),
		TEXT_UNKNOWN_FOLLOW_L("The following page does not exist "),
		TEXT_UNKNOWN_FOLLOW_R(""),

	//login/login.jsp
	TEXT_LOGIN("Login"),
	//login error
	TEXT_LOGIN_ERROR("The employee code or password or both are incorrect."),


	//configure/config.jsp
	TEXT_CONFIG_PAGE("Setting Page"),
	TEXT_CONFIG_ERROR("Errors in input content."),
	TEXT_CONFIG_COLOR_FG("Foreground color"),
	TEXT_CONFIG_COLOR_BG("Background color"),
	TEXT_CONFIG_COLOR_DEFAULT(ColorNameEnum.DEFAULT.getName()),
	TEXT_CONFIG_DISPLAY_LANG("Display language"),

	//reports
	//edit.jsp
	TEXT_REP_EDIT_PAGE("Daily report edit page"),

	//index.jsp
	TEXT_REP_LIST_PAGE("Daily report list"),

	//new.jsp
	TEXT_REP_NEW_PAGE("Daily report new registration page"),

	//show.jsp
	TEXT_REP_SHOW_PAGE("Daily report detail page"),
	TEXT_REP_CLAP("Clap"),
	TEXT_REP_CLAPPED("You clapped"),
	TEXT_REP_CLAPPED_EMPLOYEES("Clapped:&nbsp;"),
	TEXT_REP_CLAPPED_EMPLOYEE("[${clap.employee_name}]&nbsp;&nbsp;"),
		TEXT_REP_CLAPPED_EMPLOYEE_L("["),
		TEXT_REP_CLAPPED_EMPLOYEE_R("]&nbsp;&nbsp;"),
	TEXT_REP_EDIT("Edit this report"),
	;

	/**
	 * Field
	 */
	private final String htmlText;

	/**
	 * Constructor
	 */
	private HtmlConst(final String htmlText) {
		this.htmlText = htmlText;
	}

	/**
	 * Acquire the value
	 * @return HTML strings
	 */
	private String getValue() {
		return htmlText;
	}

	/**
	 * Acquire the value that localized
	 * @param lang LanguageClassConst type enum object
	 * @return Localized value (if no such declared value then original value)
	 */
	public String getValue(LanguageClassConst lang) {
		try {
			return ((Html)valueOf(lang.getHtml(), this.name())).getValue();
		}catch (IllegalArgumentException| NullPointerException e) {
			return getValue();
		}
	}

}
