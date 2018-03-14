/**
 * 
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-12
 * Lab 5
 * 
 * The Bank class represents a simple bank that holds two accounts. The accounts
 * are represented by the integer values "accountOneMoney" and "accountTwoMoney",
 * indicating the value in USD held in each account. Of note, the accounts are static,
 * and are shared by all instances of the Bank class (and are stored in the class itself).
 * This means, for example, that if you have Bank objects b1 and b2, the value of
 * "accountOne/TwoMoney" will be the same in both objects, and any changes to the
 * accounts will be reflected in the other bank. This also means that you may change the
 * value of the variables without using any bank objects. You can call static methods in
 * the class to alter them. E.g. instead of changing a variable with:
 *      (b1 is a Bank object) b1.addToAccount(5);
 * you can simply call the method on the class itself:
 *      Bank.addToAccount(5);
 *      
 * For simplicity, the user can only deposit or withdraw from accountOne.
 * 
 * The Bank class provides functionality for parsing input strings that contain
 * simple bank commands (Add to account, subtract from account, transfer from account, etc...).
 * The Bank class also handles errors that arise from incorrect commands.
 *
 */

public class Bank 
{
    /**
     * The amount of money in the first account.
     */
    private static int accountOneMoney = 0;
    
    /**
     * The amount of money in the second account.
     */
    private static int accountTwoMoney = 0;
    
    /**
     * Getter used to better test code.
     * @return the amount in USD stored in account one.
     */
    public static int getAccountOneMoney()
    {
        return accountOneMoney;
    }
    
    /**
     * Getter used to better test code.
     * @return the amount in USD stored in account one.
     */
    public static int getAccountTwoMoney()
    {
        return accountTwoMoney;
    }
    
    /**
     * Used to make tests work nicely. Put Bank.reset() at the start of all
     * of your tests.
     */
    public static void reset()
    {
        accountOneMoney = 0;
        accountTwoMoney = 0;
    }
    
    /**
     * This constructor has been added to trick the code coverage measure into 
     * doing the right thing
     */
    public Bank()
    {
        // Constructor does nothing
    }

