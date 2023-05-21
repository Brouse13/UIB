package es.brouse.panels.guess;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.Panel;

import javax.swing.*;
import java.awt.*;

/**
 * Class used to handle the view of all the guess buttons view.
 */
public class GuessButtons extends JPanel implements Panel {
    /*---------- PRIVATE ----------*/
    private final GuessPanel guessPanel;

    /**
     * Main class constructor used to create new
     * {@link GuessButtons} instances.
     *
     * @param guessPanel associated guess panels
     */
    public GuessButtons(GuessPanel guessPanel) {
        this.guessPanel = guessPanel;

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(1, 8));
    }

    @Override
    public void initComponents() {
        for (MusicalNote note : MusicalNote.values()) {
            ButtonBuilder button = new ButtonBuilder(note.name(), e -> guessPanel.tryNote(note))
                    .setColor(note.getColor());
            add(button.getComponent());
        }
    }
}
