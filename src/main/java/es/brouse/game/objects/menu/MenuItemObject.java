package es.brouse.game.objects.menu;

import es.brouse.game.objects.Component;

import javax.swing.*;
import java.awt.event.ItemListener;

/**
 * Class in charge of the creation of the {@link JMenuItem} that will
 * be on the interactive interfaces.
 */
public class MenuItemObject implements Component {
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
     * {@inheritDoc}
     * @return the swing associated JMenuItem
     */
    @Override
    public JComponent getComponent() {
        JMenuItem item = new JMenuItem(name);
        item.addItemListener(listener);
        return item;
    }
}
