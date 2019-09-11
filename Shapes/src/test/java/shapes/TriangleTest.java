package shapes; /**
 * 
 */

import org.junit.Test;
import shapes.Point;
import shapes.Triangle;
import shapes.exceptions.ShapeException;

import static org.junit.Assert.*;


/**
 * @author aditi
 *
 */
public class TriangleTest {

	/**
	 * @throws Exception
	 */
    @Test
    public void testValidConstruction() throws Exception {
    	Point p1 = new Point(-1.5,3.3);
        Point p2 = new Point(5,3.3);
        Point p3 = new Point(5,1);
        
        Triangle triangle1= new Triangle(p1,p2,p3);
        assertEquals(-1.5, triangle1.getVertice1().getX(), 0);
        assertEquals(3.3, triangle1.getVertice1().getY(), 0);
        assertEquals(5, triangle1.getVertice2().getX(), 0);
        assertEquals(3.3, triangle1.getVertice2().getY(), 0);
        assertEquals(5, triangle1.getVertice3().getX(), 0);
        assertEquals(1, triangle1.getVertice3().getY(), 0);
  


        triangle1 = new Triangle(3.2, 1.1, 3.2, 4.2, 8.3, 4.2);
        assertEquals(3.2, triangle1.getVertice1().getX(), 0);
        assertEquals(1.1, triangle1.getVertice1().getY(), 0);
        assertEquals(3.2, triangle1.getVertice2().getX(), 0);
        assertEquals(4.2, triangle1.getVertice2().getY(), 0);
        assertEquals(8.3, triangle1.getVertice3().getX(), 0);
        assertEquals(4.2, triangle1.getVertice3().getY(), 0);
        

    }

    @Test
    public void testInvalidConstruction() throws ShapeException{
    	
    	Point p1 = new Point(1,1);
        Point p2 = new Point(1,3.5);
        Point p3 = new Point(5.6,3.5);
       
        
        try {
            new Triangle(null, p2, p3);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Triangle(p1, null, p3);
            fail("Expected exception not thrown for when the second parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Triangle(p1, p2, null);
            fail("Expected exception not thrown for when the third parameter is null");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid Point", e.getMessage());
        }


        try {
            new Triangle(Double.POSITIVE_INFINITY, 1, 1, 3, 5, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Triangle(1, Double.POSITIVE_INFINITY, 1, 3, 5, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Triangle(1, 1, Double.POSITIVE_INFINITY, 3, 5, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Triangle(1, 1, 1, Double.POSITIVE_INFINITY, 5, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }
        
        try {
            new Triangle(1, 1, 1, 3,  Double.POSITIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid x-location", e.getMessage());
        }
        
        try {
            new Triangle(1, 1, 1, 3, 5, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("Invalid y-location", e.getMessage());
        }
        

        
        try {
            new Triangle(p1, p1, p2);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("A line must have a length > 0", e.getMessage());
        }

        try {
            new Triangle(1,1,2,1,6.2,1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("An edge cannot be longer than sum of other two edges", e.getMessage());
        }

        Point t1 = new Point(1,1);
        Point t2 = new Point(2,1);
        Point t3 = new Point(6.2,1);



        try {
            new Triangle(t1, t2, t3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals(ShapeException.class, e.getClass());
            assertEquals("An edge cannot be longer than sum of other two edges", e.getMessage());
        }
        
   
    }
    
    @Test
    public void testComputeArea() throws ShapeException {

    	Point p1 = new Point(-1.5,3.3);
        Point p2 = new Point(5,3.3);
        Point p3 = new Point(5,1);

        Triangle triangle1= new Triangle(p1,p2,p3);
        assertEquals(7.475, triangle1.computeArea(), 0.001);

        Triangle triangle2 = new Triangle(3.2, 1.1, 3.2, 4.2, 8.3, 4.2);
        assertEquals(7.905, triangle2.computeArea(), 0.001);

    }
    
    
    @Test
    public void testMove() throws ShapeException {
        Triangle myTriangle= new Triangle(-3, 5, 3, 7, 6, -2);

        myTriangle.move(3, 4);
        assertEquals(0, myTriangle.getVertice1().getX(), 0);
        assertEquals(9, myTriangle.getVertice1().getY(), 0);
        assertEquals(6, myTriangle.getVertice2().getX(), 0);
        assertEquals(11, myTriangle.getVertice2().getY(), 0);
        assertEquals(9, myTriangle.getVertice3().getX(), 0);
        assertEquals(2, myTriangle.getVertice3().getY(), 0);


        myTriangle.move(.4321, .7654);
        assertEquals(0.4321, myTriangle.getVertice1().getX(), 0);
        assertEquals(9.7654, myTriangle.getVertice1().getY(), 0);
        assertEquals(6.4321, myTriangle.getVertice2().getX(), 0);
        assertEquals(11.7654, myTriangle.getVertice2().getY(), 0);
        assertEquals(9.4321, myTriangle.getVertice3().getX(), 0);
        assertEquals(2.7654, myTriangle.getVertice3().getY(), 0);
     


        myTriangle.move(-0.4321, -0.7654);
        assertEquals(0, myTriangle.getVertice1().getX(), 0);
        assertEquals(9, myTriangle.getVertice1().getY(), 0);
        assertEquals(6, myTriangle.getVertice2().getX(), 0);
        assertEquals(11, myTriangle.getVertice2().getY(), 0);
        assertEquals(9, myTriangle.getVertice3().getX(), 0);
        assertEquals(2, myTriangle.getVertice3().getY(), 0);
   

    }

}
