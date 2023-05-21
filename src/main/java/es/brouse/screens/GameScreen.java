package es.brouse.screens;

import es.brouse.objects.MusicalNote;
import es.brouse.panels.mainPanel.GamePanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Class able to create new Game Screens
 */
public class GameScreen extends JFrame implements Screen {
    /**
     * Static instance of all the saved images
     */
    public static List<MusicalNote> notes = new ArrayList<>();
    private static final GameScreen instance = new GameScreen();

    /**
     * Init the Game screen
     */
    private GameScreen() {
        setUp();
    }

    /**
     * Get the class public instance.
     *
     * @return the class instance
     */
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

    /**
     * Add a new notes melody to the stored notes.
     *
     * @param notes new notes to store
     */
    public void addMelody(List<MusicalNote> notes) {
        GameScreen.notes = notes;
    }
}
