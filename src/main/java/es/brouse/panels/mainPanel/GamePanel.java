package es.brouse.panels.mainPanel;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.SplitPanelBuilder;
import es.brouse.panels.Panel;
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
public class GamePanel extends JPanel implements Panel, GameController.View {
    private static final GamePanel instance = new GamePanel();
    private final SplitPanelBuilder splitPanel;
    private final GameController controller;

    private GamePanel() {
        this.splitPanel = new SplitPanelBuilder(SplitPanelBuilder.VERTICAL_SPLIT);
        this.controller = new GameController(this);

        setUp();
        initComponents();
    }

    public static GamePanel getInstance() {
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

    public void render(GameController.RenderType renderType) {
        controller.render(renderType);
    }

    @Override
    public void renderIddle() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        splitPanel.setLeft(new ImageLogo()).setRight(new TitleLogo()).setSize(size.height - 120);

        Screen.refresh(GameScreen.getInstance());
    }

    @Override
    public void renderNotes() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        NotesPanel notesPanel = new NotesPanel();

        splitPanel.setLeft(notesPanel).setRight(new PianoPanel(notesPanel)).setSize(size.height - 120);

        Screen.refresh(GameScreen.getInstance());
    }

    @Override
    public void renderReproduce() {
        List<MusicalNote> notes = GameScreen.notes;

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        NotesReproducer notesReproducer = new NotesReproducer(notes);
        NextNotePanel reproducer = new NextNotePanel(notesReproducer);

        splitPanel.setLeft(notesReproducer).setRight(reproducer).setSize(size.height - 120);

        Screen.refresh(GameScreen.getInstance());
    }

    @Override
    public void renderGuess() {
        List<MusicalNote> notes = GameScreen.notes;

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        GuessPanel notesReproducer = new GuessPanel(notes);
        GuessButtons reproducer = new GuessButtons(notesReproducer);

        splitPanel.setLeft(notesReproducer).setRight(reproducer).setSize(size.height - 120);

        Screen.refresh(GameScreen.getInstance());
    }

    @Override
    public void errorChange(String message) {
        GameScreen.getInstance().popup(message);
    }
}
