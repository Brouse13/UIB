package es.brouse.panels;

import es.brouse.objects.builders.SplitPanelBuilder;

import javax.swing.*;
import java.awt.*;

import static es.brouse.objects.builders.SplitPanelBuilder.*;
import static java.awt.BorderLayout.*;
public class GameMainPanel extends Panel {
    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new BorderLayout());
    }

    @Override
    public void initComponents(final JPanel panel) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        GamePanel gamePanel = new GamePanel();
        SplitPanelBuilder split = new SplitPanelBuilder(
                VERTICAL_SPLIT,
                gamePanel.getComponent(),
                new ActionsPanel(gamePanel).getComponent())
                .setSize(size.height - 100);

        panel.add(split.getComponent());

        panel.add(new FooterPanel().getComponent(), SOUTH);
    }
}
