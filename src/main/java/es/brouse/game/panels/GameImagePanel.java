package es.brouse.game.panels;

import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.ImageBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.*;

public class GameImagePanel extends Panel {
    private final BufferedImage image;

    public GameImagePanel(BufferedImage image) {
        super(false);
        this.image = image;

        init();
    }

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new BorderLayout());
    }

    @Override
    public void initComponents(final JPanel panel) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension frame = new Dimension(
                (int) (size.getWidth() - 100),
                ((int) (size.getHeight() - 100))
        );

        panel.add(new ImageBuilder(image).setDimensions(frame).getComponent());

        panel.add(new ButtonBuilder("CERRAR").getComponent(), SOUTH);
    }
}
