package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Relatorios
 */
public class RelatoriosSemanal extends JPanel implements ActionListener {

    private JPanel description;
    private JLabel customerIcon;

    private JLabel line;
    private JLabel lContador;
    private JLabel lServico;
    private JLabel lValor;
    private JLabel label;

    private JButton bBarbeiro1;
    private JButton bBarbeiro2;
    private JButton bBarbeiro3;
    private JButton bBarbeiro4;

    JPanel relSemBarbeiro;

    public RelatoriosSemanal(JPanel relSemBarbeiro) {
        this.relSemBarbeiro = relSemBarbeiro;

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

        label = new JLabel("Nº");
        label.setBounds(210, 10, 55, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Serviço");
        label.setBounds(300, 10, 100, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Total");
        label.setBounds(465, 10, 100, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        lContador = new JLabel("12.944");
        lContador.setBounds(210, 90, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Corte");
        lServico.setBounds(300, 90, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ 43.243,00");
        lValor.setBounds(465, 90, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Barba

        lContador = new JLabel("12.249");
        lContador.setBounds(210, 135, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Barba");
        lServico.setBounds(300, 135, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ 0,00");
        lValor.setBounds(465, 135, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Sombrancelha

        lContador = new JLabel("00");
        lContador.setBounds(210, 180, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Sombrancelha");
        lServico.setBounds(300, 180, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ 0,00");
        lValor.setBounds(465, 180, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Coloracao

        lContador = new JLabel("00");
        lContador.setBounds(210, 225, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Coloração");
        lServico.setBounds(300, 225, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ 0,00");
        lValor.setBounds(465, 225, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Pigmentacao em barba

        lContador = new JLabel("00");
        lContador.setBounds(210, 270, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Pigmentação");
        lServico.setBounds(300, 270, 180, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ 0,00");
        lValor.setBounds(465, 270, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Selagem

        lContador = new JLabel("00");
        lContador.setBounds(210, 315, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Selagem");
        lServico.setBounds(300, 315, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ 0,00");
        lValor.setBounds(465, 315, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Relaxamento

        lContador = new JLabel("00");
        lContador.setBounds(210, 360, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Relaxamento");
        lServico.setBounds(300, 360, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ 0,00");
        lValor.setBounds(465, 360, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Luzes

        lContador = new JLabel("243");
        lContador.setBounds(210, 405, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Luzes");
        lServico.setBounds(300, 405, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ 191.245,43");
        lValor.setBounds(465, 405, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        //

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/line1.png")));
        line.setBounds(600, 5, 889, 450);
        add(line);

        label = new JLabel("Funcionário");
        label.setBounds(630, 10, 150, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Nº de serviços");
        label.setBounds(780, 10, 150, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Valor de serviço");
        label.setBounds(950, 10, 200, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Comissão");
        label.setBounds(1140, 10, 150, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        // Barbeiro 01

        bBarbeiro1 = new JButton("Hugo");
        bBarbeiro1.setBounds(630, 70, 100, 24);
        bBarbeiro1.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro1.setForeground(new Color(110, 110, 110));
        bBarbeiro1.addActionListener(this);
        add(bBarbeiro1);

        lContador = new JLabel("09");
        lContador.setBounds(830, 70, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("09");
        lContador.setBounds(1010, 70, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("09");
        lContador.setBounds(1180, 70, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 02

        bBarbeiro2 = new JButton("Mário");
        bBarbeiro2.setBounds(630, 110, 100, 24);
        bBarbeiro2.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro2.setForeground(new Color(110, 110, 110));
        bBarbeiro2.addActionListener(this);
        add(bBarbeiro2);

        lContador = new JLabel("10");
        lContador.setBounds(830, 110, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("09");
        lContador.setBounds(1010, 110, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("09");
        lContador.setBounds(1180, 110, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 03

        bBarbeiro3 = new JButton("Raimundo");
        bBarbeiro3.setBounds(630, 150, 100, 24);
        bBarbeiro3.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro3.setForeground(new Color(110, 110, 110));
        bBarbeiro3.addActionListener(this);
        add(bBarbeiro3);

        lContador = new JLabel("10");
        lContador.setBounds(830, 150, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("09");
        lContador.setBounds(1010, 150, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("09");
        lContador.setBounds(1180, 150, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 04

        bBarbeiro4 = new JButton("Sérgio");
        bBarbeiro4.setBounds(630, 190, 100, 24);
        bBarbeiro4.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro4.setForeground(new Color(110, 110, 110));
        bBarbeiro4.addActionListener(this);
        add(bBarbeiro4);

        lContador = new JLabel("10");
        lContador.setBounds(830, 190, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("09");
        lContador.setBounds(1010, 190, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("09");
        lContador.setBounds(1180, 190, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        //

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/horizontal-division-line.png")));
        line.setBounds(600, 250, 889, 2);
        add(line);

        label = new JLabel("Rendimentos");
        label.setBounds(630, 270, 400, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/credit-card-icon.png")));
        label.setBounds(680, 330, 400, 55);
        add(label);

        label = new JLabel("R$ 20.000,00");
        label.setBounds(630, 370, 400, 55);
        label.setForeground(new Color(80, 80, 80));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        add(label);

        label = new JLabel("+");
        label.setBounds(780, 360, 18, 18);
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        label.setForeground(new Color(80, 80, 80));
        add(label);

        label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/money-icon.png")));
        label.setBounds(880, 330, 400, 55);
        add(label);

        label = new JLabel("R$ 20.000,00");
        label.setBounds(835, 370, 400, 55);
        label.setForeground(new Color(80, 80, 80));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        add(label);

        label = new JLabel("=");
        label.setBounds(1000, 360, 18, 18);
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        label.setForeground(new Color(80, 80, 80));
        add(label);

        label = new JLabel("R$ 40.000,00");
        label.setBounds(1050, 360, 400, 22);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bBarbeiro1) {

            setVisible(false);
            relSemBarbeiro.setVisible(true);
        }


        if (ae.getSource() == bBarbeiro2) {

            setVisible(false);
            relSemBarbeiro.setVisible(true);
        }


        if (ae.getSource() == bBarbeiro3) {

            setVisible(false);
            relSemBarbeiro.setVisible(true);
        }


        if (ae.getSource() == bBarbeiro4) {

            setVisible(false);
            relSemBarbeiro.setVisible(true);
        }
    }

}