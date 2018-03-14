/**
 * 
 * @author CS2334.  Modified by Stephen Thung
 * @version 2018-02-12
 * Lab 5
 * 
 * Exception class when the program encounters a bad input.
 * 
 * This class extends BankException; it also stores
 * additional information about the type of illegal input
 * that occurred.
 */
public class IllegalInputException extends BankException
{
    /**
     * The type of illegal input. This should be one of these:
     *  -"Illegal Token Length"
     *  -"Illegal Command"
     *  -"Illegal Argument"
     */
    private String exceptionType;

    /**
     * Creates an illegal input exception.
     * @param type What type of illegal input was given. Token Length, Operator, or Argument.
     */
    public IllegalInputException(String type)
    {
        this.exceptionType = type;
    }

    /**
     * Returns the exception type
     * 
     * @return String describing the exception type
     */
    public String getExceptionType()
    {
        return this.exceptionType;
    }
}
