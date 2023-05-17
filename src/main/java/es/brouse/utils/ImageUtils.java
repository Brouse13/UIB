package es.brouse.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageUtils {
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

    public BufferedImage loadImage(String path) throws IOException {
        URL resource = getClass().getResource("/assets/gui/" + path);
        if (resource == null) throw new IOException("Image " + path + " not found");

        return ImageIO.read(resource);
    }
}