package es.brouse.game.panels.game;

import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.LabelBuilder;
import es.brouse.game.objects.builders.TextFieldBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.iddle.IdlePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGamePanel extends JPanel implements Panel, ActionListener {
    private TextFieldBuilder[] builders;

    public StartGamePanel() {
        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(4, 2, 5, 5));
    }

    @Override
    public void initComponents() {
        String[] names = {"USUARIO", "FILAS", "COLUMNAS"};
        builders = new TextFieldBuilder[3];

        int index = 0;
        for (String name : names) {
            add(new LabelBuilder(name)
                    .setSize(new Dimension(50, 10))
                    .setBorder(new EmptyBorder(5, 5, 5, 5))
                    .getComponent());

            builders[index] = new TextFieldBuilder();
            add(builders[index].getComponent());

            index++;
        }

        //Add null content
        add(new JLabel());

        JComponent component = new ButtonBuilder("INICIAR PARTIDA", null, this)
                .getComponent();
        component.setBorder(new EmptyBorder(0, 0, 5, 5));
        add(component);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField username = ((JTextField) builders[0].getComponent());
        JTextField rows = ((JTextField) builders[1].getComponent());
        JTextField cols = ((JTextField) builders[2].getComponent());

        //Check cols error
        try {
            Integer.parseInt(cols.getText());
        }catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(IdlePanel.getInstance(), "Número de columnas invalido");
            return;
        }

        //Check rows cols
        try {
            Integer.parseInt(rows.getText());
        }catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(IdlePanel.getInstance(), "Número de filas inválido");
            return;
        }

        String usernameVal = username.getText();
        int rowsVals = Integer.parseInt(rows.getText());
        int colsVal = Integer.parseInt(cols.getText());

        //Check if the partitions are squared
        if (rowsVals != colsVal) {
            JOptionPane.showMessageDialog(IdlePanel.getInstance(), "Las particiones han de ser cuadradas");
            return;
        }

        //Render the game instance
        IdlePanel.getInstance().getController().game(
                rowsVals,
                colsVal,
                usernameVal
        );

        //Close and reset the screen
        Panel.close(this);
        username.setText("");
        rows.setText("");
        cols.setText("");

    }
}
