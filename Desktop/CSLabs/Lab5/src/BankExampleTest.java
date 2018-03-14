import static org.junit.Assert.*;
import org.junit.Assert;

import org.junit.Test;

/**
 * Test class for Bank class
 * 
 * TODO: copy these tests into another class or expand this class.
 * By the end, you should have full code coverage. The todos within
 * this class should guide you in making your tests to acheive this
 * goal. The tests given here without TODOs are fully implemented.
 * You can use these to help make sure your program runs correctly.
 * 
 * @author Stephen Thung
 * @version 2018-02-12
 *
 */
public class BankExampleTest
{

    /**
     * Test correct deposits
     *
     */
    @Test
    public void executeDepositTest1() 
    {
        // Put this at the start of all of your tests. Makes unit tests play nicely:
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Assert.assertEquals("depositing is not working properly", 5, Bank.getAccountOneMoney());
        }
        catch (BankException e)
        {
            Assert.fail("Legal expression threw an Exception");
        }
    }

    /**
     * Test quit
     * execute() should throw a quit exception when quit is read.
     * As such, we want to make sure that we catch a quit exeception
     * and no other exception.
     */
    @Test
    public void executeQuitTest1()
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"quit"});
            // If we do not throw a quit exception, the code is not working correctly.
            // As such, we say that the test should fail. This exits the test immediately.
            // It has the same effect as failing an assertion.
            Assert.fail("String \"quit\" does not generate an Exception");
        }
        catch (QuitException e)
        {
            // Do nothing in this case The test will continue to the end and finish sucessfully.
        }
        catch (BankException e)
        {
            // If we catch any other exception, the code is likely throwing the wrong type
            // of exception. Thus, we fail.
            Assert.fail("String \"quit\" should have generated a QuitException");
        }
        
        // Once we exit the try/catch block, there is no more code to execute. The test ends.
        // A test is considered a success if it reaches the end.
    }
    
    /**  
     * Test correct withdrawal
     */ 
    @Test 
    public void executeWithdrawTest1() throws BankException  
    { 
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"withdraw", "4"});
            Assert.assertEquals("withdrawing (or depositing) is not working properly", 1, Bank.getAccountOneMoney());
        }
        catch (BankException e)
        {
            Assert.fail("Legal expression threw an Exception");
        }
    }
    
    /**  
     * Test incorrect withdrawal
     * Remember that with our unit tests, to achieve full code coverage, we need
     * to go down every branching path of code. As such, when we have a try/catch,
     * we need to test both the part of the code 
     */
    @Test 
    public void executeWithdrawTest2() throws BankException  
    { 
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"withdraw", "6"});
            Assert.fail("Should not be able to withdraw more than is deposited");
        }
        catch (InsufficientFundsException e)
        {
            // Do nothing. Succeed.
        }
        catch (BankException e)
        {
            Assert.fail("Threw an incorrect Exception, expecting InsufficientFunds");
        }
    }

    /**
     * Test Single Illegal Arg
     * Make sure that the code throws the correct exception for an illegal argument.
     * This has a very similar logic to the previous test.
     */
    @Test
    public void executeSingleIllegalArgTest()
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"foo"});
            Assert.fail("String \"foo\" should generate an Exception");
        }
        catch (IllegalInputException e)
        {
            Assert.assertEquals("IllegalInputException generated, but with incorrect message", "Illegal Command", 
                    e.getExceptionType());
        }
        catch (BankException e)
        {
            Assert.fail("String \"foo\" should generate an IllegalInputException");
        }
    }
    
    /** 
     * Test correct transferring
     */  
    @Test 
    public void executeTransferTest1() throws BankException  
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"transfer", "one", "two", "4"});
            Assert.assertEquals("Transfer out amount incorrect", 1, Bank.getAccountOneMoney());
            Assert.assertEquals("Transfer in amount incorrect", 4, Bank.getAccountTwoMoney());
        }
        catch (BankException e)
        {
            Assert.fail("Threw an incorrect Exception, expecting InsufficientFunds");
        }
    }
    
    /** 
     * Test correct transferring
     */  
    @Test 
    public void executeTransferTest2() throws BankException  
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"transfer", "one", "two", "4"});
            Bank.execute(new String[]{"transfer", "two", "one", "3"});
            Assert.assertEquals("Transfer out amount incorrect", 4, Bank.getAccountOneMoney());
            Assert.assertEquals("Transfer in amount incorrect", 1, Bank.getAccountTwoMoney());
        }
        catch (BankException e)
        {
            Assert.fail("Threw an incorrect Exception, expecting InsufficientFunds");
        }
    }

    /** 
     * Test incorrect transferring
     */  
    @Test 
    public void executeTransferTest3() throws BankException  
    {
        Bank.reset();
        // TODO: test when you try to transfer too much money out of accountOne
    }
    
    /** 
     * Test incorrect transferring
     */  
    @Test 
    public void executeTransferTest4() throws BankException  
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"transfer", "one", "two", "3"});
            Bank.execute(new String[]{"transfer", "two", "one", "6"});
            Assert.fail("Should not be able to transfer more than is in account");
        }
        catch (InsufficientFundsException e)
        {
            // Do nothing. Succeed.
        }
        catch (BankException e)
        {
            Assert.fail("Threw an incorrect Exception, expecting InsufficientFunds");
        }
    }
    
    /** 
     * Test incorrect transferring
     */  
    @Test 
    public void executeTransferTest5() throws BankException  
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"aaaa", "one", "two", "3"});
            Assert.fail("Should not transfer with bad command");
        }
        catch (IllegalInputException e)
        {
            Assert.assertEquals("Threw IllegalInputException with illegal input, but message incorrect", 
                    "Illegal Command",  
                    e.getExceptionType());
        }
        catch (BankException e)
        {
            Assert.fail("Threw an incorrect Exception, expecting IllegalInputException");
        }
    }
    
    /** 
     * Test incorrect transferring
     */  
    @Test 
    public void executeTransferTest6() throws BankException  
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"transfer", "aaaa", "two", "3"});
            Assert.fail("Should not transfer with bad account name");
        }
        catch (IllegalInputException e)
        {
            Assert.assertEquals("Threw IllegalInputException with illegal input, but message incorrect", 
                    "Illegal Argument",  
                    e.getExceptionType());
        }
        catch (BankException e)
        {
            Assert.fail("Threw an incorrect Exception, expecting IllegalInputException");
        }
    }
    
    /** 
     * Test incorrect transferring
     */  
    @Test 
    public void executeTransferTest7() throws BankException  
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"transfer", "one", "aaaaa", "3"});
            Assert.fail("Should not transfer with bad account name");
        }
        catch (IllegalInputException e)
        {
            Assert.assertEquals("Threw IllegalInputException with illegal input, but message incorrect", 
                    "Illegal Argument",  
                    e.getExceptionType());
        }
        catch (BankException e)
        {
            Assert.fail("Threw an incorrect Exception, expecting IllegalInputException");
        }
    }
    
    /** 
     * Test incorrect transferring
     */  
    @Test 
    public void executeTransferTest8() throws BankException  
    {
        Bank.reset();
        // TODO: test when you try to transfer money from account "two" to an account with a bogus name
    }
    
    /** 
     * Test incorrect transferring
     */  
    @Test 
    public void executeTransferTest9() throws BankException  
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"transfer", "one", "two", "aaa"});
            Assert.fail("Should not transfer with bad input value");
        }
        catch (IllegalInputException e)
        {
            Assert.assertEquals("Threw IllegalInputException with illegal input, but message incorrect", 
                    "Illegal Argument",  
                    e.getExceptionType());
        }
        catch (BankException e)
        {
            Assert.fail("Threw an incorrect Exception, expecting IllegalInputException");
        }
    }
    
    /** 
     * Test incorrect transferring
     */  
    @Test 
    public void executeTransferTest10() throws BankException  
    {
        Bank.reset();
        try
        {
            Bank.execute(new String[]{"deposit", "5"});
            Bank.execute(new String[]{"transfer", "two", "one", "aaa"});
            Assert.fail("Should not transfer with bad input value");
        }
        catch (IllegalInputException e)
        {
            Assert.assertEquals("Threw IllegalInputException with illegal input, but message incorrect", 
                    "Illegal Argument",  
                    e.getExceptionType());
        }
        catch (BankException e)
        {
            Assert.fail("Threw an incorrect Exception, expecting IllegalInputException");
        }
    }
    
    // TODO: make tests for a bad number of arguments
    
    // TODO: test for an illegal command for a single input token.
    // i.e. test for the case where the user inputs a single token that is not "quit"
    // For example, if the user input "hello", the program should give back an IllegalInputException
    // because the command "hello" is not a valid 1 token choice.
    
    // TODO: ensure that you have sufficient tests for full code coverage
    
    /**  
     * Test Double Illegal Arg  
     * 
     */  
    @Test 
    public void executeDoubleInputIllegalTest1()
    {
        Bank.reset();
        try  
        { 
            Bank.execute(new String[]{"foo", "bar"}); 
            Assert.fail("Did not throw IllegalInputException");  
        }  
        catch (IllegalInputException e)  
        { 
            Assert.assertEquals("Threw IllegalInputException, but message incorrect",  
                    "Illegal Command", 
                    e.getExceptionType()); 
        } 
        catch (BankException e)  
        {  
            Assert.fail("Did not throw IllegalInputException, but did throw an Exception"); 
        } 
    }  


    /**  
     * Test Double Illegal Arg 
     * 
     */ 
    @Test 
    public void executeDoubleInputIllegalTest2()
    {
        Bank.reset();
        try  
        { 
            Bank.execute(new String[]{"deposit", "aaa"});  
            Assert.fail("Did not throw an Exception when a bad argument is input");  
        } 
        catch (IllegalInputException e) 
        {  
            Assert.assertEquals("Threw an IllegalInputException, but message was wrong", "Illegal Argument",  
                    e.getExceptionType());  
        } 
        catch (BankException e)  
        {  
            Assert.fail("Did not throw an IllegalInputException when a bad argument is input"); 
        } 
    }
    
    /**  
     * Test Double Illegal Arg 
     * 
     */ 
    @Test 
    public void executeDoubleInputIllegalTest3()
    {
        Bank.reset();
        try  
        { 
            Bank.execute(new String[]{"withdraw", "aaa"});  
            Assert.fail("Did not throw an Exception when a bad argument is input");  
        } 
        catch (IllegalInputException e) 
        {  
            Assert.assertEquals("Threw an IllegalInputException, but message was wrong", "Illegal Argument",  
                    e.getExceptionType());  
        } 
        catch (BankException e)  
        {  
            Assert.fail("Did not throw an IllegalInputException when a bad argument is input"); 
        } 
    }

