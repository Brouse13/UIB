package es.brouse.screens;

import es.brouse.panels.GameMainPanel;

import javax.swing.*;
import java.util.Locale;

public class GameScreen extends JFrame implements Screen {
    public static final GameMainPanel mainPanel = new GameMainPanel();

    public GameScreen() {
        setUp();
    }

    @Override
    public void setUp() {
        setTitle("Practica 2 - Programación II");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(mainPanel);

        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLocale(Locale.ROOT);
    }

    @Override
    public void start() {
        setVisible(true);
    }
}
