package es.brouse.game.panels.game;

import es.brouse.game.objects.SplitImage;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.iddle.IdlePanel;
import es.brouse.game.utils.Ticker;
import es.brouse.game.utils.GameStats;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements Panel, GameController.View {
    private final Dimension size;
    private final GameController controller;

    private final List<JComponent> components;

    public GamePanel(BufferedImage image, int rows, int cols, Ticker ticker) {
        this.controller = new GameController(this, ticker, rows * cols);
        this.size = new Dimension(rows, cols);
        this.components = new ArrayList<>(rows * cols);

        setUp();
        initComponents();

        //Call the start on the controller
        controller.startGame(image, rows, cols);
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(size.width, size.height));
        setBackground(Color.BLACK);
    }

    @Override
    public void initComponents() {
        //No components are preInitialized
    }

    @Override
    public void start(List<SplitImage> images) {
        final GameImageSwitcher switcher = new GameImageSwitcher(images, controller);

        System.out.println(images);

        for (SplitImage image : images) {
            ImageBuilder imageBuilder = new ImageBuilder(image.getImage())
                    .setId(String.valueOf(image.getIndex()))
                    .setListener(switcher);

            components.add(imageBuilder.getComponent());
            add(imageBuilder.getComponent());
        }
    }

    @Override
    public void renderEndGame(GameStats stats) {
        String message = stats.isWin() ?
                "Enhorabuena, has conseguido solucionar el panel y ahs conseguido " + stats.getPoints() + " puntos" :
                "No lo has conseguido, el tiempo se ha acabado";

        JOptionPane.showMessageDialog(IdlePanel.getInstance(), message);
        IdlePanel.getInstance().getController().idle();
    }

    @Override
    public void requestClick(int index, boolean paint) {
        if (paint)
            components.get(index).setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        else
            components.get(index).setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public void renderSwitchPuzzle(int from, int to) {
        final Icon fromIcon = ((JLabel) components.get(from)).getIcon();
        final Icon toIcon = ((JLabel) components.get(to)).getIcon();

        ((JLabel) components.get(from)).setIcon(toIcon);
        ((JLabel) components.get(to)).setIcon(fromIcon);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    public GameController getController() {
        return controller;
    }
}
