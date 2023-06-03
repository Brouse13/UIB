package es.brouse.game.objects.menu;

import es.brouse.game.objects.Component;

import javax.swing.*;
import java.util.*;

/**
 * Class in charge of the creation of the {@link JMenu} that will
 * be on the interactive interfaces.
 */
public class MenuHeaderObject implements Component {
    /*---------- PRIVATE ----------*/
    private final JMenu menu;
    private final Set<MenuItemObject> items = new LinkedHashSet<>();

    /**
     * Main class constructor able to create new {@link MenuItemObject}
     * instance.
     *
     * @param name header name
     */
    public MenuHeaderObject(String name) {
        this.menu = new JMenu(name);
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
     * {@inheritDoc}
     * @return the swing associated JMenu
     */
    @Override
    public JComponent getComponent() {
        //Add all the items to the menu
        for (MenuItemObject item : items) menu.add(item.getComponent());

        return menu;
    }
}
