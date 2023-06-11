package es.brouse.game.objects.builders;

import es.brouse.game.objects.Component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Class in charge of the creation of the {@link JTextArea} that will
 * be on the interactive interfaces.
 */
public class TextAreaBuilder implements Component {
    /*---------- PRIVATE ----------*/
    private final JTextArea textArea = new JTextArea();

    /**
     * Main class constructor used to create new {@link TextAreaBuilder}
     * instance.
     *
     * @param editable if the textArea is editable
     */
    public TextAreaBuilder(boolean editable) {
        textArea.setEditable(editable);
    }

    /**
     * Add a new line into the textArea.
     *
     * @param line line to add
     * @return the builder instance
     */
    public TextAreaBuilder addLine(String line) {
        textArea.append(line + "\n");
        return this;
    }

    /**
     * Set the font of the text area to the specified by the params.
     *
     * @param font font family
     * @param type font type
     * @param size font size
     * @return the builder instance
     */
    public TextAreaBuilder setFont(String font, int type, int size) {
        textArea.setFont(new Font(font, type, size));
        return this;
    }

    @Override
    public JComponent getComponent() {
        return textArea;
    }
}
