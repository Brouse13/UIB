package es.brouse.game.panels.iddle;

import es.brouse.game.Game;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;

public class BackgroundPanel extends JPanel implements Panel {

    public BackgroundPanel() {
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

        Dimension frame = new Dimension(
                (int) (size.getWidth() - 100),
                ((int) (size.getHeight() - 100))
        );

        try {
            add(new ImageBuilder(new ImageUtils().loadImage("/assets/gui/background.jpg"))
                    .setDimensions(frame).getComponent());
        }catch (IOException e) {
            Game.logger.log(Level.WARNING, "Unable to load background image");
        }
    }

    @Override
    public JComponent getComponent() {
        return this;
    }
}