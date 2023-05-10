package es.brouse.game.listeners;

import es.brouse.game.Game;
import es.brouse.game.objects.SplitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

public class GameImageListener extends MouseAdapter {
    private final List<SplitImage> images;
    private static JLabel lastClick;

    private int moves = 0;

    public GameImageListener(List<SplitImage> images) {
        this.images = images;

        Integer[] array = images.stream().map(SplitImage::getIndex).toArray(Integer[]::new);

        Integer[] sorted = Arrays.stream(array).sorted().toArray(Integer[]::new);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sorted));
        System.out.println(minOperations(array, sorted, 0, 0));
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        JLabel label = (JLabel) event.getComponent();

        if (lastClick == null) {
            label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            lastClick = label;
            System.out.println(lastClick);
            return;
        }

        //Swipe method
        int last_id = Integer.parseInt(lastClick.getName());
        int current_id = Integer.parseInt(label.getName());

        System.out.println("SWIPED " + last_id + " - " + current_id);

        SplitImage tmp = images.get(last_id);
        Icon icon = lastClick.getIcon();

        images.set(last_id, images.get(current_id));
        lastClick.setIcon(label.getIcon());
        images.set(current_id, tmp);
        label.setIcon(icon);

        Game.gameScreen.refresh();

        //Reset the click
        lastClick.setBorder(BorderFactory.createEmptyBorder());
        lastClick = null;
        moves++;


        //Check the end of the game
        if (validate()) {
            System.out.println("Won game in " + moves + " moves");
        }

    }

    private boolean validate() {
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).getIndex() != i) return false;
        }
        return true;
    }

    private int minOperations(Integer[] arr1, Integer[] arr2, int i, int j) {

        // Base Case
        if (Arrays.equals(arr1, arr2)) return 0;

        if (i >= arr1.length || j >= arr2.length) return 0;

        // If arr[i] < arr[j]
        if (arr1[i] < arr2[j])
            return 1 + minOperations(arr1, arr2, i + 1, j + 1);

        // Otherwise, excluding the current element
        return Math.max(
                minOperations(arr1, arr2, i, j + 1),
                minOperations(arr1, arr2, i + 1, j)
        );
    }
}
