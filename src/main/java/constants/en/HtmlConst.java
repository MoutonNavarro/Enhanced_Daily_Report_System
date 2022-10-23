package constants.en;

import constants.interfaces.Html;

public enum HtmlConst implements Html{

	//General
	LANGUAGE("English(US)"),

	//Base
	TEXT_NAME("Name"),
	TEXT_DATE("Date"),
	TEXT_TITLE("Title"),
	TEXT_ACTION("Action"),
	TEXT_SEEDETAIL("See Detail"),
	TEXT_NUMBER_OF_ALL_ITEMS("(All: ${count})"),
	TEXT_DISCRIPT_MAIN("The enhanced daily report management system by Mouton Navarro."),

	//Report
	TEXT_REP_NUMBER_OF_ALL_ITEMS("(All: ${reports_count})"),
	TEXT_REP_SUMBIT_NEW("Register new daily report"),
	TEXT_REP_MINE("[Your daily report list]"),

	//jsps
	//app.jsp
	//Header
	TEXT_HEAD_DAILY("Daily report management system"),
	TEXT_HEAD_DAILY_TITLE("Daily report management system"),
	TEXT_HEAD_MNGEMP("Manage employees"),
	TEXT_HEAD_MNGREP("Manage daily reports"),
	TEXT_HEAD_USERNAME("	Hi!&nbsp;<c:out value=\"${sessionScope.login_employee.name}\" />&nbsp;&nbsp;&nbsp;"),

	//Footer
	TEXT_DISPLAY_LANG("English"),

	//topPage/index.jsp
	TEXT_WELCOME("Welcome to the daily report management system!"),

	//error/unknown.jsp
	TEXT_UNKNOWN("The page does not exist"),
	TEXT_UNKNOWN_FOLLOW("The following page does not exist <c:out value='${followPage}' />");

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
