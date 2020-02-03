package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Janela
 */
public class Janela extends JFrame implements ActionListener {

    public static JLabel fundo;
    public JLabel logo;

    public JPanel menubar;
    public JButton bClientes;
    public JButton bAssinaturas;
    public JButton bRelatorios;

    public JPanel footer;
    public JLabel whatsapp;
    public JLabel instagram;
    public JLabel facebook;

    private int width;
    private int height;

    public Janela() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        width = (int) d.getWidth();
        height = (int) d.getHeight();

       
        frame();
        fundo();
        menubar();
        footer();
        setVisible(true);

    }

    public void frame() {    
        new JFrame("Barbearia Navalhas");
        getContentPane().setBackground(new Color(247, 247, 247));
        setSize(width, height);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        logo = new JLabel("");
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/logo.png")));
        logo.setBounds(height / 17, height / 43, height / 3, height / 4);
        getContentPane().add(logo);
        
    }

    protected void fundo() {
        ImagePanel fundo = new ImagePanel(getClass().getResource("icons/background.png"));
        //fundo = new JLabel();
        //fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/background.png")));
        fundo.setBounds(0, 0, width, height);
        getContentPane().add(fundo);
    }

    protected void menubar() {

        menubar = new JPanel();
        menubar.setBounds(width / 5 + 30, width / 19 + 20, width / 2 + 380, width / 24);
        menubar.setBackground(new Color(34, 34, 34));
        menubar.setLayout(null);

        bClientes = new JButton("    Clientes");
        bClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-icon.png")));
        bClientes.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        bClientes.setForeground(new Color(255, 255, 255));
        bClientes.setBounds(-40, -10, 488, 80);
        bClientes.setContentAreaFilled(false);
        bClientes.setBorderPainted(false);
        bClientes.setFocusable(false);
        bClientes.addActionListener(this);
        menubar.add(bClientes);

        bAssinaturas = new JButton("    Assinaturas");
        bAssinaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signature-icon.png")));
        bAssinaturas.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        bAssinaturas.setForeground(new Color(255, 255, 255));
        bAssinaturas.setBounds(width / 4 - 40, -10, 488, 80);
        bAssinaturas.setContentAreaFilled(false);
        bAssinaturas.setBorderPainted(false);
        bAssinaturas.setFocusable(false);
        bAssinaturas.addActionListener(this);
        menubar.add(bAssinaturas);

        bRelatorios = new JButton("    Relatórios");
        bRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/report-icon.png")));
        bRelatorios.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        bRelatorios.setForeground(new Color(255, 255, 255));
        bRelatorios.setBounds(width / 2 - 40, -10, 493, 80);
        bRelatorios.setContentAreaFilled(false);
        bRelatorios.setBorderPainted(false);
        bRelatorios.setFocusable(false);
        bRelatorios.addActionListener(this);
        menubar.add(bRelatorios);

        getContentPane().add(menubar);
    }

    protected void footer() {

        whatsapp = new JLabel();
        whatsapp.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/whatsapp-icon.png")));
        whatsapp.setBounds(width / 30, width / 2 - 15, 500, 100);
        getContentPane().add(whatsapp);

        whatsapp = new JLabel("(94) 99129-0504");
        whatsapp.setBounds(125, width / 2 - 25, 500, 100);
        whatsapp.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        whatsapp.setForeground(new Color(255, 255, 255));
        getContentPane().add(whatsapp);

        whatsapp = new JLabel("(94) 98146-2634");
        whatsapp.setBounds(125, width / 2 + 3, 500, 100);
        whatsapp.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        whatsapp.setForeground(new Color(255, 255, 255));
        getContentPane().add(whatsapp);

        instagram = new JLabel("   Barbearia.Navalhas");
        instagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/instagram-icon.png")));
        instagram.setBounds(width / 3 + 120, width / 2 - 15, 500, 100);
        instagram.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        instagram.setForeground(new Color(255, 255, 255));
        getContentPane().add(instagram);

        facebook = new JLabel("   @barbearianavalhasparauapebas");
        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/facebook-icon.png")));
        facebook.setBounds(width - 450, width / 2 - 15, 500, 100);
        facebook.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        facebook.setForeground(new Color(255, 255, 255));
        getContentPane().add(facebook);

        footer = new JPanel();
        footer.setBounds(0, width / 2, width, width / 24 + 50);
        footer.setBackground(new Color(34, 34, 34));
        footer.setLayout(null);
        getContentPane().add(footer);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bClientes) {

            setVisible(false);
            Clientes cli = new Clientes();

            getContentPane().add(cli);
            cli.setVisible(true);

        }

        if (ae.getSource() == bAssinaturas) {
            setVisible(false);
            Assinaturas ass = new Assinaturas();

            getContentPane().add(ass);
            ass.setVisible(true);

        }

    }

    public static void add(JPanel panel){
        System.out.println(getFrames().length);
        getFrames()[0].add(panel);
    }
}
