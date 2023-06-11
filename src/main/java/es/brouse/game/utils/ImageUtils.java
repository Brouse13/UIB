package es.brouse.game.utils;

import es.brouse.game.Game;
import es.brouse.game.objects.SplitImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/**
 * Utility class used to handle some image operations.
 */
public class ImageUtils {
    /**
     * Split the given image in multiple {@link SplitImage}.
     *
     * @param originalImage image to split
     * @param rows rows to split
     * @param cols cols to split
     * @return a set with all the split images.
     */
    public Set<SplitImage> split(BufferedImage originalImage, int rows, int cols) {
        //Storage of all the returned subImages
        Set<SplitImage> images = new HashSet<>(rows  * cols);

        //With and height of each section
        int width = originalImage.getWidth() / rows;
        int height = originalImage.getHeight() / cols;

        int index = 0;

        // iterating over rows and columns for each sub-originalImage
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //Creating subImage
                BufferedImage image = new BufferedImage(width, height, originalImage.getType());
                Graphics2D img_creator = image.createGraphics();

                // coordinates of source originalImage
                int src_x = width * j;
                int src_y = height * i;
                int dst_x = width * j + width;
                int dst_y = height * i + height;

                img_creator.drawImage(originalImage, 0, 0, width, height, src_x, src_y, dst_x, dst_y, null);
                images.add(new SplitImage(image, index));
                index++;
            }
        }
        return images;
    }

    /**
     * Load an image from a given external path.
     *
     * @param path image path
     * @return the loaded image instance
     * @throws IOException if the image couldn't be read
     */
    public BufferedImage loadImage(String path) throws IOException {
        URL resource = getClass().getResource(path);
        if (resource == null) throw new IOException("Image " + path + " not found");

        return ImageIO.read(resource);
    }

    /**
     * Load a new image from the resources folder 'resources/assets/gui/'.
     *
     * @param path relative path to the resources folder
     * @return the load resource
     */
    public BufferedImage loadResource(String path) {
        try {
            return loadImage( "/assets/gui/" + path);
        }catch (IOException exception) {
            Game.logger.log(Level.WARNING, "Unable to load resource " + path);
            return new BufferedImage(0, 0, BufferedImage.TYPE_INT_RGB);
        }
    }

    /**
     * Rescale the given image size.
     *
     * @param image image to rescale
     * @param newWidth new image width
     * @param newLength new image height
     * @return the rescaled image instance
     */
    public BufferedImage rescaleImage(BufferedImage image, int newWidth, int newLength) {
        Image scaled = image.getScaledInstance(newWidth, newLength, Image.SCALE_SMOOTH);

        //Create a buffered image with transparency
        BufferedImage bufferedImage = new BufferedImage(newWidth, newLength, BufferedImage.TYPE_INT_ARGB);

        //Draw the image on to the buffered image
        Graphics2D bGr = bufferedImage.createGraphics();
        bGr.drawImage(scaled, 0, 0, null);
        bGr.dispose();

        //Return the buffered image
        return bufferedImage;
    }
}
