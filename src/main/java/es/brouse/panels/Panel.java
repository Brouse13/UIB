package es.brouse.panels;

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
     * Close the given panel
     *
     * @param panel panel to close
     */
    static void close(final JPanel panel) {
        Window windowAncestor = SwingUtilities.getWindowAncestor(panel);
        windowAncestor.dispose();
    }
}