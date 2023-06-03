package es.brouse.game.panels.game;

import es.brouse.game.panels.Panel;
import es.brouse.game.utils.Ticker;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class CountDownPanel extends JPanel implements Panel {
    private final JProgressBar progressBar = new JProgressBar();
    private final Ticker ticker;
    private final GameImagePanel gamePanel;
    public CountDownPanel(Ticker ticker, GameImagePanel gamePanel) {
        this.ticker = ticker;
        this.gamePanel = gamePanel;

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
        progressBar.setValue(1000);

        ticker.start();
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    private Consumer<Integer> tick() {
        return tick -> {
            if (tick == 10) {
                ticker.stop();
                gamePanel.endTicker().accept(true);
            }

            progressBar.setValue(progressBar.getValue() - 10);
        };
    }
}
