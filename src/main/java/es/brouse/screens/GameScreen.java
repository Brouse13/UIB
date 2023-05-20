package es.brouse.screens;

import es.brouse.panels.GameMainPanel;

import javax.swing.*;
import java.util.Locale;

public class GameScreen extends JFrame implements Screen {
    private static final GameScreen instance = new GameScreen();

    private GameScreen() {
        setUp();
    }

    public static GameScreen getInstance() {
        return instance;
    }

    @Override
    public void setUp() {
        setTitle("Practica 2 - Programación II");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(GameMainPanel.getInstance());

        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLocale(Locale.ROOT);
    }

    @Override
    public void start() {
        setVisible(true);
    }
}
