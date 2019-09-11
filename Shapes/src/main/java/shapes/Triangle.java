package shapes;

import shapes.exceptions.ShapeException;

/**
 * Circle
 *
 * This class represents circle objects that can be moved and scales.  Users of a circle can also get its area.
 *
 */
public class Triangle extends Shape {

    private Point point1;
    private Point point2;
    private Point point3;

    private Line line1;
    private Line line2;
    private Line line3;

    double edge1, edge2, edge3;


    /**
     *
     * @param x1                 must be a valid double
     * @param y1                 must be a valid double
     * @param x2                 must be a valid double
     * @param y2                 must be a valid double
     * @param x3                 must be a valid double
     * @param y3                 must be a valid double
     * @throws ShapeException    The exception thrown if any parameter is invalid i.e must be a valid double
     * @throws ShapeException    Length of edge must be greater than 0 otherwise throws an exception
     * @throws ShapeException    Length of an edge must not be greater than sum of other two edges otherwise throws an exception
     * @throws ShapeException    Vertices must not be in the same line otherwise throws an exception
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) throws ShapeException {

        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);

        if (point1 == null || point2 == null || point3 == null)
            throw new ShapeException("Invalid Point");

        line1 = new Line(point1, point2);
        line2 = new Line(point2, point3);
        line3 = new Line(point3, point1);

        edge1 = line1.computeLength();
        edge2 = line2.computeLength();
        edge3 = line3.computeLength();

        if (edge1 + edge2 <= edge3 || edge2 + edge3 <= edge1 || edge1 + edge3 <= edge2)
            throw new ShapeException("An edge cannot be longer than sum of other two edges");

        if ((y2 - y1)*(x3 - x1)==(y3 - y1)*(x2 - x1))
            throw new ShapeException("Vertices must not be on the same line");
    }

    /**
     * Constructor with vertices
     *
     * @param point1             Must be a valid point i.e cannot be null
     * @param point2             Must be a valid point i.e cannot be null
     * @param point3             Must be a valid point i.e cannot be null
     * @throws ShapeException    The exception thrown if any parameter is invalid i.e must be a valid double
     * @throws ShapeException    Length of edge must be greater than 0 otherwise throws an exception
     * @throws ShapeException    Length of an edge must not be greater than sum of other two edges otherwise throws an exception
     * @throws ShapeException    Vertices must not be in the same line otherwise throws an exception
     */

    public Triangle(Point point1, Point point2, Point point3) throws ShapeException{

        if (point1 == null || point2 == null || point3 == null)
            throw new ShapeException("Invalid Point");

        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;

        line1 = new Line(point1, point2);
        line2 = new Line(point2, point3);
        line3 = new Line(point3, point1);

        edge1 = line1.computeLength();
        edge2 = line2.computeLength();
        edge3 = line3.computeLength();

        if (edge1 + edge2 <= edge3 || edge2 + edge3 <= edge1 || edge1 + edge3 <= edge2)
            throw new ShapeException("An edge cannot be longer than sum of other two edges");

        if ((point2.getY() - point1.getY())*(point3.getX() - point1.getX())==(point3.getY() - point1.getY())*(point2.getX() - point1.getX()))
            throw new ShapeException("Vertices must not be on the same line");


    }

    /**
     * methods to get vertices of triangle
     */
    public Point getVertice1(){ return point1;}

    public Point getVertice2(){ return point2;}

    public Point getVertice3(){ return point3;}


    /**
     * overriding abstract methods from Shapes class
     * @return
     */
    @Override
    public double computeArea() {

        double S, area;
        S = (edge1 + edge2 + edge3)/2;
        area = Math.sqrt(S*(S-edge1)*(S-edge2)*(S-edge3));
        return area;
    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {

        point1.move(deltaX,deltaY);
        point2.move(deltaX,deltaY);
        point3.move(deltaX,deltaY);

    }
}
