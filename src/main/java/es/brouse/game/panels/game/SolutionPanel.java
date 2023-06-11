package es.brouse.game.panels.game;

import es.brouse.game.Game;
import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.iddle.IdlePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.*;

/**
 * Class used to create new solution panel view components.
 */
public class SolutionPanel {
    /**
     * Class used to render the footer panel view.
     */
    public static class Footer extends JPanel implements Panel {
        /**
         * Main class constructor used to create new {@link Footer}
         * instances.
         */
        public Footer() {
            setUp();
            initComponents();
        }

        @Override
        public void setUp() {
            setLayout(new BorderLayout());
        }

        @Override
        public void initComponents() {
            add(new ButtonBuilder("CERRAR", null, event()).getComponent(), CENTER);
        }

        @Override
        public JComponent getComponent() {
            return this;
        }

        /**
         * Action performed by the exit button.
         *
         * @return the perform action
         */
        private ActionListener event() {
            return event -> {
                IdlePanel.getInstance().getController().idle();
                Game.gameStarted = false;
            };
        }
    }

    /**
     * Class used to render the solution panel view.
     */
    public static class Solution extends JPanel implements Panel {
        /*----------- PRIVATE -------------*/
        private final BufferedImage solution;

        /**
         * Main class constructor used to create new {@link Solution}
         * instances.
         *
         * @param solution solution image
         */
        public Solution(BufferedImage solution) {
            this.solution = solution;

            setUp();
            initComponents();
        }

        @Override
        public void setUp() {
            setLayout(new BorderLayout());
        }

        @Override
        public void initComponents() {
            add(new ImageBuilder(solution).getComponent(), CENTER);
        }

        @Override
        public JComponent getComponent() {
            return this;
        }
    }
}
