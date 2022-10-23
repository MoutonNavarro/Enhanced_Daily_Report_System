package constants;

import constants.interfaces.Format;

public enum FormatConst {
	;

	/**
	 * Field
	 */
	private final String format;

	/**
	 * Constructor
	 */
	private FormatConst(final String format) {
		this.format = format;
	}

	/**
	 * Acquire the format
	 * @return Format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Acquire the format that localized
	 * @return Localized format (if no such declared value then original format)
	 */
	@SuppressWarnings("unchecked")
	public String getFormat(String lang_name) {
		try {
			return ((Format)valueOf(LanguageClassConst.getByLanguageName(lang_name).getFormat(), this.name())).getFormat();
		}catch (IllegalArgumentException e) {
			return getFormat();
		}
	}

}
