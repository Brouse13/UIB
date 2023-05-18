package es.brouse.panels;

import es.brouse.objects.builders.LabelBuilder;
import es.brouse.objects.builders.SplitPanelBuilder;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends Panel {
    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new BorderLayout());
    }

    @Override
    public void initComponents(final JPanel panel) {

        LabelBuilder labelBuilder = new LabelBuilder("TALLER 2 - PROGRAMACIÓN II - CURSO 2023")
                .setSize(new Dimension(-1, 40))
                .setBackground(Color.BLACK)
                .setFont("Arial", Font.PLAIN, 30)
                .align(JLabel.CENTER);

        panel.add(new SplitPanelBuilder(SplitPanelBuilder.VERTICAL_SPLIT,
                labelBuilder.getComponent(), null).getComponent());
    }
}
