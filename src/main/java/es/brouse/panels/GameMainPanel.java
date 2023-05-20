package es.brouse.panels;

import es.brouse.Main;
import es.brouse.objects.builders.SplitPanelBuilder;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;
public class GameMainPanel extends Panel {
    private static final SplitPanelBuilder splitPanel = new SplitPanelBuilder(SplitPanelBuilder.VERTICAL_SPLIT);
    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new BorderLayout());
    }

    @Override
    public void initComponents(final JPanel panel) {
        LogoPanel logoPanel = new LogoPanel();
        splitPanel.setLeft(logoPanel.getImage().getComponent())
                .setRight(logoPanel.getLabel().getComponent());
        panel.add(splitPanel.getComponent(), CENTER);

        panel.add(new FooterPanel().getComponent(), SOUTH);
    }

    public void changeToNotes() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        NotesPanel notesPanel = new NotesPanel();
        splitPanel.setLeft(notesPanel.getComponent())
                .setRight(new NotesFooter(notesPanel).getComponent())
                .setSize(size.height - 100);
        Main.screen.refresh();
    }
}
