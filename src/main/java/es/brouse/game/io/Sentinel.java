package es.brouse.game.io;

import java.io.Serializable;

public interface Sentinel extends Serializable {
    /**
     * Set a new sentinel.
     *
     * @param sentinel new sentinel
     */
    void setSentinel(Object sentinel);

    /**
     * Get the set sentinel associated previously, in case of
     * the sentinel is not set, it will return a null reference.
     *
     * @return the associated sentinel
     */
    Object getSentinel();
}
