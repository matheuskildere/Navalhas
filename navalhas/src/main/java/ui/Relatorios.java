package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Relatorios
 */
public class Relatorios extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 8446776308536840410L;
    private JPanel description;
    private JLabel customerIcon;

    private JButton bDiario;
    private JButton bSemanal;
    private JButton bMensal;
    private JButton bAnual;

    RelatoriosDiario relDia;
    RelatoriosSemanal relSem;
    JPanel relMes;
    JPanel relMen;
    RelatoriosAnual relAnu;

    public Relatorios(RelatoriosDiario relDia, RelatoriosSemanal relSem, JPanel relMes, RelatoriosAnual relAnu) {
        this.relDia = relDia;
        this.relSem = relSem;
        this.relMes = relMes;
        this.relAnu = relAnu;

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
        customerIcon.setIcon(new javax.swing.ImageIcon("./src/main/java/ui/icons/chart-icon.png"));
        customerIcon.setBounds(65, 196, 55, 55);
        description.add(customerIcon);

        bDiario = new JButton();
        bDiario.setIcon(new javax.swing.ImageIcon("./src/main/java/ui/icons/circle-button.png"));
        bDiario.setBounds(250, 170, 205, 80);
        bDiario.setBackground(new Color(0, 0, 0));
        bDiario.setBorderPainted(false);
        bDiario.setContentAreaFilled(false);
        bDiario.setFocusable(false);
        bDiario.setLayout(null);
        bDiario.addActionListener(this);
        add(bDiario);

        JLabel diario = new JLabel("Diário");
        diario.setForeground(new Color(255, 255, 255));
        diario.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        diario.setBounds(75, 30, 100, 23);
        bDiario.add(diario);

        bSemanal = new JButton();
        bSemanal.setIcon(new javax.swing.ImageIcon("./src/main/java/ui/icons/circle-button.png"));
        bSemanal.setBounds(500, 170, 205, 80);
        bSemanal.setBackground(new Color(0, 0, 0));
        bSemanal.setBorderPainted(false);
        bSemanal.setContentAreaFilled(false);
        bSemanal.setFocusable(false);
        bSemanal.setLayout(null);
        bSemanal.addActionListener(this);
        add(bSemanal);

        JLabel lSemanal = new JLabel("Semanal");
        lSemanal.setForeground(new Color(255, 255, 255));
        lSemanal.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        lSemanal.setBounds(60, 30, 100, 23);
        bSemanal.add(lSemanal);

        bMensal = new JButton();
        bMensal.setIcon(new javax.swing.ImageIcon("./src/main/java/ui/icons/circle-button.png"));
        bMensal.setBounds(750, 170, 205, 80);
        bMensal.setBackground(new Color(0, 0, 0));
        bMensal.setBorderPainted(false);
        bMensal.setContentAreaFilled(false);
        bMensal.setFocusable(false);
        bMensal.setLayout(null);
        bMensal.addActionListener(this);
        add(bMensal);

        JLabel lMensal = new JLabel("Mensal");
        lMensal.setForeground(new Color(255, 255, 255));
        lMensal.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        lMensal.setBounds(65, 30, 100, 23);
        bMensal.add(lMensal);

        bAnual = new JButton();
        bAnual.setIcon(new javax.swing.ImageIcon("./src/main/java/ui/icons/circle-button.png"));
        bAnual.setBounds(1000, 170, 205, 80);
        bAnual.setBackground(new Color(0, 0, 0));
        bAnual.setBorderPainted(false);
        bAnual.setContentAreaFilled(false);
        bAnual.setFocusable(false);
        bAnual.setLayout(null);
        bAnual.addActionListener(this);
        add(bAnual);

        JLabel lAnual = new JLabel("Anual");
        lAnual.setForeground(new Color(255, 255, 255));
        lAnual.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        lAnual.setBounds(70, 30, 100, 23);
        bAnual.add(lAnual);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bDiario) {

            setVisible(false);
            relDia.relatoriosDiarios();
            relDia.setVisible(true);
        }

        if (ae.getSource() == bSemanal) {

            setVisible(false);
            relSem.relatoriosSemanal();
            relSem.setVisible(true);
        }

        if (ae.getSource() == bMensal) {

            setVisible(false);
            relMes.setVisible(true);
        }

        if (ae.getSource() == bAnual) {

            setVisible(false);
            relAnu.relatorioAnual();
            relAnu.setVisible(true);
        }

    }

}
