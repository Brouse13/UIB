package es.brouse.panels;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.SplitPanelBuilder;
import es.brouse.panels.guess.GuessButtons;
import es.brouse.panels.guess.GuessPanel;
import es.brouse.panels.logo.ImageLogo;
import es.brouse.panels.logo.TitleLogo;
import es.brouse.panels.notes.NotesPanel;
import es.brouse.panels.notes.PianoPanel;
import es.brouse.panels.reproduce.NextNotePanel;
import es.brouse.panels.reproduce.NotesReproducer;
import es.brouse.screens.GameScreen;
import es.brouse.screens.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        splitPanel.setLeft(new ImageLogo()).setRight(new TitleLogo()).setSize(size.height - 120);

        add(splitPanel.getComponent(), CENTER);

        add(new FooterPanel(), SOUTH);
    }

    public void changeToNotes() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        NotesPanel notesPanel = new NotesPanel();

        splitPanel.setLeft(notesPanel).setRight(new PianoPanel(notesPanel)).setSize(size.height - 120);

        Screen.refresh(GameScreen.getInstance());
    }

    public void changeToLogo() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        splitPanel.setLeft(new ImageLogo()).setRight(new TitleLogo()).setSize(size.height - 120);

        Screen.refresh(GameScreen.getInstance());
    }

    public void changeToReproduce() {
        List<MusicalNote> notes = GameScreen.getInstance().getNotes();

        if (notes.isEmpty()) {
            GameScreen.getInstance().popup("Tienes que crear una melodía primero");
            return;
        }

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        NotesReproducer notesReproducer = new NotesReproducer(notes);
        NextNotePanel reproducer = new NextNotePanel(notesReproducer);

        splitPanel.setLeft(notesReproducer).setRight(reproducer).setSize(size.height - 120);

        Screen.refresh(GameScreen.getInstance());
    }

    public void changeToGuess() {
        List<MusicalNote> notes = GameScreen.getInstance().getNotes();

        if (notes.isEmpty()) {
            GameScreen.getInstance().popup("Tienes que crear una melodía primero");
            return;
        }

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        GuessPanel notesReproducer = new GuessPanel(notes);
        GuessButtons reproducer = new GuessButtons(notesReproducer);

        splitPanel.setLeft(notesReproducer).setRight(reproducer).setSize(size.height - 120);

        Screen.refresh(GameScreen.getInstance());
    }
}
