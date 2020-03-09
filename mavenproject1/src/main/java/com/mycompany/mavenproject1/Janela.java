/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 * Classe que inicia o programa e cria a estrutura basica (Logo, menu e rodape)
 */
public class Janela implements ActionListener {

    protected static JFrame frame;
    protected JLabel fundo;
    protected JLabel logo;

    protected JPanel menu;
    protected JButton bClientes;
    protected JButton bAssinaturas;
    protected JButton bRelatorios;

    public AddClientes addCli = new AddClientes();
    public ConsultarCliente conCli = new ConsultarCliente();
    public EditarClientes ediCli = new EditarClientes();
    public ExcluirClientes excCli = new ExcluirClientes();
    public Clientes cli = new Clientes(addCli, conCli, ediCli, excCli);

    public AddAssinaturas addAss = new AddAssinaturas();
    public Assinaturas ass = new Assinaturas(addAss);// = new Assinaturas(addAss);

    public RelatoriosDiarioBarbeiro relDiaBarbeiro = new RelatoriosDiarioBarbeiro();
    public RelatoriosDiario relDia = new RelatoriosDiario(relDiaBarbeiro);

    public RelatoriosSemanalBarbeiro relSemBarbeiro = new RelatoriosSemanalBarbeiro();
    public RelatoriosSemanal relSem = new RelatoriosSemanal(relSemBarbeiro);
    public RelatoriosMensalBarbeiro relMenBarbeiro = new RelatoriosMensalBarbeiro();
    public RelatoriosMensal relMen = new RelatoriosMensal(relMenBarbeiro);
    public RelatoriosMes relMes = new RelatoriosMes(relMen);
    public RelatorioAnualBarbeiro relAnuBarbeiro = new RelatorioAnualBarbeiro();
    public RelatoriosAnual relAnu = new RelatoriosAnual(relAnuBarbeiro);
    public Relatorios rel = new Relatorios(relDia, relSem, relMes, relAnu);

    private static JPanel panel;
    private JLabel message;

    protected JPanel rodape;
    protected JLabel whatsapp;
    protected JLabel instagram;
    protected JLabel facebook;

    public int width;
    public int height;

    public Janela() {
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        width = (int) d.getWidth();
        height = (int) d.getHeight();

        frame();
        frame.getContentPane().add(cli);
        frame.getContentPane().add(addCli);
        frame.getContentPane().add(conCli);
        frame.getContentPane().add(ediCli);
        frame.getContentPane().add(excCli);

        frame.getContentPane().add(ass);
        frame.getContentPane().add(addAss);

        frame.getContentPane().add(rel);
        frame.getContentPane().add(relDia);
        frame.getContentPane().add(relDiaBarbeiro);
        frame.getContentPane().add(relSem);
        frame.getContentPane().add(relSemBarbeiro);
        frame.getContentPane().add(relMes);
        frame.getContentPane().add(relMenBarbeiro);
        frame.getContentPane().add(relMen);
        frame.getContentPane().add(relAnu);
        frame.getContentPane().add(relAnuBarbeiro);

        cli.setVisible(false);
        addCli.setVisible(false);
        conCli.setVisible(false);
        ediCli.setVisible(false);
        excCli.setVisible(false);

        ass.setVisible(false);
        addAss.setVisible(false);

        rel.setVisible(false);
        relDia.setVisible(false);
        relDiaBarbeiro.setVisible(false);
        relSem.setVisible(false);
        relSemBarbeiro.setVisible(false);
        relMes.setVisible(false);
        relMen.setVisible(false);
        relMenBarbeiro.setVisible(false);
        relAnu.setVisible(false);
        relAnuBarbeiro.setVisible(false);

        panel();
        fundo();
        logo();
        menu();
        rodape();

        frame.setVisible(true);
    }

