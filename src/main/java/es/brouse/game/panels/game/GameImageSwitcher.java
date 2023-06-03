package es.brouse.game.panels.game;

import es.brouse.game.objects.SplitImage;
import es.brouse.game.screen.GameScreen;
import es.brouse.game.screen.Screen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GameImageSwitcher extends MouseAdapter {
    private final GameController controller;
    private JLabel lastClick;
    private final List<SplitImage> images;

    public GameImageSwitcher(List<SplitImage> images, GameController controller) {
        this.images = images;
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        JLabel label = (JLabel) event.getComponent();

        //If is the first click, we mark the component with a red border
        if (lastClick == null) {
            final int index = Integer.parseInt(label.getName());
            lastClick = label;

            controller.requestClick(index, true);
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

        if (validate()) {
            controller.endGame();
        }

        //Reset variables
        lastClick.setBorder(BorderFactory.createEmptyBorder());
        lastClick = null;

        /*
        //Request to swipe the elements
        controller.swipeRequest(from, to);

        //Reset elements
        controller.requestClick(to, false);
        lastClick = null;

        //Permute
        final SplitImage image = images.get(from);
        images.set(from, images.get(to));
        images.set(to, image);
         */
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
