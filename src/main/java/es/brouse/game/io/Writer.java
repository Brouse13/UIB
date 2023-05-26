package es.brouse.game.io;

import java.io.Closeable;

/**
 * Interface to group all the read operations that a writer can have.
 */
public interface Writer extends Closeable {
    /**
     * Write an object array into the buffer writer.
     *
     * @apiNote Object... and Object[] are just the same, but the
     * first method doesn't need to initialize the array, and all
     * the arguments can be separated by ','.
     *
     * @param objects objects to write
     */
    void write(Object... objects);
}