import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Connor Sharp
 * @version 2018-15-2
 * Project 1
 *
 * A Class that represents a days worth of mesonet data. The system keeps 
 * track of data at different time intervals and then calculates values including
 * minimums, maximums, averages, and totals for a specific weather station on a 
 * specific day of the year
 */
public class DayData
{
    /** An ArrayList for data at different times of the day */
    private ArrayList<TimeData> data = new ArrayList<TimeData>();
    /** Air temperature at 1.5m minimum */
    private double tairMin;
    /** Air temperature at 1.5m maximum */
    private double tairMax;
    /** Air temperature at 1.5m average */
    private double tairAverage;
    /** Air temperature at 9m minimum */
    private double ta9mMin;
    /** Air temperature at 9m maximum */
    private double ta9mMax;
    /** Air temperature at 9m average */
    private double ta9mAverage;
    /** Value for solar radiation minimum */
    private double solarRadiationMin;
    /** Value for solar radiation maximum */
    private double solarRadiationMax;
    /** Value for solar radiation average */
    private double solarRadiationAverage;
    /** Value for total solar radiation */
    private double solarRadiationTotal;
    /** The year of the data set */
    int year;
    /** The month of the data set */
    int month;
    /** The day of the data set*/
    int day;
    /** Unique station identifier */
    String stationID;
    /** whether or not an exception has been thrown (PRIMARILY FOR TESTING ONLY) */
    boolean exceptionTest = false;
    
    /**
     * Constructor for the DayData class that takes in information about the year, month,
     * day, Station, and file location to initialize and generate all the variables for the DayData Class  
     * @param year information about the year of the data set in format "yyyy"
     * @param month information about the month of the data set in format "mm"
     * @param day information about the day of the data set in format "dd"
     * @param stid unique station identification number
     * @param directory location to find and generate the correct data file
     */
    public DayData(int year, int month, int day, String stid, String directory)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.stationID = stid.toUpperCase();
        // calls read which tries to read from the correct
        // file and outputs and error message if not found
        try
        {
            read(directory);
        }
        catch (IOException e)
        {
            // Custom error message 
            System.out.println("Error reading from file!\n");
            // sets the exceptionTest to true so that it can be tested 
            // whether or not an exception has been thrown in the DayData Class 
            exceptionTest = true;
            e.printStackTrace();
        }
        
