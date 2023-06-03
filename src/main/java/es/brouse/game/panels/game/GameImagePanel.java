package es.brouse.game.panels.game;

import es.brouse.game.listeners.GameImageListener;
import es.brouse.game.objects.SplitImage;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.utils.GameStats;
import es.brouse.game.utils.ImageUtils;
import es.brouse.game.utils.StatsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class GameImagePanel extends JPanel implements Panel {
    private final Dimension size;
    private final BufferedImage originalImage;
    private final List<SplitImage> subImages;
    private final String username;

    private final GameImageListener listener;

    /**
     * Main class constructor used to create new {@link GameImagePanel}
     * instances.
     *
     * @param image image to render
     * @param rowsVals rows of the split
     * @param colsVal cols of the split
     * @param usernameVal name of the username
     */
    public GameImagePanel(BufferedImage image, int rowsVals, int colsVal, String usernameVal) {
        this.size = new Dimension(rowsVals, colsVal);
        this.originalImage = rescaleImage(image);
        this.subImages = shuffleImages(originalImage, rowsVals, colsVal);

        this.username = usernameVal;

        listener = new GameImageListener(subImages, gameEnd());

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(size.height, size.height, 5, 5));
    }

    @Override
    public void initComponents() {
        for (SplitImage subImage : subImages) {
            ImageBuilder imageBuilder = new ImageBuilder(subImage.getImage())
                    .setDimensions(new Dimension(-1, -1))
                    .setId(String.valueOf(subImage.getIndex()))
                    .setListener(listener);

            add(imageBuilder.getComponent());
        }
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    /**
     * Function called when the ticker has end.
     *
     * @return the ticker end function
     */
    public Consumer<Boolean> endTicker() {
        return bool -> {
            if (bool) listener.forceEnd();
        };
    }

    /**
     * Get the action performed on a game is ended.
     *
     * @return the action performed on a game is won
     */
    private Consumer<GameStats> gameEnd() {
        return stats -> {
            stats.setUsername(username);
            new StatsUtils().writeStats(stats);
            new SolutionPanel(originalImage).render();

            System.out.println(stats.isWin());
        };
    }

    /**
     * Rescale the given image.
     *
     * @param image image to rescale
     * @return the rescaled image
     */
    private BufferedImage rescaleImage(BufferedImage image) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) (size.getWidth() - 100);
        int height = (int) (size.getHeight() - 150);

        return new ImageUtils().rescaleImage(image, width, height);
    }

    /**
     * Shuffle the given images.
     *
     * @param image image to shuffle
     * @param rows rows of the shuffle
     * @param cols cols of the shuffle
     * @return the shuffled images
     */
    private List<SplitImage> shuffleImages(BufferedImage image, int rows, int cols) {
        List<SplitImage> images = new ArrayList<>(new ImageUtils().split(image, rows, cols));
        Collections.shuffle(images);
        return images;
    }
}
