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
        frame.getContentPane().add(body);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy -- hh:mm");

        message = new JLabel("Olá :) , hoje é: " + dateFormat.format(new Date()));
        message.setBounds(700, 150, 420, 25);
        message.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        body.add(message);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bClientes) {

            body.setVisible(false);
            Clientes cli = new Clientes();

            frame.getContentPane().add(cli);
            cli.setVisible(true);

        }

    }

   
}
