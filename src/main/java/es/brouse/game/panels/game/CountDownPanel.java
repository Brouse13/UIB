package es.brouse.game.panels.game;

import es.brouse.game.panels.Panel;
import es.brouse.game.utils.CountDown;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class CountDownPanel extends JPanel implements Panel {
    private final JProgressBar progressBar = new JProgressBar();
    private final CountDown ticker = new CountDown(tickRate());
    private final Consumer<Boolean> endAction;
    public CountDownPanel(Consumer<Boolean> endAction) {
        this.endAction = endAction;

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
        progressBar.setValue(1000);

        ticker.start();
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    private Consumer<Integer> tickRate() {
        return tick -> {
            if (tick == 10) {
                endAction.accept(true);
                ticker.stop();
            }

            progressBar.setValue(progressBar.getValue() - 10);
        };
    }
}
