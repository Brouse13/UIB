package es.brouse.game.utils;

import es.brouse.game.GameSettings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Utility class used to pick a random image from the {@link GameSettings#IMAGES_DIR} folder.
 */
public class ImagePicker {
    private final Set<String> VALID_EXTENSIONS = new HashSet<>(Arrays.asList("jpg", "png"));

    /**
     * Select a random image from the current images directory in a random way.
     *
     * @return the random image
     * @throws IOException if the image couldn't be load
     * @throws IllegalArgumentException if the directory is empty
     */
    public BufferedImage randomPick() throws IOException, IllegalArgumentException {
        File file = new File(GameSettings.IMAGES_DIR);

        File[] files = file.listFiles((dir, name) -> {
            if (!name.contains(".")) return false;

            String extension = name.split("\\.")[1].toLowerCase(Locale.ROOT);

            return VALID_EXTENSIONS.contains(extension);
        });

        //No files found
        if (files == null || files.length == 0) throw new IllegalArgumentException("No files to select");

        //Throw a new random
        int random = new Random().nextInt(files.length);
        return ImageIO.read(files[random]);
    }
}
