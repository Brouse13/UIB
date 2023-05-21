package es.brouse.panels.guess;

import es.brouse.objects.MusicalNote;
import es.brouse.utils.SoundManager;

import java.util.List;

/**
 * Class used to handle the view methods controller of all the guess buttons view.
 */
public class GuessController {
    /*---------- PRIVATE ----------*/
    private final View view;
    private final SoundManager soundManager;
    private final List<MusicalNote> notes;
    private int index;

    /**
     * Constructor used to create a new {@link GuessController}
     * instance
     *
     * @param view view interface
     * @param soundManager correct soundManager instance
     * @param notes notes to use
     */
    public GuessController(View view, SoundManager soundManager,  List<MusicalNote> notes) {
        this.view = view;
        this.soundManager = soundManager;
        this.notes = notes;
    }

    /**
     * Try to guess a note, and call the corresponding viewer method
     *
     * @param note note to try to attempt
     */
    public void tryToGuess(MusicalNote note) {
        //If we reached the last index cancel guess
        if (index == notes.size()) return;

        //Validate the note and call the apropiate listeners
        if (!validNote(note)) {
            soundManager.playFile("error.wav");
            view.noteWrong(index);
            return;
        }

        view.noteRight(note, index);

        if (index == notes.size() - 1) {
            soundManager.playFile("campeones.wav");
            view.winPanel();
        }

        index++;
    }

    /**
     * Try to validate the next note.
     *
     * @param note note to validate
     * @return the validated note
     */
    private boolean validNote(MusicalNote note) {
        return notes.get(index) == note;
    }

    /**
     * Interface that acts as interface with the view to make code
     * independent.
     */
    public interface View {
        /**
         * Render the next right note.
         *
         * @param note note played
         * @param index note index
         */
        void noteRight(MusicalNote note, int index);

        /**
         * Render the next wrong note.
         *
         * @param index note index
         */
        void noteWrong(int index);

        /**
         * Render the win panel view
         */
        void winPanel();
    }
}
