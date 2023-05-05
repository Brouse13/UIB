package es.brouse.game.menu;

import javax.swing.*;
import java.util.*;

/**
 * Class in charge of the creation of the {@link JMenu} that will
 * be on the interactive interfaces.
 */
public class MenuHeaderObject {
    /*---------- PRIVATE ----------*/
    private final String name;
    private final Set<MenuItemObject> items = new LinkedHashSet<>();

    /**
     * Main class constructor able to create new {@link MenuItemObject}
     * instance.
     */
    public MenuHeaderObject(String name) {
        this.name = name;
    }

    /**
     * Add a {@link MenuItemObject[]} to the stored items.
     *
     * @param items headers to add
     */
    public void addItems(MenuItemObject... items) {
        this.items.addAll(Arrays.asList(items));
    }

    /**
     * Get the associated swing component ({@link JMenuItem}) that will
     * represent all the stored data.
     *
     * @return the swing JMenuItem
     */
    public JComponent getComponent() {
        JMenu menu = new JMenu(name);

        //Add all the items to the menu
        for (MenuItemObject item : items) menu.add(item.getComponent());

        return menu;
    }
}
