package es.brouse.game.io;

import java.io.Closeable;

/**
 * Interface to group all the read operations that a reader can have.
 */
public interface Reader extends Closeable {
    /**
     * Return if the reader can perform another read operation or if
     * the read buffer has more elements to read.
     *
     * @return if reader can perform a read operation
     */
    boolean next();

    /**
     * Return the last read object by the {@link Reader}. Depending on
     * the implementation, this object can represent another class.
     *
     * In case of using this method without using {@link Reader#next()} before,
     * it will return a null object.
     *
     * @return the read object
     */
    Object read();
}