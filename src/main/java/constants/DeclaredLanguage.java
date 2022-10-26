package constants;

import java.util.Arrays;

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
}
