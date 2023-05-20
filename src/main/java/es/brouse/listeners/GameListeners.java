package es.brouse.listeners;

import es.brouse.panels.GameMainPanel;

import java.awt.event.ActionListener;

public class GameListeners {
    public ActionListener exitEvent() {
        return e -> System.exit(0);
    }

    public ActionListener create() {
        return e -> GameMainPanel.getInstance().changeToNotes();
    }

    public ActionListener reproduce() {
        return e -> GameMainPanel.getInstance().changeToContinue();
    }
}
