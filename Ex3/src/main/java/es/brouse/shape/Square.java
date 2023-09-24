package es.brouse.shape;

import java.util.Random;

public class Square extends Shape {
    private final float size;

    private Square(float size) {
        this.size = size;
    }

    @Override
    protected double calculatePerimeter() {
        return 4 * size;
    }

    @Override
    protected double calculateArea() {
        return size * size;
    }

    public static Square newInstance(final int bounds) {
        final Random random = new Random();

        return new Square(
                random.nextInt(bounds)
        );
    }
}
