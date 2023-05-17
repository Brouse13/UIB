package es.brouse;

import java.awt.event.ActionListener;

public class MusicalNote {
    private final String name;
    private final ActionListener listener;

    public MusicalNote(String name, ActionListener listener) {
        this.name = name;
        this.listener = listener;
    }

    public String getName() {
        return name;
    }

    public ActionListener getListener() {
        return listener;
    }
}
