package es.brouse.panels;

import es.brouse.objects.builders.ButtonBuilder;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends Panel {

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(1, 4));
    }

    @Override
    public void initComponents(final JPanel panel) {
        panel.add(new ButtonBuilder("CREAR", event -> {})
                .setSize(new Dimension(-1, -1)).getComponent());
        panel.add(new ButtonBuilder("REPRODUCIR", event -> {})
                .setSize(new Dimension(-1, -1)).getComponent());
        panel.add(new ButtonBuilder("ADIVINAR", event -> {})
                .setSize(new Dimension(-1, -1)).getComponent());
        panel.add(new ButtonBuilder("SALIR", event -> {})
                .setSize(new Dimension(-1, -1)).getComponent());
    }
}
