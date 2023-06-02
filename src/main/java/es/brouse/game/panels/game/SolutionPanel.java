package es.brouse.game.panels.game;

import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.objects.builders.SplitPanelBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.iddle.GamePanel;
import es.brouse.game.screen.GameScreen;
import es.brouse.game.screen.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.*;
public class SolutionPanel extends JPanel implements Panel {
    private final BufferedImage solution;

    public SolutionPanel(BufferedImage solution) {
        this.solution = solution;

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
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        ImageBuilder image = new ImageBuilder(solution)
                .setDimensions(new Dimension(-1, -1));

        ButtonBuilder button = new ButtonBuilder("CERRAR", null, event -> {
            GamePanel.getInstance().reset();
            Screen.refresh(GameScreen.getInstance());
        }).setSize(new Dimension(-1, 150));

        add(new SplitPanelBuilder(SplitPanelBuilder.VERTICAL_SPLIT,
                image.getComponent(), button.getComponent())
                .setSize(size.height - 125).getComponent(), CENTER);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }
}
