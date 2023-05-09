package es.brouse.game.panels;

import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.LabelBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StartGamePanel extends Panel {

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(4, 2, 5, 5));
    }

    @Override
    public void initComponents(final JPanel panel) {
        String[] names = {"USUARIO", "FILAS", "COLUMNAS"};

        for (String name : names) {
            panel.add(new LabelBuilder(name)
                    .setSize(new Dimension(50, 10))
                    .setBorder(new EmptyBorder(5, 5, 5, 5))
                    .getComponent());
            panel.add(new JTextField());
        }

        //Dummy content
        panel.add(new JLabel());

        JComponent component = new ButtonBuilder("INICIAR PARTIDA", null, e -> {})
                .getComponent();
        component.setBorder(new EmptyBorder(0, 0, 5, 5));
        panel.add(component);
    }
}
