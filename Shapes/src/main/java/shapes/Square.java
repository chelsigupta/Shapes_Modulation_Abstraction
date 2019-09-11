package shapes;

import shapes.exceptions.ShapeException;

@SuppressWarnings("WeakerAccess")
public class Square extends Rectangle{

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
     * @throws ShapeException exception throw if edges are not equal
     */
    public Square(double x1,double y1, double x2, double y2, double x3, double y3, double x4, double y4) throws ShapeException {

            super(x1,y1,x2,y2,x3,y3,x4,y4);

            if (getLine1().computeLength()!=getLine2().computeLength() || getLine2().computeLength()!=getLine3().computeLength() || getLine3().computeLength()!=getLine4().computeLength()
             || getLine4().computeLength()!=getLine1().computeLength())
                throw new ShapeException("All edges must be equal");



    }

    public Square(Point point1,Point point2,Point point3,Point point4) throws ShapeException {

        super(point1, point2, point3, point4);

        if (getLine1().computeLength()!=getLine2().computeLength() || getLine2().computeLength()!=getLine3().computeLength() || getLine3().computeLength()!=getLine4().computeLength()
                || getLine4().computeLength()!=getLine1().computeLength())
            throw new ShapeException("All edges must be equal");



    }

}
