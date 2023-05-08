package es.brouse.game.screen;

import es.brouse.game.Game;
import es.brouse.game.panels.GamePanel;
import es.brouse.game.panels.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.logging.Level;

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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            Game.logger.log(Level.WARNING, "Couldn't assign system LookAndFeel");
        }
        frame.setLocale(Locale.ROOT);
    }
}
