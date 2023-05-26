package es.brouse.game.panels;

import es.brouse.game.listeners.GameListeners;
import es.brouse.game.objects.builders.ButtonBuilder;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel implements Panel {
    private final GameListeners listeners = new GameListeners();

    public SidebarPanel() {
        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(4, 1));
        setSize(new Dimension(150, -1));
        setVisible(true);
    }

    @Override
    public void initComponents() {
        add(new ButtonBuilder("Nueva Partida", null, listeners.newGame()).getComponent());
        add(new ButtonBuilder("Historial General", null, listeners.generalScore()).getComponent());
        add(new ButtonBuilder("Historial Selectivo", null, listeners.score()).getComponent());
        add(new ButtonBuilder("Salir", null, listeners.exit()).getComponent());
    }

    @Override
    public JComponent getComponent() {
        return this;
    }
}
