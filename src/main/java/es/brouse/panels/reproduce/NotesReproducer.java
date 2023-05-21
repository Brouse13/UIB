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

/**
 * Class able to handle the main reproducer view
 */
public class NotesReproducer extends JPanel implements Panel, ReproducerController.View {
    /*----------- PRIVATE -----------*/
    private final ReproducerController controller;
    private final int maxSize = 10 * 11;
    private final List<JComponent> components = new ArrayList<>(maxSize);

    /**
     * Main class constructor able to create new {@link NotesReproducer}
     * instances.
     *
     * @param notes notes to reproduce
     */
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
    public void paintBorder(MusicalNote note, int index) {
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
        components.get(index).setBorder(border);
        components.get(index).setBackground(note.getColor());
    }

    @Override
    public void clearBorder(MusicalNote note, int index) {
        JComponent jComponent = components.get(index);
        jComponent.setBorder(BorderFactory.createEmptyBorder());
    }

    /**
     * Play the next note
     */
    public void playNextNote() {
        controller.playNextNote();
    }

    /**
     * Parse all the given notes into as associated
     * {@link List<JComponent>} list to then render them.
     *
     * @param notes notes to parse
     */
    private void parseComponents(List<MusicalNote> notes) {
        for (MusicalNote note : notes) {
            ButtonBuilder component = new ButtonBuilder("")
                    .setColor(Color.BLACK)
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
