package es.brouse.shape;

/**
 * Class used to create new Shapes and provides methods to get
 * their perimeter and area.
 */
public abstract class Shape {
    private final double area;
    private final double perimeter;

    public Shape() {
        this.perimeter = calculatePerimeter();
        this.area = calculateArea();
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    //Comparable<Shape> usar Comparator<Shape>

    protected abstract double calculatePerimeter();
    protected abstract double calculateArea();
}
