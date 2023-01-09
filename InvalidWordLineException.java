public class InvalidWordLineException extends IllegalArgumentException{
   /*
    * calls super class, giving the invalid argument.
    */
   public InvalidWordLineException() {
      super("Invalid: Line number is less than 1");
   }
}
