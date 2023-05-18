package es.brouse.panels;

import es.brouse.Main;
import es.brouse.objects.builders.ImageBuilder;
import es.brouse.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;

public class BackgroundPanel extends Panel {
    private final ImageUtils imageUtils = new ImageUtils();

    public BackgroundPanel() {
        super(false);

        init();
    }

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new FlowLayout());
    }

    @Override
    public void initComponents(final JPanel panel) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        try {
            panel.add(new ImageBuilder(imageUtils.loadImage("background.jpg"))
                    .setDimensions(new Dimension(size.width, size.height - 125)).getComponent());
        } catch (IOException e) {
            Main.logger.log(Level.WARNING, "Unable to load URL");
        }
    }
}
