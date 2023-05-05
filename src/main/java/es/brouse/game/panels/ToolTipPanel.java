package es.brouse.game.panels;

import es.brouse.game.Game;
import es.brouse.game.listeners.ToolTipListeners;
import es.brouse.game.objects.ButtonObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;

public class ToolTipPanel extends Panel {

    @Override
    public void setUp(JPanel panel) {
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public void initComponents(JPanel panel) {
        final ToolTipListeners listeners = new ToolTipListeners();

        panel.add(getButton("/assets/gui/game/newGame.jpg", listeners.newGame()).getComponent());
        panel.add(getButton("/assets/gui/game/selectedHistory.jpg", listeners.score()).getComponent());
        panel.add(getButton("/assets/gui/game/history.jpg", listeners.score()).getComponent());
        panel.add(getButton("/assets/gui/game/changeDir.jpg", listeners.changeDir()).getComponent());
        panel.add(getButton("/assets/gui/game/exit.jpg", listeners.exit()).getComponent());
    }

    private ButtonObject getButton(String name, ActionListener listener) {
        try {
            //Try to load the resource
            URL resource = getClass().getResource(name);
            if (resource == null) throw new NullPointerException();

            //Create the button
            return new ButtonObject(null, new ImageIcon(ImageIO.read(resource)), listener);
        } catch (IOException | NullPointerException e) {
            //Default button and error handler
            Game.logger.log(Level.WARNING, "Unable to load resource");
            return new ButtonObject("X");
        }
    }
}
