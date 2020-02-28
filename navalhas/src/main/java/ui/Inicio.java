package ui;

import javax.swing.*;

/**
 * Inicio
 */
public class Inicio extends JFrame {

    Janela jan;

    public Inicio() {

        jan = new Janela();

    }

    // Metodo para a correta mudanca de paineis

    public static void panelInicio(JPanel j) {
        j.setVisible(true);
    }

}