package es.brouse.game.menu;

import javax.swing.*;
import java.util.*;

public class MenuHeaderObject {
    private final String name;
    private final Set<MenuItemObject> items = new LinkedHashSet<>();

    public MenuHeaderObject(String name) {
        this.name = name;
    }

    public void addItems(MenuItemObject... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public JComponent getComponent() {
        JMenu menu = new JMenu(name);

        //Add all the items to the menu
        for (MenuItemObject item : items) menu.add(item.getComponent());

        return menu;
    }
}
