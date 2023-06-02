package es.brouse.game.objects.builders;

import es.brouse.game.objects.Component;

import javax.swing.*;
import javax.swing.border.Border;

public class TextAreaBuilder implements Component {
    private final JTextArea textArea = new JTextArea();

    public TextAreaBuilder(boolean editable) {
        textArea.setEditable(editable);
    }

    public TextAreaBuilder addLine(String line) {
        textArea.append(line + "\n");
        return this;
    }

    public TextAreaBuilder setBorder(Border border) {
        textArea.setBorder(border);
        return this;
    }

    @Override
    public JComponent getComponent() {
        return textArea;
    }
}
