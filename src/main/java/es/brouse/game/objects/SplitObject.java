package es.brouse.game.objects;

import javax.swing.*;

/**
 * Class in charge of the creation of the {@link JSplitPane} that will
 * be on the interactive interfaces.
 */
public class SplitObject {
    /*---------- PRIVATE ----------*/
    private final JSplitPane panel;

    /*---------- PUBLIC / STATIC ----------*/
    public static final int VERTICAL_SPLIT = 0;
    public static final int HORIZONTAL_SPLIT = 1;

    /**
     * Main class constructor able to create new {@link SplitObject}
     * instance only with its name
     */
    public SplitObject(int orientation) {
        panel = new JSplitPane(orientation);
    }

    /**
     * Get the associated swing component ({@link JComponent}) that will
     * represent all the stored data.
     *
     * @return the swing JMenuBar
     */
    public JComponent getComponent() {
        return panel;
    }
}
