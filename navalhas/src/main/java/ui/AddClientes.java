package ui;

import java.awt.*;

import javax.swing.*;

/**
 * Customer Screen
 */
public class AddClientes extends Inicio {

    public AddClientes() {

        JPanel description = new JPanel();
        description.setBounds(0, 0, 246, 530);
        description.setBackground(new Color(234, 234, 234));
        body.add(description);

        JLabel customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-users.png")));
        customerIcon.setBounds(50, 50, 0, 0);
        description.add(customerIcon);

        JLabel nome = new JLabel("Nome");
        nome.setBounds(663,130,200,60);
        nome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        nome.setForeground(new Color(131, 131, 131));
        body.add(nome);

        JTextField tNome = new JTextField("");
        tNome.setBounds(663,200,448,60);
        body.add(tNome);

        JLabel contatos = new JLabel("Contatos");
        contatos.setBounds(663,280,200,60);
        contatos.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        contatos.setForeground(new Color(131, 131, 131));
        body.add(contatos);

        JTextField tDDDContato1 = new JTextField("");
        tDDDContato1.setBounds(663,350,70,60);
        body.add(tDDDContato1);

        JTextField tContato1 = new JTextField("");
        tContato1.setBounds(750,350,362,60);
        body.add(tContato1);

        JTextField tDDDContato2 = new JTextField("");
        tDDDContato2.setBounds(663,430,70,60);
        body.add(tDDDContato2);

        JTextField tContato2 = new JTextField("");
        tContato2.setBounds(750,430,362,60);
        body.add(tContato2);

        JButton bCancelar = new JButton();
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/cancel-button.png")));
        bCancelar.setBounds(1520, 420, 80, 80);
        bCancelar.setContentAreaFilled(false);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusable(false);
        bCancelar.addActionListener(this);
        body.add(bCancelar);

        JButton bConfirmar = new JButton();
        bConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/confirm-button.png")));
        bConfirmar.setBounds(1600, 420, 160, 80);
        bConfirmar.setContentAreaFilled(false);
        bConfirmar.setBorderPainted(false);
        bConfirmar.setFocusable(false);
        bConfirmar.addActionListener(this);
        body.add(bConfirmar);


    }
    

}
