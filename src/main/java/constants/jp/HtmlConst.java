package constants.jp;

public enum HtmlConst {

	//General
	LANGUAGE("日本語(JP)"),

	//Base
	TEXT_NAME("氏名"),
	TEXT_DATE("日付"),
	TEXT_TITLE("タイトル"),
	TEXT_ACTION("操作"),
	TEXT_SEEDETAIL("詳細を見る"),
	TEXT_NUMBER_OF_ALL_ITEMS("(全: ${count} 件)"),

	//Report
	TEXT_REP_NUMBER_OF_ALL_ITEMS("(全: ${reports_count} 件)"),
	TEXT_REP_SUMBIT_NEW("日報を新しく登録する"),
	TEXT_REP_MINE("[あなたの日報リスト]"),

	//jsps
	//app.jsp
	//Header
	TEXT_HEAD_DAILY("日報管理システム"),
	TEXT_HEAD_DAILY_TITLE("日報管理システム"),
	TEXT_DISCRIPT_MAIN("ムートン・ナヴァーロの拡張日報管理システムです"),
	TEXT_HEAD_MNGEMP("従業員管理"),
	TEXT_HEAD_MNGREP("日報管理"),
	TEXT_HEAD_USERNAME("	こんにちは!&nbsp;<c:out value=\"${sessionScope.login_employee.name}\" /> さん&nbsp;&nbsp;&nbsp;"),

	//Footer
	TEXT_DISPLAY_LANG("日本語"),

	//topPage/index.jsp
	TEXT_WELCOME("日報管理システムにようこそ!"),

	//error/unknown.jsp
	TEXT_UNKNOWN("お探しのページは見つかりませんでした"),
	TEXT_UNKNOWN_FOLLOW("<c:out value='${followPage}' /> は見つかりませんでした");

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
