package es.brouse.panels.reproduce;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.Panel;
import es.brouse.screens.GameScreen;
import es.brouse.utils.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NotesReproducer extends JPanel implements Panel {
    private final SoundManager soundManager = new SoundManager();
    private final int maxSize = 10 * 11;
    private final List<MusicalNote> notes;
    private final List<JComponent> components = new ArrayList<>(maxSize);
    private int index = 0;
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
            JComponent component = new ButtonBuilder("")
                    .setColor(note.getColor())
                    .setBorder(BorderFactory.createEmptyBorder())
                    .getComponent();

            components.add(component);
            add(component);
        }

        for (int i = 0; i < maxSize - notes.size(); i++) {
            JComponent component = new ButtonBuilder("")
                    .setColor(Color.BLACK)
                    .setBorder(BorderFactory.createEmptyBorder())
                    .getComponent();

            components.add(component);
            add(component);
        }
    }

    public void playNextNote() {
        if (index == notes.size()) {
            GameScreen.getInstance().popup("No hay más notas para reproducir");
            return;
        }

        if (index != 0) {
            JComponent jComponent = components.get(index - 1);
            jComponent.setBorder(BorderFactory.createEmptyBorder());
        }

        MusicalNote note = notes.get(index);
        soundManager.playNote(note);
        components.get(index).setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        index++;
    }
}
