package es.brouse.panels.reproduce;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.Panel;
import es.brouse.utils.SoundManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NotesReproducer extends JPanel implements Panel, ReproducerController.View {
    private final ReproducerController controller;
    private final int maxSize = 10 * 11;
    private final List<JComponent> components = new ArrayList<>(maxSize);

    public NotesReproducer(List<MusicalNote> notes) {
        controller = new ReproducerController(
                this,
                new SoundManager(),
                notes
        );

        parseComponents(notes);

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
        //Add all the parsed notes to the panel
        for (JComponent component : components) add(component);
    }

    @Override
    public void paintBorder(int index) {
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
        components.get(index).setBorder(border);
    }

    @Override
    public void clearBorder(int index) {
        JComponent jComponent = components.get(index);
        jComponent.setBorder(BorderFactory.createEmptyBorder());
    }

    public void playNextNote() {
        controller.playNextNote();
    }


    private void parseComponents(List<MusicalNote> notes) {
        for (MusicalNote note : notes) {
            ButtonBuilder component = new ButtonBuilder("")
                    .setColor(note.getColor())
                    .setBorder(BorderFactory.createEmptyBorder());

            components.add(component.getComponent());
        }

        for (int i = 0; i < maxSize - notes.size(); i++) {
            ButtonBuilder component = new ButtonBuilder("")
                    .setColor(Color.BLACK)
                    .setBorder(BorderFactory.createEmptyBorder());

            components.add(component.getComponent());
        }
    }
}
