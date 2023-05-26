package es.brouse.game.panels;

import es.brouse.game.Game;
import es.brouse.game.listeners.GameListeners;
import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.SplitPanelBuilder;
import es.brouse.game.objects.builders.ToolBarBuilder;
import es.brouse.game.objects.menu.MenuHeaderObject;
import es.brouse.game.objects.menu.MenuItemObject;
import es.brouse.game.objects.menu.MenuObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;

import static java.awt.BorderLayout.*;

public class HeaderPanel extends JPanel implements Panel {
    private static final GameListeners listeners = new GameListeners();

    public HeaderPanel() {
        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout(0,0));
    }

    @Override
    public void initComponents() {
        add(mainMenu().getComponent(), NORTH);

        ToolBarBuilder toolBar = new ToolBarBuilder(ToolBarBuilder.HORIZONTAL);
        toolBar.add(getButton("/assets/gui/game/newGame.jpg", listeners.newGame()).getComponent());
        toolBar.add(getButton("/assets/gui/game/selectedHistory.jpg", listeners.score()).getComponent());
        toolBar.add(getButton("/assets/gui/game/history.jpg", listeners.score()).getComponent());
        toolBar.add(getButton("/assets/gui/game/changeDir.jpg", listeners.changeDir(this)).getComponent());
        toolBar.add(getButton("/assets/gui/game/exit.jpg", listeners.exit()).getComponent());

        add(toolBar.getComponent(), CENTER);
        add(new SplitPanelBuilder(SplitPanelBuilder.VERTICAL_SPLIT).getComponent(), SOUTH);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    private MenuObject mainMenu() {
        final GameListeners listeners = new GameListeners();
        MenuHeaderObject header = new MenuHeaderObject("Menu");

        header.addItems(
                new MenuItemObject("Nueva Partida", listeners.newGame()),
                new MenuItemObject("Clasificatoria General", listeners.generalScore()),
                new MenuItemObject("Historial", listeners.score()),
                new MenuItemObject("Cambiar directorio", listeners.changeDir(this)),
                new MenuItemObject("Salir", listeners.exit()));

        return new MenuObject(new HashSet<>(List.of(header)));
    }

    private ButtonBuilder getButton(String name, ActionListener listener) {
        try {
            //Try to load the resource
            URL resource = getClass().getResource(name);
            if (resource == null) throw new NullPointerException();

            //Create the button in fullImage mode
            return new ButtonBuilder(null, new ImageIcon(ImageIO.read(resource)), listener)
                    .fullImage();
        } catch (IOException | NullPointerException e) {
            //Default button and error handler
            Game.logger.log(Level.WARNING, "Unable to load resource");
            return new ButtonBuilder("X").fullImage();
        }
    }
}
