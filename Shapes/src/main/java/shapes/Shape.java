package shapes;

import shapes.exceptions.ShapeException;

public abstract class Shape {


    /** abstract method to calculate area */

    public abstract double computeArea();

    /**
     * abstract method to Move the point
     *
     * @param deltaX            The delta amount to move the point in the x direction -- must be a valid double
     * @param deltaY            The delta amount to move the point in the y direction -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */

    public abstract void move(double deltaX,double deltaY) throws ShapeException;
}
