package constants;

import java.util.ArrayList;
import java.util.List;

class test_for_enough_items_at_enums {

   public static void main(String[] args) {
      {
         MessageConst[] m = MessageConst.class.getEnumConstants();
         constants.en.MessageConst[] m1 = constants.en.MessageConst.class.getEnumConstants();
         List<String> f1 = new ArrayList<>();
         for (MessageConst mi : m) {
            try {
               constants.en.MessageConst.valueOf(mi.name());
            }catch (IllegalArgumentException e){
               f1.add(mi.toString());
            }
         }
         System.out.println("en: " + f1);
         constants.jp.MessageConst[] m2 = constants.jp.MessageConst.class.getEnumConstants();
         List<String> f2 = new ArrayList<>();
         for (MessageConst mi : m) {
            try {
               constants.jp.MessageConst.valueOf(mi.name());
            }catch (IllegalArgumentException e){
               f2.add(mi.toString());
            }
         }
         System.out.println("jp: " + f2);
      }
      {
         ForwardConst[] m = ForwardConst.class.getEnumConstants();
         constants.en.ForwardConst[] m1 = constants.en.ForwardConst.class.getEnumConstants();
         List<String> f1 = new ArrayList<>();
         for (ForwardConst mi : m) {
            try {
               constants.en.ForwardConst.valueOf(mi.name());
            }catch (IllegalArgumentException e){
               f1.add(mi.toString());
            }
         }
         System.out.println("en: " + f1);
         constants.jp.ForwardConst[] m2 = constants.jp.ForwardConst.class.getEnumConstants();
         List<String> f2 = new ArrayList<>();
         for (ForwardConst mi : m) {
            try {
               constants.jp.ForwardConst.valueOf(mi.name());
            }catch (IllegalArgumentException e){
               f2.add(mi.toString());
            }
         }
         System.out.println("jp: " + f2);
      }

   }

}
