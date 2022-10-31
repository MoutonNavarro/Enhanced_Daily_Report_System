package constants;

/**
 * Enum class that defines the application scope's parameter names
 */
public enum PropertyConst {
   //Pepper string
   PEPPER("pepper");

   private final String text;
   private PropertyConst(final String text) {
      this.text = text;
   }

   public String getValue() {
      return this.text;
   }
}
