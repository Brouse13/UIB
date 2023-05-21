package es.brouse.panels.logo;

import es.brouse.Main;
import es.brouse.objects.builders.ImageBuilder;
import es.brouse.panels.Panel;
import es.brouse.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;

/**
 * Class used to handle the main background image view
 */
public class ImageLogo extends JPanel implements Panel {
    private final ImageUtils imageUtils = new ImageUtils();
    public ImageLogo() {
        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        try {
            add(new ImageBuilder(imageUtils.loadImage("background.jpg"))
                    .setDimensions(new Dimension(size.width, size.height - 125))
                    .getComponent());
        }catch (IOException exception) {
            Main.logger.log(Level.WARNING, "Unable to load URL");
        }
    }
}
