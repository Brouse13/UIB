package es.brouse.game.listeners;

import es.brouse.game.objects.SplitImage;
import es.brouse.game.screen.GameScreen;
import es.brouse.game.screen.Screen;
import es.brouse.game.utils.GameStats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GameImageListener extends MouseAdapter {
    private final List<SplitImage> images;
    private final Consumer<GameStats> gameSolve;

    private static JLabel lastClick;

    private int moves = 0;
    private final long startTime = System.currentTimeMillis();
    private boolean win = false;
    private final int minOperations;

    public GameImageListener(List<SplitImage> images, Consumer<GameStats> gameSolved) {
        this.images = images;
        this.gameSolve = gameSolved;

        //Calculate minOperations
        Integer[] array = images.stream().map(SplitImage::getIndex).toArray(Integer[]::new);
        Integer[] sorted = Arrays.stream(array).sorted().toArray(Integer[]::new);

        minOperations = minOperations(array, sorted, 0, 0);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        JLabel label = (JLabel) event.getComponent();

        //If we win, the listener will be canceled
        if (win) return;

        //If is the first click, we mark the component with a red border
        if (lastClick == null) {
            label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            lastClick = label;
            return;
        }

        //If not, we swipe the components
        int last_id = Integer.parseInt(lastClick.getName());
        int current_id = Integer.parseInt(label.getName());


        SplitImage tmp = images.get(last_id);
        Icon icon = lastClick.getIcon();

        images.set(last_id, images.get(current_id));
        lastClick.setIcon(label.getIcon());
        images.set(current_id, tmp);
        label.setIcon(icon);

        //We refresh the screen
        Screen.refresh(GameScreen.getInstance());

        //Reset variables
        lastClick.setBorder(BorderFactory.createEmptyBorder());
        lastClick = null;
        moves++;


        //Check the end of the game and end listener
        if (validate()) {
            gameSolve.accept(new GameStats(moves, minOperations, startTime, true));
            win = true;
        }
    }

    /**
     * Check if the elements are in order.
     *
     * @return if the gam is solved
     */
    private boolean validate() {
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).getIndex() != i) return false;
        }
        return true;
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
}
