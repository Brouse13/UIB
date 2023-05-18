package es.brouse.objects.builders;

import es.brouse.objects.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class in charge of the creation of the {@link JButton} that will
 * be on the interactive interfaces.
 */
public class ButtonBuilder implements Component {
    /*---------- PRIVATE ----------*/
    private final JButton button;

    /**
     * Main class constructor able to create new {@link ButtonBuilder}
     * instance only with its name
     */
    public ButtonBuilder(String name) {
        this.button = new JButton(name);
    }

    /**
     * Main class constructor able to create new {@link ButtonBuilder}
     * instance with its name, icon and a listener
     */
    public ButtonBuilder(String name, ActionListener listener) {
        this.button = new JButton(name);
        this.button.addActionListener(listener);
    }

    /**
     * Main class constructor able to create new {@link ButtonBuilder}
     * instance with its name and an icon.
     */
    public ButtonBuilder(String name, Icon icon) {
        this.button = new JButton(name, icon);
    }

    /**
     * Main class constructor able to create new {@link ButtonBuilder}
     * instance with its name, icon and a listener
     */
    public ButtonBuilder(String name, Icon icon, ActionListener listener) {
        this.button = new JButton(name, icon);
        this.button.addActionListener(listener);
    }

    /**
     * Set the button color.
     *
     * @param background background color to set
     * @return the builder instance
     */
    public ButtonBuilder setColor(Color background) {
        if (background == Color.BLACK) button.setForeground(Color.WHITE);
        button.setBackground(background);
        button.setOpaque(true);
        return this;
    }

    /**
     * Set the size of the button to the specified by parameters.
     *
     * @param size size to set
     * @return the builder instance
     */
    public ButtonBuilder setSize(Dimension size) {
        button.setSize(size);
        return this;
    }

    /**
     * Set the render moder to FullImage. This render has the
     * ability to get the best image quality by adjusting the
     * size and other options.
     *
     * @return the builder instance
     */
    public ButtonBuilder fullImage() {
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setBorderPainted(false);
        return this;
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JButton
     */
    @Override
    public JComponent getComponent() {
        return button;
    }
}
