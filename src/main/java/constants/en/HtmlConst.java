package constants.en;

import colors.ColorNameEnum;
import constants.interfaces.Html;

/**
 * Enum class that define text relative to html for localize
 */
public enum HtmlConst implements Html{

	//General
	LANGUAGE("English(US)"),
	HTML_LANGUAGE("en"),
	EXAM_MESSAGE(null),

	//Base
	TEXT_NAME("Name"),
	TEXT_DATE("Date"),
	TEXT_TITLE("Title"),
	TEXT_ACTION("Action"),
	TEXT_SEEDETAIL("See Detail"),
	TEXT_EMPLOYEE("Employee"),
	TEXT_EMPLOYEE_CODE("Employee code"),
	TEXT_PASSWORD("Password"),
	TEXT_CLAPS("Claps"),
	TEXT_PRIVILEGES("Privileges"),
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

	//Employee
	TEXT_EMP_NUMBER_OF_ALL_ITEMS("(All: ${reports_count})"),
		TEXT_EMP_NUMBER_OF_ALL_ITEMS_L("(All: "),
		TEXT_EMP_NUMBER_OF_ALL_ITEMS_R(")"),
	TEXT_EMP_ADMIN_RIGHT("Administrator privileges"),
	TEXT_EMP_GENERAL("General"),
	TEXT_EMP_ADMIN("Administrator"),
	TEXT_EMP_ADMIN_ONLY("Administrator"),
	TEXT_EMP_GENERAL_LOCK("(Locked)"),
	TEXT_EMP_BACK_LIST("Back to the list"),

	//Report
	TEXT_REP_NUMBER_OF_ALL_ITEMS("(All: ${reports_count})"),
		TEXT_REP_NUMBER_OF_ALL_ITEMS_L("(All: "),
		TEXT_REP_NUMBER_OF_ALL_ITEMS_R(")"),
	TEXT_REP_SUBMIT_NEW("Register new daily report"),
	TEXT_REP_MINE("[Your daily report list]"),
	TEXT_REP_BACK_LIST("Back to list page"),

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
	TEXT_CAUTION_LANGUAGE("It's defferent the current language of configuration and displaying language (session)."
		+ "<br>If you decition to configuration then the session's will be changed same as configuration's"),

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
	TEXT_REP_CLAPPED("Clapped"),
	TEXT_REP_CLAPPED_EMPLOYEES("Clapped:&nbsp;"),
	TEXT_REP_CLAPPED_EMPLOYEE("[${clap.employee_name}]&nbsp;&nbsp;"),
		TEXT_REP_CLAPPED_EMPLOYEE_L("["),
		TEXT_REP_CLAPPED_EMPLOYEE_R("]&nbsp;&nbsp;"),
	TEXT_REP_EDIT("Edit this report"),

	//employees
	//edit.jsp
	TEXT_EMP_EDIT_PAGE("ID: ${employee.id}'s employee information edit page"),
		TEXT_EMP_EDIT_PAGE_L("ID: "),
		TEXT_EMP_EDIT_PAGE_R("'s employee information edit page"),
	TEXT_EMP_EDIT_NOTE_PASSWORD("(Please input password only when you change it)"),
	TEXT_EMP_DELETE("DELETE THIS EMPLOYEE INFORMATION"),
	TEXT_EMP_CANNOT_DELETE("(You cannot delete your employee information yourself!)"),
	TEXT_EMP_DELETE_CONFIRM("REALLY DELETE THIS EMPLOYEE?"),

	//index.jsp
	TEXT_EMP_LIST_PAGE("Employee list"),
	TEXT_EMP_DELETED("(Terminated)"),
	TEXT_EMP_REGISTER("Register new employee"),

	//new.jsp
	TEXT_EMP_NEW_PAGE("Employee new register page"),

	//show.jsp
	TEXT_EMP_SHOW_PAGE("ID: ${employee.id}'s employee information detail page"),
		TEXT_EMP_SHOW_PAGE_L("ID: "),
		TEXT_EMP_SHOW_PAGE_R("'s employee information detail page"),
	TEXT_EMP_EDIT("Edit this employee information"),

	//single actions
	TEXT_WARN_RESET("If you do that then the input content on the page will be reset. Are you sure you want to do it?"),
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
	 * Acquire the value(String)
	 */
	public String getValue() {
		return this.htmlText;
	}

}
