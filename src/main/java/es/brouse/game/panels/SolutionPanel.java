package es.brouse.game.panels;

import es.brouse.game.Game;
import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.objects.builders.SplitPanelBuilder;
import es.brouse.game.screen.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.*;
public class SolutionPanel extends Panel {
    private final BufferedImage solution;

    public SolutionPanel(BufferedImage solution) {
        super(false);
        this.solution = solution;;

        init();
    }

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new BorderLayout());
        panel.setVisible(true);

    }

    @Override
    public void initComponents(final JPanel panel) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        ImageBuilder image = new ImageBuilder(solution)
                .setDimensions(new Dimension(-1, -1));

        ButtonBuilder button = new ButtonBuilder("CERRAR", null, event -> {
            GameScreen.gamePanel.reset();
            Game.gameScreen.refresh();
        }).setSize(new Dimension(-1, 150));

        panel.add(new SplitPanelBuilder(SplitPanelBuilder.VERTICAL_SPLIT,
                image.getComponent(), button.getComponent())
                .setSize(size.height - 125).getComponent(), CENTER);
    }
}
