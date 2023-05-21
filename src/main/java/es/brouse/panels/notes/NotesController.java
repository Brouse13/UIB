package es.brouse.panels.notes;

import es.brouse.objects.MusicalNote;
import es.brouse.screens.GameScreen;
import es.brouse.utils.SoundManager;

import java.util.List;

/**
 * Class that will handle the controller of the notes
 */
public class NotesController {
    /*---------- PRIVATE ----------*/
    private final View view;
    private final int maxNotes;
    private final SoundManager soundManager;
    private final List<MusicalNote> notes;
    private int index = 0;

    /**
     * Main class constructor able to create new
     *
     * @param view associated view
     * @param soundManager associated soundManager
     * @param maxNotes maxNotes
     */
    public NotesController(View view, SoundManager soundManager, int maxNotes) {
        this.view = view;
        this.soundManager = soundManager;
        this.maxNotes = maxNotes;
        this.notes = GameScreen.notes;
    }

    /**
     * Event clicked on note clicked
     *
     * @param note note clicked
     */
    public void noteClickEvent(final MusicalNote note) {
        if (note == MusicalNote.FIN || maxNotes == index) {
            view.endPiano(notes);
            return;
        }

        view.playNote(note, index);
        reproduceNote(note);
        notes.add(note);
        index++;
    }

    private void reproduceNote(MusicalNote note) {
        soundManager.playNote(note);
    }

    /**
     * Interface that acts as interface with the view to make code
     * independent.
     */
    public interface View {
        /**
         * Play a new note
         *
         * @param note note to play
         * @param index index to update
         */
        void playNote(MusicalNote note, int index);

        /**
         * End the create notes piano
         *
         * @param notes final notes created
         */
        void endPiano(List<MusicalNote> notes);
    }

}
