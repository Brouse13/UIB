package es.brouse.game.panels.game;

import es.brouse.game.objects.SplitImage;
import es.brouse.game.utils.Ticker;
import es.brouse.game.utils.GameStats;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameController {
    /*----------- PRIVATE -----------*/
    private final View view;
    private final Ticker ticker;

    /*----------- GAME SETTINGS -----------*/
    private final int points;
    private final long startTime = System.nanoTime();
    private int minMoves;
    private int moves = 0;
    private BufferedImage finalImage;

    public GameController(View view, Ticker ticker, int points) {
        this.view = view;
        this.ticker = ticker;
        this.points = points;
    }

    public void startGame(BufferedImage image, int rows, int cols) {
        this.finalImage = rescaleImage(image);
        List<SplitImage> images = shuffleImages(finalImage, rows, cols);

        //Calculate minOperations
        Integer[] array = images.stream().map(SplitImage::getIndex).toArray(Integer[]::new);
        Integer[] sorted = Arrays.stream(array).sorted().toArray(Integer[]::new);

        minMoves = minOperations(array, sorted, 0, 0);

        //Start game
        ticker.start();
        view.start(images);
    }

    public void swipeRequest(JLabel from, JLabel to) {
        //Permute solution
        view.renderSwitchPuzzle(from, to);
        moves++;
    }

    public void forceEnd() {
        GameStats stats = new GameStats(moves, minMoves, startTime, false, points);

        ticker.stop();
        view.renderEndGame(stats, finalImage);
    }

    public void requestClick(JLabel label, boolean paint) {
        view.requestClick(label, paint);
    }

    public void endGame() {
        GameStats stats = new GameStats(moves, minMoves, startTime, true, 0);

        ticker.stop();
        view.renderEndGame(stats, finalImage);
    }

    /**
     * Get the min of movements that the user has to do to solve the given panel
     *
     * @param arr1 source array
     * @param arr2 destination array
     * @param i start index source
     * @param j start index destination
     * @return the min operation to solve the array
     */
    private int minOperations(Integer[] arr1, Integer[] arr2, int i, int j) {
        //Base Case
        if (Arrays.equals(arr1, arr2)) return 0;

        if (i >= arr1.length || j >= arr2.length) return 0;

        //If arr[i] < arr[j]
        if (arr1[i] < arr2[j])
            return 1 + minOperations(arr1, arr2, i + 1, j + 1);

        //Otherwise, excluding the current element
        return Math.max(
                minOperations(arr1, arr2, i, j + 1),
                minOperations(arr1, arr2, i + 1, j)
        );
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


