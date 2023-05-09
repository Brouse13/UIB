package es.brouse.game.panels;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;
public class GamePanel extends Panel {
    private JSplitPane splitPanel;
    private JPanel panel;

    private static final BackgroundPanel backgroundImage = new BackgroundPanel();
    @Override
    public void setUp(final JPanel panel) {
        this.panel = panel;
        panel.setLayout(new BorderLayout());
        panel.setVisible(true);
    }

    @Override
    public void initComponents(final JPanel panel) {
        panel.add(new HeaderPanel().getComponent(), NORTH);

        //Create the middle content
        splitPanel = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new SidebarPanel().getComponent(),
                backgroundImage.getComponent()
        );

        panel.add(splitPanel, CENTER);
    }

    public void setGamePanel(JComponent component) {
        splitPanel.setRightComponent(component);
        panel.add(splitPanel, CENTER);
    }

    public void reset() {
        splitPanel.setRightComponent(backgroundImage.getComponent());
    }
}
