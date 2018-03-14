import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 8
 * 
 * Restaurant class that stores orders in a PriorityQueue. This class uses the natural ordering of the Orders
 * (as defined by the Order compareTo() function) to determine which order should next be completed. Orders are sorted
 * by their stored Date, so the earliest order (date-wise) will be removed first. This is different from the
 * QueueRestaurant which will remove the order first inserted, regardless of what its date is.
 * 
 * TODO: add javadoc commentary.
 */
public class PriorityQueueRestaurant<T> extends Restaurant<T>
{
    private PriorityQueue<Order<T>> orderList;

    public PriorityQueueRestaurant(GregorianCalendar calendar)
    {
        super(calendar);
        this.orderList = new PriorityQueue<Order<T>>();
    }

    @Override
    public void addOrder(Order<T> order)
    {
        orderList.add(order);
    }

    @Override
    protected Order<T> removeOrder()
    {
        return orderList.poll();
    }
    
    @Override
    protected int getOrderListSize()
    {
        return orderList.size();
    }
    
    @Override
    public Order<T> checkTopOrder()
    {
        return orderList.peek();
    }
}