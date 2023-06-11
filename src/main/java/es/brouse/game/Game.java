package es.brouse.game;

import es.brouse.game.screen.GameScreen;

import java.util.logging.Logger;

/**
 * Main game class in charge of the start of the game
 */
public class Game {
    /*--------- PRIVATE STATIC ---------*/
    public static boolean gameStarted = false;
    public static final Logger logger = Logger.getLogger(Game.class.getSimpleName());

    /**
     * Main class instance.
     *
     * @param args JVM args
     */
    public static void main(String[] args) {
        GameScreen.getInstance().setVisible(true);
    }
}
