package es.brouse.shape;

import java.util.Comparator;

/**
 * Class used to create new Shapes and provides methods to get
 * their perimeter and area.
 */
public abstract class Shape {
    /* ----- PRIVATE FIELDS -----*/
    private double area = -1;
    private double perimeter = -1;

    private final Comparator<Shape> PERIMETER = Comparator.comparingDouble(o -> o.perimeter);
    private final Comparator<Shape> AREA = Comparator.comparingDouble(o -> o.area);

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

    /*
    public int comparePerimeter() {

    }
    public int compareArea() {

    }
     */

    //Comparable<Shape> usar Comparator<Shape>

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
}
