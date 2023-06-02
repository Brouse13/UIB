package es.brouse.game.screen;

import es.brouse.game.panels.game.StartGamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class StartGameScreen extends JFrame implements Screen {
    private static final String TITLE = "Iniciar partida";

    public StartGameScreen() {
        setUp();
    }

    @Override
    public void setUp() {
        setTitle(TITLE);
        setSize(new Dimension(500, 200));
        setContentPane(new StartGamePanel().getComponent());

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        setResizable(false);
        setLocale(Locale.ROOT);
    }

    @Override
    public void start() {
        setVisible(true);
    }
}
