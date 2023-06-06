package es.brouse.game.io;

import es.brouse.game.utils.GameStats;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class in charge of the files with sentinel reading
 */
public class StatsReader implements Closeable {
    /*---------- PRIVATE STATIC ----------*/
    private static final Logger logger = Logger.getLogger(StatsReader.class.getName());

    /*---------- PRIVATE ----------*/
    private GameStats nextObject;

    private RandomAccessFile buffer;


    /**
     * Main class constructor in charge of the creation of new
     * {@link StatsReader} instances.
     *
     * @param path relative path to the file
     */
    public StatsReader(String path) {
        try {
            this.buffer = new RandomAccessFile(path, "r");
        } catch (IOException e) {
            logger.log(Level.WARNING, "File " + path + " couldn't be opened");
        }
    }

    /**
     * Return if the reader can perform another read operation or if
     * the read buffer has more elements to read.
     *
     * @return if reader can perform a read operation
     */
    public boolean next() {
        try {
            //Check file has remaining elements
            if (buffer.length() - buffer.getFilePointer() < GameStats.LENGTH) return false;

            //Read the next object
            nextObject = new GameStats(
                    buffer.readLong(),
                    buffer.readBoolean(),
                    buffer.readInt(),
                    buffer.readUTF()
            );

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Return the last read object by the {@link Reader}. Depending on
     * the implementation, this object can represent another class.
     * <br/>
     * In case of using this method without using {@link StatsReader#next()} before,
     * it will return a null object.
     *
     * @return the read object
     */
    public GameStats read() {
        return nextObject;
    }

    /**
     * Close the buffer
     */
    @Override
    public void close() {
        if (buffer == null) return;

        try {
            buffer.close();
        } catch (IOException e) {
            logger.log(Level.WARNING, "File couldn't be closed");
        }
    }
}