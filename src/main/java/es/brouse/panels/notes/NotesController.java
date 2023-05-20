package es.brouse.panels.notes;

import es.brouse.Main;
import es.brouse.objects.MusicalNote;
import es.brouse.utils.SoundManager;

import javax.sound.sampled.AudioInputStream;
import java.io.IOException;
import java.util.logging.Level;

public class NotesController {
    private final View view;
    private final int maxNotes;
    private final SoundManager soundManager;
    private int index = 0;

    public NotesController(View view, SoundManager soundManager, int maxNotes) {
        this.view = view;
        this.soundManager = soundManager;
        this.maxNotes = maxNotes;
    }


    public void noteClickEvent(final MusicalNote note) {
        if (note != MusicalNote.FIN || maxNotes != index) {
            view.playNote(note, index);
            reproduceNote(note);
            index++;
            return;
        }

        view.endPiano();
    }

    private void reproduceNote(MusicalNote note) {
        String fileName = note.name().toLowerCase() + ".wav";

        try(AudioInputStream audioInputStream = soundManager.loadSound(fileName)) {
            if (audioInputStream != null) soundManager.playSound(audioInputStream);
        } catch (IOException e) {
            Main.logger.log(Level.WARNING, "Error loading URL");
        }
    }

    public interface View {
        void playNote(MusicalNote note, int index);

        void endPiano();
    }

}
