package es.uib.shape;

import java.util.Random;

public class Rectangle extends Shape {
    private final float height, width;

    private Rectangle(float height, float weight) {
        this.height = height;
        this.width = weight;
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * height + 2 * width;
    }

    @Override
    protected double calculateArea() {
        return height * width;
    }

    public static Rectangle newInstance(final int bounds) {
        final Random random = new Random();

        return new Rectangle(
                random.nextInt(bounds) + 1,
                random.nextInt(bounds) + 1
        );
    }
}
