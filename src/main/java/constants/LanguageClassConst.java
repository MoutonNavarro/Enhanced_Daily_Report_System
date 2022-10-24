package constants;

import java.util.Arrays;

@SuppressWarnings("rawtypes")
public enum LanguageClassConst{
	ENG		("English", "English", "ENG", null, constants.en.FormatConst.class, constants.en.ForwardConst.class, constants.en.HtmlConst.class, constants.en.MessageConst.class),
	ENG_US	("English(US)", "English(U.S)", "eng", "usa", constants.en.FormatConst.class, constants.en.ForwardConst.class, constants.en.HtmlConst.class, constants.en.MessageConst.class),
	ENG_UK	("English(UK)", "English(U.K)", "ENG", "GBR", null, null, null, null),
	ENG_CA	("English(CA)", "English(Canada)", "ENG", "CAN", null, null, null, null),
	ENG_PH	("English(PH)", "English(Philippines)", "ENG", "PHL", null, null, null, null),
	ENG_IN	("English(IN)", "English(India)", "ENG", "IND", null, null, null, null),
	JPN		("Japanese", "日本語", "JPN", null, constants.jp.FormatConst.class, constants.jp.ForwardConst.class, constants.jp.HtmlConst.class, constants.jp.MessageConst.class),
	JPN_JP	("Japanese(JP)", "日本語(Japan)", "jpn", "jpn", constants.jp.FormatConst.class, constants.jp.ForwardConst.class, constants.jp.HtmlConst.class, constants.jp.MessageConst.class),
	KOR		("Korean", "조선말", "KOR", null, null, null, null, null),
	KOR_KR	("Korean(KR)", "한국어", "KOR", "ROK", null, null, null, null),
	CHI		("Chinese", "中文", "CHI", null, null, null, null, null),
	CHI_S		("Chinese(Simplified)", "汉语", "CHI", null, null, null, null, null),
	CHI_T		("Chinese(Traditional)", "漢語", "CHI", null, null, null, null, null),
	TGL		("Tagalog", "Tagalog", "TGL", "PHL", null, null, null, null),
	CEB		("Cebuano", "Cebuano", "CEB", "PHL", null, null, null, null),
	ITA		("Italian", "Italiano", "ITA", null, null, null, null, null),
	FRA		("French", "français", "FRA", null, null, null, null, null),
	SPA		("Spanish", "español", "SPA", null, null, null, null, null),
	DEU		("German", "Deutsch", "DEU", null, null, null, null, null);




	private final String lang_name;
	private final String lang_name_display;
	private final String lang_code;
	private final String lang_country;
	private final Class<? extends Enum> format;
	private final Class<? extends Enum> forward;
	private final Class<? extends Enum> html;
	private final Class<? extends Enum> message;

	private LanguageClassConst(final String lang_name, final String lang_name_display, final String lang_code, final String lang_country, final Class<? extends Enum> format, final Class<? extends Enum> forward, final Class<? extends Enum> html, final Class<? extends Enum> message) {
		this.lang_name = lang_name == null ? "" : lang_name;
		this.lang_name_display = lang_name_display == null ? "" : lang_name_display;
		this.lang_code = lang_code == null ? "" : lang_code;
		this.lang_country = lang_country == null ? "" : lang_country;

		if(!(this.format = (format == null ? constants.en.FormatConst.class : format)).getSimpleName().equals("FormatConst")){throw new Error("Illegal type of class stored at format: " + format.getName());}
		if(!(this.forward = (forward == null ? constants.en.ForwardConst.class : forward)).getSimpleName().equals("ForwardConst")){throw new Error("Illegal type of class stored at forward: " + forward.getName());}
		if(!(this.html = html == null ? constants.en.HtmlConst.class : html).getSimpleName().equals("HtmlConst")){throw new Error("Illegal type of class stored at html: " + html.getName());}
		if(!(this.message = message == null ? constants.en.MessageConst.class : message).getSimpleName().equals("MessageConst")){throw new Error("Illegal type of class stored at message: " + message.getName());}
	}

	public String getLanguageName() {
		return lang_name;
	}
	public String getDisplayName() {
		return lang_name_display;
	}
	public String getLanguageCode() {
		return lang_code;
	}
	public String getLanguageCountry() {
		return lang_country;
	}
	Class<? extends Enum> getFormat() {
		return format;
	}
	Class<? extends Enum> getForward() {
		return forward;
	}
	Class<? extends Enum> getHtml() {
		return html;
	}
	Class<? extends Enum> getMessage() {
		return message;
	}

	/**
	 * Acquire Enum object with condition as language name
	 * @param code color code start with "#"
	 * @return Acquired Enum(Null if there is no Enum with such name)
	 */
	public static LanguageClassConst getByLanguageName(String language_name) {
		return Arrays.stream(LanguageClassConst.values())
			.filter(data -> data.getLanguageName().equalsIgnoreCase(language_name))
			.findFirst()
			.orElse(ENG_US);

	}

}
