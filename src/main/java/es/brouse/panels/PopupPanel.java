package es.brouse.panels;

import es.brouse.objects.builders.LabelBuilder;

import javax.swing.*;
import java.awt.*;

public class PopupPanel extends JPanel implements Panel {
    private final String message;

    public PopupPanel(String message) {
        this.message = message;
    }

    @Override
    public void setUp() {
        setBackground(Color.BLACK);
    }

    @Override
    public void initComponents() {
        add(new LabelBuilder(message)
                .setBackground(Color.BLACK)
                .setFont("Arial", Font.BOLD, 20)
                .getComponent());
    }
}
