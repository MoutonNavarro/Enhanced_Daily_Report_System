package constants.interfaces;

import constants.ForwardConst;
import constants.LanguageClassConst;

public class test {
	public static void main(String...strings ) {
		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue());
		String str = "English";
		System.out.println(((ForwardConst)LanguageClassConst.getByLanguageName(str).getForward()).FW_ERR_UNKNOWN.getValue());
		str = "日本語";
		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue());
	}
}
