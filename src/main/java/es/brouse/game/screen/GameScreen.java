package es.brouse.game.screen;

import es.brouse.game.panels.iddle.IdlePanel;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.util.Locale;

public class GameScreen extends JFrame implements Screen {
    private static GameScreen instance;
    private static final String TITLE = "Practica Final - Programación II";
    public static GameScreen getInstance() {
        if (instance == null) instance = new GameScreen();
        return instance;
    }

    private GameScreen() {
        setUp();
    }

    @Override
    public void setUp() {
        setTitle(TITLE);
        setContentPane(IdlePanel.getInstance().getComponent());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setIconImage(new ImageIcon(new ImageUtils().loadResource("/icon.jpg")).getImage());

        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLocale(Locale.ROOT);
    }

    @Override
    public void start() {
        setVisible(true);
    }
}
