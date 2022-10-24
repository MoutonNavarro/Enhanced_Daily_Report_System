package constants.interfaces;

import constants.ForwardConst;

class test {
	public static void main(String...strings ) {
		Forward f1 = constants.en.ForwardConst.ACT;
		System.out.println(constants.en.FormatConst.class.getSimpleName());
		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue());
		String str = "English";
		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue(str));
		str = "Japanese";
		System.out.println(ForwardConst.FW_ERR_UNKNOWN.getValue(str));
		System.out.println(constants.en.MessageConst.class.isAssignableFrom(constants.interfaces.Message.class));
		System.out.println(constants.interfaces.Message.class.isAssignableFrom(constants.en.MessageConst.class));
		System.out.println(services.ConfigureService.class.isAssignableFrom(AutoCloseable.class));
		System.out.println(AutoCloseable.class.isAssignableFrom(services.ConfigureService.class));
		}
}
