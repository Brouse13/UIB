package es.brouse.game.screen;

import es.brouse.game.panels.GamePanel;
import es.brouse.game.panels.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class GameScreen extends Screen {
    @Override
    public String getTitle() {
        return "Practica Final - Programación II";
    }

    @Override
    public Panel getRootPanel() {
        return new GamePanel();
    }

    @Override
    public void setUp(JFrame frame) {
        frame.setSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocale(Locale.ROOT);
    }
}
