package es.brouse.shape;

import java.util.Random;

public class Circle extends Shape {
    private final float radius;

    private Circle(float radius) {
        this.radius = radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public static Circle newInstance(final int bounds) {
        final Random random = new Random();

        return new Circle(
                random.nextInt(bounds) + 1
        );
    }
}
