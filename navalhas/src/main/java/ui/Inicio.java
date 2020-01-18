package ui;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * Start Screen
 */
public class Inicio extends JPanel implements ActionListener {

    public static JFrame frame;

    public JLabel fundo;
    public JLabel logo;

    public JPanel menubar;
    public JButton bClientes;
    public JButton bAssinaturas;
    public JButton bRelatorios;

    public JPanel body;
    public JLabel message;

    public JPanel footer;
    public JLabel whatsapp;
    public JLabel instagram;
    public JLabel facebook;

    public Inicio() {

        // Body start here for correctly transparency effect.
        body = new JPanel();
        body.setBounds(65, 290, 1790, 530);
        body.setBackground(new Color(255, 255, 255));
        body.setLayout(null);

        
        message = new JLabel("Bom dia / Boa tarde / Boa noite. Selecione uma opção para começar");
        message.setBounds(20,20,200,200);
        body.add(message);

        // Body end here

        fundo = new JLabel();
        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/background.png")));
        fundo.setBounds(0, 0, 1920, 1080);

        frame = new JFrame("Barbearia Navalhas");
        frame.getContentPane().setBackground(new Color(247, 247, 247));
        frame.setSize(1920, 1080);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(body);
        frame.getContentPane().add(fundo);

        logo = new JLabel("");
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/logo.png")));
        logo.setBounds(65, 25, 246, 246);
        frame.getContentPane().add(logo);

        // Menu bar start here

        menubar = new JPanel();
        menubar.setBounds(390, 109, 1465, 80);
        menubar.setBackground(new Color(34, 34, 34));
        menubar.setLayout(null);
        
        bClientes = new JButton("    Clientes");
        bClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-icon.png")));
        bClientes.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bClientes.setForeground(new Color(255, 255, 255));
        bClientes.setBounds(0, 0, 488, 80);
        bClientes.setContentAreaFilled(false);
        bClientes.setBorderPainted(false);
        bClientes.setFocusable(false);
        menubar.add(bClientes);

        bAssinaturas = new JButton("    Assinaturas");
        bAssinaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signature-icon.png")));
        bAssinaturas.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bAssinaturas.setForeground(new Color(255, 255, 255));
        bAssinaturas.setBounds(488, 0, 488, 80);
        bAssinaturas.setContentAreaFilled(false);
        bAssinaturas.setBorderPainted(false);
        bAssinaturas.setFocusable(false);
        menubar.add(bAssinaturas);

        bRelatorios = new JButton("    Relatórios");
        bRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/report-icon.png")));
        bRelatorios.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bRelatorios.setForeground(new Color(255, 255, 255));
        bRelatorios.setBounds(970, 0, 493, 80);
        bRelatorios.setContentAreaFilled(false);
        bRelatorios.setBorderPainted(false);
        bRelatorios.setFocusable(false);
        menubar.add(bRelatorios);

        frame.getContentPane().add(menubar);

        // End menu Bar

        // Footer start here
        whatsapp = new JLabel();
        whatsapp.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/whatsapp-icon.png")));
        whatsapp.setBounds(65, 865, 500, 100);
        frame.getContentPane().add(whatsapp);

        whatsapp = new JLabel("(94) 99129-0504");
        whatsapp.setBounds(125, 850, 500, 100);
        whatsapp.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        whatsapp.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(whatsapp);

        whatsapp = new JLabel("(94) 98146-2634");
        whatsapp.setBounds(125, 880, 500, 100);
        whatsapp.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        whatsapp.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(whatsapp);

        instagram = new JLabel("   Barbearia.Navalhas");
        instagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/instagram-icon.png")));
        instagram.setBounds(760, 865, 500, 100);
        instagram.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        instagram.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(instagram);

        facebook = new JLabel("   @barbearianavalhasparauapebas");
        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/facebook-icon.png")));
        facebook.setBounds(1460, 865, 500, 100);
        facebook.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        facebook.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(facebook);

        footer = new JPanel();
        footer.setBounds(0, 875, 1920, 80);
        footer.setBackground(new Color(34, 34, 34));
        footer.setLayout(null);
        frame.getContentPane().add(footer);
        // End Footer

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        /*
         * if (ae.getSource() == bGerenciamento) {
         * 
         * panel.setVisible(false); PanelGerenciamento pg = new PanelGerenciamento();
         * 
         * frame.getContentPane().add(pg); pg.setVisible(true); }
         * 
         */
    }

    public static void panelInicio(JPanel j) {
        frame.add(j);
        j.setVisible(true);
    }

}
