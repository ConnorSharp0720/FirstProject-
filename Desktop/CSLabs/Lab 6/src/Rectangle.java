/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-18
 * Lab 6
 * 
 * Class representing a Rectangle.
 */
public class Rectangle extends Quadrilateral
{
    /**
     * The rectangle constructor.  In a quadrilateral, side1 is opposite of side3 and
     * side2 is opposite of side4. As such, for a rectangle, we define that side1 = side3 = height
     * and side2 = side4 = width. Keep this in mind when calling the super constructor.
     * This will call the constructor for Quadrilateral.
     * 
     * @param height The height of the rectangle.
     * @param width The width of the rectangle.
     */
    public Rectangle(double height, double width)
    {
     // TODO: implement this.
    }
    
    /**
     * Gets the area of a rectangle. Remember that the side lengths of a quadrilateral
     * should be assigned as follows:
     * side1 = side3 = height
     * side2 = side4 = width
     * 
     * @return The area of the rectangle (height * width).
     */
    @Override
    public double getArea()
    {
        // TODO: implement this.
    }
    
    /**
     * Gets the type of the shape.
     * 
     * @return The string "Rectangle"
     */
    @Override
    public String getShapeType()
    {
        // TODO: implement this.
    }
}
