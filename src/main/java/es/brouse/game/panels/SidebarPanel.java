package es.brouse.game.panels;

import es.brouse.game.listeners.GameListeners;
import es.brouse.game.objects.ButtonObject;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends Panel {
    private static final GameListeners listeners = new GameListeners();


    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(4, 1));
        panel.setSize(new Dimension(150, -1));
        panel.setVisible(true);
    }

    @Override
    public void initComponents(final JPanel panel) {
        panel.add(new ButtonObject("Nueva Partida", null, listeners.newGame()).getComponent());
        panel.add(new ButtonObject("Historial General", null, listeners.generalScore()).getComponent());
        panel.add(new ButtonObject("Historial Selectivo", null, listeners.score()).getComponent());
        panel.add(new ButtonObject("Salir", null, listeners.exit()).getComponent());
    }
}
