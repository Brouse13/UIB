package es.brouse.panels;

import es.brouse.listeners.GameListeners;
import es.brouse.objects.builders.ButtonBuilder;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends Panel {
    private static final GameListeners listeners = new GameListeners();

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(1, 4));
    }

    @Override
    public void initComponents(final JPanel panel) {
        panel.add(new ButtonBuilder("CREAR", listeners.create())
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK).getComponent());
        panel.add(new ButtonBuilder("REPRODUCIR", event -> {})
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK).getComponent());
        panel.add(new ButtonBuilder("ADIVINAR", event -> {})
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK).getComponent());
        panel.add(new ButtonBuilder("SALIR", listeners.exitEvent())
                .setSize(new Dimension(-1, -1))
                .setColor(Color.BLACK)
                .getComponent());
    }
}
