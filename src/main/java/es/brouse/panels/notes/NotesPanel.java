package es.brouse.panels.notes;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.GameMainPanel;
import es.brouse.panels.Panel;
import es.brouse.screens.GameScreen;
import es.brouse.utils.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NotesPanel extends JPanel implements Panel, NotesController.View {
    private final List<JComponent> musicalNotes = new ArrayList<>(10 * 11);
    private final NotesController controller;

    public NotesPanel() {
        controller = new NotesController(
                this,
                new SoundManager(),
                10 * 11
        );

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(10,11, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setBackground(Color.BLACK);
    }

    @Override
    public void initComponents() {
        for (int i = 0; i < 10 * 11; i++) {
            ButtonBuilder element = new ButtonBuilder("")
                    .setColor(Color.BLACK)
                    .setBorder(BorderFactory.createEmptyBorder());

            musicalNotes.add(element.getComponent());
            add(element.getComponent());
        }
    }

    @Override
    public void playNote(MusicalNote note, int index) {
        JComponent jComponent = musicalNotes.get(index);
        jComponent.setBackground(note.getColor());
    }

    @Override
    public void endPiano(List<MusicalNote> notes) {
        GameScreen.getInstance().addMelody(notes);
        GameMainPanel.getInstance().changeToLogo();
        GameScreen.getInstance().popup("Melodía creada con éxito");
    }

    public void addNote(MusicalNote note) {
        controller.noteClickEvent(note);
    }
}
