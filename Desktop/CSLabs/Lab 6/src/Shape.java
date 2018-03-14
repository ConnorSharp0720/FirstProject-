/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-18
 * Lab 6
 * 
 * Class representing a shape. Tracks the number of shapes created.
 */
public abstract class Shape implements Comparable<Shape>
{
    /**
     * Static variable tracking the number of shape objects created. All shapes share this variable.
     * This should increase by 1 each time a shape is created (i.e. the Shape() constructor is called).
     * Remember that subclasses of Shape will implicitly call the Shape() constructor. E.g. a calling the
     * Circle() constructor will call the constructor of its superclass, which is Shape(). This will then
     * increment the number of shapes created.
     */
    private static int numShapes = 0;
    
    /**
     * Static variables persist between unit tests. As such, we put this at the start of each unit test
     * avoid dealing with this. If we did not, aftering creating 3 shapes in one unit test, numShapes
     * would start at 3 in a second unit test.
     */
    public static void resetShapes()
    {
        numShapes = 0;
    }
    
    /**
     * Identifier for a shape based on the number of shapes created. If a shape is the first created,
     * its id = 0 (numshapes starts at 0). If a shape is the second created, its id = 1 (there was one
     * shape created before it; numshapes was 1).
     */
    private int id;
    
    /**
     * Constructor for a Shape. Assigns the id of the shape and increments the number of shapes.
     */
    public Shape()
    {
        // TODO: implement this.
    }
    
    /**
     * Gets the total number of shapes that have been created.
     * @return The number of shapes created (a value shared by all shapes).
     */
    public int getNumShapes()
    {
        // TODO: implement this.
    }
    
    /**
     * Gets the id of the shape.
     * @return The id of the shape.
     */
    public int getId()
    {
        // TODO: implement this.
    }
    
    /**
     * Abstract method; defines that all shapes should compute an area.
     * @return The area of a shape.
     */
    public abstract double getArea();
    
    /**
     * Abstract method; defines that all shapes should compute a perimeter.
     * @return The perimeter of a shape.
     */
    public abstract double getPerimeter();
    
    /**
     * Abstract method; defines that all shapes should have a String representing shape type.
     * @return The type of the shape.
     */
    public abstract String getShapeType();
    
    /**
     * Implementation of the compareTo method derived from "implements Comparable<Shape>"
     * Comparisons are used to define the natural ordering of objects. That is, how to
     * sort objects. If we want to sort a list of shapes, Java has no way to know
     * inherently if one shape should come before or after another shape. Thus, we use
     * Comparable and Comparators to tell Java how to sort a list. In this case,
     * we compare area and perimeter to determine how to sort, but any property
     * of the object could be used. By convention, when comparing two objects, a comparison
     * should return -1 if the first object in the comparison should come before the second object
     * in a sorted list, 0 if they are effectively equal, and 1 if the first object should
     * come after the second object in a sorted list.
     * 
     * This compareTo orders shapes by area and perimeter. If a shape has a smaller area, it should
     * be ordered to come after the shape it is compared to in a sorted list. If the areas are equal,
     * the shape with the larger perimeter comes first. A list of shapes is thus sorted in descending
     * order of area/perimeter when using Shape's compareTo.
     * 
     * E.g. we have the shapes A, B, and C. A has a smaller area than B and an equal area to C
     * A also has a larger perimeter than C.
     *  A.compareTo(B) yields 1 because we define that it should come after B in a sorted list
     *  A.compareTo(C) yields -1 because we define that it should come before C in a sorted list
     * Thus, the when using compareTo to sort, a list will be sorted as such:
     * 
     * B A C
     * 
     * To see how comparisons affect sorting, reference the Driver class.
     * 
     * @param s the shape that this shape should be compared to.
     * @return -1, 0, or 1. These values are returned on the following conditions:
     *     (this refers to this Shape object, and s refers to the input parameter Shape s)
     *     (1) Area of this is < area of s: return 1 (this should come after s in a sorted list)
     *     (2) Area of this is > area of s: return -1 (this should come before s in a sorted list)
     *     (3) Area of this = area of s:
     *         (a) Perimeter of this is < perimeter of s: return 1 (this should come after s in a sorted list)
     *         (b) Perimeter of this is > perimeter of s: return -1 (this should come before s in a sorted list)
     *         (C) Perimeter of this = perimeter of s: return 0 (this is effecitively equal to s in a sorted list)
     */
    @Override
    public int compareTo(Shape s)
    {
        // TODO: implement this.
    }
    
    /**
     * toString override. Gives information about the shape. You will need to use the
     * methods getShapeType(), getArea(), and getPerimeter() to complete the output string.
     * Note that these are abstract methods in Shape and are thus not implemented here. Instead,
     * when you call getShapeType() in this method, it will use the getShapeType() method as
     * implemented in the non-abstract shape that the toString() is called on.
     * 
     * E.g. you call toString() on a Square. The Square does not have its own toString, so it looks
     * for a toString of one of its superclasses. Shape is the first superclass of Square that has
     * a toString, so the toString of Shape is used. getShapeType() is overriden and implemented in Square,
     * so the Shape toString() uses the getShapeType() as defined in Square, which should return the
     * String "Square".
     * 
     * @return A String describing the Shape. The returned string is of the format:
     * "<shapetype>\t ID = <id>\t area = <area rounded to 3 decimals>\t perimeter = <perimeter rounded to 3 decimals>"
     * Where <x> should be replaced with the value of x described inside the angle brackets.
     * \t is the tab character.
     */
    @Override
    public String toString()
    {
        // TODO: implement this. String.format is recommended.
    }
}
