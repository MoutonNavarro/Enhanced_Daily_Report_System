package constants.en;

import constants.interfaces.Message;

/**
 * Enum class that defines each output message (English)
 */
public enum MessageConst implements Message{
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
	E_NO_SUCH_USER_COLOR("No such color name in user color."),
	E_NO_SUCH_LANGUAGE("No such language in displays language."),

	//Configure
	I_CONFIG_UPDATED("Your Configure is updated."),
	I_CONFIG_UPDATED_TEMP("Your Configure is updated. the setting will be removed when you ended the browser."),
	I_CLAPPED("You clapped the report"),

	//Reaction
	I_UNDID_CLAP("You undid clap the report"),
	E_ALREADY_CLAPPED("You have already reacted this report"),
	E_ALREADY_UNDID_CLAP("You have already undid reaction this report");

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

	@Override
	public String getMessage() {
		return text;
	}

}
