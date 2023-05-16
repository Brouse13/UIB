package es.brouse.objects.menu;

import es.brouse.objects.Component;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class in charge of the creation of the {@link JMenuBar} that will
 * be on the interactive interfaces.
 */
public class MenuObject implements Component {
    /*---------- PRIVATE ----------*/
    private final Set<MenuHeaderObject> headers;

    /**
     * Main class constructor able to create new {@link MenuObject}
     * instance without having to instance the headers.
     */
    public MenuObject() {
        this.headers = new HashSet<>();
    }

    /**
     * Main class constructor able to create new {@link MenuObject}
     * instances forcing to instance the headers.
     */
    public MenuObject(Set<MenuHeaderObject> headers) {
        this.headers = headers;
    }

    /**
     * Add a {@link MenuObject[]} to the stored headers.
     *
     * @param headers headers to add
     */
    public void addHeaders(MenuHeaderObject... headers) {
        this.headers.addAll(Arrays.asList(headers));
    }

    /**
     * {@inheritDoc}
     * @return the swing associated JMenuBar
     */
    @Override
    public JComponent getComponent() {
        JMenuBar menuBar = new JMenuBar();

        //Add all the components
        for (MenuHeaderObject header : headers) menuBar.add(header.getComponent());

        return menuBar;
    }
}
