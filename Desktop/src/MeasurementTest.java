import org.junit.Assert;
import org.junit.Test;

 /**
  * 
  * @author Connor Sharp 
  * @version 2018-15-2
  * Project 1
  * 
  * This is a test class for the Measurement Class
  */
public class MeasurementTest
{
    /**
     * Blank constructor test 
     */
    @Test
    public void blankConstructorTest()
    {
        // calls the blank constructor 
        Measurement measurement = new Measurement();
        Assert.assertEquals(-995, measurement.getValue(), .01);
        Assert.assertFalse(measurement.isValid());
    } 
    
    /**
     * Constructor test with an input that is considered good data
     */
    @Test
    public void constructorWithParametersTest1()
    {
        // calls the constructor
        Measurement measurement = new Measurement(-14.7);
        Assert.assertEquals(-14.7, measurement.getValue(), 0.01);
        Assert.assertTrue(measurement.isValid());
    } 
    
    /**
     * Constructor test with an input that is considered bad data
     */
    @Test
    public void constructoWithParametersTest2()
    {
        //calls the constructor
        Measurement measurement = new Measurement(-995);
        Assert.assertEquals(-995, measurement.getValue(), 0.01);
        Assert.assertFalse(measurement.isValid());
    }
    
    /**
     * toString Test for Measurement
     * tests both good and bad data
     */
    @Test
    public void toStringTests()
    {
        // creates a measurement that should be considered bad
        Measurement measurement = new Measurement(-995);
        Assert.assertEquals("bad", measurement.toString());
        
        // creates a measurement that should be considered goood
        Measurement measurement2 = new Measurement(-15);
        Assert.assertEquals("-15.0000", measurement2.toString());
    }
    
    
}
