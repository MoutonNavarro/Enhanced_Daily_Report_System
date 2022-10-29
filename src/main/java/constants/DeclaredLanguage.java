package constants;

import java.util.Arrays;

import actions.views.ConfigureView;

/**
 * Enum class that defines usable languages
 */
public enum DeclaredLanguage {
	ENG_US(LanguageClassConst.ENG_US, "English_United-States"),
	JPN_JP(LanguageClassConst.JPN_JP, "Japanese_Japan"),
	TGL(LanguageClassConst.TGL, "Tagalog_Philippines"),
	SPA(LanguageClassConst.SPA, "Spanish"),
	;

	private final LanguageClassConst lcc;
	private final String name;

	private DeclaredLanguage (LanguageClassConst lcc, final String name) {
		this.lcc = lcc;
		this.name = name;
	}

	/**
	 * Acquire language name for query parameter
	 * @return This enum's language name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Acquire LanguageClassConst enum object
	 * @return LanguageClassConst object that this enum has
	 */
	public LanguageClassConst getLcc() {
		return lcc;
	}

	/**
	 * Acquire LanguageClassConst enum object
	 * @return LanguageClassConst object that this enum has
	 */
	public static DeclaredLanguage getByName(String name) {
		return  Arrays.stream(DeclaredLanguage.values())
			.filter(data -> data.getName().equals(name))
			.findFirst()
			.orElse(null);
	}

	/**
	 * Acquire language code(ISO 639-2)
	 * @return Language code based on ISO 639-2 (from this enum's LanguageClassConst object)
	 */
	public String getLanguageCode() {
		return lcc.getLanguageCode();
	}
	/**
	 * Acquire country code(ISO 3166-1 alpha-3)
	 * @return Country code based on ISO 3166-1 alpha-3 (from this enum's LanguageClassConst object)
	 */
	public String getLanguageCountry() {
		return lcc.getLanguageCountry();
	}

	/**
	 * Aquire Enum object with condition as ConfigureView
	 * @param cv ConfigureView instance
	 * @return Acquired Enum(ENG_US if there is no Enum with such name)
	 * @throws NullPointerException If null as argument
	 */
	public static LanguageClassConst getByConfigureView(ConfigureView cv) {
		DeclaredLanguage l = null;
		return null == (l = Arrays.stream(DeclaredLanguage.values())
			.filter(data -> data.getLanguageCode().equalsIgnoreCase(cv.getLanguage()))
			.findFirst().orElse(null)) ? ENG_US.getLcc() : Arrays.stream(DeclaredLanguage.values())
				.filter(data -> data.getLanguageCode().equalsIgnoreCase(cv.getLanguage()))
				.filter(data -> data.getLanguageCountry().equalsIgnoreCase(cv.getLang_country()))
				.findFirst().orElse(l).getLcc();

	}

	/**
	 * Acquire language name
	 * @return Language name from this enum's LanguageClassConst object.
	 */
	public String getLanguageName() {
		return lcc.getLanguageName();
	}
}
