package es.brouse.game.panels.game;

import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.iddle.IdlePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.*;
public class SolutionPanel {
    public static class Footer extends JPanel implements Panel {
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
            return event -> IdlePanel.getInstance().getController().idle();
        }
    }

    public static class Solution extends JPanel implements Panel {
        private final BufferedImage solution;
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
