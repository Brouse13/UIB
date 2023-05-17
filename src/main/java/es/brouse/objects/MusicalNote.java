package es.brouse.objects;

import java.awt.*;

public enum MusicalNote  {
        DO(Color.RED),
        RE(Color.PINK),
        MI(Color.CYAN),
        FA(Color.YELLOW),
        SOL(Color.MAGENTA),
        LA(Color.WHITE),
        SI(Color.GREEN),
        FIN(Color.BLACK);
        private final Color color;

        MusicalNote(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
}
