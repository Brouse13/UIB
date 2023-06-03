package es.brouse.game.utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class CountDown implements ActionListener {
    private final Timer timer;
    private final Consumer<Integer> execute;
    private int ticks;

    public CountDown(Consumer<Integer> execute) {
        this.execute = execute;
        this.ticks = 0;
        this.timer = new Timer(1000, this);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        execute.accept(ticks++);
    }
}
