package es.brouse.game.panels;

import es.brouse.game.listeners.GameImageListener;
import es.brouse.game.objects.SplitImage;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.screen.GameScreen;
import es.brouse.game.screen.Screen;
import es.brouse.game.utils.GameStats;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class GameImagePanel extends Panel {
    private final Dimension size;
    private final BufferedImage originalImage;
    private final List<SplitImage> subImages;
    private final String username;

    public GameImagePanel(BufferedImage image, int rowsVals, int colsVal, String usernameVal) {
        super(false);

        this.size = new Dimension(rowsVals, colsVal);
        this.originalImage = rescaleImage(image);
        this.subImages = shuffleImages(originalImage, rowsVals, colsVal);

        this.username = usernameVal;

        init();
    }

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(size.height, size.height, 5, 5));
    }

    @Override
    public void initComponents(final JPanel panel) {
        GameImageListener listener = new GameImageListener(subImages, actionPerform());

        for (SplitImage subImage : subImages) {
            ImageBuilder imageBuilder = new ImageBuilder(subImage.getImage())
                    .setDimensions(new Dimension(-1, -1))
                    .setId(String.valueOf(subImage.getIndex()))
                    .setListener(listener);

            panel.add(imageBuilder.getComponent());
        }
    }

    /**
     * Get the action performed on a game is ended.
     *
     * @return the action performed on a game is won
     */
    private Consumer<GameStats> actionPerform() {
        return stats -> {
            stats.setUsername(username);

            if (stats.isWin()) {
                GameScreen.gamePanel.setGamePanel(new SolutionPanel(originalImage).getComponent());
                Screen.refresh(GameScreen.getInstance());
                System.out.println("WIN GAME");
            }
        };
    }

    private BufferedImage rescaleImage(BufferedImage image) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) (size.getWidth() - 100);
        int height = (int) (size.getHeight() - 150);

        return new ImageUtils().rescaleImage(image, width, height);
    }

    private List<SplitImage> shuffleImages(BufferedImage image, int rows, int cols) {
        List<SplitImage> images = new ArrayList<>(new ImageUtils().split(image, rows, cols));
        Collections.shuffle(images);
        return images;
    }
}
