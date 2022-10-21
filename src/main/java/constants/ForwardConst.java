package constants;

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
	FW_ERR_UNKNOWN("error/unknown"),
	FW_TOP_INDEX("topPage/index"),
	FW_LOGIN("login/login"),
	FW_EMP_INDEX("employees/index"),
	FW_EMP_SHOW("employees/show"),
	FW_EMP_NEW("employees/new"),
	FW_EMP_EDIT("employees/edit"),
	FW_REP_INDEX("reports/index"),
	FW_REP_SHOW("reports/show"),
	FW_REP_NEW("reports/new"),
	FW_REP_EDIT("reports/edit"),

	//for configure
	//action
	ACT_CONFIG("Config"),

	//jsp
	FW_CONFIG("configure/config"),

	//for reactions
	//action
	ACT_CLAP("Clap"),

	//command
	CMD_DO_REACTION("doReaction"),
	CMD_UNDO_REACTION("undoReaction");


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
