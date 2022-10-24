package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ConfigureView;
import colors.ColorNameEnum;
import constants.LanguageClassConst;
import constants.MessageConst;

/**
 * Class that validates value set at Configure instance
 */
public class ConfigureValidator {

	/**
	 * Do validation about each items of Configure instance
	 * @param cv Configure instance
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return Errors list
	 * @throws NullPointerException when include null at ConfigureView in range of validation
	 */
	public static List<String> validate(ConfigureView cv, LanguageClassConst lang) throws NullPointerException{
		List<String> errors = new ArrayList<>();
		List<String> seriousErrors = new ArrayList<>();

		Object checkNull = null;
		//Check user_color
		String userColorError = null;
		//[Unlocked] We implemented color constants for foreground
		if (null == (checkNull = cv.getUser_color())) {
			System.err.println("cv = null");
		}else if (!"".equals(userColorError = validateUserColor((String)checkNull, lang))) {
			errors.add(userColorError);
		}

		//[Locked] We must implements other function

		if (seriousErrors.size() > 0) {
			throw new NullPointerException("Bad request ditected\n" + seriousErrors);
		}
		return errors;
	}

	/**
	 * Check input of the color name and return error message
	 * @param user_color Input color name
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return Error message
	 * @throws NullPointerException when include null at ConfigureView in range of validation
	 */
	private static String validateUserColor(String user_color, LanguageClassConst lang) {
		if (ColorNameEnum.getByName(user_color) == null && ColorNameEnum.getByCode(user_color) == null) {
			return MessageConst.E_NO_SUCH_USER_COLOR.getMessage(lang);
		}

		return "";	//No errors detected then empty string
	}

//	/**
//	 * Do validation about null check
//	 * @param ConfigureView
//	 * @throws NullPointerException When include null at ConfigureView in range of validation
//	 */
//	private static void validateNonNull(ConfigureView cv) {
//		List<String> errors = new ArrayList<>();
//		@SuppressWarnings("unused")
//		Object checkNull = null;
//		if (null == (checkNull = cv.getUser_color())) {
//			errors.add("User_color is null");
//		}
//
//	}

}
