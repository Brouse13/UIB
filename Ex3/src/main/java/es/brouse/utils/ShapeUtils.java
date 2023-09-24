package es.brouse.utils;

import es.brouse.shape.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ShapeUtils {
    /* ----- DEFAULT MESSAGE ERRORS ----- */
    private static final Logger LOGGER = Logger.getLogger(ShapeUtils.class.getSimpleName());
    private static final String NO_METHOD = "Class %s hasn't a newInstance() method, removing from list.";
    private static final String METHOD_NO_STATIC = "Method newInstance() is not public static.";

    /* ----- PRIVATE VALUES ----- */
    private final List<Class<? extends Shape>> SHAPES;

    /**
     * Main class constructor used to create new {@link ShapeUtils}
     * instances.
     *
     * @param shapes shapes class map
     */
    public ShapeUtils(List<Class<? extends Shape>> shapes) {
        this.SHAPES = shapes;
    }

    /**
     * Generate random shapes from the available list of shapes.
     *
     * @param amount number of shapes to generate
     * @return the generated shapes
     */
    public List<Shape> generateRandom(final int amount) {
        final Random random = new Random();
        List<Shape> result = new ArrayList<>(amount);

        for (int i = 0; i < amount; i++) {
            final int index = random.nextInt(SHAPES.size());
            Shape shape = getShape(SHAPES.get(index));

            if (shape != null) result.add(shape);
            else SHAPES.remove(index);
        }
        return result;
    }

    /**
     * Filter a given list of shapes into a map where each entry
     * will contain only one type of shape.
     *
     * @param shapes shapes to filter
     * @return ordered shapes
     */
    public Map<Class<? extends Shape>, List<Shape>> filterByShape(List<? extends Shape> shapes) {
        Map<Class<? extends Shape>, List<Shape>> filtered = new HashMap<>();

        //We initialize the map
        for (Class<? extends Shape> shape : SHAPES) filtered.put(shape, new ArrayList<>());

        //We fill the map with the values
        for (Shape shape : shapes) filtered.get(shape.getClass()).add(shape);

        return filtered;
    }

    /**
     * Generate a random shape if it's possible.
     *
     * @param clazz clazz to generate the shape from
     * @return the generated shape or null
     */
    private Shape getShape(final Class<? extends Shape> clazz) {
        try {
            //Access to method newInstance of Class<? extends Shape>
            Method newInstance = clazz.getMethod("newInstance", int.class);

            //Call the method newInstance
            return ((Shape) newInstance.invoke(null, 10));
        } catch (NoSuchMethodException e) {
            LOGGER.log(Level.SEVERE, String.format(NO_METHOD, clazz.getSimpleName()));
        } catch (InvocationTargetException | IllegalAccessException e) {
            LOGGER.log(Level.SEVERE, METHOD_NO_STATIC);
        }

        return null;
    }
}
