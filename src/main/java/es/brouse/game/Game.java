package es.brouse.game;

import es.brouse.game.screen.GameScreen;

import java.util.logging.Logger;

public class Game {
    public static final Logger logger = Logger.getLogger(Game.class.getSimpleName());

    public static void main(String[] args) throws InterruptedException {
        GameScreen.getInstance().setVisible(true);
    }
}
