package constants;

import java.util.Arrays;

import constants.interfaces.Format;
import constants.interfaces.Forward;
import constants.interfaces.Html;
import constants.interfaces.Message;

public enum LanguageClassConst {
//	ENG("English", constants.en.FormatConst.class, constants.en.ForwardConst.class, constants.en.HtmlConst.class, constants.en.MessageConst.class),
EN("English", null, constants.en.ForwardConst.class, null, null),
	ENG_US("English(US)", null, constants.en.ForwardConst.class, null, null),
	ENG_UK("English(UK)", null, null, null, null),
	ENG_CA("English(CA)", null, null, null, null),
	ENG_PH("English(PH)", null, null, null, null),
	ENG_IN("English(IN)", null, null, null, null),
JP("日本語", null, constants.jp.ForwardConst.class, null, null);
	//	JPN("日本語", constants.jp.FormatConst.class, constants.jp.ForwardConst.class, constants.jp.HtmlConst.class, constants.jp.MessageConst.class),
//	JPN_JA("日本語(JP)", constants.jp.FormatConst.class, constants.jp.ForwardConst.class, constants.jp.HtmlConst.class, constants.jp.MessageConst.class);


	private final String lang_name;
	private final Class<? extends Format> format;
	private final Class<? extends Forward> forward;
	private final Class<? extends Html> html;
	private final Class<? extends Message> message;

	private LanguageClassConst(final String lang_name, final Class<? extends Format> format, final Class<? extends Forward> forward, final Class<? extends Html> html, final Class<? extends Message> message) {
		this.lang_name = lang_name;

		this.format = format;
		this.forward = forward;
		this.html = html;
		this.message = message;
	}

	public String getLanguageName() {
		return lang_name;
	}
	public Class<? extends Forward> getForward() {
		return forward;
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
			.orElse(EN);

	}

}
