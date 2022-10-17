package colors;

import java.util.Arrays;

import constants.ColorCodeConst;

public enum ColorNameEnum {
	PINK("Pink", ColorCodeConst.PINK.getCode()),
	YELLOW("Yellow", ColorCodeConst.YELLOW.getCode()),
	GREEN("Green", ColorCodeConst.GREEN.getCode()),
	BLUE("Blue", ColorCodeConst.BLUE.getCode()),
	RED("Red", ColorCodeConst.RED.getCode()),
	BLACK("Black", ColorCodeConst.BLACK.getCode()),
	SIBUYAS("Sibyas", ColorCodeConst.SIBUYAS.getCode()),
	BERDE("Berde", ColorCodeConst.BERDE.getCode()),
	ASUL("Asul", ColorCodeConst.ASUL.getCode()),
	KULAY_ROSAS("Kulay Rosas", ColorCodeConst.KULAY_ROSAS.getCode()),
	KULAY_UBE("Kulay Ube", ColorCodeConst.KULAY_UBE.getCode()),
	DEFAULT("Default", ""),
	EMPTY("", "");

	//Color name for foreground
	private final String name;

	//Color code for foreground
	private final String code;
	private ColorNameEnum(final String name, final String code) {
		this.name = name;
		this.code = code;

	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}

	/**
	 * Acquire Enum object with condition as name(ignore case)
	 * @param name Color name
	 * @return Acquired Enum(Null if there is no Enum with such name)
	 */
	public static ColorNameEnum getByName(String name) {
		return Arrays.stream(ColorNameEnum.values())
			.filter(data -> data.getName().equalsIgnoreCase(name))
			.findFirst()
			.orElse(null);
	}

	/**
	 * Acquire Enum object with condition as color code(ignore case)
	 * @param code color code start with "#"
	 * @return Acquired Enum(Null if there is no Enum with such name)
	 */
	public static ColorNameEnum getByCode(String code) {
		return Arrays.stream(ColorNameEnum.values())
			.filter(data -> data.getCode().equalsIgnoreCase(code))
			.findFirst()
			.orElse(null);
	}
}
