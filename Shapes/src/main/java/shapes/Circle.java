package shapes;

import shapes.exceptions.ShapeException;

/**
 * Circle
 *
 * This class represents circle object that can be moved and scaled.  Users of a circle can also get its area.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Circle extends Ellipse {
    private double radius;

    /**
     * Constructor with x-y Location for center
     *
     * @param x                 The x-location of the center of the circle -- must be a valid double
     * @param y                 The y-location of the center of the circle
     * @param radius            The radius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Circle(double x, double y, double radius) throws ShapeException {
        super(x,y,radius,radius);
    }

    /**
     * Constructor with a Point for center
     *
     * @param center            The x-location of the center of the circle -- must be a valid point
     * @param radius            The radius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Circle(Point center, double radius) throws ShapeException {
        super(center,radius,radius);
    }

    /**
     * @return  The radius of the circle
     */
    public double getRadius() { return radius; }

}
