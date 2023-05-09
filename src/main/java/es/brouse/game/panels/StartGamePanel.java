package es.brouse.game.panels;

import es.brouse.game.objects.ButtonObject;
import es.brouse.game.objects.LabelObject;

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
        final Dimension labels = new Dimension(50, 10);

        panel.add(new LabelObject("USUARIO").setSize(labels).getComponent());
        panel.add(new JTextField());

        panel.add(new LabelObject("FILAS").setSize(labels).getComponent());
        panel.add(new JTextField());

        panel.add(new LabelObject("COLUMNAS").setSize(labels).getComponent());
        panel.add(new JTextField());

        panel.add(new JLabel());
        JComponent component = new ButtonObject("INICIAR PARTIDA", null, e -> {
        }).getComponent();
        component.setBorder(new EmptyBorder(0, 0, 5, 5));
        panel.add(component);
    }
}
