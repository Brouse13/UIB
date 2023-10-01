package es.uib.shape;

import java.util.Random;

public class Triangle extends Shape {
    private final long side, height;

    private Triangle(long side, long height) {
        this.side = side;
        this.height = height;
    }

    @Override
    protected double calculatePerimeter() {
        return 3 * side;
    }

    @Override
    protected double calculateArea() {
        return (double) (side * height) / 2;
    }

    public static Triangle newInstance(final int bounds) {
        final Random random = new Random();

        return new Triangle(
                random.nextInt(bounds) + 1,
                random.nextInt(bounds) + 1
        );
    }
}
