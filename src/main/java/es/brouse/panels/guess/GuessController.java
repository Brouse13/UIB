package es.brouse.panels.guess;

import es.brouse.objects.MusicalNote;
import es.brouse.utils.SoundManager;

import java.util.List;

public class GuessController {
    private final View view;
    private final SoundManager soundManager;
    private final List<MusicalNote> notes;
    private int index;

    public GuessController(View view, SoundManager soundManager,  List<MusicalNote> notes) {
        this.view = view;
        this.soundManager = soundManager;
        this.notes = notes;
    }

    public void tryToGuess(MusicalNote note) {
        //If we reached the last index cancel guess
        if (index == notes.size()) return;

        //Validate the note and call the apropiate listeners
        if (!validNote(note)) {
            soundManager.playFile("error.wav");
            view.noteWrong(notes.get(index), index);
            return;
        }

        view.noteRight(note, index);

        if (index == notes.size() - 1) {
            soundManager.playFile("campeones.wav");
            view.winPanel();
        }

        index++;
    }

    private boolean validNote(MusicalNote note) {
        return notes.get(index) == note;
    }
    public interface View {
        void noteRight(MusicalNote note, int index);
        void noteWrong(MusicalNote correct, int index);
        void winPanel();
    }
}
