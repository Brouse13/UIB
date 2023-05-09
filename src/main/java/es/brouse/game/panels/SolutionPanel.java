package es.brouse.game.panels;

import es.brouse.game.objects.ImageObject;
import es.brouse.game.objects.SplitImage;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Set;

public class SolutionPanel extends Panel {
    private final ImageUtils utils = new ImageUtils();
    private final BufferedImage solution;
    private final Set<SplitImage> subImages;

    public SolutionPanel(BufferedImage solution, int rows, int cols) {
        this.solution = solution;
        this.subImages = utils.split(solution, rows, cols);
    }

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setVisible(true);
    }

    @Override
    public void initComponents(final JPanel panel) {
        panel.add(new ImageObject(solution).setDimensions(new Dimension(-1, -1)).getComponent());
    }
}
