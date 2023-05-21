package es.brouse.panels.reproduce;

import es.brouse.objects.MusicalNote;
import es.brouse.panels.mainPanel.GameController;
import es.brouse.panels.mainPanel.GamePanel;
import es.brouse.screens.GameScreen;
import es.brouse.screens.Screen;
import es.brouse.utils.SoundManager;

import java.util.List;

/**
 * Class that will handle the controller of the reproducer
 */
public class ReproducerController {
    /*---------- PRIVATE ----------*/
    private final View view;
    private final SoundManager soundManager;
    private final List<MusicalNote> notes;
    private int index = 0;

    /**
     * Main class constructor able to create new {@link ReproducerController}
     * instance.
     *
     * @param view associated view
     * @param soundManager associated soundManager
     * @param notes notes to reproduce
     */
    public ReproducerController(View view, SoundManager soundManager, List<MusicalNote> notes) {
        this.view = view;
        this.soundManager = soundManager;
        this.notes = notes;
    }

    /**
     * Reproduce the nextNote
     */
    public void playNextNote() {
        //No more notes to play
        if (index == notes.size()) {
            GameScreen.getInstance().popup("No hay más notas para reproducir");
            GamePanel.getInstance().render(GameController.RenderType.IDDLE);
            return;
        }

        //If possible clear last border and call controller
        if (index != 0) view.clearBorder(index - 1);

        //Get the next note, play it and paint it
        MusicalNote note = notes.get(index);
        soundManager.playNote(note);
        view.paintBorder(index);

        index++;
    }

    /**
     * Interface that acts as interface with the view to make code
     * independent.
     */
    public interface View {
        /**
         * Pain the border of the given note
         *
         * @param index note index
         */
        void paintBorder(int index);

        /**
         * Clear the border of the given note.
         *
         * @param index note index
         */
        void clearBorder(int index);
    }
}
