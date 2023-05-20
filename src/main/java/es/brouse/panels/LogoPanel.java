package es.brouse.panels;

import es.brouse.Main;
import es.brouse.objects.builders.ImageBuilder;
import es.brouse.objects.builders.LabelBuilder;
import es.brouse.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;

public class LogoPanel {
    private final ImageUtils imageUtils = new ImageUtils();
    public LabelBuilder getLabel() {
        return new LabelBuilder("TALLER 2 - PROGRAMACIÓN II - CURSO 2023")
                .setSize(new Dimension(-1, 40))
                .setBackground(Color.BLACK)
                .setFont("Arial", Font.PLAIN, 30)
                .align(JLabel.CENTER);
    }

    public ImageBuilder getImage() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        try {
            return new ImageBuilder(imageUtils.loadImage("background.jpg"))
                    .setDimensions(new Dimension(size.width, size.height - 125));
        }catch (IOException exception) {
            Main.logger.log(Level.WARNING, "Unable to load URL");
        }
        return null;
    }
}
