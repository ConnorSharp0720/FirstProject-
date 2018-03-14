import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 7
 * 
 * Restaurant class storing orders in a stack. The orderList provides the spaces in memory in which order may be
 * placed, but the "stack" itself is defined by its start and end indices. The start index for the stack is considered
 * the first index in orderList (0). The last element is determined by the number of orders added. Remember that the
 * order most recently added should be the first removed.
 */
public class StackRestaurant<T> extends Restaurant<T>
{
    /**
     * The maximum size of the order list.
     */
    private static final int ORDER_LIST_SIZE = 10;
    /**
     * The index of the next completed order in the list. Should start at -1.
     */
    private int nextCompletedOrder = -1;
    /**
     * The index of the next free spot in the list. Should start at 0.
     */
    private int nextFreeSpot = 0;
    /**
     * The number of orders stored in the stack. This is different from the number of slots in orderList.
     */
    private int size = 0;
    /**
     * The array holding orders stored by this restaurant. The actual "stack" is defined with an end index (start index
     * will always be 0). orderList is the allocation of memory spots in which orders can be inserted.
     */
    private ArrayList<Order<T>> orderList;

    /**
     * Constructor. Sets the size of the list of orders to be ORDER_LIST_SIZE.
     * @param calendar The calendar used by superclass.
     */
    public StackRestaurant(GregorianCalendar calendar)
    {
        super(calendar);
        this.orderList = new ArrayList<Order<T>>(ORDER_LIST_SIZE);
    }

    /**
     * Add an order into the next free spot. The next free spot, next completed order, and the size should
     * be updated (incremented). You should be using the .add method that uses an index parameter (or .set).
     * 
     * @param order The order to add.
     */
    @Override
    public void addOrder(Order<T> order)
    {
        if (size >= ORDER_LIST_SIZE)
        {
            System.out.println("Not enough space!!!");
            return;
        }
        // TODO: complete this
    }

    /**
     * Get the next order to be completed. The next free spot, next completed order, and the size should
     * be updated (decremented). It is not necessary to actually remove the order from the list. The spot
     * it occupies will be counted as a "free"/"empty" spot. Updating the index values will be enough.
     * 
     * @return The next order to be removed. I.e. the most recent one inserted into the list.
     */
    @Override
    protected Order<T> removeOrder()
    {
        if (size <= 0)
        {
            System.out.println("Queue is empty!!!");
            return new Order<T>(null, new Date(0));
        }
        // TODO: complete this
    }
    
    /**
     * Gets the number of orders stored.
     * @return The number of orders stored in the stack.
     */
    @Override
    protected int getOrderListSize()
    {
        // TODO: complete this
    }
    
    /**
     * Get the next order to be completed.
     * @return The order that will next be completed.
     */
    @Override
    public Order<T> checkTopOrder()
    {
        if (size > 0)
        {
            // TODO: complete this
        }
        return null;
    }
    
    /**
     * Gets the next completed order index.
     * @return nextCompletedOrder
     */
    public int getNextCompletedOrder()
    {
        return nextCompletedOrder;
    }
    
    /**
     * Gets the next free spot in the queue.
     * @return nextFreeSpot
     */
    public int getNextFreeSpot()
    {
        return nextFreeSpot;
    }
}
