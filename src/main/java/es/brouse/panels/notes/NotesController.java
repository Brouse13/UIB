package es.brouse.panels.notes;

import es.brouse.objects.MusicalNote;
import es.brouse.screens.GameScreen;
import es.brouse.utils.SoundManager;

import java.util.List;

public class NotesController {
    private final View view;
    private final int maxNotes;
    private final SoundManager soundManager;
    private final List<MusicalNote> notes;
    private int index = 0;

    public NotesController(View view, SoundManager soundManager, int maxNotes) {
        this.view = view;
        this.soundManager = soundManager;
        this.maxNotes = maxNotes;
        this.notes = GameScreen.notes;
    }


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

    public interface View {
        void playNote(MusicalNote note, int index);

        void endPiano(List<MusicalNote> notes);
    }

}
