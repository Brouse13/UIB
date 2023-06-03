package es.brouse.game.panels.iddle;


import es.brouse.game.panels.Panel;
import es.brouse.game.panels.game.CountDownPanel;
import es.brouse.game.panels.game.GameImagePanel;
import es.brouse.game.panels.game.SolutionPanel;
import es.brouse.game.panels.stats.StatsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

public class IdlePanel extends JPanel implements Panel, IdleController.View {
    /*---------- PRIVATE ----------*/
    private static IdlePanel instance;
    private final IdleController controller;
    private JSplitPane splitPanel;

    /**
     * Singleton pattern retriever.
     *
     * @return the singleton instance
     */
    public static IdlePanel getInstance() {
        if (instance == null) instance = new IdlePanel();
        return instance;
    }

    private IdlePanel() {
        this.controller = new IdleController(this);

        setUp();
        initComponents();
    }

    /**
     * Get the class controller
     *
     * @return the class controller
     */
    public IdleController getController() {
        return controller;
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        add(new HeaderPanel(), NORTH);

        //Create the middle content
        splitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new BackgroundPanel(), null);

        JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new SidebarPanel() , splitPanel);

        add(panel, CENTER);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    @Override
    public void renderIdle() {
        splitPanel.setLeftComponent(new BackgroundPanel());
        splitPanel.setRightComponent(null);
    }

    @Override
    public void renderGame(BufferedImage image, int rows, int cols, String username) {
        final GameImagePanel gameImage = new GameImagePanel(image, rows, cols, username);

        splitPanel.setLeftComponent(gameImage);
        splitPanel.setRightComponent(new CountDownPanel(gameImage));
    }

    @Override
    public void renderStats(String username) {
        splitPanel.setLeftComponent(new StatsPanel(username));
        splitPanel.setRightComponent(null);
    }

    @Override
    public void renderSolution(BufferedImage image) {
        splitPanel.setLeftComponent(new SolutionPanel.Solution(image));
        splitPanel.setRightComponent(new SolutionPanel.Footer());
    }
}
