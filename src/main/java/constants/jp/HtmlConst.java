package constants.jp;

import constants.interfaces.Html;

public enum HtmlConst implements Html{

	//General
	LANGUAGE("日本語(JP)"),
	HTML_LANGUAGE("jp"),
	EXAM_MESSAGE(null),

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
	TEXT_CONTENT("内容"),
	TEXT_SUBMIT("投稿"),
	TEXT_SEND("送信"),
	TEXT_DATE_REGISTERED("登録日時"),
	TEXT_DATE_UPDATED("更新日時"),
	TEXT_BACK_TOP("トップページに戻る"),
	TEXT_GO_TOP("トップページへ"),

	TEXT_CLAPS("拍手数"),
	TEXT_PRIVILEGES("権限"),

	TEXT_FORM_ERR("入力内容に誤りがありました。"),

	//Employee
	TEXT_EMP_NUMBER_OF_ALL_ITEMS("(全 ${reports_count} 件)"),
		TEXT_EMP_NUMBER_OF_ALL_ITEMS_L("(全 "),
		TEXT_EMP_NUMBER_OF_ALL_ITEMS_R(" 件)"),
	TEXT_EMP_ADMIN_RIGHT("管理者権限"),
	TEXT_EMP_GENERAL("一般"),
	TEXT_EMP_ADMIN("管理者"),
	TEXT_EMP_BACK_LIST("従業員一覧ページに戻る"),

	//Report
	TEXT_REP_NUMBER_OF_ALL_ITEMS("(全: ${reports_count} 件)"),
		TEXT_REP_NUMBER_OF_ALL_ITEMS_L("(全: "),
		TEXT_REP_NUMBER_OF_ALL_ITEMS_R(" 件)"),
	TEXT_REP_SUBMIT_NEW("日報を新しく登録する"),
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
	TEXT_CONFIG_COLOR_BG("背景色"),
	TEXT_CONFIG_COLOR_DEFAULT("デフォルト"),
	TEXT_CONFIG_DISPLAY_LANG("表示言語"),
	TEXT_CAUTION_LANGUAGE("現在の表示言語(セッション)と、設定の表示言語が異なります。"
		+ "<br>設定を確定すると、表示言語は設定項目と同じに変更されます。"),

	//reports
	//edit.jsp
	TEXT_REP_EDIT_PAGE("日報編集ページ"),

	//index.jsp
	TEXT_REP_LIST_PAGE("日報一覧"),

	//new.jsp
	TEXT_REP_NEW_PAGE("日報新規登録ページ"),

	//show.jsp
	TEXT_REP_SHOW_PAGE("日報詳細ページ"),
	TEXT_REP_CLAP("拍手"),
	TEXT_REP_CLAPPED("拍手しました"),
	TEXT_REP_CLAPPED_EMPLOYEES("拍手した:&nbsp;"),
	TEXT_REP_CLAPPED_EMPLOYEE("[${clap.employee_name}]&nbsp;&nbsp;"),
		TEXT_REP_CLAPPED_EMPLOYEE_L("["),
		TEXT_REP_CLAPPED_EMPLOYEE_R("]さん&nbsp;&nbsp;"),
	TEXT_REP_EDIT("この日報を編集する"),

	//employees
	//edit.jsp
	TEXT_EMP_EDIT_PAGE("従業員ID: ${employee.id} の従業員情報編集ページ"),
		TEXT_EMP_EDIT_PAGE_L("従業員ID: "),
		TEXT_EMP_EDIT_PAGE_R(" の従業員情報編集ページ"),
	TEXT_EMP_EDIT_NOTE_PASSWORD("(パスワードは変更したい場合のみ入力してください)"),
	TEXT_EMP_DELETE("＜この従業員を削除する！＞"),
	TEXT_EMP_DELETE_CONFIRM("本当にこの従業員を削除しますか？"),

	//index.jsp
	TEXT_EMP_LIST_PAGE("従業員一覧"),
	TEXT_EMP_DELETED("(停止)"),
	TEXT_EMP_REGISTER("従業員を登録する"),

	//new.jsp
	TEXT_EMP_NEW_PAGE("従業員新規登録ページ"),

	//show.jsp
	TEXT_EMP_SHOW_PAGE("従業員ID: ${employee.id} の詳細ページ"),
		TEXT_EMP_SHOW_PAGE_L("従業員ID: "),
		TEXT_EMP_SHOW_PAGE_R(" の詳細ページ"),
	TEXT_EMP_EDIT("この従業員情報を編集する"),
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
