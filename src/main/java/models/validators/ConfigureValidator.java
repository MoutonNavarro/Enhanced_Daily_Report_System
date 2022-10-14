package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ConfigureView;

/**
 * Class that validates value set at Configure instance
 */
public class ConfigureValidator {

	/**
	 * Do validation about each items of Configure instance
	 * @param cv Configure instance
	 * @return Errors list
	 */
	public static List<String> validate(ConfigureView cv) {
		List<String> errors = new ArrayList<>();

		//Check user_color
		String userColorError = validateUserColor(cv.getUser_color());
		if (!userColorError.equals("")) {
			errors.add(userColorError);
		}
		//[Locked] We must declares color name constants

		//[Locked] We must implements other function

		return errors;
	}

	private static String validateUserColor(String user_color) {
		if (user_color == null) {
			return "Bad user_color request";
		}
		return "";	//No errors detected then empty string
	}

}
