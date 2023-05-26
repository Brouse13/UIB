package es.brouse.game.panels;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;
public class GamePanel extends JPanel implements Panel {
    private static GamePanel instance;
    private JSplitPane splitPanel;
    private static final BackgroundPanel backgroundImage = new BackgroundPanel();

    public static GamePanel getInstance() {
        if (instance == null) instance = new GamePanel();
        return instance;
    }

    private GamePanel() {
        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout());
        setVisible(true);
    }

    @Override
    public void initComponents() {
        add(new HeaderPanel(), NORTH);

        //Create the middle content
        splitPanel = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new SidebarPanel(),
                backgroundImage
        );

        add(splitPanel, CENTER);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    public void setGamePanel(JComponent component) {
        splitPanel.setRightComponent(component);
        add(splitPanel, CENTER);
    }

    public void reset() {
        splitPanel.setRightComponent(backgroundImage);
    }
}
