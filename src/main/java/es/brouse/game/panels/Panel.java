package es.brouse.game.panels;

import javax.swing.*;

/**
 * Class in charge of the creation of the {@link JPanel} that will
 * be on the interactive interfaces.
 */
public abstract class Panel {
    /*---------- PRIVATE ----------*/
    private final JPanel panel;

    /**
     * Main class constructor able to create new {@link Panel}
     * instance.
     */
    public Panel() {
        this.panel = new JPanel();

        //Call the setup steps in order
        setUp(panel);
        initComponents(panel);
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
}
