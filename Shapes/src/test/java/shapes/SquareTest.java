package shapes; /**
 * 
 */

import org.junit.Test;
import shapes.Point;
import shapes.Rectangle;
import shapes.Square;
import shapes.exceptions.ShapeException;

import static org.junit.Assert.*;


/**
 * @author aditi
 *
 */
public class SquareTest {

	/**
	 * @throws Exception
	 */
    @Test
    public void testValidConstruction() throws Exception {
    	Point p1 = new Point(-1.5,3.3);
        Point p2 = new Point(0.8,3.3);
        Point p3 = new Point(0.8,1);
        Point p4 = new Point(-1.5,1);

        try
        {
            new Square(p1,p2,p3,p4);
            fail("Exception expected");
        }catch(ShapeException sh) {
            //ignore
        }

        try
        {
            new Square(-11.2, 5, 4.8, 5, 4.8, -11, -11.2, -11);
            fail("Exception expected");
        }catch(ShapeException sh) {
            //ignore
        }

    }

    @Test
    public void testInvalidConstruction() throws ShapeException {

        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 3.5);
        Point p3 = new Point(5.6, 3.5);
        Point p4 = new Point(5.6, 1);

        try {
            new Square(null, p2, p3, p4);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Points are invalid", e.getMessage());
        }

        try {
            new Square(p1, null, p3, p4);
            fail("Expected exception not thrown for when the second parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Points are invalid", e.getMessage());
        }

        try {
            new Square(p1, p2, null, p4);
            fail("Expected exception not thrown for when the third parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Points are invalid", e.getMessage());
        }


        try {
            new Square(Double.POSITIVE_INFINITY, 1, 1, 3, 5, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Square(1, Double.POSITIVE_INFINITY, 1, 3, 5, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Square(1, 1, Double.POSITIVE_INFINITY, 3, 5, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Square(1, 1, 1, Double.POSITIVE_INFINITY, 5, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Square(1, 1, 1, 3, Double.POSITIVE_INFINITY, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Square(1, 1, 1, 3, 5, Double.POSITIVE_INFINITY, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Square(1, 1, 1, 3, 5, 3, Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Square(1, 1, 1, 3, 5, 3, 5, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }


        try {
            new Square(p1, p1, p2, p2);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("A line must have a length > 0", e.getMessage());
        }

        try {
            new Rectangle(1, 1, 1, 1, 3, 5, 3, 5);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("A line must have a length > 0", e.getMessage());
        }

        try {
            new Square(1, 1, 4, 3, 5, 3, 6, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("All angle should be 90 Degree", e.getMessage());
        }

        Point n1 = new Point(1, 1);
        Point n2 = new Point(4, 3);
        Point n3 = new Point(5, 3);
        Point n4 = new Point(6, 1);


        try {
            new Rectangle(n1, n2, n3, n4);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("All angle should be 90 Degree", e.getMessage());
        }


        try {
            new Square(3.2, 1.1, 3.2, 4.2, 8.3, 4.2, 8.3, 1.1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("All angle should be 90 Degree", e.getMessage());
        }
        Point t1 = new Point(3.2, 1.1);
        Point t2 = new Point(3.2, 4.2);
        Point t3 = new Point(8.3, 4.2);
        Point t4 = new Point(8.3, 1.1);
        try {
            new Square(t1, t2, t3, t4);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("All angle should be 90 Degree", e.getMessage());
        }
    }


    
    @Test
    public void testComputeArea() throws ShapeException {

    	Point p1 = new Point(-1.5,3.3);
        Point p2 = new Point(0.8,3.3);
        Point p3 = new Point(0.8,1);
        Point p4 = new Point(-1.5,1);

        try
        {
            new Square(p1,p2,p3,p4);
            fail("Exception expected");
        }catch(ShapeException sh) {
            //ignore
        }

        try
        {
            new Square(-11.2, 5, 4.8, 5, 4.8, -11, -11.2, -11);
            fail("Exception expected");
        }catch(ShapeException sh) {
            //ignore
        }

    }
    
    
    @Test
    public void testMove() throws ShapeException {
        try
        {
            new Square(2, 4, 4.3, 4, 4.3, 1.7, 2, 1.7);
            fail("Exception expected");
        }catch(ShapeException sh) {
            //ignore
        }
    }

}
