import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-18
 * Lab 6
 * 
 * Test class for Lab 6
 * 
 * TODO: You should test getArea(), getPerimeter, and getShapeType for each non-abstract shape subclass.
 * You may need to test other things as well to ensure that you have full coverage. For example, you need
 * to test that the number of shapes is computed correctly and that ids are assigned correctly. You also
 * need to test Shape's toString().
 */
public class ShapeTest
{
    /**
     * Tests for the circle class. Also test that number of shapes and IDs are done correctly.
     */
    @Test
    public void circleTest()
    {
        // You need to do this at the start of all tests!
        Shape.resetShapes();
        Circle circ = new Circle(3.0);
        assertEquals("Circle area incorrect.", Math.PI * 3.0 * 3.0, circ.getArea(), 0.0001);
        assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 3.0, circ.getPerimeter(), 0.0001);
        assertEquals("Circle type incorrect.", "Circle", circ.getShapeType());
        assertEquals("Shape ID incorrect.", 0, circ.getId());
    }
    
    // TODO: implement the remaining needed tests to ensure proper code functionality and get full coverage.
}