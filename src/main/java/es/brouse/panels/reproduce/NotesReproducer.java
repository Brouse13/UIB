package es.brouse.panels.reproduce;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NotesReproducer extends JPanel implements Panel {
    private final int maxSize = 10 * 11;
    private final List<MusicalNote> notes;
    private int index;
    public NotesReproducer(List<MusicalNote> notes) {
        this.notes = notes;

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(10,11, 10, 10));
        setBackground(Color.BLACK);
    }

    @Override
    public void initComponents() {
        for (MusicalNote note : notes) {
            add(new ButtonBuilder("")
                    .setColor(note.getColor())
                    .setBorder(BorderFactory.createEmptyBorder())
                    .getComponent());
        }

        for (int i = 0; i < maxSize - notes.size(); i++) {
            add(new ButtonBuilder("")
                    .setColor(Color.BLACK)
                    .setBorder(BorderFactory.createEmptyBorder())
                    .getComponent());
        }
    }

    public void playNextNote() {
        System.out.println("Playing " + notes.get(index++));
    }
}
