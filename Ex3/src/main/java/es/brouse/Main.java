package es.brouse;

import es.brouse.shape.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

    }

    private List<Shape> generateShapes(final int size) {
        Random random = new Random();
        final List<Shape> shapes = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            switch (random.nextInt(4)) {
                /*
                case 0:
                    shapes.add(new Square(10));
                    break;
                case 1:
                    shapes.add(new Rectangle(10, 10));
                    break;
                case 2:
                    shapes.add(new Triangle(10, 10, 10));
                    break;
                case 3:
                    shapes.add(new Circle(10));
                    break;
                 */
            }
        }

        return shapes;
    }


}
