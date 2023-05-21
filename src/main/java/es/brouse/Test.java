package es.brouse;

import es.brouse.objects.MusicalNote;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    private class Piano extends JPanel {
        private Tablero tablero;

        public Piano(Tablero tablero) {
            this.tablero = tablero;

            initComponents();
        }

        private void initComponents() {

        }
    }

    private class Tablero extends JPanel {
        private JButton[] botones = new JButton[110];
        private int index = 0;

        public Tablero() {
            setBackground(Color.BLACK);

            initComponents();
        }

        private void initComponents() {

        }
        public void addNota(MusicalNote nota) {
            botones[index].setBackground(nota.getColor());
            index++;
        }
    }
}
