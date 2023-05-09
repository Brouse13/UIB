package es.brouse.game.objects.builders;

import es.brouse.game.objects.Component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Class in charge of the creation of the {@link JLabel} that will
 * be on the interactive interfaces.
 */
public class LabelBuilder implements Component {
    /*---------- PRIVATE ----------*/
    private final JLabel label;

    /**
     * Main class constructor able to create new {@link SplitPanelBuilder}
     * instance only with its orientation.
     */
    public LabelBuilder(String name) {
        label = new JLabel(name);
    }

    public LabelBuilder setSize(Dimension size) {
        label.setSize(size);
        return this;
    }

    public LabelBuilder setBorder(Border border) {
        label.setBorder(border);
        return this;
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JSplitPanel
     */
    @Override
    public JComponent getComponent() {
        return label;
    }
}
