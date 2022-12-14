package constants;


/**
 * Enum class that define screen items value and else
 */
public enum AttributeConst {
	//Flush message
	FLUSH("flush"),

	//Common to all list screens
	MAX_ROW("maxRow"),
	PAGE("page"),

	//Common to all input form
	TOKEN("_token"),
	ERR("errors"),

	//Employee who logged in
	LOGIN_EMP("login_employee"),

	//Login screen
	LOGIN_ERR("loginError"),

	//Manage employees
	EMPLOYEE("employee"),
	EMPLOYEES("employees"),
	EMP_COUNT("employees_count"),
	EMP_ID("id"),
	EMP_CODE("code"),
	EMP_PASS("password"),
	EMP_NAME("name"),
	EMP_ADMIN_FLG("admin_flag"),

	//Administrator flag
	ROLE_ADMIN(1),
	ROLE_GENERAL(0),

	//Delete flag
	DEL_FLAG_TRUE(1),
	DEL_FLAG_FALSE(0),

	//Management the report
	REPORT("report"),
	REPORTS("reports"),
	REP_COUNT("reports_count"),
	REP_ID("id"),
	REP_DATE("report_date"),
	REP_TITLE("title"),
	REP_CONTENT("content_msg"),

	//Configure
	CONFIG("configure"),
	CONFIG_COLOR("color"),
	CONFIG_BG("background"),
	CONFIG_LANGUAGE("language"),
	CONFIG_TIMEZONE("timezone"),
	CONFIG_CUR_LANG("currentLang"),

	LANGUAGE("lang"),

	//Claps
	CLAP("claps"),
	CLAP_COUNT("clap_count"),
	IS_CLAPPED("is_clapped"),

	//Single action(Post)
	POST("post"),
	TYPE("type"),
	POST_FLUSH("postFlush"),
	POST_FLUSH_ERR("postFlush_E"),
	LANGUAGE_POST("lang_post"),
	LINK("link"),
	;

	private final String text;
	private final Integer i;

	private AttributeConst(final String text) {
		this.text = text;
		this.i = null;
	}

	private AttributeConst(final Integer i) {
		this.text = null;
		this.i = i;
	}

	public String getValue() {
		return this.text;
	}

	public Integer getIntegerValue() {
		return this.i;
	}
}
