package es.brouse.game.menu;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MenuObject {
    private final Set<MenuHeaderObject> headers;

    public MenuObject() {
        this.headers = new HashSet<>();
    }

    public MenuObject(Set<MenuHeaderObject> headers) {
        this.headers = headers;
    }

    public void addHeaders(MenuHeaderObject... headers) {
        this.headers.addAll(Arrays.asList(headers));
    }

    public JComponent getComponent() {
        JMenuBar menuBar = new JMenuBar();

        //Add all the components
        for (MenuHeaderObject header : headers) menuBar.add(header.getComponent());

        return menuBar;
    }
}
