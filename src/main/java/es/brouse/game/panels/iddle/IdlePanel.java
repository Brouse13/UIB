package es.brouse.game.panels.iddle;


import es.brouse.game.GameSettings;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.game.CountDownPanel;
import es.brouse.game.panels.game.GameImagePanel;
import es.brouse.game.panels.game.SolutionPanel;
import es.brouse.game.panels.stats.StatsPanel;
import es.brouse.game.utils.Ticker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

/**
 * Class in charge of the game idle panel status rendering.
 */
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

    /**
     * Main class constructor used to create new {@link IdlePanel}
     * instances.
     */
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
        final Ticker ticker = new Ticker();
        final int maxTicks = rows * cols * GameSettings.GAME_DIFFICULTY;

        final GameImagePanel gameImage = new GameImagePanel(ticker, image, rows, cols, username);
        final CountDownPanel countDown = new CountDownPanel(gameImage.getController(), ticker, maxTicks);

        splitPanel.setLeftComponent(gameImage);
        splitPanel.setRightComponent(countDown);
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
