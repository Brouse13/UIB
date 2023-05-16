package es.brouse.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Class in charge of the creation of the {@link JPanel} that will
 * be on the interactive interfaces.
 */
public abstract class Panel {
    /*---------- PRIVATE ----------*/
    private final JPanel panel;

    /**
     * Main class constructor able to create new {@link Panel}
     * instance and if the argument is true, it will init
     * the components.
     *
     * @param init init the components
     */
    public Panel(boolean init) {
        this.panel = new JPanel();

        //Call the setup steps in order
        if (init) init();
    }

    /**
     * Main class constructor able to create new {@link Panel}
     * instance with the component initialization.
     */
    public Panel() {
        this(true);
    }

    /**
     * Set up the main features to the panel
     *
     * @param panel panel to apply the 'Set Up' on
     */
    public abstract void setUp(final JPanel panel);

    /**
     * Init all the needed components for the panel
     *
     * @param panel panel to apply the component initialization
     */
    public abstract void initComponents(final JPanel panel);

    /**
     * Get the associated swing component ({@link JPanel}) that will
     * represent all the stored data.
     *
     * @return the swing JPanel
     */
    public JComponent getComponent() {
        return panel;
    }

    /**
     * Method to init all the components
     */
    protected void init() {
        setUp(panel);
        initComponents(panel);
    }

    protected void close() {
        Window windowAncestor = SwingUtilities.getWindowAncestor(panel);
        windowAncestor.dispose();
    }
}