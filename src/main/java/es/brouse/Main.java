package es.brouse;

import es.brouse.screens.GameScreen;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        EventQueue.invokeLater(() ->new GameScreen().start());
    }
}
