package es.brouse.game.panels.game;

import es.brouse.game.panels.Panel;
import es.brouse.game.utils.Ticker;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/**
 * Panel in charge of the display of the timer of the game
 */
public class CountDownPanel extends JPanel implements Panel {
    /*------------ PRIVATE --------------*/
    private final JProgressBar progressBar = new JProgressBar();
    private final Ticker ticker;
    private final GameController controller;
    private final int maxTicks;

    /**
     * Main class constructor used to create new {@link CountDownPanel}
     * instances.
     *
     * @param controller game controller instance
     * @param ticker game ticker instance
     * @param maxTicks max ticks of the timer
     */
    public CountDownPanel(GameController controller, Ticker ticker, int maxTicks) {
        this.controller = controller;
        this.ticker = ticker;
        this.maxTicks = maxTicks;

        ticker.setTicker(tick());

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        add(progressBar);
        progressBar.setValue(100);
        progressBar.setStringPainted(true);

        ticker.start();
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    /**
     * Function called in each time the ticker ticks. This time is
     * referred on the {@link es.brouse.game.GameSettings#TIMER_DELTA}.
     *
     * @return the action performed on each tick
     */
    private Consumer<Integer> tick() {
        return tick -> {
            if (tick == maxTicks) controller.endGame(false);

            if (tick == 1) progressBar.setValue(progressBar.getValue() - (100 % maxTicks));

            progressBar.setValue(progressBar.getValue() - (100 / maxTicks));

        };
    }
}
