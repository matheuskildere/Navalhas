package ui;

import java.awt.*;

import javax.swing.*;


/**
 * Customer Screen
 */
public class Clientes extends Inicio {

    public Clientes() {     

        JPanel description = new JPanel();
        description.setBounds(0, 0, 246, 200);
        description.setBackground(new Color(234, 234, 234));
        body.add(description);

        JLabel customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-users.png")));
        customerIcon.setBounds(50, 50, 0, 0);
        description.add(customerIcon);     

        JButton bAddCliente = new JButton();
        bAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-add.png")));
        bAddCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bAddCliente.setForeground(new Color(0, 0, 0));
        bAddCliente.setBounds(350, 0, 300, 200);
        bAddCliente.setContentAreaFilled(false);
        bAddCliente.setBorderPainted(false);
        bAddCliente.setFocusable(false);
        bAddCliente.addActionListener(this);
        body.add(bAddCliente);

        JButton bConsultarCliente = new JButton();
        bConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-search.png")));
        bConsultarCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bConsultarCliente.setForeground(new Color(0, 0, 0));
        bConsultarCliente.setBounds(700, 0, 300, 200);
        bConsultarCliente.setContentAreaFilled(false);
        bConsultarCliente.setBorderPainted(false);
        bConsultarCliente.setFocusable(false);
        bConsultarCliente.addActionListener(this);
        body.add(bConsultarCliente);

        JButton bEditarCliente = new JButton();
        bEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-edit.png")));
        bEditarCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bEditarCliente.setForeground(new Color(0, 0, 0));
        bEditarCliente.setBounds(1050, 0, 300, 200);
        bEditarCliente.setContentAreaFilled(false);
        bEditarCliente.setBorderPainted(false);
        bEditarCliente.setFocusable(false);
        bEditarCliente.addActionListener(this);
        body.add(bEditarCliente);

        JButton bExcluirCliente = new JButton();
        bExcluirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-delete.png")));
        bExcluirCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bExcluirCliente.setForeground(new Color(0, 0, 0));
        bExcluirCliente.setBounds(1400, 0, 300, 200);
        bExcluirCliente.setContentAreaFilled(false);
        bExcluirCliente.setBorderPainted(false);
        bExcluirCliente.setFocusable(false);
        bExcluirCliente.addActionListener(this);
        body.add(bExcluirCliente);


        body.setBounds(65, 420, 1790, 200);

    }

}
