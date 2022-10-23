package constants;

import java.util.Arrays;

import constants.interfaces.EnumInterface;

@SuppressWarnings("rawtypes")
public enum LanguageClassConst implements EnumInterface{
	ENG("English", constants.en.FormatConst.class, constants.en.ForwardConst.class, constants.en.HtmlConst.class, constants.en.MessageConst.class),
	ENG_US("English(US)", constants.en.FormatConst.class, constants.en.ForwardConst.class, constants.en.HtmlConst.class, constants.en.MessageConst.class),
	ENG_UK("English(UK)", null, null, null, null),
	ENG_CA("English(CA)", null, null, null, null),
	ENG_PH("English(PH)", null, null, null, null),
	ENG_IN("English(IN)", null, null, null, null),
	JPN("日本語", constants.jp.FormatConst.class, constants.jp.ForwardConst.class, constants.jp.HtmlConst.class, constants.jp.MessageConst.class),
	JPN_JA("日本語(JP)", constants.jp.FormatConst.class, constants.jp.ForwardConst.class, constants.jp.HtmlConst.class, constants.jp.MessageConst.class);



	private final String lang_name;
	private final Class<? extends Enum> format;
	private final Class<? extends Enum> forward;
	private final Class<? extends Enum> html;
	private final Class<? extends Enum> message;

	private LanguageClassConst(final String lang_name, final Class<? extends Enum> format, final Class<? extends Enum> forward, final Class<? extends Enum> html, final Class<? extends Enum> message) {
		this.lang_name = lang_name;

		if(!(this.format = (format == null ? constants.en.FormatConst.class : format)).getSimpleName().equals("FormatConst")){throw new Error("Illegal type of class stored at format: " + format.getName());}
		if(!(this.forward = (forward == null ? constants.en.ForwardConst.class : forward)).getSimpleName().equals("ForwardConst")){throw new Error("Illegal type of class stored at forward: " + forward.getName());}
		if(!(this.html = html == null ? constants.en.HtmlConst.class : html).getSimpleName().equals("HtmlConst")){throw new Error("Illegal type of class stored at html: " + html.getName());}
		if(!(this.message = message == null ? constants.en.MessageConst.class : message).getSimpleName().equals("MessageConst")){throw new Error("Illegal type of class stored at message: " + message.getName());}
	}

	public String getLanguageName() {
		return lang_name;
	}
	public Class<? extends Enum> getForward() {
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
			.orElse(ENG);

	}

}
