package es.brouse.listeners;

import es.brouse.panels.mainPanel.GamePanel;

import java.awt.event.ActionListener;

import static es.brouse.panels.mainPanel.GameController.RenderType.*;

public class GameListeners {
    public ActionListener exitEvent() {
        return e -> System.exit(0);
    }

    public ActionListener create() {
        return e -> GamePanel.getInstance().render(NOTES);
    }

    public ActionListener reproduce() {
        return e -> GamePanel.getInstance().render(REPRODUCE);
    }

    public ActionListener guess() {
        return e -> GamePanel.getInstance().render(GUESS);
    }
}
