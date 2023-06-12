package es.brouse.game.objects.menu;

import es.brouse.game.objects.Component;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Class in charge of the creation of the {@link JMenuBar} that will
 * be on the interactive interfaces.
 */
public class MenuObject implements Component {
    /*---------- PRIVATE ----------*/
    private final Set<MenuHeaderObject> headers = new HashSet<>();

    /**
     * Class constructor used to create a menu with only one item.
     *
     * @param name menu name
     * @param items menu items
     */
    public MenuObject(String name, MenuItemObject... items) {
        this.headers.add(new MenuHeaderObject(name, items));
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JMenuBar
     */
    @Override
    public JComponent getComponent() {
        JMenuBar menuBar = new JMenuBar();

        menuBar.setBackground(Color.BLACK);
        menuBar.setOpaque(true);

        //Add all the components
        for (MenuHeaderObject header : headers) {
            menuBar.add(header.getComponent());
        }

        return menuBar;
    }
}
