package es.brouse.game.utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class Ticker implements ActionListener {
    private final Timer timer;
    private Consumer<Integer> ticker = i -> {};
    private int ticks;

    public Ticker() {
        this.ticks = 0;
        this.timer = new Timer(1000, this);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setTicker(Consumer<Integer> ticker) {
        this.ticker = ticker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticker.accept(ticks++);
    }
}
