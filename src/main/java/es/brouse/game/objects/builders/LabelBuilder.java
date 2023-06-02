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
     * Main class constructor able to create new {@link JLabel}
     * instance.
     *
     * @param name label content
     */
    public LabelBuilder(String name) {
        label = new JLabel(name);
    }

    /**
     * Set the new size to the label.
     *
     * @param dimension new dimension
     * @return the builder instance
     */
    public LabelBuilder setSize(Dimension dimension) {
        label.setSize(dimension);
        return this;
    }

    /**
     * Set the current background to the given color.
     *
     * @param background new backgroundColor
     * @return the builder instance
     */
    public LabelBuilder setBackground(Color background) {
        if (background == Color.BLACK) label.setForeground(Color.WHITE);
        label.setBackground(background);
        label.setOpaque(true);
        return this;
    }

    /**
     * Set the current label font to the given.
     *
     * @param font new font name
     * @param type new font type
     * @param size new font size
     * @return the builder instance
     */
    public LabelBuilder setFont(String font, int type, int size) {
        label.setFont(new Font(font, type, size));
        return this;
    }

    /**
     * Set the new alignment to the label.
     *
     * @param align new alignment
     * @return the new builder
     */
    public LabelBuilder align(int align) {
        label.setHorizontalAlignment(align);
        return this;
    }

    /**
     * Set the border to the label.
     *
     * @param border new border
     * @return the builder instance
     */
    public LabelBuilder setBorder(Border border) {
        label.setBorder(border);
        return this;
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JLabel
     */
    @Override
    public JComponent getComponent() {
        return label;
    }
}
