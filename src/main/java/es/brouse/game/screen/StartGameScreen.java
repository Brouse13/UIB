package es.brouse.game.screen;

import es.brouse.game.Game;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.StartGamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.logging.Level;

public class StartGameScreen extends Screen {
    @Override
    public String getTitle() {
        return "Iniciar partida";
    }

    @Override
    public Panel getRootPanel() {
        return new StartGamePanel();
    }

    @Override
    public void setUp(final JFrame frame) {
        frame.setSize(new Dimension(500, 200));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            Game.logger.log(Level.WARNING, "Couldn't assign system LookAndFeel");
        }
        frame.setLocale(Locale.ROOT);
    }
}
