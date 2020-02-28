package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Relatorios
 */
public class RelatoriosMes extends JPanel implements ActionListener {

    private JPanel description;
    private JLabel customerIcon;

    private JButton bJaneiro;
    private JButton bFevereiro;
    private JButton bMarco;
    private JButton bAbril;
    private JButton bMaio;
    private JButton bJunho;
    private JButton bJulho;
    private JButton bAgosto;
    private JButton bSetembro;
    private JButton bOutubro;
    private JButton bNovembro;
    private JButton bDezembro;

    JPanel relMen;

    public RelatoriosMes(JPanel relMen) {
        this.relMen = relMen;

        removeAll();

        setBounds(45, 182, 1275, 460);
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        description = new JPanel();
        description.setLayout(null);
        description.setBounds(0, 0, 175, 460);
        description.setBackground(new Color(234, 234, 234));
        add(description);

        customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/chart-icon.png")));
        customerIcon.setBounds(65, 196, 55, 55);
        description.add(customerIcon);

        bJaneiro = new JButton();
        bJaneiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bJaneiro.setBounds(250, 50, 205, 80);
        bJaneiro.setBackground(new Color(0, 0, 0));
        bJaneiro.setBorderPainted(false);
        bJaneiro.setContentAreaFilled(false);
        bJaneiro.setFocusable(false);
        bJaneiro.setLayout(null);
        bJaneiro.addActionListener(this);
        add(bJaneiro);

        JLabel lJaneiro = new JLabel("Janeiro");
        lJaneiro.setForeground(new Color(255, 255, 255));
        lJaneiro.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lJaneiro.setBounds(65, 30, 100, 23);
        bJaneiro.add(lJaneiro);

        bFevereiro = new JButton();
        bFevereiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bFevereiro.setBounds(500, 50, 205, 80);
        bFevereiro.setBackground(new Color(0, 0, 0));
        bFevereiro.setBorderPainted(false);
        bFevereiro.setContentAreaFilled(false);
        bFevereiro.setFocusable(false);
        bFevereiro.setLayout(null);
        bFevereiro.addActionListener(this);
        add(bFevereiro);

        JLabel lFevereiro = new JLabel("Fevereiro");
        lFevereiro.setForeground(new Color(255, 255, 255));
        lFevereiro.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lFevereiro.setBounds(60, 30, 100, 23);
        bFevereiro.add(lFevereiro);

        bMarco = new JButton();
        bMarco.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bMarco.setBounds(750, 50, 205, 80);
        bMarco.setBackground(new Color(0, 0, 0));
        bMarco.setBorderPainted(false);
        bMarco.setContentAreaFilled(false);
        bMarco.setFocusable(false);
        bMarco.setLayout(null);
        bMarco.addActionListener(this);
        add(bMarco);

        JLabel lMarco = new JLabel("Março");
        lMarco.setForeground(new Color(255, 255, 255));
        lMarco.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lMarco.setBounds(75, 30, 100, 23);
        bMarco.add(lMarco);

        bAbril = new JButton();
        bAbril.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bAbril.setBounds(1000, 50, 205, 80);
        bAbril.setBackground(new Color(0, 0, 0));
        bAbril.setBorderPainted(false);
        bAbril.setContentAreaFilled(false);
        bAbril.setFocusable(false);
        bAbril.setLayout(null);
        bAbril.addActionListener(this);
        add(bAbril);

        JLabel lAbril = new JLabel("Abril");
        lAbril.setForeground(new Color(255, 255, 255));
        lAbril.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lAbril.setBounds(80, 30, 100, 23);
        bAbril.add(lAbril);

        bMaio = new JButton();
        bMaio.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bMaio.setBounds(250, 185, 205, 80);
        bMaio.setBackground(new Color(0, 0, 0));
        bMaio.setBorderPainted(false);
        bMaio.setContentAreaFilled(false);
        bMaio.setFocusable(false);
        bMaio.setLayout(null);
        bMaio.addActionListener(this);
        add(bMaio);

        JLabel lMaio = new JLabel("Maio");
        lMaio.setForeground(new Color(255, 255, 255));
        lMaio.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lMaio.setBounds(75, 30, 100, 23);
        bMaio.add(lMaio);

        bJunho = new JButton();
        bJunho.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bJunho.setBounds(500, 185, 205, 80);
        bJunho.setBackground(new Color(0, 0, 0));
        bJunho.setBorderPainted(false);
        bJunho.setContentAreaFilled(false);
        bJunho.setFocusable(false);
        bJunho.setLayout(null);
        bJunho.addActionListener(this);
        add(bJunho);

        JLabel lJunho = new JLabel("Junho");
        lJunho.setForeground(new Color(255, 255, 255));
        lJunho.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lJunho.setBounds(70, 30, 100, 23);
        bJunho.add(lJunho);

        bJulho = new JButton();
        bJulho.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bJulho.setBounds(750, 185, 205, 80);
        bJulho.setBackground(new Color(0, 0, 0));
        bJulho.setBorderPainted(false);
        bJulho.setContentAreaFilled(false);
        bJulho.setFocusable(false);
        bJulho.setLayout(null);
        bJulho.addActionListener(this);
        add(bJulho);

        JLabel lJulho = new JLabel("Julho");
        lJulho.setForeground(new Color(255, 255, 255));
        lJulho.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lJulho.setBounds(75, 30, 100, 23);
        bJulho.add(lJulho);

        bAgosto = new JButton();
        bAgosto.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bAgosto.setBounds(1000, 190, 205, 80);
        bAgosto.setBackground(new Color(0, 0, 0));
        bAgosto.setBorderPainted(false);
        bAgosto.setContentAreaFilled(false);
        bAgosto.setFocusable(false);
        bAgosto.setLayout(null);
        bAgosto.addActionListener(this);
        add(bAgosto);

        JLabel lAgosto = new JLabel("Agosto");
        lAgosto.setForeground(new Color(255, 255, 255));
        lAgosto.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lAgosto.setBounds(70, 30, 100, 23);
        bAgosto.add(lAgosto);

        bSetembro = new JButton();
        bSetembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bSetembro.setBounds(250, 330, 205, 80);
        bSetembro.setBackground(new Color(0, 0, 0));
        bSetembro.setBorderPainted(false);
        bSetembro.setContentAreaFilled(false);
        bSetembro.setFocusable(false);
        bSetembro.setLayout(null);
        bSetembro.addActionListener(this);
        add(bSetembro);

        JLabel lSetembro = new JLabel("Setembro");
        lSetembro.setForeground(new Color(255, 255, 255));
        lSetembro.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lSetembro.setBounds(60, 30, 100, 23);
        bSetembro.add(lSetembro);

        bOutubro = new JButton();
        bOutubro.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bOutubro.setBounds(500, 330, 205, 80);
        bOutubro.setBackground(new Color(0, 0, 0));
        bOutubro.setBorderPainted(false);
        bOutubro.setContentAreaFilled(false);
        bOutubro.setFocusable(false);
        bOutubro.setLayout(null);
        bOutubro.addActionListener(this);
        add(bOutubro);

        JLabel lOutubro = new JLabel("Outubro");
        lOutubro.setForeground(new Color(255, 255, 255));
        lOutubro.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lOutubro.setBounds(65, 30, 100, 23);
        bOutubro.add(lOutubro);

        bNovembro = new JButton();
        bNovembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bNovembro.setBounds(750, 330, 205, 80);
        bNovembro.setBackground(new Color(0, 0, 0));
        bNovembro.setBorderPainted(false);
        bNovembro.setContentAreaFilled(false);
        bNovembro.setFocusable(false);
        bNovembro.setLayout(null);
        bNovembro.addActionListener(this);
        add(bNovembro);

        JLabel lNovembro = new JLabel("Novembro");
        lNovembro.setForeground(new Color(255, 255, 255));
        lNovembro.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lNovembro.setBounds(55, 30, 120, 23);
        bNovembro.add(lNovembro);

        bDezembro = new JButton();
        bDezembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/circle-button.png")));
        bDezembro.setBounds(1000, 330, 205, 80);
        bDezembro.setBackground(new Color(0, 0, 0));
        bDezembro.setBorderPainted(false);
        bDezembro.setContentAreaFilled(false);
        bDezembro.setFocusable(false);
        bDezembro.setLayout(null);
        bDezembro.addActionListener(this);
        add(bDezembro);

        JLabel lDezembro = new JLabel("Dezembro");
        lDezembro.setForeground(new Color(255, 255, 255));
        lDezembro.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
        lDezembro.setBounds(55, 30, 120, 23);
        bDezembro.add(lDezembro);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bJaneiro) {

            setVisible(false);
            relMen.setVisible(true);
        }

    }

}