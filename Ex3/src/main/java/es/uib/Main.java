package es.uib;

import es.uib.shape.*;
import es.uib.utils.ShapeUtils;

import java.util.*;

/**
 * Volem representar diferents 4 tipus de Figura (Cercle,Triangle, Rectangle i Quadrat). Totes les Figures tenen una àrea i un perímetre.
 * - Heu de generar de manera aleatòria 10000 figures i emmagatzemar-les en una Collection
 * - Heu de calcular la suma de les àrees i perímetres de totes les figures
 * - Heu de calcular la suma de les àrees i perímetres de cada tipus de figura
 * - Heu de calcular l’àrea màxima i mínima de totes les figures i per a cada tipus de figures.
 * - Heu de poder ordenar les figures per àrees i per perímetre i mostrar les 10 primeres.
 * - Heu de documentar el codi amb JavaDoc
 *
 * @version 1.0
 * @author Brouse, Carlos
 */
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
        System.out.printf("Sum area: %,.2f\n",
                shapes.stream().mapToDouble(Shape::getArea).sum());
    }

    /**
     * Print the max perimeter of the shapes
     *
     * @param shapes shapes to print
     */
    private void maxPerimeter(final List<Shape> shapes) {
        System.out.printf("Sum perimeter: %,.2f\n",
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

        final int min = Math.min(shapes.size(), 10);

        List<Shape> subList = shapes.subList(shapes.size() - min, shapes.size());

        for (Shape shape : subList)
            System.out.println("\t" + shape.toString());
    }
}
