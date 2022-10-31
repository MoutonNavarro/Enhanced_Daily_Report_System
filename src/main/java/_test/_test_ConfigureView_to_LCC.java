package _test;

import actions.views.ConfigureView;
import constants.LanguageClassConst;

class _test_ConfigureView_to_LCC {

   public static void main(String[] args) {
      ConfigureView cv1 = new ConfigureView(null, null, null, "eng", "usa", "UTC+08:00", "Manila", (byte)2, "default", false, false, "", "", false);
      ConfigureView cv2 = new ConfigureView(null, null, null, "eng", null, "UTC+08:00", "Manila", (byte)2, "default", false, false, "", "", false);
      ConfigureView cv3 = new ConfigureView(null, null, null, "jpn", "jpn", "UTC+08:00", "Manila", (byte)2, "default", false, false, "", "", false);
      ConfigureView cv4 = new ConfigureView(null, null, null, "jpn", "rok", "UTC+08:00", "Manila", (byte)2, "default", false, false, "", "", false);

      System.out.println(LanguageClassConst.getByConfigureView(cv1));
      System.out.println(LanguageClassConst.getByConfigureView(cv2));
      System.out.println(LanguageClassConst.getByConfigureView(cv3));
      System.out.println(LanguageClassConst.getByConfigureView(cv4));
      System.out.println(LanguageClassConst.getByConfigureView(cv1).getLanguageName());
      System.out.println(LanguageClassConst.getByConfigureView(cv2).getLanguageName());
      System.out.println(LanguageClassConst.getByConfigureView(cv3).getLanguageName());
      System.out.println(LanguageClassConst.getByConfigureView(cv4).getLanguageName());

   }

}
