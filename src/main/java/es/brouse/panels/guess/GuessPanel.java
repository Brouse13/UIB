package es.brouse.panels.guess;

import es.brouse.objects.MusicalNote;
import es.brouse.objects.builders.ButtonBuilder;
import es.brouse.panels.mainPanel.GamePanel;
import es.brouse.panels.Panel;
import es.brouse.screens.GameScreen;
import es.brouse.utils.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static es.brouse.panels.mainPanel.GameController.RenderType.*;

/**
 * Class used to handle the view of the guess pannel
 */
public class GuessPanel extends JPanel implements Panel, GuessController.View {
    /*---------- PRIVATE ----------*/
    private final GuessController controller;
    private final List<JComponent> components = new ArrayList<>(10 * 11);

    /**
     * Main class constructor used to create new {@link GuessPanel}
     * instances.
     *
     * @param notes associates notes to store
     */
    public GuessPanel(List<MusicalNote> notes) {
        controller = new GuessController(
                this,
                new SoundManager(),
                notes
        );
        parseComponents(notes);

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new GridLayout(10, 11, 10, 10));
        setBackground(Color.BLACK);
    }

    @Override
    public void initComponents() {
        //Add all the parsed notes to the panel
        for (JComponent component : components) add(component);
    }

    /**
     * Parse all the given notes into a {@link List<JComponent>}
     * to then being able to modify it's content
     *
     * @param notes notes
     */
    private void parseComponents(List<MusicalNote> notes) {
        for (int i = 0; i < notes.size(); i++) {
            ButtonBuilder component = new ButtonBuilder("")
                    .setColor(Color.BLACK)
                    .cancelInteract()
                    .setBorder(BorderFactory.createEmptyBorder());

            components.add(component.getComponent());
        }

        for (int i = 0; i < 110 - notes.size(); i++) {
            ButtonBuilder component = new ButtonBuilder("")
                    .setColor(Color.BLACK)
                    .setBorder(BorderFactory.createEmptyBorder());

            components.add(component.getComponent());
        }
    }

    /**
     * Try to guess the given note
     *
     * @param note note to guess
     */
    public void tryNote(MusicalNote note) {
        controller.tryToGuess(note);
    }

    @Override
    public void noteRight(MusicalNote note, int index) {
        JComponent jComponent = components.get(index);
        jComponent.setBackground(note.getColor());
        jComponent.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public void noteWrong(int index) {
        JComponent jComponent = components.get(index);
        jComponent.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
    }

    @Override
    public void winPanel() {
        GameScreen.getInstance().popup("¡Enhorabuena! Has acertado todas las melodía");
        GamePanel.getInstance().render(IDDLE);
    }
}
