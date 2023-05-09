package es.brouse.game.panels;

import es.brouse.game.Game;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;

public class BackgroundPanel extends Panel {
    private static final ImageUtils utils = new ImageUtils();

    @Override
    public void setUp(final JPanel panel) {
        panel.setSize(new Dimension(-1, -1));
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setVisible(true);
    }

    @Override
    public void initComponents(final JPanel panel) {
        try {
            panel.add(new ImageBuilder(utils.loadImage("/assets/gui/background.jpg"))
                    .setDimensions(new Dimension(150, 150)).getComponent());
        }catch (IOException e) {
            Game.logger.log(Level.WARNING, "Unable to load background image");
        }
    }
}
