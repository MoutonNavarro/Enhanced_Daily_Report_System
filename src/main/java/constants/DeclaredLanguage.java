package constants;

import java.util.Arrays;

import actions.views.ConfigureView;

public enum DeclaredLanguage {
	ENG_US(LanguageClassConst.ENG_US, "English_United-States"),
	JPN_JP(LanguageClassConst.JPN_JP, "Japanese_Japan"),
	;

	private final LanguageClassConst lcc;
	private final String name;

	private DeclaredLanguage (LanguageClassConst lcc, final String name) {
		this.lcc = lcc;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public LanguageClassConst getLcc() {
		return lcc;
	}

	public static DeclaredLanguage getByName(String name) {
		return  Arrays.stream(DeclaredLanguage.values())
			.filter(data -> data.getName().equals(name))
			.findFirst()
			.orElse(null);
	}
	public String getLanguageCode() {
		return lcc.getLanguageCode();
	}
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

	public String getLanguageName() {
		return lcc.getLanguageName();
	}
}
