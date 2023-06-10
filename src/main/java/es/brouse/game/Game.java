package es.brouse.game;

import es.brouse.game.screen.GameScreen;

import java.util.logging.Logger;

public class Game {
    public static boolean gameStarted = false;
    public static final Logger logger = Logger.getLogger(Game.class.getSimpleName());

    public static void main(String[] args) {
        GameScreen.getInstance().setVisible(true);
    }
}
