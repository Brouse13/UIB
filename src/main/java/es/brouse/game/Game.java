package es.brouse.game;

import es.brouse.game.io.StatsReader;
import es.brouse.game.io.StatsWriter;
import es.brouse.game.screen.GameScreen;
import es.brouse.game.utils.GameStats;

import javax.swing.*;
import java.util.logging.Logger;

public class Game extends JFrame {
    public static final Logger logger = Logger.getLogger(Game.class.getSimpleName());

    public static void main(String[] args) throws InterruptedException {
        GameScreen.getInstance().setVisible(true);
        GameStats gameStats = new GameStats(10, 10, 10L, 10L, false, "ds");
        try(StatsWriter writer = new StatsWriter("test.dat")) {
            writer.write(gameStats);
        }

        try(StatsReader reader = new StatsReader("test.dat")) {
            while (reader.next()) {
                System.out.println(reader.read().toString());
            }
        }
    }
}
