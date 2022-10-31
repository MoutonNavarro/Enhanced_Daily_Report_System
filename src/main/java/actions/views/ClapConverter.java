package actions.views;

import models.Clap;

/**
 * Class that mutual converts the configuration data's DTO model and View model
 */
public class ClapConverter {
   /**
    * Create DTO model's instance from View model's instance
    * @param cv ClapView's instance
    * @return Clap's instance
    * @throws NullPointerException In case that null argument
    */
   public static Clap toModel(ClapView cv) {
      return new Clap(cv.getId(), cv.getReport_id(),  cv.getEmployee_id(), cv.getReaction());
   }

   /**
    * Create View model's instance from DTO model's instance
    * @param c Clap's instance
    * @return ClapView's instance
    */
   public static ClapView toView(Clap c) {

      if (c == null) {
         return null;
      }

      return new ClapView(c.getId(), c.getReport_id(),   c.getEmployee_id(),  c.getReaction());
   }

   /**
    * Copy all field's content of View model to DTO model's field
    * @param c DTO model (copy to)
    * @param cv View model (copy from)
    */
   public static void copyViewToModel(Clap c, ClapView cv) {
      c.setId(cv.getId()); c.setReport_id(cv.getReport_id());  c.setEmployee_id(cv.getEmployee_id()); c.setReaction(cv.getReaction());

   }

}
