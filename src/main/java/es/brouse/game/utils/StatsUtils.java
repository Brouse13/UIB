package es.brouse.game.utils;

import es.brouse.game.Game;
import es.brouse.game.io.StatsWriter;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class StatsUtils {
    /**
     * Write into the stats file the given stats.
     *
     * @param stats stats to write
     */
    public void writeStats(GameStats... stats) {
        //Assert the ile is created
        createDir();

        //Log the stats
        try(StatsWriter writer = new StatsWriter("data/resultats.dat")) {
            for (GameStats stat : stats) writer.write(stat);
        }
    }

    /**
     * Create the stats folder.
     */
    private void createDir() {
        try {
            final File dir = new File("data");
            final File file = new File("data/resultats.dat");
            if (!file.exists() && dir.mkdir()) {
                if (file.createNewFile())
                    System.out.println("'stats/dat.dat' created");
                else
                    System.out.println("Error creating 'data/resultats.dat'");
            }
        }catch (IOException e) {
            Game.logger.log(Level.WARNING, "Unable to create file 'data/resultats.dat'");
        }
    }
}
