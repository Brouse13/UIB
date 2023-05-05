package es.brouse.game.objects.menu;

import javax.swing.*;
import java.awt.event.ItemListener;

/**
 * Class in charge of the creation of the {@link JMenuItem} that will
 * be on the interactive interfaces.
 */
public class MenuItemObject {
    /*---------- PRIVATE ----------*/
    private final String name;
    private final ItemListener listener;

    /**
     * Main class constructor able to create new {@link MenuItemObject}
     * instance.
     */
    public MenuItemObject(String name, ItemListener listener) {
        this.name = name;
        this.listener = listener;
    }

    /**
     * Get the associated swing component ({@link JMenuItem}) that will
     * represent all the stored data.
     *
     * @return the swing JMenuItem
     */
    public JComponent getComponent() {
        JMenuItem item = new JMenuItem(name);
        item.addItemListener(listener);
        return item;
    }
}
