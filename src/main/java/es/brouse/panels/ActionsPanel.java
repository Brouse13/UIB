package es.brouse.panels;

import es.brouse.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActionsPanel extends Panel {
    private static final Set<MusicalNote> notes = new HashSet<>(List.of(
            new MusicalNote("DO", e -> {}),
            new MusicalNote("RE", e -> {}),
            new MusicalNote("MI", e -> {}),
            new MusicalNote("FA", e -> {}),
            new MusicalNote("SOL", e -> {}),
            new MusicalNote("LA", e -> {}),
            new MusicalNote("SI", e -> {}),
            new MusicalNote("FIN", e -> {})
    ));

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(1, 8));
    }

    @Override
    public void initComponents(final JPanel panel) {
        for (MusicalNote note : notes) {
            panel.add(new ButtonBuilder(note.getName(), note.getListener()).getComponent());
        }
    }
}
