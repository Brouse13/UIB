package es.brouse.game.objects.builders;

import es.brouse.game.objects.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Class in charge of the creation of the {@link JLabel} that will
 * display images on the interactive interfaces.
 */
public class ImageBuilder implements Component {
    /*---------- PRIVATE ----------*/
    private final JLabel label;
    private final BufferedImage image;

    /**
     * Main class constructor able to create new {@link ImageBuilder}
     * instance with the image.
     */
    public ImageBuilder(BufferedImage image) {
        this.label = new JLabel();
        this.image = image;
    }

    /**
     * Set the dimensions of the image.
     *
     * @param size image size
     * @return the builder instance
     */
    public ImageBuilder setDimensions(Dimension size) {
        label.setSize(size);
        return this;
    }

    public ImageBuilder test() {
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 10));
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * @return the swing associated image
     */
    @Override
    public JComponent getComponent() {
        Image scaledInstance = image.getScaledInstance(
                label.getWidth(),
                label.getHeight(),
                Image.SCALE_SMOOTH);

        label.setIcon(new ImageIcon(scaledInstance));

        return label;
    }
}
