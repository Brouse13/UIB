package es.brouse.game.panels.game;

import es.brouse.game.listeners.GameImageListener;
import es.brouse.game.objects.SplitImage;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.iddle.IdlePanel;
import es.brouse.game.utils.GameStats;
import es.brouse.game.utils.ImageUtils;
import es.brouse.game.utils.Ticker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameImagePanel extends JPanel implements Panel, GameController.View {
    private final Dimension size;
    private final List<SplitImage> subImages;
    private final GameImageListener listener;
    private final GameController controller;

    /**
     * Main class constructor used to create new {@link GameImagePanel}
     * instances.
     *
     * @param image image to render
     * @param rows rows of the split
     * @param cols cols of the split
     */
    public GameImagePanel(Ticker ticker, BufferedImage image, int rows, int cols) {
        this.controller = new GameController(this, ticker, rows * cols);

        this.size = new Dimension(rows, cols);
        BufferedImage originalImage = rescaleImage(image);
        this.subImages = shuffleImages(originalImage, rows, cols);


        listener = new GameImageListener(controller, subImages);

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

    public GameController getController() {
        return controller;
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

    @Override
    public void start(List<SplitImage> images) {

    }

    @Override
    public void requestClick(int position, boolean paint) {

    }

    @Override
    public void renderEndGame(GameStats stats) {
        String message = stats.isWin() ?
                "Enhorabuena, has conseguido solucionar el panel y ahs conseguido " + stats.getPoints() + " puntos" :
                "No lo has conseguido, el tiempo se ha acabado";

        JOptionPane.showMessageDialog(IdlePanel.getInstance(), message);
        IdlePanel.getInstance().getController().idle();
    }

    @Override
    public void renderSwitchPuzzle(int from, int to) {

    }
}
