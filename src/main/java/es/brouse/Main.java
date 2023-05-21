package es.brouse;

import es.brouse.screens.GameScreen;

import java.awt.*;
import java.util.logging.Logger;

/**
 * Main Game class able to init the game instance with its frame
 */
public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());

    /**
     * JVM main class
     *
     * @param args JVM args
     */
    public static void main(String[] args) {
        new Main().start();
    }

    /**
     * Class init
     */
    private void start() {
        EventQueue.invokeLater(() -> GameScreen.getInstance().start());
    }
}
