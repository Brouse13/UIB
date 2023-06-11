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
        setBackground(Color.BLACK);
    }

    @Override
    public void initComponents() {
        String[] names = {
                "NOMBRE JUGADOR",
                "NÚMERO DE SUBDIVISIONES HORIZONTALES",
                "NÚMERO DE SUBDIVISIONES VERTICALES"
        };
        builders = new TextFieldBuilder[3];

        int index = 0;
        for (String name : names) {
            add(new LabelBuilder(name)
                    .setSize(new Dimension(50, 10))
                    .setBorder(new EmptyBorder(5, 5, 5, 5))
                    .setBackground(Color.BLACK)
                    .setFont("Arial", Font.BOLD, 12)
                    .getComponent());

            builders[index] = new TextFieldBuilder();
            add(builders[index].getComponent());

            index++;
        }

        //Add null content
        add(new JLabel());

        ButtonBuilder builder = new ButtonBuilder("INICIAR PARTIDA", null, this)
                .setBorder(new EmptyBorder(0, 0, 5, 5));

        add(builder.getComponent());
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField usrText = ((JTextField) builders[0].getComponent());
        JTextField rowsText = ((JTextField) builders[1].getComponent());
        JTextField colsText = ((JTextField) builders[2].getComponent());

        String username = usrText.getText().toLowerCase();
        int rows;
        int cols;

        //Check rowsText and columns error
        try {
            cols = Integer.parseInt(colsText.getText());
            rows = Integer.parseInt(rowsText.getText());

            if (rows <= 1 || cols <= 1)
                throw new IllegalArgumentException("Has de tener mínimo 2 particiones horizontales y verticales");

            if (usrText.getText() == null || "".equals(username))
                throw new IllegalArgumentException("El nombre no puede ser nulo");
        }catch (NumberFormatException exception) {
            error("Error, revisa los datos");
            return;
        }catch (IllegalArgumentException ex) {
            error(ex.getMessage());
            return;
        }

        //Render the game instance
        IdlePanel.getInstance().getController().game(rows, cols, username);

        //Close and reset the screen
        Panel.close(this);

        //Reset the text fields
        for (TextFieldBuilder component : builders)
            ((JTextField) component.getComponent()).setText("");
    }

    /**
     * Display the error message on an optionPanel
     *
     * @param message error message
     */
    private void error(String message) {
        JOptionPane.showMessageDialog(IdlePanel.getInstance(), message);
    }
}
