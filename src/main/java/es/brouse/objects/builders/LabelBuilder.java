package es.brouse.objects.builders;

import es.brouse.objects.Component;

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
     */
    public LabelBuilder(String name) {
        label = new JLabel(name);
    }

    /**
     * Set the size of the label.
     *
     * @param size new size
     * @return the builder instance
     */
    public LabelBuilder setSize(Dimension size) {
        label.setSize(size);
        return this;
    }

    public LabelBuilder setBackground(Color background) {
        if (background == Color.BLACK) label.setForeground(Color.WHITE);
        label.setBackground(background);
        label.setOpaque(true);
        return this;
    }

    public LabelBuilder setFont(String font, int type, int size) {
        label.setFont(new Font(font, type, size));
        return this;
    }

    /**
     * Set the textSize to the label
     *
     * @param size new size
     * @return the builder instance
     */
    public LabelBuilder setTextSize(int size) {
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, size));
        return this;
    }

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
