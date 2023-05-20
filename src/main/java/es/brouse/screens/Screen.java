package es.brouse.screens;

import javax.swing.*;

/**
 * Class in charge of the creation of the {@link JFrame} that will
 * be on the interactive interfaces.
 */
public interface Screen {
    /**
     * Set up the main features to the frame
     */
    void setUp();

    /**
     * Set visible the frame that is the same as starting
     * the frame.
     */
    void start();

    /**
     * Display a popup message associated to this panel.
     *
     * @param message popup message content
     */
    void popup(String message);

    /**
     * Refresh the given screen
     *
     * @param frame frame to refresh
     */
    static void refresh(JFrame frame) {
        frame.revalidate();
        frame.validate();
        frame.repaint();
    }
}