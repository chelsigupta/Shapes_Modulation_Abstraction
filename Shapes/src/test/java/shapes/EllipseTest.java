package shapes;

import org.junit.Test;
import shapes.Ellipse;
import shapes.Point;
import shapes.exceptions.ShapeException;

import static org.junit.Assert.*;

public class EllipseTest {

    @Test
    public void testValidConstruction() throws Exception {
        Point center = new Point(1,2);
        Ellipse myEllipse = new Ellipse(center, 5, 3.2);
        assertSame(center, myEllipse.getCenter());
        assertEquals(5, myEllipse.getMajorRadius(), 0);

        myEllipse = new Ellipse(1.3, 2.6, 2.5, 1);
        assertEquals(1.3, myEllipse.getCenter().getX(), 0);
        assertEquals(2.6, myEllipse.getCenter().getY(), 0);
        assertEquals(2.5, myEllipse.getMajorRadius(), 0);
        assertEquals(1, myEllipse.getMinorRadius(), 0);
        assertEquals(3.60, myEllipse.getFoci1().getX(), 0.01);
        assertEquals(2.60, myEllipse.getFoci1().getY(), 0.01);
        assertEquals(-0.99, myEllipse.getFoci2().getX(), 0.01);
        assertEquals(2.60, myEllipse.getFoci2().getY(), 0);
        
    }

