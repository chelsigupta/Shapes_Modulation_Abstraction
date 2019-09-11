package shapes.validate;
import shapes.exceptions.ShapeException;

public class ValidateDouble {
    public  static void checkDouble(double value, String errorMessage) throws ShapeException {
        if (Double.isInfinite(value) || Double.isNaN(value))
            throw new ShapeException(errorMessage);
    }

    public static void checkPositiveDouble(double value, String errorMessage) throws ShapeException {
        checkDouble(value, errorMessage);
        if (value<0)
            throw new ShapeException(errorMessage);
    }
}
