package es.brouse.game.screen;

import es.brouse.game.listeners.GameListeners;
import es.brouse.game.objects.menu.MenuItemObject;
import es.brouse.game.objects.menu.MenuObject;
import es.brouse.game.panels.iddle.IdlePanel;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.util.Locale;

/**
 * Class used to handle the game screens
 */
public class GameScreen extends JFrame implements Screen {
    /* -------------- PRIVATE -------------- */
    private static GameScreen instance;
    private static final String TITLE = "Practica Final - Programación II";

    /**
     * Get the class singleton instance.
     *
     * @return the singleton instance
     */
    public static GameScreen getInstance() {
        if (instance == null) instance = new GameScreen();
        return instance;
    }

    /**
     * Main class constructor used to create new {@link GameScreen}
     * instances
     */
    private GameScreen() {
        setUp();
    }

    @Override
    public void setUp() {
        setTitle(TITLE);
        setContentPane(IdlePanel.getInstance().getComponent());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setIconImage(new ImageIcon(new ImageUtils().loadResource("/icon.jpg")).getImage());

        setJMenuBar(((JMenuBar) mainMenu().getComponent()));

        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLocale(Locale.ROOT);
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
    
    @Override
    public void start() {
        setVisible(true);
    }
}
