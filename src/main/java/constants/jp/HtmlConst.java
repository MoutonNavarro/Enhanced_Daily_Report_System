package constants.jp;

import constants.interfaces.Html;

public enum HtmlConst implements Html{

	//General
	LANGUAGE("日本語(JP)"),
	HTML_LANGUAGE("jp"),

	//Base
	TEXT_NAME("氏名"),
	TEXT_DATE("日付"),
	TEXT_TITLE("タイトル"),
	TEXT_ACTION("操作"),
	TEXT_SEEDETAIL("詳細を見る"),
	TEXT_EMPLOYEE("従業員"),
	TEXT_EMPLOYEE_CODE("従業員コード"),
	TEXT_PASSWORD("パスワード"),
	TEXT_NUMBER_OF_ALL_ITEMS("(全: ${count} 件)"),
		TEXT_NUMBER_OF_ALL_ITEMS_L("(全: "),
		TEXT_NUMBER_OF_ALL_ITEMS_R(" 件)"),
	TEXT_DO_LOGIN("ログイン"),
	TEXT_SUBMIT("送信"),
	TEXT_BACK_TOP("トップページに戻る"),
	TEXT_GO_TOP("トップページへ"),

	//Report
	TEXT_REP_NUMBER_OF_ALL_ITEMS("(全: ${reports_count} 件)"),
		TEXT_REP_NUMBER_OF_ALL_ITEMS_L("(全: "),
		TEXT_REP_NUMBER_OF_ALL_ITEMS_R(" 件)"),
	TEXT_REP_SUMBIT_NEW("日報を新しく登録する"),
	TEXT_REP_MINE("[あなたの日報リスト]"),
	TEXT_REP_BACK_LIST("一覧ページに戻る"),

	//jsps
	//app.jsp
	//Header
	TEXT_HEAD_DAILY("日報管理システム"),
	TEXT_HEAD_DAILY_TITLE("日報管理システム"),
	TEXT_DISCRIPT_MAIN("ムートン・ナヴァーロの拡張日報管理システムです"),
	TEXT_HEAD_MNGEMP("従業員管理"),
	TEXT_HEAD_MNGREP("日報管理"),
	TEXT_HEAD_USERNAME("	こんにちは!&nbsp;<c:out value=\"${sessionScope.login_employee.name}\" /> さん&nbsp;&nbsp;&nbsp;"),
		TEXT_HEAD_USERNAME_L("	こんにちは!&nbsp;"),
		TEXT_HEAD_USERNAME_R(" さん&nbsp;&nbsp;&nbsp;"),
	TEXT_HEAD_SETTING("設定"),
	TEXT_HEAD_LOGOUT("ログアウト"),

	//Footer
	TEXT_DISPLAY_LANG("日本語"),

	//topPage/index.jsp
	TEXT_WELCOME("日報管理システムにようこそ!"),

	//error/unknown.jsp
	TEXT_UNKNOWN("お探しのページは見つかりませんでした"),
	TEXT_UNKNOWN_FOLLOW("<c:out value='${followPage}' /> は見つかりませんでした"),
		TEXT_UNKNOWN_FOLLOW_L(""),
		TEXT_UNKNOWN_FOLLOW_R(" は見つかりませんでした"),

	//login/login.jsp
	TEXT_LOGIN("ログイン"),
	//login error
	TEXT_LOGIN_ERROR("従業員コードかパスワード、またはその両方が正しくありません。"),


	//configure/config.jsp
	TEXT_CONFIG_PAGE("設定ページ"),
	TEXT_CONFIG_ERROR("入力内容に誤りがあります。"),
	TEXT_CONFIG_COLOR_FG("文字色"),
	TEXT_CONFIG_COLOR_DEFAULT("デフォルト"),
	TEXT_CONFIG_DISPLAY_LANG("表示言語"),
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
