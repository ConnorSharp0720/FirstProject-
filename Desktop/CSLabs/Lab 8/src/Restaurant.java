import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 8
 * 
 * Class representing a restaurant. A restaurant stores a list of Orders and
 * implements several methods for adding/removing orders. Once an order is removed,
 * information is calculated to determine how long it took to complete that order.
 * 
 * Subclasses may choose different ways to process orders.
 */
public abstract class Restaurant<T>
{
    /**
     * Calendar used to get useful information out of a Date object.
     * Specifically, after creating a Date with a long primitive, we use the
     * calendar to get the hour, minute, and second of that Date. Other information,
     * such as the day of the week and month are also available if we wanted it.
     */
    private GregorianCalendar calendar;
    
    /**
     * Constructor
     * @param calendar The calendar used to determine the time information.
     */
    public Restaurant(GregorianCalendar calendar)
    {
        this.calendar = calendar;
    }
    
    /**
     * Add an order to the restaurant. This should be stored in some way.
     * @param order The order to be added.
     */
    public abstract void addOrder(Order<T> order);
    
    /**
     * Remove an order from the restaurant. The implementing class should determine to order in which to 
     * remove orders via this method.
     * @return The next order to be removed.
     */
    protected abstract Order<T> removeOrder();
    
    /**
     * Get the size of the list of stored orders.
     * @return The number of stored orders.
     */
    protected abstract int getOrderListSize();
    
    /**
     * Gets the order that will next be completed. That is, gets the order that would
     * be returned by removeOrder without actually removing the order from the list
     * of Orders stored by the restaurant. It is advised that you look at methods
     * in Stack and PriorityQueue that have similar behaviour when implementing the
     * subclasses.
     * 
     * @return The order at the top of the restaurant's list.
     */
    public abstract Order<T> checkTopOrder();
    
    /**
     * Gets the current status of the restaurant. Specifically, we get information about the
     * number of orders remaining in the restaurant, and the description of the order that
     * will next be completed (removed from the list).
     * 
     * It is recommended that you use String.format()
     * 
     * @return A string of the format:
     *  "<number of orders in restaurant order list> orders left. Working on: <the toString() of the next order to be completed>"
     */
    public String getCurrentStatus()
    {
       Order<T> topOrder = checkTopOrder();
       return String.format("%d orders left. Working on: %s", getOrderListSize(), topOrder.toString());
    }
    
    /**
     * Completes an order. This involves removing and order and computing
     * the time it took to complete the order. Which order was completed is determined
     * by the implementation of the restaurant's removeOrder() method.
     * 
     * @param timeCompleted The time at which the order was completed.
     * @return A string of the format:
     *  "It tooks <hours to complete> hours, <minutes to complete> minutes, and
     *  <seconds to complete> seconds to complete the following order: <toString of completed order>"
     *  There is a space and no newline after the and. The line is cut to fit line wrap length.
     *  I.e. the portion of the string cut here is "and <seconds to complete>".
     */
    public String completeOrder(Date timeCompleted)
    {
        // Get the order completed; get the time it was ordered:
        Order<T> completed = removeOrder();
        Date timeOrdered = completed.getTimeOrdered();
        
        // Set the calendar time to the time completed:
        calendar.setTime(timeCompleted);
        
        // Find the hour, minute, and second the order was completed; store these as ints:
        int hours = calendar.get(GregorianCalendar.HOUR);
        int minutes = calendar.get(GregorianCalendar.MINUTE);
        int seconds = calendar.get(GregorianCalendar.SECOND);
        
        // Set the calendar time to the time ordered:
        calendar.setTime(timeOrdered);
        
        // Find the hour, minute, and second the order was completed; subtract these from the completed times:
        hours -= calendar.get(GregorianCalendar.HOUR);
        minutes -= calendar.get(GregorianCalendar.MINUTE);
        seconds -= calendar.get(GregorianCalendar.SECOND);
        
        // Output the info about the order:
        return String.format("It tooks %d hours, %d minutes, and %d seconds to complete the following order: %s",
                hours, minutes, seconds, completed.toString());
    }
}