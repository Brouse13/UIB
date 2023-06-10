package es.brouse.game.listeners;

import es.brouse.game.objects.SplitImage;
import es.brouse.game.panels.game.GameController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GameImageListener extends MouseAdapter {
    private final List<SplitImage> images;

    private JLabel lastClick;

    private final GameController controller;

    public GameImageListener(GameController controller, List<SplitImage> images) {
        this.controller = controller;
        this.images = images;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        JLabel label = (JLabel) event.getComponent();

        //If is the first click, we mark the component with a red border
        if (lastClick == null) {
            controller.requestClick(label, true);
            lastClick = label;
            return;
        }

        //If not, we swipe the components
        int from = Integer.parseInt(label.getName());
        int to = Integer.parseInt(lastClick.getName());

        //Swipe the images
        SplitImage tmp = images.get(to);
        images.set(to, images.get(from));
        images.set(from, tmp);
        controller.swipeRequest(label, lastClick);

        //Reset variables
        controller.requestClick(lastClick, false);
        lastClick = null;

        //Check the end of the game and end listener
        if (validate()) controller.endGame(true);

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
}
