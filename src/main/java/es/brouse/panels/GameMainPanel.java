package es.brouse.panels;

import es.brouse.objects.builders.SplitPanelBuilder;
import es.brouse.panels.logo.ImageLogo;
import es.brouse.panels.logo.TitleLogo;
import es.brouse.panels.notes.NotesPanel;
import es.brouse.panels.notes.PianoPanel;
import es.brouse.screens.GameScreen;
import es.brouse.screens.Screen;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;
public class GameMainPanel extends JPanel implements Panel {
    private static final GameMainPanel instance = new GameMainPanel();
    private final SplitPanelBuilder splitPanel;

    private GameMainPanel() {
        splitPanel = new SplitPanelBuilder(SplitPanelBuilder.VERTICAL_SPLIT);

        setUp();
        initComponents();
    }

    public static GameMainPanel getInstance() {
        return instance;
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        splitPanel.setLeft(new ImageLogo()).setRight(new TitleLogo());

        add(splitPanel.getComponent(), CENTER);

        add(new FooterPanel(), SOUTH);
    }

    public void changeToNotes() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        NotesPanel notesPanel = new NotesPanel();
        splitPanel.setLeft(notesPanel).setRight(new PianoPanel(notesPanel))
                .setSize(size.height - 100);

        Screen.refresh(GameScreen.getInstance());
    }
}
