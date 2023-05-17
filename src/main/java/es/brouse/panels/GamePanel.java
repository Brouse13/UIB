package es.brouse.panels;

import es.brouse.Main;
import es.brouse.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends Panel {
    private final List<JComponent> elements = new ArrayList<>(10 * 11);
    private int index;


    public GamePanel() {
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
        System.out.println("ds");
        for (int i = 0; i < 10 * 11; i++) {
            ButtonBuilder element = new ButtonBuilder("ds", event -> {
                addNote(null);
            }).setBackgroundColor(Color.RED);
            elements.add(element.getComponent());

            panel.add(element.getComponent());
        }
    }

    public void addNote(MusicalNote note) {
        JComponent musicalNote = elements.get(index++);

        musicalNote.setBackground(Color.BLUE);

        Main.screen.refresh();
    }
}
