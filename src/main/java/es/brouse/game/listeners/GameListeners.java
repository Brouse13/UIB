package es.brouse.game.listeners;

import es.brouse.game.Game;
import es.brouse.game.GameSettings;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.iddle.IdlePanel;
import es.brouse.game.screen.StartGameScreen;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;

public final class GameListeners {

    public ActionListener newGame() {
        return event -> {
            if (Game.gameStarted) return;

            new StartGameScreen().start();
        };
    }

    public ActionListener generalScore() {
        return event -> {
            if (Game.gameStarted) return;
            IdlePanel.getInstance().getController().renderStats(false);
        };
    }

    public ActionListener score() {
        return event -> {
            if (Game.gameStarted) return;
            IdlePanel.getInstance().getController().renderStats(true);
        };
    }

    public ActionListener changeDir(final Panel panel) {
        return event -> {
            if (Game.gameStarted) return;

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setDialogTitle("Directorio de las imágenes");
            fileChooser.setCurrentDirectory(new File(GameSettings.IMAGES_DIR));

            int result = fileChooser.showOpenDialog(panel.getComponent());

            if (result != JFileChooser.CANCEL_OPTION) {

                File fileName = fileChooser.getSelectedFile();

                if ((fileName == null) || (fileName.getName().equals(""))) {
                    JOptionPane.showMessageDialog(panel.getComponent(),
                            "Error, no se ha podido cambiar el directorio");
                } else {
                    GameSettings.IMAGES_DIR = fileName.getPath();
                    JOptionPane.showMessageDialog(panel.getComponent(),
                            "Directorio cambiado con éxito");
                }
            }
        };
    }
    public ActionListener exit() {
        return event -> System.exit(0);
    }
}
