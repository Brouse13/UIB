package es.brouse.game.menu;

import javax.swing.*;
import java.awt.event.ItemListener;

public class MenuItemObject {
    private final String name;
    private final ItemListener listener;

    public MenuItemObject(String name, ItemListener listener) {
        this.name = name;
        this.listener = listener;
    }

    public JComponent getComponent() {
        JMenuItem item = new JMenuItem(name);
        item.addItemListener(listener);
        return item;
    }
}
