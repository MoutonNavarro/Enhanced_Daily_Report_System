package constants;

/**
 * Enum class that defines color profile
 */
public enum ColorCodeConst {
   PINK("Pink"),
   YELLOW("Yellow"),
   GREEN("Green"),
   BLUE("Blue"),
   RED("Red"),
   BLACK("Black"),
   SIBUYAS("#A54200"),
   BERDE("#31572A"),
   ASUL("#5E4266"),
   KULAY_ROSAS("#FF3B60"),
   KULAY_UBE("#36425C"),
   DEFAULT("");

   //Color name for foreground
   private final String code;
   private ColorCodeConst(final String code) {
      this.code = code;
   }

   /**
    * Acquire color code
    * @return This enum's color code(RGB value)
    */
   public String getCode() {
      return code;
   }
}
