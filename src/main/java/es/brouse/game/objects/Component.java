package es.brouse.game.objects;

import javax.swing.*;

/**
 * General interface that will determine that an object
 * can be converted into a swing component.
 */
public interface Component {
    /**
     * Get the associated swing component ({@link JComponent}) that will
     * represent all the stored data.
     *
     * @return the swing associated JComponent
     */
    JComponent getComponent();
}
