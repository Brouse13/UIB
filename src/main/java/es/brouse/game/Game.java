package es.brouse.game;

import es.brouse.game.screen.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class Game extends JFrame {
    public static final Logger logger = Logger.getLogger(Game.class.getSimpleName());
    public static final GameScreen gameScreen = new GameScreen();

    public static void main(String[] args) throws InterruptedException {
        EventQueue.invokeLater(gameScreen::start);
    }
}
