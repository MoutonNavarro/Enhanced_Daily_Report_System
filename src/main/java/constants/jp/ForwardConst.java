package constants.jp;

/**
 * Enum class that defines relative the forward screen that request parameter variable names, variable value, jsp file's name, and else.
 */
public enum ForwardConst {
	//action
	ACT("action"),
	ACT_TOP("Top"),
	ACT_EMP("Employee"),
	ACT_REP("Report"),
	ACT_AUTH("Auth"),

	//command
	CMD("command"),
	CMD_NONE(""),
	CMD_INDEX("index"),
	CMD_SHOW("show"),
	CMD_SHOW_LOGIN("showLogin"),
	CMD_LOGIN("login"),
	CMD_LOGOUT("logout"),
	CMD_NEW("entryNew"),
	CMD_CREATE("create"),
	CMD_EDIT("edit"),
	CMD_UPDATE("update"),
	CMD_DESTROY("destroy"),

	//jsp
	FW_ERR_UNKNOWN("jp/error/unknown"),
	FW_TOP_INDEX("jp/topPage/index"),
	FW_LOGIN("jp/login/login"),
	FW_EMP_INDEX("jp/employees/index"),
	FW_EMP_SHOW("jp/employees/show"),
	FW_EMP_NEW("jp/employees/new"),
	FW_EMP_EDIT("jp/employees/edit"),
	FW_REP_INDEX("jp/reports/index"),
	FW_REP_SHOW("jp/reports/show"),
	FW_REP_NEW("jp/reports/new"),
	FW_REP_EDIT("jp/reports/edit"),

	//for configure
	//action
	ACT_CONFIG("Config"),

	//jsp
	FW_CONFIG("jp/configure/config");

	/**
	 * Character strings
	 */
	private final String text;

	/**
	 * Constructor
	 */
	private ForwardConst(final String text) {
		this.text = text;
	}

	/**
	 * Acquire the value(String)
	 */
	public String getValue() {
		return this.text;
	}
}
