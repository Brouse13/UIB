package es.brouse.panels;

import es.brouse.objects.builders.LabelBuilder;
import es.brouse.objects.builders.SplitPanelBuilder;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends Panel {
    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new FlowLayout());
    }

    @Override
    public void initComponents(final JPanel panel) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        LabelBuilder labelBuilder = new LabelBuilder("TALLER 2 - PROGRAMACIÓN II - CURSO 2023")
                .setSize(new Dimension(-1, 30));


        JLabel right = new JLabel("TALLER 2 - PROGRAMACIÓN II - CURSO 2023");
        right.setFont(new Font(right.getFont().getName(), Font.PLAIN, 30));
        right.setSize(new Dimension((int) size.getWidth(), 200));
        right.setForeground(Color.WHITE);
        right.setBackground(Color.BLACK);
        right.setOpaque(true);
        String padding = "                                                  ";
        right.setText(padding + "TALLER 2 - PROGRAMACIÓN II - CURSO 2023" + padding);

        panel.add(new SplitPanelBuilder(SplitPanelBuilder.VERTICAL_SPLIT,
                right, null).getComponent());
    }
}
