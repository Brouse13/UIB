package es.brouse.objects;

import java.awt.*;

/**
 * Class used to store and represent the available MusicalNotes
 * of the piano.
 * It also handles the color that each note will have on the piano
 */
public enum MusicalNote  {
        DO(Color.RED),
        RE(Color.PINK),
        MI(Color.CYAN),
        FA(Color.YELLOW),
        SOL(Color.MAGENTA),
        LA(Color.WHITE),
        SI(Color.GREEN),
        FIN(Color.BLACK);
        /*---------- PRIVATE ----------*/
        private final Color color;

        /**
         * Main class constructor used to create new
         * {@link MusicalNote} instances.
         *
         * @param color new color note
         */
        MusicalNote(Color color) {
            this.color = color;
        }

        /**
         * Get the musical note color.
         *
         * @return the note color
         */
        public Color getColor() {
            return color;
        }
}
