package es.brouse.game.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Class in charge of the creation of the {@link JPanel} that will
 * be on the interactive interfaces.
 */
public interface Panel {
    /**
     * Set up the main features to the panel.
     */
    void setUp();

    /**
     * Init all the needed components for the panel.
     */
    void initComponents();

    /**
     * Get the associated component to the panel.
     *
     * @return associated component
     */
    JComponent getComponent();

    /**
     * Close a specific panel on the current view.
     *
     * @param panel closed panel
     */
    static void close(final JPanel panel) {
        Window windowAncestor = SwingUtilities.getWindowAncestor(panel);
        windowAncestor.dispose();
    }
}
