package es.brouse.game.panels.game;

import es.brouse.game.objects.builders.ButtonBuilder;
import es.brouse.game.objects.builders.ImageBuilder;
import es.brouse.game.panels.Panel;
import es.brouse.game.panels.iddle.GamePanel;
import es.brouse.game.screen.GameScreen;
import es.brouse.game.screen.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.*;
public class SolutionPanel {
    private final Solution solution;
    private final Footer footer;

    public SolutionPanel(BufferedImage solution) {
        this.solution = new Solution(solution);
        this.footer = new Footer();
    }

    public void render() {
        GamePanel.getInstance().setGamePanel(solution);
        GamePanel.getInstance().setFooterPanel(footer);

        //Refresh the screen
        Screen.refresh(GameScreen.getInstance());
    }

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
            return event -> {
                GamePanel.getInstance().reset();
                Screen.refresh(GameScreen.getInstance());
            };
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
