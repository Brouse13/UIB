package es.brouse.game.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class in charge of the files with sentinel reading
 */
public class FileSentinelReader implements Reader, Sentinel {
    /*---------- PRIVATE STATIC ----------*/
    private static final Logger logger = Logger.getLogger(FileSentinelReader.class.getName());

    private Object nextObject;
    private Object sentinel;
    private ObjectInputStream inStream;


    /**
     * Main class constructor in charge of the creation of new
     * {@link FileSentinelReader} instances.
     *
     * @param path relative path to the file
     */
    public FileSentinelReader(String path) {
        final File file = new File(path);

        try {
            this.inStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            logger.log(Level.WARNING, "File " + path + " couldn't be opened");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return if reader has objects
     */
    @Override
    public boolean next() {
        try {
            //Read next object
            nextObject = inStream.readObject();

            //Check if is null -> No more elements
            if (nextObject == null) return false;

            //If the read obj is not null check if it's the sentinel, if set
            if (sentinel != null && sentinel.equals(nextObject)) return false;
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @return the read value
     */
    @Override
    public Object read() {
        return nextObject;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void setSentinel(Object sentinel) {
        this.sentinel = sentinel;
    }

    /**
     * {@inheritDoc}
     *
     * @return sentinel set
     */

    @Override
    public Object getSentinel() {
        return sentinel;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void close() {
        if (inStream != null) {
            try {
                inStream.close();
            } catch (IOException e) {
                logger.log(Level.WARNING, "File couldn't be closed");
            }
        }
    }
}