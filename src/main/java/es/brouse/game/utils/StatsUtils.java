package es.brouse.game.utils;

import es.brouse.game.io.StatsWriter;

public class StatsUtils {
    public void writeStats(GameStats... stats) {
        try(StatsWriter writer = new StatsWriter("data/stats.dat")) {
            for (GameStats stat : stats) writer.write(stat);
        }
    }
}
