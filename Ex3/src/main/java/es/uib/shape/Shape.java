package es.uib.shape;

/**
 * Class used to create new Shapes and provides methods to get
 * their perimeter and area.
 */
public abstract class Shape {
    /* ----- PRIVATE FIELDS -----*/
    private double area = -1;
    private double perimeter = -1;

    /**
     * Get the perimeter of the shape.
     *
     * @return the shape perimeter
     */
    public double getPerimeter() {
        if (perimeter == -1) perimeter = calculatePerimeter();
        return perimeter;
    }

    /**
     * Get the area of the shape.
     *
     * @return the shape area
     */
    public double getArea() {
        if (area == -1) area = calculateArea();
        return area;
    }

    /**
     * Calculate the perimeter of the given shape.
     *
     * @return the calculated perimeter
     */
    protected abstract double calculatePerimeter();

    /**
     * Calculate the area of the given shape.
     *
     * @return the calculated area
     */
    protected abstract double calculateArea();

    @Override
    public String toString() {
        return String.format("%s{area=%,.2f, perimeter=%,.2f}",
                getClass().getSimpleName(), area, perimeter);
    }
}
