package es.brouse.game.panels;

import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.LabelBuilder;
import es.brouse.game.objects.builders.TextFieldBuilder;
import es.brouse.game.utils.ImagePicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartGamePanel extends Panel implements ActionListener {
    private TextFieldBuilder[] builders;
    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(4, 2, 5, 5));
    }

    @Override
    public void initComponents(final JPanel panel) {
        String[] names = {"USUARIO", "FILAS", "COLUMNAS"};
        builders = new TextFieldBuilder[3];

        int index = 0;
        for (String name : names) {
            panel.add(new LabelBuilder(name)
                    .setSize(new Dimension(50, 10))
                    .setBorder(new EmptyBorder(5, 5, 5, 5))
                    .getComponent());

            builders[index] = new TextFieldBuilder();
            panel.add(builders[index].getComponent());

            index++;
        }

        //Add null content
        panel.add(new JLabel());

        JComponent component = new ButtonBuilder("INICIAR PARTIDA", null, this)
                .getComponent();
        component.setBorder(new EmptyBorder(0, 0, 5, 5));
        panel.add(component);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField username = ((JTextField) builders[0].getComponent());
        JTextField rows = ((JTextField) builders[1].getComponent());
        JTextField cols = ((JTextField) builders[2].getComponent());

        String usernameVal = username.getText();
        int rowsVals = Integer.parseInt(rows.getText());
        int colsVal = Integer.parseInt(cols.getText());

        try {
            GameImagePanel panel = new GameImagePanel(new ImagePicker().randomPick(),
                    rowsVals, colsVal, usernameVal);

            GamePanel.getInstance().setGamePanel(panel.getComponent());

            //Close and reset the screen
            close();
            username.setText("");
            rows.setText("");
            cols.setText("");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
