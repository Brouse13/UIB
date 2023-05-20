package es.brouse.panels.reproduce;

import es.brouse.objects.MusicalNote;
import es.brouse.screens.GameScreen;
import es.brouse.utils.SoundManager;

import java.util.List;

public class ReproducerController {
    private final View view;
    private final SoundManager soundManager;
    private final List<MusicalNote> notes;
    private int index = 0;

    public ReproducerController(View view, SoundManager soundManager, List<MusicalNote> notes) {
        this.view = view;
        this.soundManager = soundManager;
        this.notes = notes;
    }

    public void playNextNote() {
        //No more notes to play
        if (index == notes.size()) {
            GameScreen.getInstance().popup("No hay más notas para reproducir");
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

    public interface View {
        void paintBorder(int index);

        void clearBorder(int index);
    }
}
