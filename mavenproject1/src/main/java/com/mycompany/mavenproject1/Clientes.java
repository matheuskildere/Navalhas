/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Customer Screen
 */

public class Clientes extends JPanel implements ActionListener {
    

    /**
     *
     */
    private static final long serialVersionUID = -4657005931050868533L;
    private JPanel description;
    private JLabel customerIcon;

    private JButton bAddCliente;
    private JButton bConsultarCliente;
    private JButton bEditarCliente;
    private JButton bExcluirCliente;

    JPanel addCli;
    JPanel conCli;
    JPanel ediCli;
    JPanel excCli;

   
    public Clientes(JPanel addCli, JPanel conCli, JPanel ediCli, JPanel excCli) {
        this.addCli = addCli;
        this.conCli = conCli;
        this.ediCli = ediCli;
        this.excCli = excCli;

        removeAll();

        setBounds(46, 327, 1273, 145);
        // setBounds(45, 182, 1275, 460);
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        description = new JPanel();
        description.setBounds(0, 0, 175, 145);
        description.setBackground(new Color(234, 234, 234));
        description.setLayout(null);
        add(description);

        customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/customer-users.png")));
        customerIcon.setBounds(65, 50, 45, 42);
        description.add(customerIcon);

        bAddCliente = new JButton("\nAdicionar");
        bAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/customer-add.png")));
        bAddCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bAddCliente.setForeground(new Color(0, 0, 0));
        bAddCliente.setBounds(220, 50, 300, 40);
        bAddCliente.setContentAreaFilled(false);
        bAddCliente.setBorderPainted(false);
        bAddCliente.setFocusable(false);
        bAddCliente.addActionListener(this);
        add(bAddCliente);

        bConsultarCliente = new JButton("\nConsultar");
        bConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/customer-search.png")));
        bConsultarCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bConsultarCliente.setForeground(new Color(0, 0, 0));
        bConsultarCliente.setBounds(470, 50, 300, 40);
        bConsultarCliente.setContentAreaFilled(false);
        bConsultarCliente.setBorderPainted(false);
        bConsultarCliente.setFocusable(false);
        bConsultarCliente.addActionListener(this);
        add(bConsultarCliente);

        bEditarCliente = new JButton("\nEditar");
        bEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/customer-edit.png")));
        bEditarCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bEditarCliente.setForeground(new Color(0, 0, 0));
        bEditarCliente.setBounds(720, 50, 300, 40);
        bEditarCliente.setContentAreaFilled(false);
        bEditarCliente.setBorderPainted(false);
        bEditarCliente.setFocusable(false);
        bEditarCliente.addActionListener(this);
        add(bEditarCliente);

        bExcluirCliente = new JButton("\nExcluir");
        bExcluirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/customer-delete.png")));
        bExcluirCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bExcluirCliente.setForeground(new Color(0, 0, 0));
        bExcluirCliente.setBounds(970, 50, 300, 40);
        bExcluirCliente.setContentAreaFilled(false);
        bExcluirCliente.setBorderPainted(false);
        bExcluirCliente.setFocusable(false);
        bExcluirCliente.addActionListener(this);
        add(bExcluirCliente);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bAddCliente) {

            setVisible(false);
            addCli.setVisible(true);

        }

        if (ae.getSource() == bConsultarCliente) {

            setVisible(false);
            conCli.setVisible(true);

        }

        if (ae.getSource() == bEditarCliente) {

            setVisible(false);
            ediCli.setVisible(true);
        }

        if (ae.getSource() == bExcluirCliente) {

            setVisible(false);
            excCli.setVisible(true);
        }

    }

}
