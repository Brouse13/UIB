package es.brouse.game.screen;

import es.brouse.game.Game;
import es.brouse.game.panels.GamePanel;

import javax.swing.*;
import java.util.Locale;
import java.util.logging.Level;

public class GameScreen extends JFrame implements Screen {
    private static final String TITLE = "Practica Final - Programación II";
    public static final GamePanel gamePanel = new GamePanel();

    public GameScreen() {
        setUp();
    }

    @Override
    public void setUp() {
        setTitle(TITLE);
        setContentPane(gamePanel.getComponent());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

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
