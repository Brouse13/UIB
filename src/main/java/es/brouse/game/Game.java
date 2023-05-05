package es.brouse.game;

import es.brouse.game.screen.GameScreen;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new GameScreen()::start);
    }
}
