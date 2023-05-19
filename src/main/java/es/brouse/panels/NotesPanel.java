package es.brouse.panels;

import es.brouse.Main;
import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.utils.SoundManager;

import javax.sound.sampled.AudioInputStream;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

public class NotesPanel extends Panel {
    private final SoundManager soundManager = new SoundManager();
    private final List<JComponent> elements = new ArrayList<>(10 * 11);
    private int index;


    public NotesPanel() {
        super(false);

        init();
    }

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(10,11, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    @Override
    public void initComponents(final JPanel panel) {
        for (int i = 0; i < 10 * 11; i++) {
            ButtonBuilder element = new ButtonBuilder("");
            elements.add(element.getComponent());

            panel.add(element.getComponent());
        }
    }

    public void addNote(MusicalNote note) {
        JComponent musicalNote = elements.get(index++);

        musicalNote.setBackground(note.getColor());

        String fileName = note.name().toLowerCase(Locale.ROOT);
        try(AudioInputStream audioInputStream = soundManager.loadSound(fileName + ".wav")) {
            if (audioInputStream != null)
                soundManager.playSound(audioInputStream);
        } catch (IOException e) {
            Main.logger.log(Level.WARNING, "Error loading URL");
        }

        Main.screen.refresh();
    }
}