    @Test
    public void testInvalidConstruction() {

        try {
            new Ellipse(null, 2.5, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse( new Point(1, 2), Double.POSITIVE_INFINITY, 3);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(new Point(1, 2), Double.NEGATIVE_INFINITY, 4);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse( new Point(1, 2), 6, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(new Point(1, 2), 5.6, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        try {
            new Ellipse(new Point(1, 2), Double.NaN, 1.2);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
        
        try {
            new Ellipse(new Point(1, 2), 6.6, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(Double.POSITIVE_INFINITY, 2, 3, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(Double.NEGATIVE_INFINITY, 2, 3, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(Double.NaN, 2, 3, 2);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, Double.POSITIVE_INFINITY, 3, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, Double.NEGATIVE_INFINITY, 3, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, Double.NaN, 3, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }


        try {
            new Ellipse(1, 2, Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, 2, Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, 2, Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, 2, 4, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, 2, 4, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            new Ellipse(1, 2, 4, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
    }

    @Test
    public void testMove() throws ShapeException {
        Ellipse myEllipse = new Ellipse(1, 2, 5, 2.3);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMajorRadius(), 0);
        assertEquals(2.3, myEllipse.getMinorRadius(), 0);
        assertEquals(5.43, myEllipse.getFoci1().getX(), 0.01);
        assertEquals(2, myEllipse.getFoci1().getY(), 0.01);
        assertEquals(-3.43, myEllipse.getFoci2().getX(), 0.01);
        assertEquals(2, myEllipse.getFoci2().getY(), 0.01);


        myEllipse.move(3, 4);
        assertEquals(4, myEllipse.getCenter().getX(), 0);
        assertEquals(6, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMajorRadius(), 0);
        assertEquals(2.3, myEllipse.getMinorRadius(), 0);
        assertEquals(8.43, myEllipse.getFoci1().getX(), 0.01);
        assertEquals(6.00, myEllipse.getFoci1().getY(), 0.01);
        assertEquals(-0.43, myEllipse.getFoci2().getX(), 0.01);
        assertEquals(6.00, myEllipse.getFoci2().getY(), 0.01);


        myEllipse.move(0.123,  0.456);
        assertEquals(4.123, myEllipse.getCenter().getX(), 0);
        assertEquals(6.456, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMajorRadius(), 0);
        assertEquals(2.3, myEllipse.getMinorRadius(), 0);
        assertEquals(8.56, myEllipse.getFoci1().getX(), 0.01);
        assertEquals(6.45, myEllipse.getFoci1().getY(), 0.01);
        assertEquals(-0.31, myEllipse.getFoci2().getX(), 0.01);
        assertEquals(6.45, myEllipse.getFoci2().getY(), 0.01);


        myEllipse.move(-0.123,  -0.456);
        assertEquals(4, myEllipse.getCenter().getX(), 0);
        assertEquals(6, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMajorRadius(), 0);
        assertEquals(2.3, myEllipse.getMinorRadius(), 0);
        assertEquals(8.43, myEllipse.getFoci1().getX(), 0.01);
        assertEquals(6.00, myEllipse.getFoci1().getY(), 0.01);
        assertEquals(-0.43, myEllipse.getFoci2().getX(), 0.01);
        assertEquals(6.00, myEllipse.getFoci2().getY(), 0.01);


        myEllipse.move(-12,  -26);
        assertEquals(-8, myEllipse.getCenter().getX(), 0);
        assertEquals(-20, myEllipse.getCenter().getY(), 0);
        assertEquals(5, myEllipse.getMajorRadius(), 0);
        assertEquals(2.3, myEllipse.getMinorRadius(), 0);
        assertEquals(-3.56, myEllipse.getFoci1().getX(), 0.01);
        assertEquals(-20.0, myEllipse.getFoci1().getY(), 0.01);
        assertEquals(-12.43, myEllipse.getFoci2().getX(), 0.01);
        assertEquals(-20.0, myEllipse.getFoci2().getY(), 0.01);


        try {
            myEllipse.move(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myEllipse.move(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myEllipse.move(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myEllipse.move(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myEllipse.move(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myEllipse.move(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

    }

    @Test
    public void testScale() throws ShapeException {
        Ellipse myEllipse = new Ellipse(1, 2, 4.8, 3.2);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(4.8, myEllipse.getMajorRadius(), 0);
        assertEquals(3.2, myEllipse.getMinorRadius(), 0);
        assertEquals(4.57, myEllipse.getFoci1().getX(), 0.01);
        assertEquals(2.0, myEllipse.getFoci1().getY(), 0.01);
        assertEquals(-2.57, myEllipse.getFoci2().getX(), 0.01);
        assertEquals(2.0, myEllipse.getFoci2().getY(), 0.01);


        myEllipse.scale(3);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(14.4, myEllipse.getMajorRadius(), 0.01);
        assertEquals(9.6, myEllipse.getMinorRadius(), 0.01);
        assertEquals(11.73, myEllipse.getFoci1().getX(), 0.01);
        assertEquals(2.0, myEllipse.getFoci1().getY(), 0.01);
        assertEquals(-9.73, myEllipse.getFoci2().getX(), 0.01);
        assertEquals(2.0, myEllipse.getFoci2().getY(), 0.01);


        myEllipse.scale(0.2);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(2.88, myEllipse.getMajorRadius(), 0.01);
        assertEquals(1.92, myEllipse.getMinorRadius(), 0.01);
        assertEquals(3.14, myEllipse.getFoci1().getX(), 0.01);
        assertEquals(2.0, myEllipse.getFoci1().getY(), 0.01);
        assertEquals(-1.14, myEllipse.getFoci2().getX(), 0.01);
        assertEquals(2.0, myEllipse.getFoci2().getY(), 0);


        try {
            myEllipse.scale(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myEllipse.scale(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }

        try {
            myEllipse.scale(Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            // ignore
        }
    }

    @Test
    public void testComputeArea() throws ShapeException {
        Ellipse myEllipse = new Ellipse(1, 2, 5, 3);
        assertEquals(47.1238, myEllipse.computeArea(), 0.0001);

        myEllipse = new Ellipse(1, 2, 4.234, 2.344);
        assertEquals(31.1787, myEllipse.computeArea(), 0.0001);

        try
        {
            new Ellipse(1, 2, 0, 5.3);
            fail("Exception expected");
        }catch(ShapeException sh) {
            //ignore
        }
    }

}