package es.brouse.game.panels;

import es.brouse.game.objects.SplitObject;

import javax.swing.*;
import java.awt.*;

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
        panel.add(new SplitObject(SplitObject.HORIZONTAL_SPLIT).getComponent());
        panel.add(new SidebarPanel().getComponent(), WEST);
    }
}
