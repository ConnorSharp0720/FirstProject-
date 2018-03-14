/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-18
 * Lab 6
 * 
 * Class representing an Isoceles Trapezoid. This has two bases which 
 * are parallel and two other sides of equal length.
 * 
 * THIS CLASS IS GIVEN TO YOU FOR REFERENCE.
 */
public class IsoscelesTrapezoid extends Quadrilateral
{
    /**
     * The length of the larger base.
     */
    private double base1;
    
    /**
     * The length of the smaller base.
     */
    private double base2;
    
    /**
     * The length of the non-base sides.
     */
    private double side;
    
    /**
     * Constructor for an IsoscelesTrapezoid. This should explicitly call
     * the super constructor. This will call the constructor for Quadrilateral.
     * It does not matter which side is associated with which value. (i.e. side1 can
     * equal base1, base2, or side). As long as the perimeter is correct, the code
     * will work.
     * 
     * @param base1 The length of the larger base.
     * @param base2 The length of the smaller base.
     * @param side The length of the non-base sides.
     */
    public IsoscelesTrapezoid(double base1, double base2, double side)
    {
        super(side, base1, side, base2);
        this.base1 = base1;
        this.base2 = base2;
        this.side = side;
    }

    /**
     * Gets the area for the trapezoid.
     * 
     * @return area of the trapezoid.
     */
    @Override
    public double getArea()
    {
        // Use formula for Isoceles Trapezoids:
        return 0.5 * (base1 + base2) * Math.sqrt(Math.pow(side, 2) - 0.25 * Math.pow(base1 - base2, 2));
    }

    /**
     * Get the shape type for the Isoceles Trapezoid.
     * 
     * @return The string "IsoscelesTrapezoid"
     */
    @Override
    public String getShapeType()
    {
        return "IsoscelesTrapezoid";
    }
}
