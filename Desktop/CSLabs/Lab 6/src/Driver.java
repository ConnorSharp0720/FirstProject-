import java.util.ArrayList;
import java.util.Collections;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-18
 * Lab 6
 * 
 * Driver class that creates some shapes and demonstrates how sorting is accomplished
 * through use of the defined natural ordering of shapes (compareTo in Shape) and
 * an alternate order (compare in ShapeComparator).
 */
public class Driver
{
    /**
     * Method used to do high-level testing of your code. You may alter this as you see fit.
     * @param args Program args.
     */
	public static void main(String[] args)
	{
		ArrayList<Shape> list = new ArrayList<Shape>();
		
		Shape s1 = new Square(4.0);
		Shape s2 = new Rectangle(4.0, 1.0);
		Shape s3 = new Rectangle(3.0, 4.0);
		Shape s4 = new Rectangle(16.0, 1.0);
		Shape s5 = new Rectangle(8.0, 2.0);
		
		list.add(s1);
		list.add(s2);
		list.add(s4);
		list.add(s3);
		list.add(s5);
		
		
		System.out.println("###");
		for(Shape s: list) System.out.println(s);
		
		Collections.sort(list);
		
		System.out.println("###");
		for(Shape s: list) System.out.println(s);

		Collections.sort(list, new ShapeComparator());
		
		System.out.println("###");
		for(Shape s: list) System.out.println(s);
	}
}