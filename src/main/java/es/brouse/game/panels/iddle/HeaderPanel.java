package es.brouse.game.panels.iddle;

import es.brouse.game.listeners.GameListeners;
import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.SplitPanelBuilder;
import es.brouse.game.objects.builders.ToolBarBuilder;
import es.brouse.game.objects.menu.MenuItemObject;
import es.brouse.game.objects.menu.MenuObject;
import es.brouse.game.panels.Panel;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.*;

/**
 * Class used to create and display the header content that will
 * have a dropdown with some game options.
 */
public class HeaderPanel extends JPanel implements Panel {
    /*---------- PRIVATE ----------*/
    private static final GameListeners listeners = new GameListeners();

    /**
     * Main class constructor used to create new {@link HeaderPanel}
     * instances.
     */
    public HeaderPanel() {
        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout(0,0));
        setBackground(Color.BLACK);
    }

    @Override
    public void initComponents() {
        ToolBarBuilder toolBar = new ToolBarBuilder(ToolBarBuilder.HORIZONTAL).setBackground(Color.BLACK);
        SplitPanelBuilder splitPane = new SplitPanelBuilder(SplitPanelBuilder.VERTICAL_SPLIT);

        //Add the items to the toolbar
        toolBar.add(getButton("newGame.jpg", listeners.newGame()).getComponent());
        toolBar.add(getButton("selectedHistory.jpg", listeners.score()).getComponent());
        toolBar.add(getButton("history.jpg", listeners.score()).getComponent());
        toolBar.add(getButton("changeDir.jpg", listeners.changeDir()).getComponent());
        toolBar.add(getButton("exit.jpg", listeners.exit()).getComponent());

        //Add toolbar to the panel
        add(mainMenu().getComponent(), NORTH);
        add(toolBar.getComponent(), CENTER);
        add(splitPane.getComponent(), SOUTH);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    private MenuObject mainMenu() {
        final GameListeners listeners = new GameListeners();

        return new MenuObject(
                "Menu",
                new MenuItemObject("Nueva Partida", listeners.newGame()),
                new MenuItemObject("Clasificatoria General", listeners.generalScore()),
                new MenuItemObject("Historial", listeners.score()),
                new MenuItemObject("Cambiar directorio", listeners.changeDir()),
                new MenuItemObject("Salir", listeners.exit())
        );
    }

    /**
     * Get the built button.
     *
     * @param name button name
     * @param listener button listener
     * @return the built button
     */
    private ButtonBuilder getButton(String name, ActionListener listener) {
        //Create the path of the file
        String path = "game/" + name;

        //Load the image from resources
        final BufferedImage bufferedImage = new ImageUtils().loadResource(path);
        final ImageIcon icon = new ImageIcon(bufferedImage);

        //Return the button
        return new ButtonBuilder(null, icon, listener).setBackgroundColor(Color.BLACK).fullImage();
    }
}