    /**
     * Execute the expression encoded in a sequence of tokens.
     * 
     * For each number of tokens that the program receives, it may behave in different ways.
     * That is, for each number of tokens, the program expects a certain format of input. When
     * the input does not match its expectations, the program should throw an exception. Follow
     * the below cases to determine when you should throw an exception. The cases outline all
     * possibilities for inputs - all the ways an input can be formatted both correctly and
     * incorrectly, and how to choose what to do as a result (operate normally or throw and
     * exception).
     * 
     * Note: the IllegalInputException has a String parameter in its constructor. This gives
     * some additional information about the Exception. When throwing these, make sure to 
     * add the correct info. For example, in the 0 tokens case, we would declare:
     * "throw new IllegalInputException("Illegal Token Length");"
     * 
     * Also, for simplicity, in our tests we will never give you a negative integer as an
     * input, so you don't need to check for this.
     * 
     * 0 tokens: IllegalInputException: "Illegal Token Length"
     * 1 token:
     *      "quit" (any casing): QuitException
     *      All other cases: IllegalInputException: "Illegal Argument"
     * 2 tokens:
     *      "deposit" and any int: add the input number value to accountOne
     *      "deposit" and not a int: IllegalInputException: "Illegal Argument"
     *      "withdraw" and any int < accountOneMoney: subtract the input number value from accountOne
     *      "withdraw" and any int > accountOneMoney: InsufficientFundsException() [Can't withdraw more than you have!]
     *      "withdraw" and not a int: IllegalInputException: "Illegal Argument"
     *      any other string (first token) and any string (second token): IllegalInputException: "Illegal Command"
     * 3 tokens: IllegalInputException: "Illegal Token Length"
     * 4 tokens:
     *      "transfer one two" and an int value: transfer value from accountOne to accountTwo
     *                                           throw InsufficientFundsException if accountOne - value < 0
     *      "transfer two one" and an int value: transfer value from accountTwo to accountOne
     *                                           throw InsufficientFundsException if accountTwo - value < 0
     *      "transfer one two" and not an int value: IllegalInputException: "Illegal Argument"
     *      "transfer two one" and not an int value: IllegalInputException: "Illegal Argument"
     *      "transfer" followed by two strings that are not either "one two" or "two one": IllegalInputException: "Illegal Argument"
     *      any first token that is not "transfer": IllegalInputException: "Illegal Command"
     * 5+ tokens: IllegalInputException: "Illegal Token Length"
     * 
     * @param tokens The array of tokens to evaluate
     * @throws BankException If some form of error has been generated or
     * "quit" has been typed. Throws one of the several child classes of CalculatorException
     * in order to give more information on what the error is.
     */
    public static void execute(String[] tokens) throws BankException
    {
        // Condition on the number of tokens (number of strings in user input separated by spaces)
        switch(tokens.length)
        {
            case 0:
                // Insufficient number of tokens
                throw new IllegalInputException("Illegal Token Length");

            case 1:
                // Only valid case: quit
                if (tokens[0].equalsIgnoreCase("quit"))
                {
                    // TODO: throw a quit exception
                }
                else
                {
                    throw new IllegalInputException("Illegal Command");
                }

            case 2:
                // Two cases: deposit and withdraw
                // Valid commands are of form: <deposit/withdraw> <amount>
                if (tokens[0].equalsIgnoreCase("deposit"))
                {
                    try
                    {
                        // Make sure the deposit amount is an integer:
                        int deposit = Integer.parseInt(tokens[1]);
                        accountOneMoney += deposit;
                    }
                    catch (NumberFormatException e)
                    {
                        // If Integer.parseInt fails, we know that the second token is not an int
                        // As such, we throw an IllegalArgumentException
                        throw new IllegalInputException("Illegal Argument");
                    }
                }
                else if (tokens[0].equalsIgnoreCase("withdraw"))
                {
                    // TODO: withdraw from accountOne
                    // TODO: throw appropriate exception if input is bad
                    // TODO: throw InsufficientFundsException if withdraw amount is > accountOneMoney
                }
                else
                {
                    throw new IllegalInputException("Illegal Command");
                }
                break;

            case 3:
                // Not a valid token length
                // TODO: handle this case
            
            case 4:
                // Only valid case: transfer money
                // Valid commands are of form: <deposit/withdraw> <amount>
                if (tokens[0].equalsIgnoreCase("transfer"))
                {
                    // Case: transfer from accountOne to accountTwo
                    if (tokens[1].equalsIgnoreCase("one") && tokens[2].equalsIgnoreCase("two"))
                    {
                        // TODO: remove transfer amount from accountOne and add it to accountTwo
                        // TODO: if transfer amount is not an int, throw an exception
                        // TODO: if transfer amount is > accountOneMoney, throw an exception
                    }
                    // TODO: Case: transfer from accountTwo to accountOne
                    else if 
                    
                    // TODO: Case: invalid account specified
                    else
                    
                }
                else
                {
                    // TODO: handle the case when the first token is not "transfer"
                }
                break;

            default:
                // 5 or more tokens
                // TODO: handle this case
        }

    }

    /**
     * Parse the input string as an expression and evaluate it.
     * 
     * Tokens in the string are separated by spaces. I.e. the string "a b" has two tokens:
     * "a" and "b".
     * 
     * If the input is a legal expression, then the return a String of the format:
     * "Input was: <input>", where <input> was the String Parameter passed into the function.
     * 
     * Otherwise a BankException has occurred.  Return a message based on
     * what exception type it is.
     * 
     * -QuitException: "quit"
     * -InsufficentFundsException (This is the BankException catch): "Not Enough Money!"
     * -IllegalInputException: "Illegal input: " + illegalinputtype(given to constructor, use a getter on the exception [look at the class!])
     * 
     * @param input A String possibly containing a bank command
     * @return "quit" if the program should end, information on how the program executed else.
     */
    public static String parseAndExecute(String input)
    {
        // Pull out the tokens
        // TODO: split up the input into tokens
        try
        {
            // Attempt to evaluate the sequence of tokens
            // TODO: call execute
        }
        catch (QuitException e)
        {
            // TODO: what to return when you encounter a quit exception
        }
        catch (IllegalInputException e)
        {
            // An error has occurred: return the message
            // TODO: what to return when you encounter this exception
        }
        catch (BankException e)
        {
            // This catches the remaining CalculatorException case: InsufficientFundsException
            // We are doing it this way so that ECLEMMA (code coverage measure) is happy
            // TODO: what to return when you encounter this exception
        }
        
        // Quit has not been specified
        // TODO: what to return when you encounter no exception
    }
}
