import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import org.junit.Assert;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 7
 * 
 * Test class for lab 7.
 */
class RestaurantTest
{
    /**
     * Tests Order constructor.
     * Also tests getters.
     */
    @Test
    void testOrderConstructor()
    {
        String expectedString = "testOrder";
        Date expectedDate = new Date();
        Order order = new Order(expectedString, expectedDate);
        
        Assert.assertEquals("Order does not store or get the correct description.",
                expectedString, order.getDescription());
        Assert.assertEquals("Order does not store or get the correct date.",
                expectedDate, order.getTimeOrdered());
    }

    /**
     * Tests Order toString.
     */
    @Test
    void testOrderToString()
    {
        String expectedString = "testOrder";
        Date expectedDate = new Date();
        Order order = new Order(expectedString, expectedDate);
        
        Assert.assertEquals("Order toString is incorrect.",
                expectedString, order.toString());
    }
    
    /**
     * Tests Order compareTo.
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
        
        Order order1 = new Order(string1, date1);
        Order order2 = new Order(string2, date2); 
        Order order3 = new Order(string3, date3);
        
        Assert.assertEquals("Order compareTo is incorrect.", 0, order1.compareTo(order2));
        Assert.assertEquals("Order compareTo is incorrect.", 0, order2.compareTo(order3));
        Assert.assertEquals("Order compareTo is incorrect.", 0, order3.compareTo(order1));
        Assert.assertEquals("Order compareTo is incorrect.", 0, order1.compareTo(order1));
    }
    
    // TODO: test the rest of your code.
}
