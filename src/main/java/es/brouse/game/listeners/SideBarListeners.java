package es.brouse.game.listeners;

import java.awt.event.ActionListener;

public class SideBarListeners {
    public ActionListener newGame() {
        return event -> System.out.println("New Game Started");
    }

    public ActionListener generalScore() {
        return event -> System.out.println("General Score: %d");
    }

    public ActionListener score() {
        return event -> System.out.println("Score: %d");
    }

    public ActionListener exit() {
        return event -> System.exit(0);
    }
}
