package es.brouse.game.listeners;

import java.awt.event.ItemListener;

public final class GameListeners {
    public ItemListener newGame() {
        return event -> System.out.println("New Game Started");
    }

    public ItemListener generalScore() {
        return event -> System.out.println("General Score: %d");
    }

    public ItemListener score() {
        return event -> System.out.println("Score: %d");
    }

    public ItemListener changeDir() {
        return event -> System.out.println("Directory changed");
    }

    public ItemListener exit() {
        return event -> System.exit(0);
    }
}
