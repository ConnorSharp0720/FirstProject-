import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 8
 * 
 * Restaurant class that stores orders in a queue. Specifically, the queue is a circular queue.
 * The data is stored in an array (ArrayList here) with a constant size (ORDER_LIST_SIZE). Two indices are
 * used to determine where to next insert an element and where to next remove and element. When the next location
 * to insert an element would be greater than the maximum index of the array (remember that it has a fixed size),
 * the next location to insert wraps around to the start (index 0). This is what makes the array circular - the indices
 * wrap around. Thus, the logical start and end of the queue change their positions in the set of free spaces in the
 * array as elements are added and removed. The orderList provides the spaces in memory in which order may be
 * placed, but the "queue" itself is defined by its start and end indices.
 */
public class QueueRestaurant<T> extends Restaurant<T>
{
    /**
     * The maximum size of the order list.
     */
    private static final int ORDER_LIST_SIZE = 10;
    /**
     * The index of the next completed order in the list. Should start at 0.
     */
    private int nextCompletedOrder = 0;
    /**
     * The index of the next free spot in the list. Should start at 0.
     * When the next free spot would be greater than the maximum array index (ORDER_LIST_SIZE - 1),
     * nextFreeSpot should loop back to the start of the array and become 0.
     */
    private int nextFreeSpot = 0;
    /**
     * The number of orders stored in the queue. This is different from the number of slots in orderList.
     */
    private int size = 0;
    /**
     * The array holding orders stored by this restaurant. The actual "queue" is defined with a start and end index.
     * These indicies are the nextCompletedOrder and nextFreeSpot. orderList is the allocation of memory spots in
     * which orders can be inserted.
     */
    private ArrayList<Order<T>> orderList;

    /**
     * Constructor. Sets the size of the list of orders to be ORDER_LIST_SIZE.
     * @param calendar The calendar used by superclass.
     */
    public QueueRestaurant(GregorianCalendar calendar)
    {
        super(calendar);
        this.orderList = new ArrayList<Order<T>>(ORDER_LIST_SIZE);
    }

    /**
     * Add an order into the next free spot. The next free spot and the size should
     * be updated (incremented). If the next free spot would be greater the maximum array index (ORDER_LIST_SIZE - 1),
     * it should wrap back to the start of the array (0). You should be using the .add method that uses
     * an index parameter (or .set).
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
     * Get the next order to be completed. This should update the next completed order index (increment)
     * and the size (decrement). Remember that the maximum index is (ORDER_LIST_SIZE - 1). It is not necessary
     * to actually remove the order from the list. The spot it occupies will be counted as a "free"/"empty" spot.
     * Updating the index values will be enough.
     * 
     * @return The next order to be removed. I.e. the first one inserted into the list.
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
     * @return The number of orders stored in the queue.
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