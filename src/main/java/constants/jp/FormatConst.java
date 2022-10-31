package constants.jp;

import constants.interfaces.Format;

/**
 * Enum class that defines format for date and etc.
 */
public enum FormatConst implements Format{
   TIME_FORMAT("yyyy/MM/dd HH:mm:ss"),
   DATE_FORMAT("yyyy/MM/dd"),
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
   @Override
   public String getFormat() {
      return this.format;
   }

}
