package es.brouse.game.utils;

import es.brouse.game.GameSettings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ImagePicker {
    private final Set<String> extensions = new HashSet<>(Arrays.asList("jpg", "png"));
    public BufferedImage randomPick() throws IOException, IllegalArgumentException {
        File file = new File(GameSettings.IMAGES_DIR);

        File[] files = file.listFiles((dir, name) -> {
            if (!name.contains(".")) return false;

            String extension = name.split("\\.")[1].toLowerCase(Locale.ROOT);

            return extensions.contains(extension);
        });

        //No files found
        if (files == null || files.length == 0)
            throw new IllegalArgumentException("No files to select");

        int random = new Random().nextInt(files.length);
        return ImageIO.read(files[random]);
    }
}
