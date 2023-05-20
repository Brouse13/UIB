package es.brouse.panels;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.notes.NotesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotesFooter extends JPanel implements Panel, ActionListener {
    private final NotesPanel gamePanel;

    public NotesFooter(NotesPanel gamePanel) {
        this.gamePanel = gamePanel;

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(1, 8));
        setSize(new Dimension(-1, 50));
    }

    @Override
    public void initComponents() {
        for (MusicalNote note : MusicalNote.values()) {
            ButtonBuilder button = new ButtonBuilder(note.name(), this).setColor(note.getColor());
            add(button.getComponent());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        switch (button.getText()) {
            case "DO" ->  gamePanel.addNote(MusicalNote.DO);
            case "RE" ->  gamePanel.addNote(MusicalNote.RE);
            case "MI" ->  gamePanel.addNote(MusicalNote.MI);
            case "FA" ->  gamePanel.addNote(MusicalNote.FA);
            case "SOL" -> gamePanel.addNote(MusicalNote.SOL);
            case "LA" ->  gamePanel.addNote(MusicalNote.LA);
            case "SI" ->  gamePanel.addNote(MusicalNote.SI);
            case "FIN" -> {
                //Close window
            }
        }
    }
}
