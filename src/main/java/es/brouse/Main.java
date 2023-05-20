package es.brouse;

import es.brouse.screens.GameScreen;

import java.awt.*;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        EventQueue.invokeLater(() -> GameScreen.getInstance().start());
    }
}
