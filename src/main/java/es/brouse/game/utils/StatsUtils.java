package es.brouse.game.utils;

import es.brouse.game.Game;
import es.brouse.game.io.StatsWriter;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class StatsUtils {
    public void writeStats(GameStats... stats) {
        //Assert the ile is created
        try {
            final File dir = new File("data");
            final File file = new File("data/stats.dat");
            if (!file.exists() && dir.mkdir()) {
                if (file.createNewFile())
                    System.out.println("'stats/dat.dat' created");
                else
                    System.out.println("Error creating 'data/stats.dat'");
            }
        }catch (IOException e) {
            Game.logger.log(Level.WARNING, "Unable to create file 'data/stats.dat'");
        }

        //Log the stats
        try(StatsWriter writer = new StatsWriter("data/stats.dat")) {
            for (GameStats stat : stats) writer.write(stat);
        }
    }
}
