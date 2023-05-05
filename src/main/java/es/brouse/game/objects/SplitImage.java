package es.brouse.game.objects;

import java.awt.image.BufferedImage;

/**
 * Class in charge of the storage of the parts of a complete
 * rendered image Furthermore, each part will be identified by an index
 * to make sure order integrity.
 */
public class SplitImage {
    /*---------- PRIVATE ----------*/
    private final BufferedImage image;
    private final int index;

    /**
     * Main class constructor able to create new {@link SplitImage}
     * instance.
     *
     * @param image image bytes
     * @param index image index
     */
    public SplitImage(BufferedImage image, int index) {
        this.image = image;
        this.index = index;
    }

    /**
     * Image Getter
     *
     * @return the BufferedImage
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Index Getter
     *
     * @return the image index
     */
    public int getIndex() {
        return index;
    }
}
