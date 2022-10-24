package constants;

import constants.interfaces.Forward;

/**
 * Enum class that defines relative the forward screen that request parameter variable names, variable value, jsp file's name, and else.
 */
public enum ForwardConst{
	//action
	ACT("action", "ACT"),
	ACT_TOP("Top", "ACT_TOP"),
	ACT_EMP("Employee", "ACT_EMP"),
	ACT_REP("Report", "ACT_REP"),
	ACT_AUTH("Auth", "ACT_AUTH"),

	//command
	CMD("command", "CMD"),
	CMD_NONE("", "CMD_NONE"),
	CMD_INDEX("index", "CMD_INDEX"),
	CMD_SHOW("show", "CMD_SHOW"),
	CMD_SHOW_LOGIN("showLogin", "CMD_SHOW_LOGIN"),
	CMD_LOGIN("login", "CMD_LOGIN"),
	CMD_LOGOUT("logout", "CMD_LOGOUT"),
	CMD_NEW("entryNew", "CMD_NEW"),
	CMD_CREATE("create", "CMD_CREATE"),
	CMD_EDIT("edit", "CMD_EDIT"),
	CMD_UPDATE("update", "CMD_UPDATE"),
	CMD_DESTROY("destroy", "CMD_DESTROY"),

	//jsp
	FW_ERR_UNKNOWN("error/unknown", "FW_ERR_UNKNOWN"),
	FW_TOP_INDEX("topPage/index", "FW_TOP_INDEX"),
	FW_LOGIN("login/login", "FW_LOGIN"),
	FW_EMP_INDEX("employees/index", "FW_EMP_INDEX"),
	FW_EMP_SHOW("employees/show", "FW_EMP_SHOW"),
	FW_EMP_NEW("employees/new", "FW_EMP_NEW"),
	FW_EMP_EDIT("employees/edit", "FW_EMP_EDIT"),
	FW_REP_INDEX("reports/index", "FW_REP_INDEX"),
	FW_REP_SHOW("reports/show", "FW_REP_SHOW"),
	FW_REP_NEW("reports/new", "FW_REP_NEW"),
	FW_REP_EDIT("reports/edit", "FW_REP_EDIT"),

	//for configure
	//action
	ACT_CONFIG("Config", "ACT_CONFIG"),

	//jsp
	FW_CONFIG("configure/config", "FW_CONFIG"),

	//for reactions
	//action
	ACT_CLAP("Clap", "ACT_CLAP"),

	//command
	CMD_DO_REACTION("doReaction", "CMD_DO_REACTION"),
	CMD_UNDO_REACTION("undoReaction", "CMD_UNDO_REACTION");

	/**
	 * Character strings
	 */
	private final String text;

	/**
	 * For search code
	 */
	private final String code;

	/**
	 * Constructor
	 */
	private ForwardConst(final String text, final String code) {
		this.text = text;
		this.code = code;
	}

	/**
	 * Acquire the value(String)
	 */
	public String getValue() {
		return this.text;
	}

	/**
	 * Acquire the value that localized
	 * @param lang_name Language name
	 * @return Localized value (if no such declared value then original value)
	 * @deprecated We recommend to use getValue(LanguageClassConst lang) because safer
	 */
	@Deprecated
	public String getValue(String lang_name) {
		try {
			return ((Forward)valueOf(LanguageClassConst.getByLanguageName(lang_name).getForward(), this.name())).getValue();
		}catch (IllegalArgumentException| NullPointerException e) {
			return getValue();
		}
	}

	/**
	 * Acquire the value that localized
	 * @param lang LanguageClassConst type enum object
	 * @return Localized value (if no such declared value then original value)
	 */
	public String getValue(LanguageClassConst lang) {
		try {
			return ((Forward)valueOf(lang.getForward(), this.name())).getValue();
		}catch (IllegalArgumentException| NullPointerException e) {
			return getValue();
		}
	}
}
