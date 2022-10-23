package constants.interfaces;

import constants.ForwardConst;

class test {
	public static void main(String...strings ) {
		Forward f1 = constants.en.ForwardConst.ACT;
		System.out.println(constants.en.FormatConst.class.getSimpleName());
		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue());
		String str = "English";
		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue(str));
		str = "日本語";
		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue(str));
	}
}
