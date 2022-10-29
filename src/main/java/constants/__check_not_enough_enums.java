package constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class that check not enough enum classes(for localize)
 */
class __check_not_enough_enums {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		LanguageClassConst[] lang = LanguageClassConst.class.getEnumConstants();
		//FormatConst
		System.out.println("FormatConst:");
		FormatConst[] format = FormatConst.class.getEnumConstants();
		for (LanguageClassConst lang_name : lang) {
			List<String> list = new ArrayList<>();
			for (FormatConst f : format) {
				try {
					FormatConst.valueOf(LanguageClassConst.getByLanguageName(lang_name.getLanguageName()).getFormat(), f.name());
				}catch (IllegalArgumentException e) {
					list.add(f.toString());
				}
			}
			if (list.size() > 0) {System.out.println(lang_name.getLanguageName() + "'s not enough enums: " + list);}
		}

		//ForwardConst
		System.out.println("ForwardConst:");
		ForwardConst[] forward = ForwardConst.class.getEnumConstants();
		for (LanguageClassConst lang_name : lang) {
			List<String> list = new ArrayList<>();
			for (ForwardConst f : forward) {
				try {
					ForwardConst.valueOf(LanguageClassConst.getByLanguageName(lang_name.getLanguageName()).getForward(), f.name());
				}catch (IllegalArgumentException e) {
					list.add(f.toString());
				}
			}
			if (list.size() > 0) {System.out.println(lang_name.getLanguageName() + "'s not enough enums: " + list);}
		}

		//HtmlConst
		System.out.println("HtmlConst:");
		HtmlConst[] html = HtmlConst.class.getEnumConstants();
		for (LanguageClassConst lang_name : lang) {
			List<String> list = new ArrayList<>();
			for (HtmlConst f : html) {
				try {
					HtmlConst.valueOf(LanguageClassConst.getByLanguageName(lang_name.getLanguageName()).getHtml(), f.name());
				}catch (IllegalArgumentException e) {
					list.add(f.toString());
				}
			}
			if (list.size() > 0) {System.out.println(lang_name.getLanguageName() + "'s not enough enums: " + list);}
		}

		//MessageConst
		System.out.println("MessageConst:");
		MessageConst[] message = MessageConst.class.getEnumConstants();
		for (LanguageClassConst lang_name : lang) {
			List<String> list = new ArrayList<>();
			for (MessageConst f : message) {
				try {
					MessageConst.valueOf(LanguageClassConst.getByLanguageName(lang_name.getLanguageName()).getMessage(), f.name());
				}catch (IllegalArgumentException e) {
					list.add(f.toString());
				}
			}
			if (list.size() > 0) {System.out.println(lang_name.getLanguageName() + "'s not enough enums: " + list);}
		}

	}

}
