package constants.tl;

import constants.interfaces.Forward;

/**
 * Enum class that defines relative the forward screen that request parameter variable names, variable value, jsp file's name, and else. (English)
 */
public enum ForwardConst implements Forward{
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
	FW_ERR_UNKNOWN("en/error/unknown"),
	FW_TOP_INDEX("en/topPage/index"),
	FW_LOGIN("en/login/login"),
	FW_EMP_INDEX("en/employees/index"),
	FW_EMP_SHOW("en/employees/show"),
	FW_EMP_NEW("en/employees/new"),
	FW_EMP_EDIT("en/employees/edit"),
	FW_REP_INDEX("en/reports/index"),
	FW_REP_SHOW("en/reports/show"),
	FW_REP_NEW("en/reports/new"),
	FW_REP_EDIT("en/reports/edit"),

	//for configure
	//action
	ACT_CONFIG("Config"),

	//jsp
	FW_CONFIG("en/configure/config"),

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
