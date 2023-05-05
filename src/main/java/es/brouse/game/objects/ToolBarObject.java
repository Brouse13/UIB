package es.brouse.game.objects;

import javax.swing.*;

/**
 * Class in charge of the creation of the {@link JToolBar} that will
 * be on the interactive interfaces.
 */
public class ToolBarObject implements Component {
    /*---------- PRIVATE ----------*/
    private final JToolBar toolBar;

    /*---------- PUBLIC / STATIC ----------*/
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL   = 1;

    /**
     * Main class constructor able to create new {@link SplitObject}
     * instance with its orientation
     */
    public ToolBarObject(int orientation) {
        this.toolBar = new JToolBar(orientation);
    }

    public void add(JComponent component) {
        toolBar.add(component);
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JToolBar
     */
    @Override
    public JComponent getComponent() {
        return toolBar;
    }
}
