package ui;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Start Screen
 */
public class Inicio extends Janela implements ActionListener {

    public static JPanel addPanel;
    private JPanel body;
    private JLabel message;

    public Inicio() {
        body();

    }

    private void body() {

        body = new JPanel();
        body.setBounds(65, 400, 1790, 350);
        body.setBackground(new Color(255, 255, 255));
        body.setLayout(null);
        
        getContentPane().add(body);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy -- hh:mm");

        message = new JLabel("Ola¡ :) , hoje Ã©: " + dateFormat.format(new Date()));
        message.setBounds(700, 150, 420, 25);
        message.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        body.add(message);

    }

    public static void add(JPanel panel) {
        getFrames()[0].add(panel);
    }
    public static void remove(JPanel panel) {
        getFrames()[0].remove(panel);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bClientes) {

            body.setVisible(false);
            Clientes cli = new Clientes();
            getContentPane().add(cli);
            cli.setVisible(true);

        }
        if (ae.getSource() == bAssinaturas) {

            body.setVisible(false);
            Assinaturas ass = new Assinaturas();

            ass.setVisible(true);
            
            getContentPane().add(ass);

        }
        if (ae.getSource() == bRelatorios) {

            

        }
    }

   
}
