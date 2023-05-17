package es.brouse.screens;

import es.brouse.Main;
import es.brouse.panels.GameMainPanel;
import es.brouse.panels.Panel;

import javax.swing.*;
import java.util.Locale;
import java.util.logging.Level;

public class GameScreen extends Screen {
    @Override
    public String getTitle() {
        return "Practica 2 - Programación II";
    }

    @Override
    public Panel getRootPanel() {
        return new GameMainPanel();
    }

    @Override
    public void setUp(final JFrame frame) {
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            Main.logger.log(Level.WARNING, "Couldn't assign system LookAndFeel");
        }
        frame.setLocale(Locale.ROOT);
    }
}
