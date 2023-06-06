package es.brouse.game.panels.game;

import es.brouse.game.objects.SplitImage;
import es.brouse.game.utils.StatsUtils;
import es.brouse.game.utils.Ticker;
import es.brouse.game.utils.GameStats;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    /*----------- PRIVATE -----------*/
    private final View view;
    private final Ticker ticker;
    private final StatsUtils statsUtils;

    /*----------- GAME SETTINGS -----------*/
    private final int points;
    private BufferedImage finalImage;

    public GameController(View view, Ticker ticker, int points) {
        this.view = view;
        this.ticker = ticker;
        this.points = points;
        this.statsUtils = new StatsUtils();
    }

    public void startGame(BufferedImage image, int rows, int cols) {
        this.finalImage = rescaleImage(image);
        List<SplitImage> images = shuffleImages(finalImage, rows, cols);

        //Start game
        ticker.start();
        view.start(images);
    }

    public void swipeRequest(JLabel from, JLabel to) {
        //Permute solution
        view.renderSwitchPuzzle(from, to);
    }

    public void requestClick(JLabel label, boolean paint) {
        view.requestClick(label, paint);
    }

    public void endGame(boolean win) {
        GameStats stats = new GameStats(win, win ? points : 0);

        //Stop the game and call the view
        ticker.stop();
        view.renderEndGame(stats, finalImage);

        //Save the stats on the file
        statsUtils.writeStats(stats);
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

    public interface View {
        void start(List<SplitImage> images);
        void requestClick(JLabel label, boolean paint);
        void renderEndGame(GameStats stats, BufferedImage image);
        void renderSwitchPuzzle(JLabel from, JLabel to);
    }
}


