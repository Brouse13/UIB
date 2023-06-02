package es.brouse.game.panels.iddle;

import es.brouse.game.listeners.GameListeners;
import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.panels.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        add(getButton("Nueva Partida", listeners.newGame()));
        add(getButton("Historial Partida", listeners.generalScore()));
        add(getButton("Historial Selectivo", listeners.score()));
        add(getButton("Salir", listeners.exit()));
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    /**
     * Get the button associated to the given name and listener.
     *
     * @param name button name
     * @param listener button listener
     * @return the created component
     */
    private JComponent getButton(String name, ActionListener listener) {
        return new ButtonBuilder(name, null, listener)
                .setBackgroundColor(Color.BLACK)
                .getComponent();
    }
}
