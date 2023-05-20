package es.brouse.panels.logo;

import es.brouse.objects.builders.LabelBuilder;
import es.brouse.panels.Panel;

import javax.swing.*;
import java.awt.*;

public class TitleLogo extends JPanel implements Panel {
    public TitleLogo() {
        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        add(new LabelBuilder("TALLER 2 - PROGRAMACIÓN II - CURSO 2023")
                .setSize(new Dimension(-1, 40))
                .setBackground(Color.BLACK)
                .setFont("Arial", Font.PLAIN, 30)
                .align(JLabel.CENTER).getComponent());
    }
}
