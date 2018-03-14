import java.util.Comparator;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-18
 * Lab 6
 * 
 * Class used to define a new way to compare shapes. This gives a different ordering
 * to shapes. The compareTo() in Shape orders shapes in descending order (comparing area then perimeter).
 * When a sorting function uses this class instead of the compareTo() method in shape, the sorting function
 * will sort the list of shapes in ascending order of area.
 */
public class ShapeComparator implements Comparator<Shape>
{
    /**
     * Implementation of Comparator<Shape>'s compare method.
     * This method should define an ordering of shapes that
     * would sort shapes in order of ascending area.
     * Look to the documentation in Shape's compareTo to better understand
     * how this should work.
     * 
     * @param s1 The first shape to be compared.
     * @param s2 The second shape to be compared.
     * @return -1, 0, or 1.
     *  -1 if s1 should come before s2
     *  0 if s1 and s2 are effectively equal
     *  1 if s1 should come after s2
     */
    public int compare(Shape s1, Shape s2)
    {
        // TODO: implement this.
    }

    /**
     * Compares two shapes to determine if they are effectively equal. You should
     * use the compare() method of this class to determine this.
     * 
     * @param s1 The first shape to be compared.
     * @param s2 The second shape to be compared.
     * @return True if the shapes are effectively equal, False if they do not.
     */
    public boolean equals(Shape s1, Shape s2)
    {
        // TODO: implement this.
    }
}
