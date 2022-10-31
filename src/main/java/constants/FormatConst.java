package constants;

import constants.interfaces.Format;

/**
 * Enum class that defines format for date and etc.
 */
public enum FormatConst {
   TIME_FORMAT("MM/dd/yyyy HH:mm:ss"),
   DATE_FORMAT("MM/dd/yyyy"),
   ;

   /**
    * Field
    */
   private final String format;

   /**
    * Constructor
    */
   private FormatConst(final String format) {
      this.format = format;
   }

   /**
    * Acquire the format
    * @return Format
    */
   private String getFormat() {
      return format;
   }

   /**
    * Acquire the format that localized
    * @param lang LanguageClassConst type enum object
    * @return Localized format (if no such declared value then original format)
    */
   public String getFormat(LanguageClassConst lang) {
      try {
         return ((Format)valueOf(lang.getFormat(), this.name())).getFormat();
      }catch (IllegalArgumentException| NullPointerException e) {
         return getFormat();
      }
   }

}
