package es.brouse.game.screen;

import es.brouse.game.panels.game.StartGamePanel;
import es.brouse.game.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class StartGameScreen extends JFrame implements Screen {
    private static final String TITLE = "Iniciar partida";

    public StartGameScreen() {
        setUp();
    }

    @Override
    public void setUp() {
        setTitle(TITLE);
        setSize(new Dimension(700, 200));
        setContentPane(new StartGamePanel().getComponent());

        setIconImage(new ImageIcon(new ImageUtils().loadResource("/icon.jpg")).getImage());

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 500) / 2);
        int y = (int) ((dimension.getHeight() - 200) / 2);
        setLocation(x, y);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setResizable(false);
        setLocale(Locale.ROOT);
    }

    @Override
    public void start() {
        setVisible(true);
    }
}
