package ui;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private int width;
    private int height;

    public Inicio() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        width = (int) d.getWidth();
        height = (int) d.getHeight();

        body();
        frame();
        menubar();
        footer();
        frame.setVisible(true);

    }

    public void frame() {

        fundo = new JLabel();
        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/background.png")));
        fundo.setBounds(0, 0, width, height);

        frame = new JFrame("Barbearia Navalhas");
        frame.getContentPane().setBackground(new Color(247, 247, 247));
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(body);
        frame.getContentPane().add(fundo);

        logo = new JLabel("");
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/Logo1.png")));
        logo.setBounds(height/17, height/43, height/3, height/4);
        frame.getContentPane().add(logo);
    }

    protected void body() {

        body = new JPanel();
        body.setBounds(width/30, width/6, width/1 - 110, width/4);
        body.setBackground(new Color(255, 255, 255));
        body.setLayout(null);

        // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy -- hh:mm");

        // message = new JLabel("Olá :) , hoje é: " + dateFormat.format(new Date()));
        // message.setBounds(700, 0, 420, 500);
        // message.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        // body.add(message);
    }

    protected void menubar() {

        menubar = new JPanel();
        menubar.setBounds(width/5 +20, width/19 + 20, width/2 +380 , width/24);
        menubar.setBackground(new Color(34, 34, 34)); 
        menubar.setLayout(null);

        bClientes = new JButton("    Clientes");
        bClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-icon.png")));
        bClientes.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bClientes.setForeground(new Color(255, 255, 255));
        bClientes.setBounds(-40, -10, 488, 80);
        bClientes.setContentAreaFilled(false);
        bClientes.setBorderPainted(false);
        bClientes.setFocusable(false);
        bClientes.addActionListener(this);
        menubar.add(bClientes);

        bAssinaturas = new JButton("    Assinaturas");
        bAssinaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signature-icon.png")));
        bAssinaturas.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bAssinaturas.setForeground(new Color(255, 255, 255));
        bAssinaturas.setBounds(width/4 - 40, -10, 488, 80);
        bAssinaturas.setContentAreaFilled(false);
        bAssinaturas.setBorderPainted(false);
        bAssinaturas.setFocusable(false);
        menubar.add(bAssinaturas);

        bRelatorios = new JButton("    Relatorios");
        bRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/report-icon.png")));
        bRelatorios.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bRelatorios.setForeground(new Color(255, 255, 255));
        bRelatorios.setBounds(width/2 -40, -10, 493, 80);
        bRelatorios.setContentAreaFilled(false);
        bRelatorios.setBorderPainted(false);
        bRelatorios.setFocusable(false);
        menubar.add(bRelatorios);

        frame.getContentPane().add(menubar);
    }

    protected void footer() {

        whatsapp = new JLabel();
        whatsapp.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/whatsapp-icon.png")));
        whatsapp.setBounds(width/30, width/2 - 15, 500, 100);
        frame.getContentPane().add(whatsapp);

        whatsapp = new JLabel("(94) 99129-0504");
        whatsapp.setBounds(125, width/2 - 25, 500, 100);
        whatsapp.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        whatsapp.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(whatsapp);

        whatsapp = new JLabel("(94) 98146-2634");
        whatsapp.setBounds(125, width/2 - 4, 500, 100);
        whatsapp.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        whatsapp.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(whatsapp);

        instagram = new JLabel("   Barbearia.Navalhas");
        instagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/instagram-icon.png")));
        instagram.setBounds(width/3 + 100, width/2 - 15, 500, 100);
        instagram.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        instagram.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(instagram);

        facebook = new JLabel("   @barbearianavalhasparauapebas");
        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/facebook-icon.png")));
        facebook.setBounds(width - 420, width/2 - 15, 500, 100);
        facebook.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        facebook.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(facebook);

        footer = new JPanel();
        footer.setBounds(0, width/2, width , width/24 + 50);
        footer.setBackground(new Color(34, 34, 34));
        footer.setLayout(null);
        frame.getContentPane().add(footer);

    }

    public void actionPerformed(ActionEvent ae) {

        /*
         * 
         * if (ae.getSource() == bClientes) {
         * 
         * body.setVisible(false); Clientes cli = new Clientes();
         * 
         * frame.getContentPane().add(cli); cli.setVisible(true);
         * 
         * }
         */
    }

    public static void panelInicio(JPanel j) {
        frame.add(j);
        j.setVisible(true);
    }

    public static void main(String[] args) {
        Inicio i = new Inicio();
    }
}
