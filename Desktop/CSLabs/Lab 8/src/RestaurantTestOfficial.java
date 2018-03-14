import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import org.junit.Assert;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 8
 * 
 * Test class for lab 7.
 */
class RestaurantTestOfficial
{
    /**
     * Tests Order<String> constructor.
     * Also tests getters.
     */
    @Test
    void testOrderConstructor()
    {
        String expectedString = "testOrder";
        Date expectedDate = new Date();
        Order<String> order = new Order<String>(expectedString, expectedDate);
        
        Assert.assertEquals("Order does not store or get the correct description.",
                expectedString, order.getDescription());
        Assert.assertEquals("Order does not store or get the correct date.",
                expectedDate, order.getTimeOrdered());
    }

    /**
     * Tests Order<String> toString.
     */
    @Test
    void testOrderToString()
    {
        String expectedString = "testOrder";
        Date expectedDate = new Date();
        Order<String> order = new Order<String>(expectedString, expectedDate);
        
        Assert.assertEquals("Order toString is incorrect.",
                expectedString, order.toString());
    }
    
    /**
     * Tests Order<Integer> toString.
     */
    @Test
    void testOrderToString2()
    {
        Integer expectedInteger = 5;
        Date expectedDate = new Date();
        Order<Integer> order = new Order<Integer>(expectedInteger, expectedDate);
        
        Assert.assertEquals("Order toString is incorrect.",
                expectedInteger.toString(), order.toString());
    }
    
    /**
     * Tests Order<String> compareTo.
     */
    @Test
    void testOrderCompareTo()
    {
        String string1 = "aaaa";
        Date date1 = new Date(1000);
        String string2 = "cccc";
        Date date2 = new Date(10);
        String string3 = "bbbb";
        Date date3 = new Date(100);
        
        Order<String> order1 = new Order<String>(string1, date1);
        Order<String> order2 = new Order<String>(string2, date2); 
        Order<String> order3 = new Order<String>(string3, date3);
        
        Assert.assertEquals("Order compareTo is incorrect.", 1, order1.compareTo(order2));
        Assert.assertEquals("Order compareTo is incorrect.", -1, order2.compareTo(order3));
        Assert.assertEquals("Order compareTo is incorrect.", -1, order3.compareTo(order1));
        Assert.assertEquals("Order compareTo is incorrect.", 0, order1.compareTo(order1));
    }
    
    @Test
    void testQueueRestaurantEmpty()
    {
        QueueRestaurant<String> queue = new QueueRestaurant<String>(null);
        Assert.assertNull("QueueRestaurant should start empty.", queue.checkTopOrder());
    }
    
    @Test
    void testQueueRestaurantAddAndRemove()
    {
        String string1 = "aaaa";
        Date date1 = new Date(1000);
        Order<String> order1 = new Order<String>(string1, date1);
        
        QueueRestaurant<String> queue = new QueueRestaurant<String>(null);
        queue.addOrder(order1);
        Assert.assertEquals("QueueRestaurant does not add and remove properly.", order1, queue.removeOrder());
    }
    
    @Test
    void testQueueRestaurantRemoveOrdering()
    {
        String string1 = "aaaa";
        Date date1 = new Date(1000);
        String string2 = "bbbb";
        Date date2 = new Date(10);
        String string3 = "cccc";
        Date date3 = new Date(100);
        Order<String> order1 = new Order<String>(string1, date1);
        Order<String> order2 = new Order<String>(string2, date2);
        Order<String> order3 = new Order<String>(string3, date3);
        
        QueueRestaurant<String> queue = new QueueRestaurant<String>(null);
        queue.addOrder(order1);
        queue.addOrder(order2);
        queue.addOrder(order3);
        Assert.assertEquals("QueueRestaurant does not add and remove in correct order.", order1, queue.removeOrder());
        Assert.assertEquals("QueueRestaurant does not add and remove in correct order.", order2, queue.removeOrder());
        Assert.assertEquals("QueueRestaurant does not add and remove in correct order.", order3, queue.removeOrder());
    }
    
    @Test
    void testQueueRestaurantTopOrder()
    {
        String string1 = "aaaa";
        Date date1 = new Date(1000);
        String string2 = "bbbb";
        Date date2 = new Date(10);
        String string3 = "cccc";
        Date date3 = new Date(100);
        Order<String> order1 = new Order<String>(string1, date1);
        Order<String> order2 = new Order<String>(string2, date2);
        Order<String> order3 = new Order<String>(string3, date3);
        
        QueueRestaurant<String> queue = new QueueRestaurant<String>(null);
        queue.addOrder(order1);
        queue.addOrder(order2);
        queue.addOrder(order3);
        Assert.assertEquals("QueueRestaurant returns incorrect top order.", order1, queue.checkTopOrder());
    }
    
