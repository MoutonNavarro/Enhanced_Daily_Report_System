package constants;

/**
 * Enum class that defines each output message
 */
public enum MessageConst {
	//Authentication
	I_LOGINED("Logged in"),
	E_LOGINED("Failed to login"),
	I_LOGOUT("Logged out"),

	//DB update
	I_REGISTERED("Register complete"),
	I_UPDATED("Update complete"),
	I_DELETED("Delete complete"),

	//Validation
	E_NONAME("Please input the name."),
	E_NOPASSWORD("Please input password."),
	E_NOEMP_CODE("Please input the employee code."),
	E_EMP_CODE_EXIST("The information of input employee code is already exists."),
	E_NOTITLE("Please input title."),
	E_NOCONTENT("Please input the content."),

	//Configure
	I_CONFIG_UPDATED("Your Configure is updated."),
	I_CONFIG_UPDATED_TEMP("Your Configure is updated. the setting will be removed when you ended the browser.");

	/**
	 * Character string
	 */
	private final String text;

	/**
	 * Constructor
	 */
	private MessageConst(final String text) {
		this.text = text;
	}

	/**
	 * Acquire the value (String)
	 */
	public String getMessage() {
		return this.text;
	}
}
