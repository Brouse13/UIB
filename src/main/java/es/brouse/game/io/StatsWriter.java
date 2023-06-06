package es.brouse.game.io;

import es.brouse.game.utils.GameStats;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class in charge of the files with sentinel writing
 */
public class StatsWriter implements Closeable {
    /*---------- PRIVATE STATIC ----------*/
    private static final Logger logger = Logger.getLogger(StatsWriter.class.getName());

    /*---------- PRIVATE ----------*/
    private RandomAccessFile buffer;

    /**
     * Main class constructor used to create new {@link StatsWriter}
     * instances.
     *
     * @param path relative path to the file
     */
    public StatsWriter(String path) {
        try {
            this.buffer = new RandomAccessFile(path, "rw");
        } catch (IOException e) {
            logger.log(Level.WARNING, "File " + path + " couldn't be opened");
        }
    }

    /**
     * Write an object array into the buffer writer.
     *
     * @apiNote Object... and Object[] are just the same, but the
     * first method doesn't need to initialize the array, and all
     * the arguments can be separated by ','.
     *
     * @param stats objects to write
     */
    public void write(GameStats... stats) {
        try {
            if (buffer == null) return;
            buffer.seek(buffer.length());

            for (GameStats stat : stats) {
                buffer.writeLong(stat.getTime());

                buffer.writeBoolean(stat.isWin());

                buffer.writeInt(stat.getPoints());

                buffer.writeUTF(stat.getUsername());
            }

        } catch (IOException e) {
            logger.log(Level.WARNING, "Object couldn't be written");
        }
    }

    /**
     * Close the buffer
     */
    @Override
    public void close() {
        if (buffer == null) return;

        try {
            //Close the stream
            buffer.close();
        } catch (Exception e) {
            logger.log(Level.WARNING, "File couldn't be closed");
        }
    }

}