/* ****************************************
 * Below are tests for parseAndExecute
 * ****************************************/
    
    /** 
     * Test parseAndExecute: quit 
     * 
     */ 
    @Test 
    public void parseAndExecuteQuit()  
    { 
        Bank.reset();
        // TODO: test that quitting works
    }
    
    /** 
     * Test parseAndExecute: output for a bad command
     * 
     */ 
    @Test 
    public void parseAndExecuteBadCommand()  
    { 
        Bank.reset();
        // TODO: test that parseAndExecute handles bad command correctly
    }
    
    /** 
     * Test parseAndExecute: output for insufficient funds
     * 
     */ 
    @Test 
    public void parseAndExecuteBadTransaction()  
    { 
        Bank.reset();
        // TODO: test that parseAndExecute handles bad transactions correctly
    }

    /**
     * Test parseAndExecute: normal deposit
     * 
     */
    @Test
    public void parseAndExecuteDeposit()
    {
        Bank.reset();
        Assert.assertEquals("parseAndExecute() should return input with a valid expression", 
                "Input was: deposit 5", Bank.parseAndExecute("deposit 5"));
    }

    /**
     * Bogus test to address ECLEMMA code coverage bug
     */
    @Test
    public void constructorTest()
    {
        // We aren't actually testing anything here - just addressing a bug in the
        //  code coverage computation
        new Bank();
        // Web-Cat wants an Assert here: use one that will always pass
        Assert.assertTrue(true);
    }

}
