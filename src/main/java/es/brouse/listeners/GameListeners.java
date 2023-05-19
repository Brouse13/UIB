package es.brouse.listeners;

import es.brouse.Main;
import es.brouse.panels.GameMainPanel;
import es.brouse.screens.GameScreen;

import java.awt.event.ActionListener;

public class GameListeners {
    public ActionListener exitEvent() {
        return e -> System.exit(0);
    }

    public ActionListener create() {
        return e -> GameScreen.mainPanel.changeToNotes();
    }
}
