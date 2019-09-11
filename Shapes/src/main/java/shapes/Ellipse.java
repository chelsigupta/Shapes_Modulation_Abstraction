package shapes;

import shapes.exceptions.ShapeException;
import shapes.validate.ValidateDouble;

public class Ellipse extends Shape{

    private Point center;
    private double major;
    private double minor;

    /**
     *
     * @param x                must be a double
     * @param y                must be a double
     * @param major            must be a valid positive double
     * @param minor            must be a valid positive double
     * @throws ShapeException  Exception throw if area is 0
     */
    public Ellipse(double x, double y, double major, double minor)throws ShapeException {
        ValidateDouble.checkPositiveDouble(major, "Invalid Major Axis");
        ValidateDouble.checkPositiveDouble(minor, "Invalid Minor Axis");

        center = new Point(x, y);
        this.major = major;
        this.minor = minor;

        if (this.computeArea()==0)
            throw new ShapeException("Area cannot be zero");
    }

    /**
     *
     * @param center           must be valid--cannot be null
     * @param major            must be a valid positive double
     * @param minor            must be a valid positive double
     * @throws ShapeException  Exception throw if area is 0
     * @throws ShapeException  if center is null
     */
    public Ellipse(Point center, double major, double minor)throws ShapeException{
        ValidateDouble.checkPositiveDouble(major, "Invalid Major Axis");
        ValidateDouble.checkPositiveDouble(minor, "Invalid Minor Axis");

        if (center == null)
            throw new ShapeException("center is invalid");

        this.center = center;
        this.major = major;
        this.minor = minor;

        if (this.computeArea()==0)
            throw new ShapeException("Area cannot be zero");
    }

    /**
     * methods to access the attributes
     */
    public Point getCenter(){ return center;}

    public double getMajorRadius(){ return major;}

    public double getMinorRadius(){ return minor;}

    /**
     *
     * @return first foci
     * @throws ShapeException
     */
    public Point getFoci1() throws ShapeException{

        double c,x;
        Point foci1;
        c = Math.sqrt((Math.pow(major,2))-(Math.pow(minor,2)));
        x = center.getX() + c;
        foci1 = new Point(x, center.getY());
        return foci1;

    }

    /**
     *
     * @return second foci of ellipse
     * @throws ShapeException
     */
    public Point getFoci2()throws ShapeException{

        double c,x;
        Point foci2;
        c = Math.sqrt((Math.pow(major,2))-(Math.pow(minor,2)));
        x = center.getX() - c;
        foci2 = new Point(x, center.getY());
        return foci2;

    }

    /**
     * Scale the circle
     *
     * @param scaleFactor       a non-negative double that represents the percentage to scale the circle.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   Exception thrown if the scale factor is not valid
     */
    public void scale(double scaleFactor) throws ShapeException {
        ValidateDouble.checkPositiveDouble(scaleFactor, "Invalid scale factor");
        major *= scaleFactor;
        minor *= scaleFactor;
    }
    @Override
    /**
     * @return area of the ellipse
     */
    public double computeArea() {
        return Math.PI*major*minor;
    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);

    }
}