        // calls various calculate methods to help instantiate 
        // the instance variables that are not instantiated above
        this.calculateAirTemperatureStatistics("tair");
        this.calculateAirTemperatureStatistics("ta9m");
        this.calculateSolarRadiationStatistics();
    }
    
    /**
     * Helps further abstract the DayData constructor by hiding some of the details in another method,
     * takes the location of the file and reads in data to create The TimeData elements for ArrayList data
     * @param directory location of the file
     */
    public void read(String directory) throws IOException
    {
        //creates the string and location of the file directory/20180101nrmn.csv
        String filename = String.format("%s/%d%02d%02d%s.csv", directory, year, month, day, stationID.toLowerCase());
        // creates a buffered reader to read in lines from a file 
        BufferedReader br = new BufferedReader(new FileReader(filename));
        // read and discard the first line which is a header 
        String strg = br.readLine();
        // read and save the next line 
        strg = br.readLine();
        Measurement tairValue;
        Measurement ta9mValue;
        Measurement solarRadiationValue;
        // loops until there are no more lines left to read
        while (strg != null)
        {
            // splits the read line by commas into an array
            String[] values = strg.split(",");
            // initializes Measurements with the correct values from the array
            tairValue = new Measurement(Double.parseDouble(values[4]));
            ta9mValue = new Measurement(Double.parseDouble(values[14]));
            solarRadiationValue = new Measurement(Double.parseDouble(values[13]));
            // Checks to make sure that the Measurements are all valid so there is no corrupted TimeData 
            if (tairValue.isValid() && ta9mValue.isValid() && solarRadiationValue.isValid())
            {
                //creates a TimeData object and adds it to the data ArrayList
                TimeData input = new TimeData(stationID, year, month, day, 
                             Integer.parseInt(values[2]), tairValue, ta9mValue, solarRadiationValue);
                data.add(input);
            }
            // reads the next line for the next loop 
            strg = br.readLine();
        }
        // closes the Buffered Reader so there are no warnings 
        br.close();
        
    }
    
    /**
     *  calculates statistics on the Solar Radiation values in 
     *  a days worth of data including the minimum, maximum, average, and total
     */
    private void calculateSolarRadiationStatistics()
    {
        // creates temporary method variables to calculate and set to instance variables 
        // variables set to MAX and MIN values to be sure that they will be overridden
        // and to help the test classes hit the inside of the if statements 
        double solRadMin = Integer.MAX_VALUE;
        double solRadMax = Integer.MIN_VALUE;
        double solRadSum = 0.0;
        for (int index = 0; index < data.size(); ++index)
        {
            // pulls out each solar radiation value and adds it to a Sum
            solRadSum += data.get(index).getSolarRadiation().getValue();
            // checks if there is a new min and resets it 
            if (data.get(index).getSolarRadiation().getValue() < solRadMin)
            {
                solRadMin = data.get(index).getSolarRadiation().getValue();
            }
            // checks if there is a new max and resets it 
            if (data.get(index).getSolarRadiation().getValue() > solRadMax)
            {
                solRadMax = data.get(index).getSolarRadiation().getValue();
            }    
        }
        // sets the instance variables to the method variables
        solarRadiationMin = solRadMin;
        solarRadiationMax = solRadMax;
        solarRadiationTotal = solRadSum;
        // calculates average
        solarRadiationAverage = solRadSum / data.size();    
    }
    
    /**
     * calculates statistics on the Air Temperature values in a days worth 
     * of data including the minimum, maximum, average depending on the elevation 
     * @param tairName specifies the elevation of calculation - tair(1.5m) or ta9m(9m)
     */
    private void calculateAirTemperatureStatistics(String tairName)
    {
        double airTempMin;
        double airTempMax;
        double airTempSum;
        // calculations for the Air Temperature at 1.5m
        if (tairName.equalsIgnoreCase("tair"))
        {
            // creates temporary method variables to calculate and set to instance variables 
            // variables set to MAX and MIN values to be sure that they will be overridden
            // and to help the test classes hit the inside of the if statements 
            airTempMin = Integer.MAX_VALUE;
            airTempMax = Integer.MIN_VALUE;
            airTempSum = 0.0;
            for (int index = 0; index < data.size(); ++index)
            {
                // pulls out each tair value and adds it to a Sum
                airTempSum += data.get(index).getTair().getValue();
                // checks if there is a new min and resets it 
                if (data.get(index).getTair().getValue() < airTempMin)
                {
                    airTempMin = data.get(index).getTair().getValue();
                }
                // checks if there is a new max and resets it 
                if (data.get(index).getTair().getValue() > airTempMax)
                {
                    airTempMax = data.get(index).getTair().getValue();
                }    
            }
            // sets the instance variables to the method variables
            tairMin = airTempMin;
            tairMax = airTempMax;
            tairAverage = airTempSum / data.size();
        }
        // calculations for the Air Temperature at 9m
        else 
        {
            // creates temporary method variables to calculate and set to instance variables 
            // variables set to MAX and MIN values to be sure that they will be overridden
            // and to help the test classes hit the inside of the if statements 
            airTempMin = Integer.MAX_VALUE;
            airTempMax = Integer.MIN_VALUE;
            airTempSum = 0.0;
            for (int index = 0; index < data.size(); ++index)
            {
                // pulls out each ta9m value and adds it to a Sum
                airTempSum += data.get(index).getTa9m().getValue();
                // checks if there is a new min and resets it 
                if (data.get(index).getTa9m().getValue() < airTempMin)
                {
                    airTempMin = data.get(index).getTa9m().getValue();
                }
                // checks if there is a new max and resets it 
                if (data.get(index).getTa9m().getValue() > airTempMax)
                {
                    airTempMax = data.get(index).getTa9m().getValue();
                }    
            }
            // sets the instance variables to the method variables
            ta9mMin = airTempMin;
            ta9mMax = airTempMax;
            ta9mAverage = airTempSum / data.size();
        }
        
    }

    /**
     * @return the tairMin
     */
    public double getTairMin()
    {
        return tairMin;
    }

    /**
     * @return the tairMax
     */
    public double getTairMax()
    {
        return tairMax;
    }

    /**
     * @return the tairAverage
     */
    public double getTairAverage()
    {
        return tairAverage;
    }

    /**
     * @return the ta9mMin
     */
    public double getTa9mMin()
    {
        return ta9mMin;
    }

    /**
     * @return the ta9mMax
     */
    public double getTa9mMax()
    {
        return ta9mMax;
    }

    /**
     * @return the ta9mAverage
     */
    public double getTa9mAverage()
    {
        return ta9mAverage;
    }

    /**
     * @return the solarRadiationMin
     */
    public double getSolarRadiationMin()
    {
        return solarRadiationMin;
    }

    /**
     * @return the solarRadiationMax
     */
    public double getSolarRadiationMax()
    {
        return solarRadiationMax;
    }

    /**
     * @return the solarRadiationAverage
     */
    public double getSolarRadiationAverage()
    {
        return solarRadiationAverage;
    }

    /**
     * @return the solarRadiationTotal
     */
    public double getSolarRadiationTotal()
    {
        return solarRadiationTotal;
    }

    /**
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return the month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * @return the day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * @return the stationID
     */
    public String getStationID()
    {
        return stationID;
    }
    
    /**
     * toString gives all the information about the days worth of data calculations 
     * @return the information on DayData in format
     * yyyy-mm-dd, StationID:
     *   Air Temperature[1.5m] = [MIN, MAX, AVG]
     *   Air Temperature[9m] = [MIN, MAX, AVG]
     *   Solar Radiation = [MIN, MAX, AVG, TOTAL]
     */
    public String toString()
    {
        // creates a String output to help break down the pieces of the return String into easier to read pieces 
        String output =  String.format("%d-%02d-%02d, %s: \n", year, month, day, stationID); 
        output +=  String.format("  Air Temperature[1.5m] = [%.4f, %.4f, %.4f] \n", tairMin, tairMax, tairAverage);
        output +=  String.format("  Air Temperature[9m] = [%.4f, %.4f, %.4f] \n", ta9mMin, ta9mMax, ta9mAverage);
        output +=  String.format("  Solar Radiation = [%.4f, %.4f, %.4f, %.4f]"
                , solarRadiationMin, solarRadiationMax, solarRadiationAverage, solarRadiationTotal);
        return output;
    }
}
