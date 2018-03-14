import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Connor Sharp 
 * @version 2018-15-2
 * Project 1
 * 
 * This is a Test Class for the DayData Class 
 *
 */
public class DayDataTest
{
    /**
     * Test the functionality of the DayData Constructor and therefore 
     * tests the functionality of the entire DayData class because all
     * necessary methods are called in the constructor 
     */
    @Test
    public void constructorTest()
    {
        // creates a DayData object from a new csv file that 
        // I created with more predictable data with known values
        DayData daydata = new DayData(2018, 01, 01, "nrmn", "data");
        // tests all the getter methods witch in turn actually tests 
        // all the methods from the DayData Class other than toString
        Assert.assertEquals(2018, daydata.getYear());
        Assert.assertEquals(1, daydata.getMonth()); 
        Assert.assertEquals(1, daydata.getDay());
        Assert.assertEquals("NRMN", daydata.getStationID());
        Assert.assertEquals(-14.9000, daydata.getTairMin(), 0.01);
        Assert.assertEquals(-6.5000, daydata.getTairMax(), 0.01);
        Assert.assertEquals(-10.8931, daydata.getTairAverage(), 0.01);
        Assert.assertEquals(-14.8000, daydata.getTa9mMin(), 0.01);
        Assert.assertEquals(-6.9000, daydata.getTa9mMax(), 0.01);
        Assert.assertEquals(-10.9723, daydata.getTa9mAverage(), 0.01);
        Assert.assertEquals(0.0000, daydata.getSolarRadiationMin(), 0.01);
        Assert.assertEquals(564.0000, daydata.getSolarRadiationMax(), 0.01);
        Assert.assertEquals(139.8264, daydata.getSolarRadiationAverage(), 0.01);
        Assert.assertEquals(40270.0000, daydata.getSolarRadiationTotal(), 0.01); 
    }
    
    /**
     * Tests the constructor for faulty input
     * 
     * @throws IOException
     */
    @Test
    public void incorrectFileLocationTest() throws IOException 
    {
        // Tries to create a DayData object with an incorrect
        // file location to test the constructors catch function
        // Wrong year "2015" and location "incorrect"
        DayData daydata = new DayData(2015, 01, 01, "nrmn", "incorrect");
        Assert.assertTrue(daydata.exceptionTest);
    }
    
    /**
     * Tests the toString method
     */
    @Test
    public void toStringTest()
    {
        // Creates a DayData object and then tests for the expected output
        DayData daydata = new DayData(2018, 01, 01, "nrmn", "data");
        Assert.assertEquals("2018-01-01, NRMN: \n"
                       + "  Air Temperature[1.5m] = [-14.9000, -6.5000, -10.8931] \n"
                       + "  Air Temperature[9m] = [-14.8000, -6.9000, -10.9726] \n"
                       + "  Solar Radiation = [0.0000, 564.0000, 139.8264, 40270.0000]", daydata.toString());
    }
}
