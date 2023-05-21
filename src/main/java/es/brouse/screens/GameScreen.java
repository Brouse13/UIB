package es.brouse.screens;

import es.brouse.objects.MusicalNote;
import es.brouse.panels.mainPanel.GamePanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Class
 */
public class GameScreen extends JFrame implements Screen {
    public static List<MusicalNote> notes = new ArrayList<>();
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

        setContentPane(GamePanel.getInstance());

        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLocale(Locale.ROOT);
    }

    @Override
    public void start() {
        setVisible(true);
    }

    @Override
    public void popup(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void addMelody(List<MusicalNote> notes) {
        GameScreen.notes = notes;
    }
}
