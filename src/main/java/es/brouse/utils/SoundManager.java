package es.brouse.utils;

import es.brouse.Main;
import es.brouse.objects.MusicalNote;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;

public class SoundManager {
    public void playNote(MusicalNote note) {
        String sound = note.name().toLowerCase() + ".wav";

        try(AudioInputStream inputStream = loadSound(sound)) {
            if (inputStream != null) playSound(inputStream);
        }catch (IOException exception) {
            Main.logger.log(Level.WARNING, "ERROR: Unable to play " + sound);
        }
    }

    public void playSound(AudioInputStream sound) {
        Clip clip;

        try {
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
        }catch (LineUnavailableException | IOException error) {
            Main.logger.log(Level.WARNING, "Unable to open sound");
        }
    }

    private AudioInputStream loadSound(String sound) throws IOException {
        try {
            URL resource = getClass().getResource("/assets/sounds/" + sound);
            if (resource == null) throw new IOException("Sound " + sound + " not found");

            return AudioSystem.getAudioInputStream(resource);
        }catch (UnsupportedAudioFileException exception) {
            Main.logger.log(Level.WARNING, "Unable to find sound " + sound);
        }
        return null;
    }
}
