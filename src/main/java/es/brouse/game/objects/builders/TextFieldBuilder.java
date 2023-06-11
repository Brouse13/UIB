package es.brouse.game.objects.builders;

import es.brouse.game.objects.Component;

import javax.swing.*;

/**
 * Class in charge of the creation of the {@link JTextField} that will
 * be on the interactive interfaces.
 */
public class TextFieldBuilder implements Component {
    /*---------- PRIVATE ----------*/
    private final JTextField textField;

    /**
     * Main class constructor able to create new {@link JTextField}
     * instance.
     */
    public TextFieldBuilder() {
        textField = new JTextField();
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JButton
     */
    @Override
    public JComponent getComponent() {
        return textField;
    }
}
