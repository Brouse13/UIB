package es.brouse.game.panels.iddle;

import es.brouse.game.panels.Panel;

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
        splitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, backgroundImage, null);

        JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new SidebarPanel() , splitPanel);

        add(panel, CENTER);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    /**
     * Set the content of the main panel to the specified by the
     * arguments.
     *
     * @param component component to set
     */
    public void setGamePanel(JComponent component) {
        splitPanel.setLeftComponent(component);
    }

    /**
     * Set the footer of the main panel to the specified by the
     * arguments.
     *
     * @param component component to set
     */
    public void setFooterPanel(JComponent component) {
        splitPanel.setRightComponent(component);
    }

    /**
     * Reset the content of the main panel
     */
    public void reset() {
        splitPanel.setLeftComponent(backgroundImage);
        splitPanel.setRightComponent(null);
    }
}
