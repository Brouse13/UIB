package es.brouse.game.panels;

import es.brouse.game.objects.SplitImage;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameImagePanel extends Panel {
    private final Dimension size;
    private final BufferedImage originalImage;
    private final List<SplitImage> subImages;
    private final String username;
    private final ImageBuilder[] images;

    public GameImagePanel(BufferedImage image, int rowsVals, int colsVal, String usernameVal) {
        super(false);

        this.size = new Dimension(rowsVals, colsVal);
        this.originalImage = rescaleImage(image);
        this.subImages = shuffleImages(originalImage, rowsVals, colsVal);

        this.username = usernameVal;
        this.images = new ImageBuilder[rowsVals * colsVal];

        init();
    }

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(size.height, size.height, 5, 5));
    }

    @Override
    public void initComponents(final JPanel panel) {
        int index = 0;

        for (SplitImage subImage : subImages) {
            ImageBuilder imageBuilder = new ImageBuilder(subImage.getImage());
            Dimension imageSize = new Dimension(-1, -1);

            panel.add(imageBuilder.setDimensions(imageSize).getComponent());
            images[index] = imageBuilder;
        }
    }

    private BufferedImage rescaleImage(BufferedImage image) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) (size.getWidth() - 100);
        int height = (int) (size.getHeight() - 100);

        return new ImageUtils().rescaleImage(image, width, height);
    }

    private List<SplitImage> shuffleImages(BufferedImage image, int rows, int cols) {
        List<SplitImage> images = new ArrayList<>(new ImageUtils().split(image, rows, cols));
        Collections.shuffle(images);
        return images;
    }
}
