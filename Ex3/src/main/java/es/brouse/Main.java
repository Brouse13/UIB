package es.brouse;

import es.brouse.shape.*;
import es.brouse.utils.ShapeUtils;

import java.util.*;

public class Main {
    private final ShapeUtils shapeUtils = new ShapeUtils(shapes);
    private static final List<Class<? extends Shape>> shapes = Arrays.asList(
            Triangle.class, Rectangle.class, Square.class, Circle.class);

    /**
     * Main class of the program
     *
     * @param args JVM args
     */
    public static void main(String[] args) {
        final Main main = new Main();

        //We get the random shapes and an ordered version
        List<Shape> shapes = main.shapeUtils.generateRandom(10_000);
        Map<Class<? extends Shape>, List<Shape>> classListMap = main.shapeUtils.filterByShape(shapes);

        //We print general info
        main.maxArea(shapes);
        main.maxPerimeter(shapes);

        //We print each shape info
        for (Class<? extends Shape> aClass : classListMap.keySet())
            main.printShapeInfo(aClass, classListMap.get(aClass));

        //We print top 10 perimeters
        System.out.println("Top 10 perimeters");
        main.printTop10(shapes, Comparator.comparingDouble(Shape::getPerimeter));

        System.out.println("Top 10 areas");
        main.printTop10(shapes, Comparator.comparingDouble(Shape::getArea));
    }

    /**
     * Print the max area of the shapes
     *
     * @param shapes shapes to print
     */
    private void maxArea(final List<Shape> shapes) {
        System.out.printf("Sum area: %,.2fm\n",
                shapes.stream().mapToDouble(Shape::getArea).sum());
    }

    /**
     * Print the max perimeter of the shapes
     *
     * @param shapes shapes to print
     */
    private void maxPerimeter(final List<Shape> shapes) {
        System.out.printf("Sum perimeter: %,.2fm\n",
                shapes.stream().mapToDouble(Shape::getPerimeter).sum());
    }

    /**
     * Print the information of a specific shape.
     *
     * @param clazz class clazz of the shape
     * @param shapes shapes to list
     */
    private void printShapeInfo(final Class<?> clazz, final List<Shape> shapes) {
        if (shapes.isEmpty()) return;

        double sumPerimeter = shapes.stream().mapToDouble(Shape::getPerimeter).sum();
        double maxPerimeter = shapes.stream().mapToDouble(Shape::getPerimeter).max().orElse(0d);

        double sumArea = shapes.stream().mapToDouble(Shape::getArea).sum();
        double maxArea = shapes.stream().mapToDouble(Shape::getArea).max().orElse(0d);

        System.out.printf("""
                    %s:
                    \tSum perimeter: %,.2f
                    \tMax perimeter: %,.2f
                    \tSum area:      %,.2f
                    \tMax area:      %,.2f
                    """, clazz.getSimpleName(), sumPerimeter, maxPerimeter, sumArea, maxArea);
    }

    /**
     * Print the top 10 shapes from a collection.
     *
     * @param shapes shapes to print
     * @param comparator comparator used to sort
     */
    private void printTop10(List<Shape> shapes, Comparator<Shape> comparator) {
        shapes.sort(comparator);

        List<Shape> subList = shapes.subList(0, Math.max(shapes.size(), 10));

        for (Shape shape : subList)
            System.out.println("\t" + shape.toString());
    }
}
