package es.brouse.game.screen;

import es.brouse.game.Game;
import es.brouse.game.panels.StartGamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.logging.Level;

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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            Game.logger.log(Level.WARNING, "Couldn't assign system LookAndFeel");
        }
        setLocale(Locale.ROOT);
    }

    @Override
    public void start() {
        setVisible(true);
    }
}
