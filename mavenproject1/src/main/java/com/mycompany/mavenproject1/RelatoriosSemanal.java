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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import relatorio.Relatorio;

/**
 * Relatorios
 */
public class RelatoriosSemanal extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = -7273215319151435418L;
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

    private Relatorio relatorioDAO = new Relatorio();
    RelatoriosSemanalBarbeiro relSemBarbeiro;

    public RelatoriosSemanal(RelatoriosSemanalBarbeiro relSemBarbeiro) {
        this.relSemBarbeiro = relSemBarbeiro;
        relatoriosSemanal();
    }

    protected void relatoriosSemanal() {
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
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/chart-icon.png")));
        customerIcon.setBounds(65, 196, 55, 55);
        description.add(customerIcon);

        label = new JLabel("Nº");
        label.setBounds(210, 10, 55, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Serviço");
        label.setBounds(270, 10, 100, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Total");
        label.setBounds(465, 10, 100, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        // Corte
        int dataInicio = Integer.parseInt(dataString("dd"));
        int dataFinal = dataInicio - 7;
        int cont = 0;
        String data = "";
        data = dataFinal + "/" + dataString("MM/yyyy");
        if (dataInicio - 7 < 1) {
            for (int i = dataFinal; i <= 0; i++) {
                cont++;
            }
            dataFinal = 31 - cont;

            int mesInicio = Integer.parseInt(dataString("MM"));
            data = dataFinal + "/0" + (mesInicio - 1) + "/" + dataString("yyyy");
        }
        Object[] corte = relatorioDAO.nServico(1, data, dataString("dd/MM/yyyy"));
        lContador = new JLabel("" + corte[0]);
        lContador.setBounds(210, 70, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Corte");
        lServico.setBounds(270, 70, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ " + corte[1]);
        lValor.setBounds(465, 70, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Barba

        Object[] barba = relatorioDAO.nServico(0, data, dataString("dd/MM/yyyy"));
        lContador = new JLabel("" + barba[0]);
        lContador.setBounds(210, 110, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Barba");
        lServico.setBounds(270, 110, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ " + barba[1]);
        lValor.setBounds(465, 110, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Sombrancelha
        Object[] sobrancelha = relatorioDAO.nServico(7, data, dataString("dd/MM/yyyy"));

        lContador = new JLabel("" + sobrancelha[0]);
        lContador.setBounds(210, 150, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Sombrancelha");
        lServico.setBounds(270, 150, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ " + sobrancelha[1]);
        lValor.setBounds(465, 150, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Coloracao
        Object[] coloracao = relatorioDAO.nServico(2, data, dataString("dd/MM/yyyy"));

        lContador = new JLabel("" + coloracao[0]);
        lContador.setBounds(210, 190, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Coloração");
        lServico.setBounds(270, 190, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ " + coloracao[1]);
        lValor.setBounds(465, 190, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Pigmentacao em barba
        Object[] pigmentacao = relatorioDAO.nServico(5, data, dataString("dd/MM/yyyy"));

        lContador = new JLabel("" + pigmentacao[0]);
        lContador.setBounds(210, 230, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Pigmentação em B.");
        lServico.setBounds(270, 230, 180, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ " + pigmentacao[1]);
        lValor.setBounds(465, 230, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Selagem

        Object[] selagem = relatorioDAO.nServico(6, data, dataString("dd/MM/yyyy"));
        lContador = new JLabel("" + selagem[0]);
        lContador.setBounds(210, 270, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Selagem");
        lServico.setBounds(270, 270, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ " + selagem[1]);
        lValor.setBounds(465, 270, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Relaxamento

        Object[] relaxamento = relatorioDAO.nServico(4, data, dataString("dd/MM/yyyy"));
        lContador = new JLabel("" + relaxamento[0]);
        lContador.setBounds(210, 310, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Relaxamento");
        lServico.setBounds(270, 310, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ " + relaxamento[1]);
        lValor.setBounds(465, 310, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Luzes

        Object[] luzes = relatorioDAO.nServico(3, data, dataString("dd/MM/yyyy"));
        lContador = new JLabel("" + luzes[0]);
        lContador.setBounds(210, 350, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Luzes");
        lServico.setBounds(270, 350, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ " + luzes[1]);
        lValor.setBounds(465, 350, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        //

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/line1.png")));
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

        Object[] hugo = relatorioDAO.nServicoBarbeiro(0, data, dataString("dd/MM/yyyy"));
        bBarbeiro1 = new JButton("Hugo");
        bBarbeiro1.setBounds(630, 190, 120, 24);
        bBarbeiro1.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro1.setForeground(new Color(110, 110, 110));
        bBarbeiro1.setBackground(new Color(255, 255, 255));
        bBarbeiro1.addActionListener(this);
        add(bBarbeiro1);

        lContador = new JLabel("" + quantServicos(0));
        lContador.setBounds(830, 190, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " + hugo[1]);
        lContador.setBounds(1000, 190, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " + (double) hugo[1] * 0.5);
        lContador.setBounds(1160, 190, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 02
        Object[] mario = relatorioDAO.nServicoBarbeiro(1, data, dataString("dd/MM/yyyy"));
        bBarbeiro2 = new JButton("Mário");
        bBarbeiro2.setBounds(630, 70, 120, 24);
        bBarbeiro2.setBackground(new Color(255, 255, 255));
        bBarbeiro2.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro2.setForeground(new Color(110, 110, 110));
        bBarbeiro2.addActionListener(this);
        add(bBarbeiro2);

        lContador = new JLabel("" + quantServicos(1));
        lContador.setBounds(830, 70, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " + (double) mario[1]);
        lContador.setBounds(1000, 70, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " + (double) mario[1] * 0.5);
        lContador.setBounds(1160, 70, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 03
        Object[] raimundo = relatorioDAO.nServicoBarbeiro(2, data, dataString("dd/MM/yyyy"));
        bBarbeiro3 = new JButton("Raimundo");
        bBarbeiro3.setBackground(new Color(255, 255, 255));
        bBarbeiro3.setBounds(630, 110, 120, 24);
        bBarbeiro3.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        bBarbeiro3.setForeground(new Color(110, 110, 110));
        bBarbeiro3.addActionListener(this);
        add(bBarbeiro3);

        lContador = new JLabel("" + quantServicos(2));
        lContador.setBounds(830, 110, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " + (double) raimundo[1]);
        lContador.setBounds(1000, 110, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " + (double) raimundo[1] * 0.5);
        lContador.setBounds(1160, 110, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 04

        Object[] sergio = relatorioDAO.nServicoBarbeiro(3, data, dataString("dd/MM/yyyy"));
        bBarbeiro4 = new JButton("Sérgio");
        bBarbeiro4.setBounds(630, 150, 120, 24);
        bBarbeiro4.setBackground(new Color(255, 255, 255));
        bBarbeiro4.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro4.setForeground(new Color(110, 110, 110));
        bBarbeiro4.addActionListener(this);
        add(bBarbeiro4);

        lContador = new JLabel("" + quantServicos(3));
        lContador.setBounds(830, 150, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " + (double) sergio[1]);
        lContador.setBounds(1000, 150, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " + (double) sergio[1] * 0.5);
        lContador.setBounds(1160, 150, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        //
        //

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/horizontal-division-line.png")));
        line.setBounds(600, 250, 889, 2);
        add(line);

        label = new JLabel("Rendimentos");
        label.setBounds(630, 270, 400, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/credit-card-icon.png")));
        label.setBounds(680, 330, 400, 55);
        add(label);

        label = new JLabel("R$ " + relatorioDAO.somaValorCartao(data, dataString("dd/MM/yyyy")));
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
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/money-icon.png")));
        label.setBounds(880, 330, 400, 55);
        add(label);

        label = new JLabel("R$ " + relatorioDAO.somaValorDinheiro(data, dataString("dd/MM/yyyy")));
        label.setBounds(835, 370, 400, 55);
        label.setForeground(new Color(80, 80, 80));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        add(label);

        label = new JLabel("=");
        label.setBounds(1000, 360, 18, 18);
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        label.setForeground(new Color(80, 80, 80));
        add(label);

        label = new JLabel("R$ " + relatorioDAO.somaValorTotal(data, dataString("dd/MM/yyyy")));
        label.setBounds(1050, 360, 400, 22);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);
        repaint();
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bBarbeiro1) {

            setVisible(false);
            relSemBarbeiro.barbeiro(0);
            relSemBarbeiro.setVisible(true);
        }

        if (ae.getSource() == bBarbeiro2) {

            setVisible(false);
            relSemBarbeiro.barbeiro(1);
            relSemBarbeiro.setVisible(true);
        }

        if (ae.getSource() == bBarbeiro3) {

            setVisible(false);
            relSemBarbeiro.barbeiro(2);
            relSemBarbeiro.setVisible(true);
        }

        if (ae.getSource() == bBarbeiro4) {

            setVisible(false);
            relSemBarbeiro.barbeiro(3);
            relSemBarbeiro.setVisible(true);
        }
    }

    private String dataString(String formato) {
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat(formato); // "dd/MM/yyyy"
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        return formatador.format(calendar.getTime());
    }

    private int quantServicos(int idBarbeiro) {
        int dataInicio = Integer.parseInt(dataString("dd"));
        int dataFinal = dataInicio - 7;
        int cont = 0;
        String data = "";
        data = dataFinal + "/" + dataString("MM/yyyy");
        if (dataInicio - 7 < 1) {
            for (int i = dataFinal; i <= 0; i++) {
                cont++;
            }
            dataFinal = 31 - cont;

            int mesInicio = Integer.parseInt(dataString("MM"));
            data = dataFinal + "/0" + (mesInicio - 1) + "/" + dataString("yyyy");
        }
        Object[] corte = relatorioDAO.nServiBarb(1, idBarbeiro, data, dataString("dd/MM/yyyy"));
        Object[] barba = relatorioDAO.nServiBarb(0, idBarbeiro, data, dataString("dd/MM/yyyy"));
        Object[] somb = relatorioDAO.nServiBarb(7, idBarbeiro, data, dataString("dd/MM/yyyy"));
        Object[] colo = relatorioDAO.nServiBarb(2, idBarbeiro, data, dataString("dd/MM/yyyy"));
        Object[] pig = relatorioDAO.nServiBarb(5, idBarbeiro, data, dataString("dd/MM/yyyy"));
        Object[] sela = relatorioDAO.nServiBarb(6, idBarbeiro, data, dataString("dd/MM/yyyy"));
        Object[] rela = relatorioDAO.nServiBarb(4, idBarbeiro, data, dataString("dd/MM/yyyy"));
        Object[] luz = relatorioDAO.nServiBarb(3, idBarbeiro, data, dataString("dd/MM/yyyy"));
        return (int) corte[0] + (int) barba[0] + (int) somb[0] + (int) colo[0] + (int) pig[0] + (int) sela[0]
                + (int) rela[0] + (int) luz[0];
    }

}
