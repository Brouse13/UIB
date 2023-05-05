package es.brouse.game.panels;

import es.brouse.game.listeners.GameListeners;
import es.brouse.game.objects.SplitObject;
import es.brouse.game.objects.menu.MenuHeaderObject;
import es.brouse.game.objects.menu.MenuItemObject;
import es.brouse.game.objects.menu.MenuObject;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;

import static java.awt.BorderLayout.*;
public class GamePanel extends Panel {

    @Override
    public void setUp(final JPanel panel) {
        panel.setLayout(new BorderLayout());
        panel.setVisible(true);
    }

    @Override
    public void initComponents(final JPanel panel) {
        panel.add(mainMenu().getComponent(), NORTH);
        panel.add(new SplitObject(SplitObject.HORIZONTAL_SPLIT).getComponent());
        panel.add(new SidebarPanel().getComponent(), WEST);
    }

    private MenuObject mainMenu() {
        final GameListeners listeners = new GameListeners();
        MenuHeaderObject header = new MenuHeaderObject("Menu");

        header.addItems(
                new MenuItemObject("Nueva Partida", listeners.newGame()),
                new MenuItemObject("Clasificatoria General", listeners.generalScore()),
                new MenuItemObject("Historial", listeners.score()),
                new MenuItemObject("Cambiar directorio", listeners.changeDir()),
                new MenuItemObject("Salir", listeners.exit()));

        return new MenuObject(new HashSet<>(List.of(header)));
    }
}
