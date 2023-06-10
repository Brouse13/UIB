package es.brouse.game.panels.game;

import es.brouse.game.Game;
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
    private final String username;
    private BufferedImage finalImage;

    public GameController(View view, Ticker ticker, int points, String username) {
        this.view = view;
        this.ticker = ticker;
        this.points = points;
        this.statsUtils = new StatsUtils();

        this.username = username;
    }

    public void startGame(BufferedImage image, int rows, int cols) {
        this.finalImage = rescaleImage(image);
        List<SplitImage> images = shuffleImages(finalImage, rows, cols);

        //Start game
        ticker.start();
        view.start(images);

        //test(image, rows, cols);
    }

    public void swipeRequest(JLabel from, JLabel to) {
        //Permute solution
        view.renderSwitchPuzzle(from, to);
    }

    public void requestClick(JLabel label, boolean paint) {
        view.requestClick(label, paint);
    }

    public void endGame(boolean win) {
        GameStats stats = new GameStats(username, win, win ? points : 0);

        //Stop the game and call the view
        ticker.stop();
        view.renderEndGame(stats, finalImage);

        //Save the stats on the file
        statsUtils.writeStats(stats);

        Game.gameStarted = false;
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

        //Check if not ordered
        for (int i = 0; i < images.size(); i++)
            if (images.get(i).getIndex() != i) return images;

        return shuffleImages(image, rows, cols);
    }

    public interface View {
        void start(List<SplitImage> images);
        void requestClick(JLabel label, boolean paint);
        void renderEndGame(GameStats stats, BufferedImage image);
        void renderSwitchPuzzle(JLabel from, JLabel to);
    }

    /*
    TEST TO CHECK SUB IMAGES ARE SHUFFLED
    private void test(BufferedImage image, int rows, int cols) {
        boolean failed = false;
        for (int i = 0; i < 200; i++) {
            final List<SplitImage> splitImages = shuffleImages(image, rows, cols);

            if (checkDone(splitImages)) {
                failed = true;
                System.out.println("Failed test");
            }
        }

        if (!failed) System.out.println("El test no ha fallado");
    }

    private boolean checkDone(List<SplitImage> images) {
        for (int i = 0; i < images.size(); i++)
            //Avoid creating a game with all the images ordered
            if (images.get(i).getIndex() != i) return false;
        return true;
    }
     */
}


