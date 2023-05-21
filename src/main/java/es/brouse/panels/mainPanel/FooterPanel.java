package es.brouse.panels.mainPanel;

import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.Panel;

import javax.swing.*;
import java.awt.*;

import static es.brouse.panels.mainPanel.GameController.RenderType.*;

public class FooterPanel extends JPanel implements Panel {
    public FooterPanel() {
        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(1, 4));
    }

    @Override
    public void initComponents() {
        add(new ButtonBuilder("CREAR", e -> GamePanel.getInstance().render(NOTES))
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK).getComponent());

        add(new ButtonBuilder("REPRODUCIR", e -> GamePanel.getInstance().render(REPRODUCE))
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK).getComponent());

        add(new ButtonBuilder("ADIVINAR", e -> GamePanel.getInstance().render(GUESS))
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK).getComponent());

        add(new ButtonBuilder("SALIR", e -> System.exit(0))
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK)
                .getComponent());
    }
}
