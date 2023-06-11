package es.brouse.game.listeners;

import es.brouse.game.Game;
import es.brouse.game.GameSettings;
import es.brouse.game.panels.iddle.IdlePanel;
import es.brouse.game.screen.StartGameScreen;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;

public final class GameListeners {

    /**
     * Create a new game asking input instance
     *
     * @return the game starter listener
     */
    public ActionListener newGame() {
        return event -> {
            if (checkErr()) return;

            new StartGameScreen().start();
        };
    }

    /**
     * Open the general score window.
     *
     * @return the open general score listener
     */
    public ActionListener generalScore() {
        return event -> {
            if (checkErr()) return;

            IdlePanel.getInstance().getController().renderStats(false);
        };
    }

    /**
     * Open the specific score window.
     *
     * @return the open specific score listener
     */
    public ActionListener score() {
        return event -> {
            if (checkErr()) return;

            IdlePanel.getInstance().getController().renderStats(true);
        };
    }

    /**
     * Change the current game images folder from game listener.
     *
     * @return the change directory listener
     */
    public ActionListener changeDir() {
        return event -> {
            if (checkErr()) return;

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setDialogTitle("Directorio de las imágenes");
            fileChooser.setCurrentDirectory(new File(GameSettings.IMAGES_DIR));

            int result = fileChooser.showOpenDialog(IdlePanel.getInstance());

            if (result != JFileChooser.CANCEL_OPTION) {

                File fileName = fileChooser.getSelectedFile();

                if ((fileName == null) || (fileName.getName().equals(""))) {
                    JOptionPane.showMessageDialog(null,
                            "Error, no se ha podido cambiar el directorio");
                } else {
                    GameSettings.IMAGES_DIR = fileName.getPath();
                    JOptionPane.showMessageDialog(null,
                            "Directorio cambiado con éxito");
                }
            }
        };
    }

    /**
     * Exit from game listener.
     *
     * @return the exit game listener
     */
    public ActionListener exit() {
        return event -> System.exit(0);
    }

    /**
     * Check if the game has been started.
     *
     * @return if the error has been triggered
     */
    private boolean checkErr() {
        if (Game.gameStarted) {
            JOptionPane.showMessageDialog(null, "Acaba la partida antes de ejecutar esta acción");
            return true;
        }
        return false;
    }
}
