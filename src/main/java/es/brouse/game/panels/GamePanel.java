package es.brouse.game.panels;

import es.brouse.game.objects.SplitObject;

import javax.swing.*;
import java.awt.*;

import static es.brouse.game.objects.SplitObject.HORIZONTAL_SPLIT;
import static java.awt.BorderLayout.*;
public class GamePanel extends Panel {

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new BorderLayout());
        panel.setVisible(true);
    }

    @Override
    public void initComponents(final JPanel panel) {
        panel.add(new HeaderPanel().getComponent(), NORTH);

        //Create the middle content
        SplitObject split = new SplitObject(HORIZONTAL_SPLIT,
                new SidebarPanel().getComponent(), new BackgroundPanel().getComponent());
        panel.add(split.getComponent(), CENTER);
    }
}
