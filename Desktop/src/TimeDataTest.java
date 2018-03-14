import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Connor Sharp
 * @version 2018-15-2
 *
 */
public class TimeDataTest
{
    /** Creates a class Measurement variable for easy repetitive use in testing  */
    private Measurement tair = new Measurement(-14.7);
    /** Creates a class Measurement variable for easy repetitive use in testing  */
    private Measurement ta9m = new Measurement(-15.8);
    /** Creates a class Measurement variable for easy repetitive use in testing  */
    private Measurement solarRadiation = new Measurement(404);
    
    /** creates a TimeData object for all of our testing */
    private TimeData timedata = new TimeData("nrmn", 2018, 01, 01, 405, tair, ta9m, solarRadiation);
    
    /**
     * TimeData Constructor test
     */
    @Test
    public void constructorTest()
    {
        // set of get methods tests that test the 
        // constructor from the above timedata initialization
        Assert.assertEquals("NRMN", timedata.getStationID()); 
        Assert.assertEquals(2018, timedata.getYear());
        Assert.assertEquals(1, timedata.getMonth());
        Assert.assertEquals(1, timedata.getDay());
        Assert.assertEquals(405, timedata.getMinute());
        Assert.assertEquals(tair, timedata.getTair());
        Assert.assertEquals(ta9m, timedata.getTa9m());
        Assert.assertEquals(solarRadiation, timedata.getSolarRadiation());
    }
    
    /**
     * TimeData toString Test
     */
    @Test
    public void toStringTest()
    {
        Assert.assertEquals("NRMN: Air temperature[1.5m] = -14.7000, "
                + "Air temperature[9m] = -15.8000, Solar Radiation = 404.0000", timedata.toString());
    }
            
    
}
