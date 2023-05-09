package es.brouse.game.screen;

import es.brouse.game.Game;
import es.brouse.game.panels.GamePanel;
import es.brouse.game.panels.Panel;

import javax.swing.*;
import java.util.Locale;
import java.util.logging.Level;

public class GameScreen extends Screen {
    private static final GamePanel gamePanel = new GamePanel();
    @Override
    public String getTitle() {
        return "Practica Final - Programación II";
    }

    @Override
    public Panel getRootPanel() {
        return gamePanel;
    }

    @Override
    public void setUp(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            Game.logger.log(Level.WARNING, "Couldn't assign system LookAndFeel");
        }
        frame.setLocale(Locale.ROOT);
    }
}
