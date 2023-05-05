package es.brouse.game;

import es.brouse.game.screen.GameScreen;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class Game extends JFrame {
    public static final Logger logger = Logger.getLogger(Game.class.getSimpleName());

    public static void main(String[] args) {
        EventQueue.invokeLater(new GameScreen()::start);
    }
}
