package constants.jp;

import constants.interfaces.Message;

/**
 * Enum class that defines each output message (Japanese)
 */
public enum MessageConst implements Message{
	//Authentication
	I_LOGINED("ログインしました"),
	E_LOGINED("ログインに失敗しました"),
	I_LOGOUT("ログアウトしました"),

	//DB update
	I_REGISTERED("登録が完了しました"),
	I_UPDATED("更新が完了しました"),
	I_DELETED("削除が完了しました"),

	//Validation
	E_NONAME("名前を入力してください。"),
	E_NOPASSWORD("パスワードを入力してください。"),
	E_NOEMP_CODE("従業員コードを入力してください。"),
	E_EMP_CODE_EXIST("入力された従業員コードの情報は既に存在します。"),
	E_NOTITLE("タイトルを入力してください。"),
	E_NOCONTENT("内容を入力してください。"),
	E_NO_SUCH_USER_COLOR("そのような名前の色はありません。"),
	E_NO_SUCH_LANGUAGE("そのような名前の言語はありません。"),
	E_NO_SUCH_DEFINED_LANGUAGE("表示言語として定義された言語ではありません。"),

	//Configure
	I_CONFIG_UPDATED("コンフィグが更新されました。"),
	I_CONFIG_UPDATED_TEMP("コンフィグが更新されました。この設定はブラウザーを終了すると削除されます。"),
	I_CLAPPED("日報に拍手しました。"),

	//Reaction
	I_UNDID_CLAP("日報の拍手を取り消しました。"),
	E_ALREADY_CLAPPED("既にこの日報にリアクションしています"),
	E_ALREADY_UNDID_CLAP("既にこの日報へのリアクションを取り消しています");

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
