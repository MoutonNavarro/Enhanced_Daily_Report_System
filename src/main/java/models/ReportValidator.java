package models;

import java.util.ArrayList;
import java.util.List;

import actions.views.ReportView;
import constants.MessageConst;

/**
 * Class that validate of set value at the Report instance
 */
public class ReportValidator {

	/**
	 * Do validation about each items of the Report instance
	 * @param rv Report instance
	 * @return Errors list
	 */
	public static List<String> validate(ReportView rv){
		List<String> errors = new ArrayList<>();

		//Check title
		String titleError = validateTitle(rv.getTitle());
		if (!titleError.equals("")) {
			errors.add(titleError);
		}

		//Check content
		String contentError = validateContent(rv.getContent());
		if(!contentError.equals("")) {
			errors.add(contentError);
		}

		return errors;
	}

	/**
	 * Check whether there is input value in title and return error message if not input value there
	 * @param title Title
	 * @return Error message
	 */
	private static String validateTitle(String title) {
		if (title == null || title.equals("")) {
			return MessageConst.E_NOTITLE.getMessage();
		}

		//In case there is input value then return empty string
		return "";
	}

	/**
	 * Check whether there is input value in content and return error message if not input value there
	 * @param content Content
	 * @return error message
	 */
	private static String validateContent(String content) {
		if (content == null|| content.equals("")) {
			return MessageConst.E_NOCONTENT.getMessage();
		}

		//In case there is input value then return empty string
		return "";
	}
}
