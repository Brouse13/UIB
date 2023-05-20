package es.brouse.panels.notes;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.Panel;

import javax.swing.*;
import java.awt.*;

public class PianoPanel extends JPanel implements Panel {
    private final NotesPanel gamePanel;
    public PianoPanel(NotesPanel gamePanel) {
        this.gamePanel = gamePanel;

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
            ButtonBuilder button = new ButtonBuilder(note.name(), e -> gamePanel.addNote(note))
                    .setColor(note.getColor());
            add(button.getComponent());
        }
    }
}