    @Test
    void testQueueRestaurantIndices()
    {
        String string1 = "aaaa";
        Date date1 = new Date(1000);
        String string2 = "bbbb";
        Date date2 = new Date(10);
        String string3 = "cccc";
        Date date3 = new Date(100);
        Order<String> order1 = new Order<String>(string1, date1);
        Order<String> order2 = new Order<String>(string2, date2);
        Order<String> order3 = new Order<String>(string3, date3);
        
        QueueRestaurant<String> queue = new QueueRestaurant<String>(null);
        Assert.assertEquals("Initial queue free spot should be 0.", 0, queue.getNextFreeSpot());
        Assert.assertEquals("Initial queue next completed order should be 0.", 0, queue.getNextCompletedOrder());
        queue.addOrder(order1);
        Assert.assertEquals("Queue does not update next free spot correctly.", 1, queue.getNextFreeSpot());
        Assert.assertEquals("Queue does not update next completed order correctly.", 0, queue.getNextCompletedOrder());
        queue.addOrder(order2);
        Assert.assertEquals("Queue does not update next free spot correctly.", 2, queue.getNextFreeSpot());
        Assert.assertEquals("Queue does not update next completed order correctly.", 0, queue.getNextCompletedOrder());
        queue.removeOrder();
        Assert.assertEquals("Queue does not update next free spot correctly.", 2, queue.getNextFreeSpot());
        Assert.assertEquals("Queue does not update next completed order correctly.", 1, queue.getNextCompletedOrder());
        queue.addOrder(order3);
        Assert.assertEquals("Queue does not update next free spot correctly.", 3, queue.getNextFreeSpot());
        Assert.assertEquals("Queue does not update next completed order correctly.", 1, queue.getNextCompletedOrder());
        
        // Add enough orders to wrap around:
        queue.addOrder(order1);
        queue.addOrder(order1);
        queue.addOrder(order1);
        queue.addOrder(order1);
        queue.addOrder(order1);
        queue.addOrder(order1);
        queue.addOrder(order1);
        Assert.assertEquals("Queue does not update next free spot correctly.", 0, queue.getNextFreeSpot());
        queue.addOrder(order1);
        Assert.assertEquals("Queue does not update next free spot correctly.", 1, queue.getNextFreeSpot());
        Assert.assertEquals("Queue does not update next completed order correctly.", 1, queue.getNextCompletedOrder());
        queue.removeOrder();
        queue.removeOrder();
        queue.removeOrder();
        queue.removeOrder();
        queue.removeOrder();
        queue.removeOrder();
        queue.removeOrder();
        queue.removeOrder();
        queue.removeOrder();
        Assert.assertEquals("Queue does not update next free spot correctly.", 1, queue.getNextFreeSpot());
        Assert.assertEquals("Queue does not update next completed order correctly.", 0, queue.getNextCompletedOrder());
    }
    
    @Test
    void testQueueRestaurantListSize()
    {
        String string1 = "aaaa";
        Date date1 = new Date(1000);
        String string2 = "bbbb";
        Date date2 = new Date(10);
        String string3 = "cccc";
        Date date3 = new Date(100);
        Order<String> order1 = new Order<String>(string1, date1);
        Order<String> order2 = new Order<String>(string2, date2);
        Order<String> order3 = new Order<String>(string3, date3);
        
        QueueRestaurant<String> queue = new QueueRestaurant<String>(null);
        queue.addOrder(order1);
        queue.addOrder(order2);
        queue.addOrder(order3);
        Assert.assertEquals("QueueRestaurant gives incorrect count.", 3, queue.getOrderListSize());
    }
    
    // TODO: complete unit tests for other classes
    
    /**
     * Method to make our tests more relaxed:
     * @param s The input string to simplify.
     * @return The input modified by the following steps:
     *  1. Whitespaces removed
     *  2. Turned to lowercase
     *  3. Remove common delimiting and punctuation characters [:,.!?]
     */
    private static String laxStringComp(String s)
    {
        // Remove whitespace:
        s = s.replaceAll("\\s", "");
        s = s.toLowerCase();
        s = s.replaceAll("[:,.!?]", "");
        return s;
    }
    
    @Test
    void testRestaurantCurrentStatus()
    {
        String string1 = "aaaa";
        Date date1 = new Date(1000);
        Order<String> order1 = new Order<String>(string1, date1);
        
        QueueRestaurant<String> queue = new QueueRestaurant<String>(null);
        queue.addOrder(order1);
        
        String expected = "1 orders left. Working on: aaaa";
        String actual = queue.getCurrentStatus();
        Assert.assertEquals("Restaurant current status incorrect.", laxStringComp(expected), laxStringComp(actual));
    }
    
    @Test
    void testRestaurantCompleteOrder()
    {
        String string1 = "aaaa";
        Date date1 = new Date(1000);
        Order<String> order1 = new Order<String>(string1, date1);
        
        QueueRestaurant<String> queue = new QueueRestaurant<String>(new GregorianCalendar());
        queue.addOrder(order1);
        
        String expected = "It tooks 0 hours, 0 minutes, and 9 seconds to complete the following order: aaaa";
        String actual = queue.completeOrder(new Date(10000));
        Assert.assertEquals("Restaurant order completion incorrect.", laxStringComp(expected), laxStringComp(actual));
    }
}
