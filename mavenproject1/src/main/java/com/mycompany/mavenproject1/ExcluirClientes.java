/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cliente.Cliente;
import cliente.ClienteDAO;

/**
 * ExcluirClientes
 */
public class ExcluirClientes extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = -1003636406051270363L;
    private JPanel description;
    private JLabel customerIcon;

    private JLabel lClientes;
    private JLabel lConsultaNome;
    private JTextField tConsultaNome;

    private JButton bEnviar;
    private JButton bLimpar;

    private ClienteDAO clienteDAO = new ClienteDAO();
    private final int WIDTH = 1366;
    private final int HEIGHT = 768;

    ExcluirClientes() {

        setBounds(45, 182, 1275, 460);
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        description = new JPanel();
        description.setLayout(null);
        description.setBounds(0, 0, 175, 460);
        description.setBackground(new Color(234, 234, 234));
        add(description);

        customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/customer-delete.png")));
        customerIcon.setBounds(65, 196, 50, 45);
        description.add(customerIcon);

        lClientes = new JLabel("Excluir Cliente");
        lClientes.setBounds(WIDTH / 2 - WIDTH / 20, WIDTH / 14, WIDTH / 5, WIDTH / 32);
        lClientes.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        lClientes.setForeground(new Color(128, 128, 128));
        add(lClientes);

        lConsultaNome = new JLabel("Nome");
        lConsultaNome.setBounds(WIDTH / 2 - WIDTH / 5, HEIGHT / 5 + HEIGHT / 15, WIDTH / 5, HEIGHT / 27);
        lConsultaNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        lConsultaNome.setForeground(new Color(128, 128, 128));
        add(lConsultaNome);

        tConsultaNome = new JTextField("");
        tConsultaNome.setBounds(WIDTH / 2 - WIDTH / 8, HEIGHT / 5 + HEIGHT / 15, WIDTH / 4 + WIDTH / 15, HEIGHT / 16);
        tConsultaNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        tConsultaNome.setForeground(new Color(131, 131, 131));
        // tConsultaCpf.setDocument(new Tratamento());
        add(tConsultaNome);

        bEnviar = new JButton("Enviar");
        bEnviar.setBounds(WIDTH / 2 + WIDTH / 40 + WIDTH / 32, HEIGHT / 3 + HEIGHT / 15, WIDTH / 10, HEIGHT / 16);
        bEnviar.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bEnviar.addActionListener(this);
        bEnviar.setBackground(new Color(255, 255, 255));
        bEnviar.setForeground(new Color(0, 128, 128));
        add(bEnviar);

        bLimpar = new JButton("Limpar");
        bLimpar.setBounds(WIDTH / 3 + WIDTH / 12, HEIGHT / 3 + HEIGHT / 15, WIDTH / 10, HEIGHT / 16);
        bLimpar.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bLimpar.setBackground(new Color(255, 255, 255));
        bLimpar.setForeground(new Color(205, 92, 92));
        bLimpar.addActionListener(this);
        add(bLimpar);

    }

    void resultadoConsulta() {

        description = new JPanel();
        description.setBounds(0, 0, 175, 460);
        description.setBackground(new Color(234, 234, 234));
        description.setLayout(null);
        add(description);

        customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/customer-delete.png")));
        customerIcon.setBounds(65, 196, 50, 45);
        description.add(customerIcon);

        JLabel label = new JLabel("VocÃª estÃ¡ prestes a excluir ");
        label.setBounds(280, 220, 300, 22);
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        label.setForeground(new Color(131, 131, 131));
        add(label);

        JLabel bFoto = new JLabel();
        bFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/picture-customer.png")));
        bFoto.setBounds(620, 180, 100, 100);
        add(bFoto);

        JLabel nome = new JLabel("Nome");
        nome.setBounds(720, 220, 80, 22);
        nome.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        nome.setForeground(new Color(131, 131, 131));
        add(nome);

        label = new JLabel(" deseja mesmo continuar ? ");
        label.setBounds(710, 385, 280, 50);
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        label.setForeground(new Color(47, 47, 47));
        add(label);

        JButton bCancelar = new JButton();
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/cancel-button.png")));
        bCancelar.setBounds(1080, 385, 58, 58);
        bCancelar.setContentAreaFilled(false);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusable(false);
        bCancelar.addActionListener(this);
        add(bCancelar);

        JButton bConfirmar = new JButton();
        bConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/confirm-button.png")));
        bConfirmar.setBounds(1135, 385, 120, 60);
        bConfirmar.setContentAreaFilled(false);
        bConfirmar.setBorderPainted(false);
        bConfirmar.setFocusable(false);
        bConfirmar.addActionListener(this);
        add(bConfirmar);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bEnviar) {
            String nomePesquisado = tConsultaNome.getText().trim();
            List<Cliente> listaClientes = clienteDAO.read();
            Cliente clientePesquisado = null;

            for (Cliente cliente : listaClientes) {
                String nomeCliente = cliente.getNome().trim();

                if (nomePesquisado.equalsIgnoreCase(nomeCliente)) {
                    clientePesquisado = cliente;
                }
            }

            if (clientePesquisado != null) {
                System.out.println(clientePesquisado.getContato1());
                clienteDAO.delete(clientePesquisado);
            } else {
                System.out.println("Cliente nao encontrado");
            }
        }

        if (e.getSource() == bLimpar) {
            tConsultaNome.setText("");
        }

    }

}