package es.brouse.panels;

import es.brouse.listeners.GameListeners;
import es.brouse.objects.builders.ButtonBuilder;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel implements Panel {
    private final GameListeners listeners = new GameListeners();

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
        add(new ButtonBuilder("CREAR", listeners.create())
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK).getComponent());

        add(new ButtonBuilder("REPRODUCIR", listeners.reproduce())
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK).getComponent());

        add(new ButtonBuilder("ADIVINAR", listeners.guess())
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK).getComponent());

        add(new ButtonBuilder("SALIR", listeners.exitEvent())
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK)
                .getComponent());
    }
}