    private void frame() {
        frame = new JFrame("Barbearia Navalhas");
        frame.setSize(1366, 768);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private void panel() {
        panel = new JPanel();
        panel.setBounds(45, 182, 1275, 460);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //-- hh:mm");

        message = new JLabel("Bem Vindo ao Sistema da Barbearia Navalhas\n " + dateFormat.format(new Date()));
        message.setBounds(420, 230, 600, 25);
        message.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        panel.add(message);
    }

    private void fundo() {
        fundo = new JLabel();
        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/background.png")));
        fundo.setBounds(0, 0, 1366, 768);
        frame.getContentPane().add(fundo);
    }

    private void logo() {
        logo = new JLabel("");
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/logo.png")));
        logo.setBounds(52, 5, 160, 160);
        frame.getContentPane().add(logo);
    }

    public void menu() {
        menu = new JPanel();
        menu.setBounds(276, 55, 1045, 56);
        menu.setBackground(new Color(34, 34, 34));
        menu.setLayout(null);

        bClientes = new JButton("    Clientes");
        bClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/customer-icon.png")));
        bClientes.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bClientes.setForeground(new Color(255, 255, 255));
        bClientes.setBounds(0, 0, 348, 56);
        bClientes.setContentAreaFilled(false);
        bClientes.setBorderPainted(false);
        bClientes.setFocusable(false);
        bClientes.addActionListener(this);
        menu.add(bClientes);

        bAssinaturas = new JButton("    Assinaturas");
        bAssinaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/signature-icon.png")));
        bAssinaturas.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bAssinaturas.setForeground(new Color(255, 255, 255));
        bAssinaturas.setBounds(348, 0, 348, 56);
        bAssinaturas.setContentAreaFilled(false);
        bAssinaturas.setBorderPainted(false);
        bAssinaturas.setFocusable(false);
        bAssinaturas.addActionListener(this);
        menu.add(bAssinaturas);

        bRelatorios = new JButton("   Relatórios");
        bRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/report-icon.png")));
        bRelatorios.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bRelatorios.setForeground(new Color(255, 255, 255));
        bRelatorios.setBounds(696, 0, 348, 56);
        bRelatorios.setContentAreaFilled(false);
        bRelatorios.setBorderPainted(false);
        bRelatorios.setFocusable(false);
        bRelatorios.addActionListener(this);
        menu.add(bRelatorios);
        frame.getContentPane().add(menu);
    }

    public void rodape() {
        whatsapp = new JLabel();
        whatsapp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/whatsapp-icon.png")));
        whatsapp.setBounds(47, 695, 26, 26);
        frame.getContentPane().add(whatsapp);

        whatsapp = new JLabel("(94) 99129-0504");
        whatsapp.setBounds(88, 689, 140, 19);
        whatsapp.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        whatsapp.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(whatsapp);

        whatsapp = new JLabel("(94) 98146-2634");
        whatsapp.setBounds(88, 708, 140, 19);
        whatsapp.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        whatsapp.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(whatsapp);

        instagram = new JLabel("   Barbearia.Navalhas");
        instagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/instagram-icon.png")));
        instagram.setBounds(496, 695, 220, 27);
        instagram.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        instagram.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(instagram);

        facebook = new JLabel("   @barbearianavalhasparauapebas");
        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/facebook-icon.png")));
        facebook.setBounds(1000, 695, 340, 26);
        facebook.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        facebook.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(facebook);

        rodape = new JPanel();
        rodape.setBounds(0, 678, 1366, 80);
        rodape.setBackground(new Color(34, 34, 34));
        rodape.setLayout(null);
        frame.getContentPane().add(rodape);
    }


    // Metodo para a correta mudanca de paineis
    public static void panelInicio(JPanel j) {
        frame.getContentPane().add(j);
        j.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bClientes) {

            panel.setVisible(false);

            cli.setVisible(true);
            addCli.setVisible(false);
            conCli.setVisible(false);
            ediCli.setVisible(false);
            excCli.setVisible(false);

            ass.setVisible(false);
            addAss.setVisible(false);

            rel.setVisible(false);
            relDia.setVisible(false);
            relDiaBarbeiro.setVisible(false);
            relSem.setVisible(false);
            relSemBarbeiro.setVisible(false);
            relMes.setVisible(false);
            relMenBarbeiro.setVisible(false);
            relAnuBarbeiro.setVisible(false);
            relMen.setVisible(false);
            relMenBarbeiro.setVisible(false);
            relAnu.setVisible(false);

        }

        if (ae.getSource() == bAssinaturas) {

            panel.setVisible(false);

            cli.setVisible(false);
            addCli.setVisible(false);
            conCli.setVisible(false);
            ediCli.setVisible(false);
            excCli.setVisible(false);

            ass.setVisible(true);
            ass.iniciaAssinaturas();
            addAss.setVisible(false);

            rel.setVisible(false);
            relDia.setVisible(false);
            relDiaBarbeiro.setVisible(false);
            relSem.setVisible(false);
            relSemBarbeiro.setVisible(false);
            relMes.setVisible(false);
            relMenBarbeiro.setVisible(false);
            relAnuBarbeiro.setVisible(false);
            relMen.setVisible(false);
            relMenBarbeiro.setVisible(false);
            relAnu.setVisible(false);

        }

        if (ae.getSource() == bRelatorios) {

            panel.setVisible(false);

            cli.setVisible(false);
            addCli.setVisible(false);
            conCli.setVisible(false);
            ediCli.setVisible(false);
            excCli.setVisible(false);

            ass.setVisible(false);
            addAss.setVisible(false);

            rel.setVisible(true);
            relDia.setVisible(false);
            relDiaBarbeiro.setVisible(false);
            relSem.setVisible(false);
            relSemBarbeiro.setVisible(false);
            relMenBarbeiro.setVisible(false);
            relAnuBarbeiro.setVisible(false);
            relMes.setVisible(false);
            relMen.setVisible(false);
            relMenBarbeiro.setVisible(false);
            relAnu.setVisible(false);
        }

    }
    
}