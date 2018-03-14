import java.util.Date;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 7
 * 
 * TODO: add in documentation.
 */
public class Order implements Comparable<Order>
{
    private String description;
    private Date timeOrdered;
    
    public Order(String description, Date timeOrdered)
    {
        this.description = description;
        this.timeOrdered = timeOrdered;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public Date getTimeOrdered()
    {
        return timeOrdered;
    }
    
    @Override
    public String toString()
    {
        return description;
    }

    /**
     * Method implemented to satisfy comparable so that
     * Order can be stored in a PriorityQueue.
     * 
     * @param arg0 The other Order to compare to.
     * @return Always return 0.
     */
    @Override
    public int compareTo(Order arg0)
    {
        return 0;
    }
}