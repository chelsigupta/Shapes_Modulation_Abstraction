package shapes; /**
 * 
 */

import org.junit.Test;
import shapes.Point;
import shapes.Rectangle;
import shapes.exceptions.ShapeException;

import static org.junit.Assert.*;


/**
 * @author aditi
 *
 */
public class RectangleTest {

	/**
	 * @throws Exception
	 */
    @Test
    public void testValidConstruction() throws Exception {
    	Point p1 = new Point(-1.5,3.3);
        Point p2 = new Point(5,3.3);
        Point p3 = new Point(5,1);
        Point p4 = new Point(-1.5,1);

        try
        {
            new Rectangle(p1,p2,p3,p4);
            fail("Exception expected");
        }catch(ShapeException sh) {
            //ignore
        }

    }

    @Test
    public void testInvalidConstruction() throws ShapeException{
    	
    	Point p1 = new Point(1,1);
        Point p2 = new Point(1,3.5);
        Point p3 = new Point(5.6,3.5);
        Point p4 = new Point(5.6,1);
        
        try {
            new Rectangle(null, p2, p3, p4);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Points are invalid", e.getMessage());
        }

        try {
            new Rectangle(p1, null, p3, p4);
            fail("Expected exception not thrown for when the second parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Points are invalid", e.getMessage());
        }

        try {
            new Rectangle(p1, p2, null, p4);
            fail("Expected exception not thrown for when the third parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Points are invalid", e.getMessage());
        }


        try {
            new Rectangle(Double.POSITIVE_INFINITY, 1, 1, 3, 5, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Rectangle(1, Double.POSITIVE_INFINITY, 1, 3, 5, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Rectangle(1, 1, Double.POSITIVE_INFINITY, 3, 5, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Rectangle(1, 1, 1, Double.POSITIVE_INFINITY, 5, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }
        
        try {
            new Rectangle(1, 1, 1, 3,  Double.POSITIVE_INFINITY, 3, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }
        
        try {
            new Rectangle(1, 1, 1, 3, 5, Double.POSITIVE_INFINITY, 5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }
        
        try {
            new Rectangle(1, 1, 1, 3, 5, 3, Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }
        
        try {
            new Rectangle(1, 1, 1, 3, 5, 3, 5, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }

        
        try {
            new Rectangle(p1, p1, p2, p2);
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
            new Rectangle(1,1,4,3,5,3,6,1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("All angle should be 90 Degree", e.getMessage());
        }

        Point t1= new Point(1,1);
        Point t2= new Point(4,3);
        Point t3= new Point(5,3);
        Point t4= new Point(6,1);


        try {
            new Rectangle(t1, t2, t3, t4);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("All angle should be 90 Degree", e.getMessage());
        }
    }
    
    @Test
    public void testComputeArea() throws ShapeException {

    	Point p1 = new Point(-1.5,3.3);
        Point p2 = new Point(5,3.3);
        Point p3 = new Point(5,1);
        Point p4 = new Point(-1.5,1);

        try
        {
            new Rectangle(p1,p2,p3,p4);
            fail("Exception expected");
        }catch(ShapeException sh) {
            //ignore
        }
    }
    
    
    @Test
    public void testMove() throws ShapeException {
        Rectangle myRectangle= new Rectangle(-3, 5, 3, 7, 6, -2, 0, 4);

        myRectangle.move(3, 4);
        assertEquals(0, myRectangle.getVertices1().getX(), 0);
        assertEquals(9, myRectangle.getVertices1().getY(), 0);
        assertEquals(6, myRectangle.getVertices2().getX(), 0);
        assertEquals(11, myRectangle.getVertices2().getY(), 0);
        assertEquals(9, myRectangle.getVertices3().getX(), 0);
        assertEquals(2, myRectangle.getVertices3().getY(), 0);
        assertEquals(3, myRectangle.getVertices4().getX(), 0);
        assertEquals(8, myRectangle.getVertices4().getY(), 0);

        myRectangle.move(.4321, .7654);
        assertEquals(0.4321, myRectangle.getVertices1().getX(), 0);
        assertEquals(9.7654, myRectangle.getVertices1().getY(), 0);
        assertEquals(6.4321, myRectangle.getVertices2().getX(), 0);
        assertEquals(11.7654, myRectangle.getVertices2().getY(), 0);
        assertEquals(9.4321, myRectangle.getVertices3().getX(), 0);
        assertEquals(2.7654, myRectangle.getVertices3().getY(), 0);
        assertEquals(3.4321, myRectangle.getVertices4().getX(), 0);
        assertEquals(8.7654, myRectangle.getVertices4().getY(), 0);


        myRectangle.move(-0.4321, -0.7654);
        assertEquals(0, myRectangle.getVertices1().getX(), 0);
        assertEquals(9, myRectangle.getVertices1().getY(), 0);
        assertEquals(6, myRectangle.getVertices2().getX(), 0);
        assertEquals(11, myRectangle.getVertices2().getY(), 0);
        assertEquals(9, myRectangle.getVertices3().getX(), 0);
        assertEquals(2, myRectangle.getVertices3().getY(), 0);
        assertEquals(3, myRectangle.getVertices4().getX(), 0);
        assertEquals(8, myRectangle.getVertices4().getY(), 0);

    }

}
