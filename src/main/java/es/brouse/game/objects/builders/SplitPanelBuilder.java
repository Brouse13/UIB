package es.brouse.game.objects.builders;

import es.brouse.game.objects.Component;

import javax.swing.*;

/**
 * Class in charge of the creation of the {@link JSplitPane} that will
 * be on the interactive interfaces.
 */
public class SplitPanelBuilder implements Component {
    /*---------- PRIVATE ----------*/
    private final JSplitPane panel;

    /*---------- PUBLIC / STATIC ----------*/
    public static final int VERTICAL_SPLIT = 0;
    public static final int HORIZONTAL_SPLIT = 1;

    /**
     * Main class constructor able to create new {@link SplitPanelBuilder}
     * instance only with its orientation.
     *
     * @param orientation panel orientation
     */
    public SplitPanelBuilder(int orientation) {
        panel = new JSplitPane(orientation);
    }

    /**
     * Main class constructor able to create new {@link SplitPanelBuilder}
     * instance with the orientation and the elements.
     *
     * @param orientation panel orientation
     * @param left left component
     * @param right right component
     */
    public SplitPanelBuilder(int orientation, JComponent left, JComponent right) {
        panel = new JSplitPane(orientation, left, right);
    }

    /**
     * Set the left component.
     *
     * @param component new left component
     * @return the builder instance
     */
    public SplitPanelBuilder setLeft(JComponent component) {
        panel.setLeftComponent(component);
        return this;
    }

    /**
     * Set the right component.
     *
     * @param component new right component
     * @return the builder instance
     */
    public SplitPanelBuilder setRight(JComponent component) {
        panel.setRightComponent(component);
        return this;
    }

    /**
     * Set the preferred divider size to the set by params.
     *
     * @param size new preferred size
     * @return the builder instance
     */
    public SplitPanelBuilder setSize(int size) {
        panel.setDividerLocation(size);
        return this;
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JSplitPanel
     */
    @Override
    public JComponent getComponent() {
        panel.setEnabled(false);
        return panel;
    }
}
