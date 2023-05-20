package es.brouse.panels;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotesFooter extends Panel implements ActionListener {
    private final NotesPanel gamePanel;

    public NotesFooter(NotesPanel gamePanel) {
        super(false);
        this.gamePanel = gamePanel;

        init();
    }

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new GridLayout(1, 8));
        panel.setSize(new Dimension(-1, 50));
    }

    @Override
    public void initComponents(final JPanel panel) {
        for (MusicalNote note : MusicalNote.values()) {
            ButtonBuilder button = new ButtonBuilder(note.name(), this).setColor(note.getColor());
            panel.add(button.getComponent());
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
