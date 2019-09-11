package shapes;

import shapes.exceptions.ShapeException;

public class Rectangle extends Shape {

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;

    /**
     * Constructor with x-y location of points
     * @param x1  x-location of vertice 1--must be valid double
     * @param y1  y-location of vertice 1--must be valid double
     * @param x2  x-location of vertice 2--must be valid double
     * @param y2  y-location of vertice 2--must be valid double
     * @param x3  x-location of vertice 3--must be valid double
     * @param y3  y-location of vertice 3--must be valid double
     * @param x4  x-location of vertice 4--must be valid double
     * @param y4  y-location of vertice 4--must be valid double
     * @throws Exception Exception throw if edge have zero length
     * @throws Exception Exception throw if adjacent angles is not 90
     */
    public Rectangle(double x1,double y1, double x2, double y2, double x3, double y3, double x4, double y4) throws ShapeException{


        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        point3 = new Point(x3, y3);
        point4 = new Point(x4, y4);

        line1 = new Line(point1, point2);
        line2 = new Line(point2, point3);
        line3 = new Line(point3, point4);
        line4 = new Line(point4, point1);

        if (line1.computeLength()==0 || line2.computeLength()==0 || line3.computeLength()==0 || line4.computeLength()==0)
            throw new ShapeException("No edge can have zero length");

        if (line1.computeSlope()*line2.computeSlope()!=-1 && line2.computeSlope()*line3.computeSlope()!=-1 && line3.computeSlope()*line4.computeSlope()!=-1 && line4.computeSlope()*line1.computeSlope()!=-1)
            throw new ShapeException("All angle should be 90 Degree");
    }

    /**
     * Constructor with vertices
     * @param point1 First vertice--must not be null
     * @param point2 First vertice--must not be null
     * @param point3 First vertice--must not be null
     * @param point4 First vertice--must not be null
     * @throws Exception Exception throw if edge have zero length
     * @throws Exception Exception throw if adjacent angles is not 90
     */
    public Rectangle(Point point1,Point point2,Point point3,Point point4) throws ShapeException{

        if(point1==null || point2==null || point3==null || point4==null)
           throw new ShapeException("Points are invalid");

        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;

        line1 = new Line(point1, point2);
        line2 = new Line(point2, point3);
        line3 = new Line(point3, point4);
        line4 = new Line(point4, point1);

        if (line1.computeLength()==0 || line2.computeLength()==0 || line3.computeLength()==0 || line4.computeLength()==0)
            throw new ShapeException("No edge can have zero length");

        if (line1.computeSlope()*line2.computeSlope()!=-1 && line2.computeSlope()*line3.computeSlope()!=-1 && line3.computeSlope()*line4.computeSlope()!=-1 && line4.computeSlope()*line1.computeSlope()!=-1)
            throw new ShapeException("All angle should be 90 Degree");
    }

    /**
     *
     * @return vertex 1 of rectangle
     */
    public Point getVertices1(){ return point1;}

    /**
     *
     * @return vertex 2 of rectangle
     */
    public Point getVertices2(){ return point2;}

    /**
     *
     * @return vertex 3 of rectangle
     */
    public Point getVertices3(){ return point3;}

    /**
     *
     * @return vertex 4 of rectange
     */
    public Point getVertices4(){ return point4;}

    public Line getLine1(){ return line1;}

    public Line getLine2(){ return line2;}

    public Line getLine3(){ return line3;}

    public Line getLine4(){ return line4;}
    /**
     *
     * @return Height of rectangle
     */
    public double getheight(){
        return line2.computeLength();
    }

    /**
     *
     * @return Width of rectangle
     */
    public double getWidth(){
        return line1.computeLength();
    }

    @Override
    public double computeArea() {

        double h, w;
        h = getheight();
        w = getWidth();
        return h*w;
    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {

        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
        point3.move(deltaX, deltaY);
        point4.move(deltaX, deltaY);

    }
}
