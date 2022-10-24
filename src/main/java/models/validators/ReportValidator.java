package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ReportView;
import constants.LanguageClassConst;
import constants.MessageConst;

/**
 * Class that validate of set value at the Report instance
 */
public class ReportValidator {

	/**
	 * Do validation about each items of the Report instance
	 * @param rv Report instance
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return Errors list
	 */
	public static List<String> validate(ReportView rv, LanguageClassConst lang){
		List<String> errors = new ArrayList<>();

		//Check title
		String titleError = validateTitle(rv.getTitle(), lang);
		if (!titleError.equals("")) {
			errors.add(titleError);
		}

		//Check content
		String contentError = validateContent(rv.getContent(), lang);
		if(!contentError.equals("")) {
			errors.add(contentError);
		}

		return errors;
	}

	/**
	 * Check whether there is input value in title and return error message if not input value there
	 * @param title Title
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return Error message
	 */
	private static String validateTitle(String title, LanguageClassConst lang) {
		if (title == null || title.equals("")) {
			return MessageConst.E_NOTITLE.getMessage(lang);
		}

		//In case there is input value then return empty string
		return "";
	}

	/**
	 * Check whether there is input value in content and return error message if not input value there
	 * @param content Content
	 * @param lang For localize based on LanguageClassConst enum object
	 * @return error message
	 */
	private static String validateContent(String content, LanguageClassConst lang) {
		if (content == null|| content.equals("")) {
			return MessageConst.E_NOCONTENT.getMessage(lang);
		}

		//In case there is input value then return empty string
		return "";
	}
}
