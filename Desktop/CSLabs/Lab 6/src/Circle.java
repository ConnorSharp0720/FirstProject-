/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-18
 * Lab 6
 * 
 * Class representing a circle.
 * 
 * THIS CLASS IS GIVEN TO YOU FOR REFERENCE.
 */
public class Circle extends Shape
{
    /**
     * The radius of the circle.
     */
    private double radius;
    
    /**
     * Circle constructor. Although super() would be called automatically, we make an
     * explicit call to super() here. As Shape is the superclass of Circle, this calls
     * the Shape() constructor. This means that when the Circle() constructor is called,
     * the Shape() constructor is also called, and the Circle is assigned an id.
     * 
     * @param radius The radius of the circle.
     */
    public Circle(double radius)
    {
        super();
        this.radius = radius;
    }
    
    /**
     * Gets the area of the circle.
     * 
     * @return pi*(radius^2)
     */
    public double getArea()
    {
        return Math.PI * radius * radius;
    }
    
    /**
     * Gets the circumference (perimeter) of the circle.
     * 
     * @return 2*pi*radius
     */
    public double getPerimeter()
    {
        return 2.0 * Math.PI * radius;
    }
    
    /**
     * Gets the type of the shape.
     * 
     * @return The string "Circle"
     */
    public String getShapeType()
    {
        return "Circle";
    }
}
