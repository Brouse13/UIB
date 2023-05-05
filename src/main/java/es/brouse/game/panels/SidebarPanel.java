package es.brouse.game.panels;

import es.brouse.game.listeners.SideBarListeners;
import es.brouse.game.objects.ButtonBuilder;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends Panel {

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(4, 1));
        panel.setSize(new Dimension(150, -1));
        panel.setVisible(true);
    }

    @Override
    public void initComponents(final JPanel panel) {
        final SideBarListeners listeners = new SideBarListeners();

        panel.add(new ButtonBuilder("Nueva Partida", null, listeners.newGame()).getComponent());
        panel.add(new ButtonBuilder("Historial General", null, listeners.generalScore()).getComponent());
        panel.add(new ButtonBuilder("Historial Selectivo", null, listeners.score()).getComponent());
        panel.add(new ButtonBuilder("Salir", null, listeners.exit()).getComponent());
    }
}
