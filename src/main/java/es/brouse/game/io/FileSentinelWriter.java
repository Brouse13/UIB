package es.brouse.game.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class in charge of the files with sentinel writing
 */
public class FileSentinelWriter implements Writer, Sentinel {
    /*---------- PRIVATE STATIC ----------*/
    private static final Logger logger = Logger.getLogger(FileSentinelWriter.class.getName());

    /*---------- PRIVATE ----------*/
    private Object sentinel;
    private ObjectOutputStream outStream;

    /**
     * Main class constructor used to create new {@link FileSentinelWriter}
     * instances.
     *
     * @param path relative path to the file
     */
    public FileSentinelWriter(String path) {
        try {
            //Crea el OutputStream
            this.outStream = new ObjectOutputStream(new FileOutputStream(path));
        } catch (IOException e) {
            logger.log(Level.WARNING, "File " + path + " couldn't be opened");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param objects object to write
     */
    @Override
    public void write(Object... objects) {
        for (Object object : objects) {
            try {
                outStream.writeObject(object);
            } catch (NotSerializableException e) {
                logger.log(Level.WARNING, "Object " + object.getClass().getSimpleName() +
                        " must implement Serializable interface");
            } catch (IOException e) {
                logger.log(Level.WARNING, "Object " + object.toString() + " couldn't be written");
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param sentinel new sentinel
     */
    @Override
    public void setSentinel(Object sentinel) {
        this.sentinel = sentinel;
    }

    /**
     * {@inheritDoc}
     *
     * @return the set sentinel
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
        if (outStream != null)
            try {
                //Write sentinel if the file has any sentinel
                if (sentinel != null) write(sentinel);

                //Close the stream
                outStream.close();
            } catch (Exception e) {
                logger.log(Level.WARNING, "File couldn't be closed");
            }
    }
}