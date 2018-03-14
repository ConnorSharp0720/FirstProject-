/**
 * 
 * @author Connor Sharp
 * @version 2018-15-2
 * Project 1
 * 
 * Class representing a list of data at a specific
 * time interval from a certain date and station  
 */
public class TimeData
{
    /** The minute of the collected data in increments of 5 */
    private int minute;
    /** The month of the collected data */
    private int month;
    /** The day of the collected data */
    private int day;
    /** The year of the collected data */
    private int year;
    /** Unique station identifier */
    private String stationID;
    /** Measurement of air temperature data including value and validity at elevation 1.5m */
    private Measurement tair;
    /** Measurement of air temperature data including value and validity at elevation 9m */
    private Measurement ta9m;
    /** Measurement of solar radiation data including value and validity */
    private Measurement solarRadiation;
    
    /**
     * Constructor for the TimeData class that takes in information about the year, month,
     * day, Station, and file location to initialize all the variables for the TimeData Class 
     * @param stationID unique station identification number
     * @param year information about the year of the data set
     * @param month information about the month of the data set
     * @param day information about the day of the data set
     * @param minute information about the minute of the data set
     * @param tair Measurement of air temperature data including value and validity at elevation 1.5m
     * @param ta9m Measurement of air temperature data including value and validity at elevation 9m
     * @param solarRadiation Measurement of solar radiation data including value and validity
     */
    public TimeData(String stationID, int year, int month, int day, 
            int minute, Measurement tair, Measurement ta9m, Measurement solarRadiation)
    {
        this.stationID = stationID.toUpperCase();
        this.year = year;
        this.month = month;
        this.day = day;
        this.minute = minute;
        this.tair = tair;
        this.ta9m = ta9m;
        this.solarRadiation = solarRadiation;
    }

    /**
     * @return the minute
     */
    public int getMinute()
    {
        return minute;
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
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return the stationID
     */
    public String getStationID()
    {
        return stationID;
    }

    /**
     * @return the tair
     */
    public Measurement getTair()
    {
        return tair;
    }

    /**
     * @return the ta9m
     */
    public Measurement getTa9m()
    {
        return ta9m;
    }

    /**
     * @return the solarRadiation
     */
    public Measurement getSolarRadiation()
    {
        return solarRadiation;
    }
    
    /**
     * toString override gives all the relevant data about the specific time 
     * @return the information on TimeData in format
     * StationID: Air temperature[1.5m] = value, Air temperature[9m] = value, SolarRadiation = value
     *   
     */
    public String toString()
    {
        // formats the string to the correct output style
        return String.format("%s: Air temperature[1.5m] = %s, Air temperature[9m] = %s, "
                + "Solar Radiation = %s", stationID, tair, ta9m, solarRadiation);
    }
    
}
