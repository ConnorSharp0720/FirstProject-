/**
 * 
 * @author Connor Sharp
 * @version 2018-15-2
 * Project 1
 * 
 * Class that keeps track of Measurements and 
 * whether or not those Measurement values are valid 
 */
public class Measurement
{
    /** information on the numerical value of the measurement */
    private double value;
    /** true or false statement on whether the measurement is valid */
    private boolean valid;
    
    /**
     * Blank Constructor for Measurement that sets the value to a 
     * default invalid value and sets the validity of the Measurement 
     * to be invalid because it does not exist 
     */
    public Measurement()
    {
        this.value = -995;
        this.valid = false;
    }
    
    /**
     * Constructor for Measurement that sets the value to an 
     * inputed number and then tests to see if it is valid 
     * @param value numerical number for value 
     */ 
    public Measurement(double value)
    {
        this.value = value;
        // defaults valid to true until proven otherwise
        this.valid = true;
        // checks to see if value is an invalid value
        if (value < -900)
        {
            this.valid = false; 
        }
    }
    
    /**
     * @return the value
     */
    public double getValue()
    {
        return value;
        
    }
    
    /**
     * @return valid
     */
    public boolean isValid()
    {
        return valid;
    }
    
    /**
     * toString for Measurement that returns the 
     * value if it is valid and "bad" if it is invalid 
     * @return the Measurement as a string of value or "bad"
     */
    public String toString()
    {
        if (valid)
        {
            return String.format("%.4f", value);
        }
        return "bad";
    }
}
