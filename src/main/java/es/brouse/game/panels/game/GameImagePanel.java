package es.brouse.game.panels.game;

import es.brouse.game.listeners.GameImageListener;
import es.brouse.game.objects.SplitImage;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.iddle.IdlePanel;
import es.brouse.game.utils.GameStats;
import es.brouse.game.utils.Ticker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class GameImagePanel extends JPanel implements Panel, GameController.View {
    private final Dimension size;
    private final GameController controller;

    /**
     * Main class constructor used to create new {@link GameImagePanel}
     * instances.
     *
     * @param image image to render
     * @param rows rows of the split
     * @param cols cols of the split
     */
    public GameImagePanel(Ticker ticker, BufferedImage image, int rows, int cols) {
        this.controller = new GameController(this, ticker, rows * cols);

        this.size = new Dimension(rows, cols);

        setUp();
        initComponents();

        controller.startGame(image, rows, cols);
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(size.height, size.height, 5, 5));
    }

    @Override
    public void initComponents() {
        //This panel doesn't init any component on start
    }

    @Override
    public void start(List<SplitImage> images) {
        final GameImageListener listener = new GameImageListener(controller, images);

        for (SplitImage subImage : images) {
            ImageBuilder imageBuilder = new ImageBuilder(subImage.getImage())
                    .setDimensions(new Dimension(-1, -1))
                    .setId(String.valueOf(subImage.getIndex()))
                    .setListener(listener);

            add(imageBuilder.getComponent());
        }
    }

    @Override
    public void requestClick(JLabel label, boolean paint) {
        if (paint)
            label.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        else
            label.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public void renderSwitchPuzzle(JLabel from, JLabel to) {
        final Icon icon = from.getIcon();
        from.setIcon(to.getIcon());
        to.setIcon(icon);
    }

    @Override
    public void renderEndGame(GameStats stats, BufferedImage image) {
        String message = stats.isWin() ?
                "Enhorabuena, has conseguido solucionar el panel y ahs conseguido " + stats.getPoints() + " puntos" :
                "No lo has conseguido, el tiempo se ha acabado";

        JOptionPane.showMessageDialog(IdlePanel.getInstance(), message);
        IdlePanel.getInstance().getController().renderSolution(image);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    public GameController getController() {
        return controller;
    }
}
