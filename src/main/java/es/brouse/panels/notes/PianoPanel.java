package es.brouse.panels.notes;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PianoPanel extends JPanel implements Panel, ActionListener {
    private final NotesPanel gamePanel;
    public PianoPanel(NotesPanel gamePanel) {
        this.gamePanel = gamePanel;

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(1, 8));
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
