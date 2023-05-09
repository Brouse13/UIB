package es.brouse.game.screen;

import es.brouse.game.panels.Panel;

import javax.swing.*;

/**
 * Class in charge of the creation of the {@link JFrame} that will
 * be on the interactive interfaces.
 */
public abstract class Screen {
    /*---------- PRIVATE ----------*/
    private final JFrame frame;

    /**
     * Main class constructor able to create new {@link Screen}
     * instance.
     */
    public Screen() {
        this.frame = new JFrame(getTitle());

        //Call init phase in order
        frame.setContentPane(getRootPanel().getComponent());
        setUp(frame);
    }

    /**
     * Get the main title of the screen.
     *
     * @return screen title
     */
    public abstract String getTitle();

    /**
     * Get the Panel that will apear at first on the screen.
     *
     * @return main content panel
     */
    public abstract Panel getRootPanel();

    /**
     * Set up the main features to the frame
     *
     * @param frame frame to apply the 'Set Up' on
     */
    public abstract void setUp(final JFrame frame);

    /**
     * Set visible the frame that is the same as starting
     * the frame.
     */
    public void start() {
        frame.setVisible(true);
    }

    public void refresh() {
        frame.revalidate();
        frame.validate();
        frame.repaint();
    }
}
