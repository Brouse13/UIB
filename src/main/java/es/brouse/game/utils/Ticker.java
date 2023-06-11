package es.brouse.game.utils;

import es.brouse.game.GameSettings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

/**
 * Class in charge of performing an action in a fixed time rate
 * represented by the {@link GameSettings#TIMER_DELTA} and it
 * will consume the given action.
 */
public class Ticker implements ActionListener {
    /*------------ PRIVATE ---------------*/
    private final Timer timer;
    private Consumer<Integer> ticker = i -> {};
    private int ticks;

    /**
     * Main class constructor used to create new {@link Ticker}
     * instances.
     */
    public Ticker() {
        this.ticks = 0;
        this.timer = new Timer(GameSettings.TIMER_DELTA, this);
    }

    /**
     * Start the ticker
     */
    public void start() {
        timer.start();
    }

    /**
     * End the ticker
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Set the new ticker action performed each {@link GameSettings#TIMER_DELTA}
     * tick.
     *
     * @param ticker ticker action
     */
    public void setTicker(Consumer<Integer> ticker) {
        this.ticker = ticker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticker.accept(ticks++);
    }
}
