/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

import relatorio.Relatorio;

/**
 * Relatorios
 */
public class RelatoriosMensal extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 8279451395859290558L;
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

    RelatoriosMensalBarbeiro relMenBarbeiro;
    private Relatorio relatorioDAO = new Relatorio();
    private String mes = "01";

    public RelatoriosMensal(RelatoriosMensalBarbeiro relMenBarbeiro) {
        this.relMenBarbeiro = relMenBarbeiro;
        relatorioMensal();
    }
    private void relatorioMensal(){
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
        label.setBounds(330, 10, 100, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Total");
        label.setBounds(525, 10, 100, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        // Corte
        String ano = dataString("yyyy");
        String dataCompleta = mes+"/"+ano;
        Object[] corte = relatorioDAO.nServico(1, dataCompleta);
        lContador = new JLabel(""+corte[0]);
        lContador.setBounds(210, 90, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Corte");
        lServico.setBounds(330, 90, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+corte[1]);
        lValor.setBounds(525, 90, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Barba

        Object[] barba = relatorioDAO.nServico(0, dataCompleta);
        lContador = new JLabel(""+barba[0]);
        lContador.setBounds(210, 135, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Barba");
        lServico.setBounds(330, 135, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+barba[1]);
        lValor.setBounds(525, 135, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Sombrancelha

        Object[] sobrancelha = relatorioDAO.nServico(7, dataCompleta);

        lContador = new JLabel(""+sobrancelha[0]);
        lContador.setBounds(210, 180, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Sombrancelha");
        lServico.setBounds(330, 180, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+sobrancelha[1]);
        lValor.setBounds(525, 180, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Coloracao
        Object[] coloracao = relatorioDAO.nServico(2, dataCompleta);

        lContador = new JLabel(""+coloracao[0]);
        lContador.setBounds(210, 225, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Coloração");
        lServico.setBounds(330, 225, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+coloracao[1]);
        lValor.setBounds(525, 225, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Pigmentacao em barba

        Object[] pigmentacao = relatorioDAO.nServico(5, dataCompleta);

        lContador = new JLabel(""+pigmentacao[0]);
        lContador.setBounds(210, 270, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Pigmentação");
        lServico.setBounds(330, 270, 180, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+pigmentacao[1]);
        lValor.setBounds(525, 270, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Selagem

        Object[] selagem = relatorioDAO.nServico(6, dataCompleta);
        lContador = new JLabel(""+selagem[0]);
        lContador.setBounds(210, 315, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Selagem");
        lServico.setBounds(330, 315, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+selagem[1]);
        lValor.setBounds(525, 315, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Relaxamento

        Object[] relaxamento = relatorioDAO.nServico(4, dataCompleta);
        lContador = new JLabel(""+relaxamento[0]);
        lContador.setBounds(210, 360, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Relaxamento");
        lServico.setBounds(330, 360, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+relaxamento[1]);
        lValor.setBounds(525, 360, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Luzes

        Object[] luzes = relatorioDAO.nServico(3, dataCompleta);
        lContador = new JLabel(""+luzes[0]);
        lContador.setBounds(210, 405, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Luzes");
        lServico.setBounds(330, 405, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+luzes[1]);
        lValor.setBounds(525, 405, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        //

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/line1.png")));
        line.setBounds(700, 5, 889, 450);
        add(line);

        label = new JLabel("Funcionário");
        label.setBounds(730, 10, 150, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Nº");
        label.setBounds(920, 10, 150, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        // Barbeiro 01

        bBarbeiro1 = new JButton("Hugo");
        bBarbeiro1.setBounds(730, 225, 150, 24);
        bBarbeiro1.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro1.setForeground(new Color(110, 110, 110));
        bBarbeiro1.setBackground(new Color(255, 255, 255));
        bBarbeiro1.addActionListener(this);
        add(bBarbeiro1);

        lContador = new JLabel(""+ quantServicos(0));
        lContador.setBounds(920, 225, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 02

        bBarbeiro2 = new JButton("Mário");
        bBarbeiro2.setBounds(730, 90, 150, 24);
        bBarbeiro2.setBackground(new Color(255, 255, 255));
        bBarbeiro2.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro2.setForeground(new Color(110, 110, 110));
        bBarbeiro2.addActionListener(this);
        add(bBarbeiro2);

        lContador = new JLabel(""+ quantServicos(1));
        lContador.setBounds(920, 90, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 03

        bBarbeiro3 = new JButton("Raimundo");
        bBarbeiro3.setBounds(730, 135, 150, 24);
        bBarbeiro3.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bBarbeiro3.setBackground(new Color(255, 255, 255));
        bBarbeiro3.setForeground(new Color(110, 110, 110));
        bBarbeiro3.addActionListener(this);
        add(bBarbeiro3);

        lContador = new JLabel(""+ quantServicos(2));
        lContador.setBounds(920, 135, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 04
        
        bBarbeiro4 = new JButton("Sérgio");
        bBarbeiro4.setBackground(new Color(255, 255, 255));
        bBarbeiro4.setBounds(730, 180, 150, 24);
        bBarbeiro4.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro4.setForeground(new Color(110, 110, 110));
        bBarbeiro4.addActionListener(this);
        add(bBarbeiro4);

        lContador = new JLabel(""+quantServicos(3));
        lContador.setBounds(920, 180, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        //

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/line1.png")));
        line.setBounds(1000, 15, 2, 250);
        add(line);

        label = new JLabel("Numero de servicos");
        label.setBounds(1045, 10, 400, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        lContador = new JLabel(""+(quantServicos(0)+quantServicos(1)+quantServicos(2)+quantServicos(3)));
        lContador.setBounds(1090, 140, 400, 55);
        lContador.setForeground(new Color(47, 47, 47));
        lContador.setFont(new Font("Helvetica Neue UltraLight", Font.PLAIN, 35));
        add(lContador);

        //

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/horizontal-division-line.png")));
        line.setBounds(730, 280, 520, 2);
        add(line);

        label = new JLabel("Valor bruto");
        label.setBounds(780, 320, 400, 55);
        label.setForeground(new Color(115, 115, 115));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);
        double money = relatorioDAO.somaValorTotal(dataCompleta);
        label = new JLabel("R$ "+money);
        label.setBounds(760, 370, 400, 55);
        label.setForeground(new Color(115, 115, 115));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Valor líquido");
        label.setBounds(1020, 320, 400, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("R$ "+ (money*0.5));
        label.setBounds(1010, 370, 400, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bBarbeiro1) {

            setVisible(false);
            relMenBarbeiro.barbeiro(0, mes);
            relMenBarbeiro.setVisible(true);
        }

        if (ae.getSource() == bBarbeiro2) {

            setVisible(false);
            relMenBarbeiro.barbeiro(1, mes);
            relMenBarbeiro.setVisible(true);
        }

        if (ae.getSource() == bBarbeiro3) {

            setVisible(false);
            relMenBarbeiro.barbeiro(2, mes);
            relMenBarbeiro.setVisible(true);
        }

        if (ae.getSource() == bBarbeiro4) {

            setVisible(false);
            relMenBarbeiro.barbeiro(3, mes);
            relMenBarbeiro.setVisible(true);
        }
    }
    private int quantServicos(int idBarbeiro){
        String ano = dataString("yyyy");
        String dataCompleta = mes+"/"+ano;
        Object[] corte = relatorioDAO.nServiBarb(1,idBarbeiro, dataCompleta);
        Object[] barba = relatorioDAO.nServiBarb(0,idBarbeiro, dataCompleta);
        Object[] somb = relatorioDAO.nServiBarb(7,idBarbeiro, dataCompleta);
        Object[] colo = relatorioDAO.nServiBarb(2,idBarbeiro, dataCompleta);
        Object[] pig = relatorioDAO.nServiBarb(5,idBarbeiro, dataCompleta);
        Object[] sela = relatorioDAO.nServiBarb(6,idBarbeiro, dataCompleta);
        Object[] rela = relatorioDAO.nServiBarb(4,idBarbeiro, dataCompleta);
        Object[] luz = relatorioDAO.nServiBarb(3,idBarbeiro, dataCompleta);
        return (int) corte[0] +(int) barba[0] + (int)somb[0] + (int)colo[0] + (int)pig[0]+ (int)sela[0]+ (int)rela[0]+ (int)luz[0];
    }

    private String dataString(String formato){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat(formato); //"dd/MM/yyyy"
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        return formatador.format(calendar.getTime());
    }

    protected void mes(String mes){
        this.mes = mes;
        relatorioMensal();
    }
}