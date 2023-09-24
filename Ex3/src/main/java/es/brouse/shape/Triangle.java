package es.brouse.shape;

import java.util.Random;

public class Triangle extends Shape {
    private final long side1, side2, side3;

    private Triangle(long side1, long side2, long side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    protected double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    protected double calculateArea() {
        //Apply Heron fórmula √(s (s - a) (s - b) (s - c)) where s = semi perimeter and (a, b, c) the sides
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public static Triangle newInstance(final int bounds) {
        final Random random = new Random();

        return new Triangle(
                random.nextInt(bounds),
                random.nextInt(bounds),
                random.nextInt(bounds)
        );
    }
}
