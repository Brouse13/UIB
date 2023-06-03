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
     * @param items items of the menu
     */
    public MenuHeaderObject(String name, MenuItemObject... items) {
        this.menu = new JMenu(name);
        this.items.addAll(List.of(items));
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
