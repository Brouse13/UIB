package es.brouse.game.panels;

import es.brouse.game.io.StatsReader;
import es.brouse.game.objects.builders.LabelBuilder;
import es.brouse.game.objects.builders.TextAreaBuilder;
import es.brouse.game.utils.GameStats;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.NORTH;
import static javax.swing.ScrollPaneConstants.*;

/**
 * Class used to create new Stats panels to display all the user stats, this
 * can be also used to filter by name.
 */
public class StatsPanel extends JPanel implements Panel {
    private static final String FORMAT = "JUGADOR: %s - FECHA: %s - PUNTOS %s";
    private final String name;
    private final boolean onlyUser;

    public StatsPanel(String name) {
        this.name = name;
        this.onlyUser = name != null;

        setUp();
        initComponents();
    }

    @Override
    public void setUp() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initComponents() {
        boolean content = false;

        TextAreaBuilder textArea = new TextAreaBuilder(false);

        //If is user mode set, we add the player name
        LabelBuilder label = new LabelBuilder("Historial" + (onlyUser ? " de " + name : ""))
                .setFont("Arial", Font.PLAIN, 25);

        try(StatsReader reader = new StatsReader("data/stats.dat")) {
            while (reader.next()) {
                content = true;
                GameStats read = reader.read();

                //Add to the panel if the stats are displayed global or user matches
                if (!onlyUser || read.getUsername().equals(name))
                    textArea.addLine(String.format(FORMAT,read.getUsername(), read.getTime(), read.getPoints()));
            }
        }

        if (!content) textArea.addLine("NO HAY DATOS PARA MOSTRAR");

        add(label.getComponent(), NORTH);
        add(new JScrollPane(textArea.getComponent(), VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_AS_NEEDED));
    }

    @Override
    public JComponent getComponent() {
        return this;
    }
}
