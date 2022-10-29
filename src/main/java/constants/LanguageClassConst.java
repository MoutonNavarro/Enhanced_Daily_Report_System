package constants;

import java.util.Arrays;

import actions.views.ConfigureView;
import constants.interfaces.Format;
import constants.interfaces.Forward;
import constants.interfaces.Html;
import constants.interfaces.Message;

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
	TGL		("Tagalog", "Tagalog", "TGL", "PHL", null, null, constants.tl.HtmlConst.class, null),
	CEB		("Cebuano", "Cebuano", "CEB", "PHL", null, null, null, null),
	ITA		("Italian", "Italiano", "ITA", null, null, null, null, null),
	FRA		("French", "français", "FRA", null, null, null, null, null),
	SPA		("Spanish", "español", "SPA", null, null, null, constants.es.HtmlConst.class, null),
	DEU		("German", "Deutsch", "DEU", null, null, null, null, null);




	private final String lang_name;
	private final String lang_name_display;
	private final String lang_code;
	private final String lang_country;
	private final Class<Format> format;
	private final Class<Forward> forward;
	private final Class<Html> html;
	private final Class<Message> message;

	@SuppressWarnings("unchecked")
	private LanguageClassConst(final String lang_name, final String lang_name_display, final String lang_code, final String lang_country, final Class<? extends Format> format, final Class<? extends Forward> forward, final Class<? extends Html> html, final Class<? extends Message> message) {
		this.lang_name = lang_name == null ? "" : lang_name;
		this.lang_name_display = lang_name_display == null ? "" : lang_name_display;
		this.lang_code = lang_code == null ? "" : lang_code;
		this.lang_country = lang_country == null ? "" : lang_country;

		if(!Enum.class.isAssignableFrom(this.format = (Class<Format>)(format == null ? constants.en.FormatConst.class : format))){throw new Error("Illegal type of class stored at format: " + format.getName());}
		if(!Enum.class.isAssignableFrom(this.forward = (Class<Forward>)(forward == null ? constants.en.ForwardConst.class : forward))){throw new Error("Illegal type of class stored at forward: " + forward.getName());}
		if(!Enum.class.isAssignableFrom(this.html = (Class<Html>)(html == null ? constants.en.HtmlConst.class : html))){throw new Error("Illegal type of class stored at html: " + html.getName());}
		if(!Enum.class.isAssignableFrom(this.message = (Class<Message>)(message == null ? constants.en.MessageConst.class : message))){throw new Error("Illegal type of class stored at message: " + message.getName());}
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
	@SuppressWarnings("unchecked")
	<T> Class<T> getFormat() {
		return (Class<T>) format;
	}
	@SuppressWarnings("unchecked")
	<T> Class<T> getForward() {
		return (Class<T>) forward;
	}
	@SuppressWarnings("unchecked")
	<T> Class<T> getHtml() {
		return (Class<T>) html;
	}
	@SuppressWarnings("unchecked")
	<T> Class<T> getMessage() {
		return (Class<T>) message;
	}

	/**
	 * Acquire Enum object with condition as language name
	 * @param code color code start with "#"
	 * @return Acquired Enum(ENG_US if there is no Enum with such name)
	 */
	public static LanguageClassConst getByLanguageName(String language_name) {
		return Arrays.stream(LanguageClassConst.values())
			.filter(data -> data.getLanguageName().equalsIgnoreCase(language_name))
			.findFirst()
			.orElse(ENG_US);

	}

	/**
	 * Aquire Enum object with condition as ConfigureView
	 * @param cv ConfigureView instance
	 * @return Acquired Enum(ENG_US if there is no Enum with such name)
	 * @throws NullPointerException If null as argument
	 */
	public static LanguageClassConst getByConfigureView(ConfigureView cv) {
		LanguageClassConst l = null;
		return null == (l = Arrays.stream(LanguageClassConst.values())
			.filter(data -> data.getLanguageCode().equalsIgnoreCase(cv.getLanguage()))
			.findFirst().orElse(null)) ? ENG_US : Arrays.stream(LanguageClassConst.values())
				.filter(data -> data.getLanguageCode().equalsIgnoreCase(cv.getLanguage()))
				.filter(data -> data.getLanguageCountry().equalsIgnoreCase(cv.getLang_country()))
				.findFirst().orElse(l);

	}

}
