/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-18
 * Lab 6
 * 
 * Abstract class representing a quadrilateral.
 */
public abstract class Quadrilateral extends Shape
{
    /**
     * The side lenghts of a quadrilateral. We define side1 to opposite side3 and side2 to be
     * opposite side4.
     */
    private double side1;
    
    /**
     * Second side.
     */
    private double side2;
    
    /**
     * Third side.
     */
    private double side3;
    
    /**
     * Fourth side.
     */
    private double side4;
    
    /**
     * Quadrilateral constructor. Should call the super constructor explicitly and
     * should assign the side values.
     * 
     * @param side1 Length of side1.
     * @param side2 Length of side2.
     * @param side3 Length of side3.
     * @param side4 Length of side4.
     */
    public Quadrilateral(double side1, double side2, double side3, double side4)
    {
        // TODO: implement this.
    }
    
    // TODO: generate getters for the sides and provide documentation
    
    /**
     * Gets the perimeter of the quadrilateral.
     * @return The perimeter (sum of side lengths)
     */
    public double getPerimeter()
    {
     // TODO: implement this.
    }
}
