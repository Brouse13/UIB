package es.brouse.game.objects;

import javax.swing.*;

/**
 * Class in charge of the creation of the {@link JSplitPane} that will
 * be on the interactive interfaces.
 */
public class SplitObject implements Component {
    /*---------- PRIVATE ----------*/
    private final JSplitPane panel;

    /*---------- PUBLIC / STATIC ----------*/
    public static final int VERTICAL_SPLIT = 0;
    public static final int HORIZONTAL_SPLIT = 1;

    /**
     * Main class constructor able to create new {@link SplitObject}
     * instance only with its orientation.
     */
    public SplitObject(int orientation) {
        panel = new JSplitPane(orientation);
    }

    /**
     * Main class constructor able to create new {@link SplitObject}
     * instance with the orientation and the elements.
     */
    public SplitObject(int orientation, JComponent left, JComponent right) {
        panel = new JSplitPane(orientation, left, right);
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JSplitPanel
     */
    @Override
    public JComponent getComponent() {
        return panel;
    }
}
