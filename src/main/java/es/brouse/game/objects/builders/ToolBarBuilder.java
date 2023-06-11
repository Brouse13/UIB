package es.brouse.game.objects.builders;

import es.brouse.game.objects.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Class in charge of the creation of the {@link JToolBar} that will
 * be on the interactive interfaces.
 */
public class ToolBarBuilder implements Component {
    /*---------- PRIVATE ----------*/
    private final JToolBar toolBar;

    /*---------- PUBLIC / STATIC ----------*/
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL   = 1;

    /**
     * Main class constructor able to create new {@link SplitPanelBuilder}
     * instance with its orientation.
     *
     * @param orientation component orientation
     */
    public ToolBarBuilder(int orientation) {
        this.toolBar = new JToolBar(orientation);
        toolBar.setFloatable(false);
    }

    /**
     * Add a new set of components to the ToolBar.
     *
     * @param component components to add
     * @return the builder instance
     */
    public ToolBarBuilder add(JComponent component) {
        toolBar.add(component);
        return this;
    }

    /**
     * Set the background color of the toolBar.
     *
     * @param color new color
     * @return the builder instance
     */
    public ToolBarBuilder setBackground(Color color) {
        toolBar.setBackground(color);
        return this;
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
