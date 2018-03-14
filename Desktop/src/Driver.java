import java.io.IOException;

/**
 * 
 * @author Connor Sharp 
 * @version 2018-15-2
 * Project 1
 * 
 * This is the Driver Class for Project1, this is where the main
 * method is carried out and the functionality of the code is displayed 
 */
public class Driver 
{
    public static void main(String[] args) throws IOException 
    {
        // Creates three measurements to create a TimeData object 
        Measurement tair = new Measurement(-14.7);
        Measurement ta9m = new Measurement(-15.8);
        Measurement solarRadiation = new Measurement(404); 
        // Creates a TimeData object with the Measurements 
        TimeData timedata = new TimeData("nrmn", 2018, 01, 01, 405, tair, ta9m, solarRadiation);
        // Creates a DayData of the correct file location 
        DayData dayData = new DayData(2018, 01, 01, "nrmn","data");
        
        // Prints each of the created objects as examples and to view formating 
        System.out.println(tair);
        System.out.println(timedata);
        System.out.println("\n" + dayData);
    }

}
