package es.brouse.game.panels.iddle;

import es.brouse.game.utils.ImagePicker;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class IdleController {
    private final View view;

    /**
     * Main class constructor used to create new {@link IdleController}
     * instances.
     *
     * @param view view to control
     */
    public IdleController(View view) {
        this.view = view;
    }

    public void idle() {
        view.renderIdle();
    }

    public void game(int rows, int cols, String username) {
        try {
            view.renderGame(new ImagePicker().randomPick(), rows, cols, username);
        } catch (IOException e) {
            JOptionPane.showInternalMessageDialog(IdlePanel.getInstance(),
                    "Error al seleccionar la imagen");
        }catch (IllegalArgumentException e) {
            JOptionPane.showInternalMessageDialog(IdlePanel.getInstance(),
                    "El directorio se encuentra vacío, selecciona uno válido antes");
        }
    }

    public void renderStats(boolean specific) {
        if (!specific)  {
            view.renderStats(null);
            return;
        }

        String message = "Introduce el nombre del usuario:";
        String input = JOptionPane.showInputDialog(IdlePanel.getInstance(), message);

        if (input != null) view.renderStats(input);
    }

    public void renderSolution(BufferedImage image) {
        view.renderSolution(image);
    }


    /**
     * Controller view interface used to use the (view - model) pattern
     */
    public interface View {
        /**
         * Render the idle screen
         */
        void renderIdle();

        /**
         * Render the game screen
         *
         * @param image game image
         * @param rows image rows
         * @param username username
         */
        void renderGame(BufferedImage image, int rows, int cols, String username);

        /**
         * Render the specific stats screen. If the username is null
         * it will render the global statistics, if not, the specific with
         * the given username.
         *
         * @param username username stats
         */
        void renderStats(String username);

        /**
         * Render the solution panel.
         *
         * @param image solution image
         */
        void renderSolution(BufferedImage image);
    }
}
