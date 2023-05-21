package es.brouse.panels.reproduce;

import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.Panel;

import javax.swing.*;
import java.awt.*;

/**
 * Class that handles the next note view
 */
public class NextNotePanel extends JPanel implements Panel {
    /*----------- PRIVATE -----------*/
    private final NotesReproducer reproducer;

    /**
     * Main class constructor able to create new {@link NextNotePanel}
     * instances.
     *
     * @param reproducer associated reproducer
     */
    public NextNotePanel(NotesReproducer reproducer) {
        this.reproducer =  reproducer;

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        add(new ButtonBuilder(">", e -> reproducer.playNextNote())
                .setSize(new Dimension(-1, 50))
                .getComponent());
    }
}
