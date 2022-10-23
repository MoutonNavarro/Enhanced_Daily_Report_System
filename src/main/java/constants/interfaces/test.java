package constants.interfaces;

import constants.ForwardConst;
import constants.en.FormatConst;

public class test {
	public static void main(String...strings ) {
		Forward f1 = constants.en.ForwardConst.ACT;
		System.out.println(constants.en.FormatConst.class.isAssignableFrom(FormatConst.class));
		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue());
//		String str = "English";
//		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue(str));
//		str = "日本語";
//		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue(str));
	}
}
