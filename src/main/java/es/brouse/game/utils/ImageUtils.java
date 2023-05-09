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

public class ImageUtils {
    public Set<SplitImage> split(BufferedImage originalImage, int rows, int cols) {
        //Storage of all the returned subImages
        Set<SplitImage> images = new HashSet<>(rows  * cols);

        //With and height of each section
        int width = originalImage.getWidth() / cols;
        int height = originalImage.getHeight() / rows;

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

    public BufferedImage loadImage(String path) throws IOException {
        URL resource = getClass().getResource(path);
        if (resource == null) throw new IOException("Image " + path + " not found");

        return ImageIO.read(resource);
    }
}
