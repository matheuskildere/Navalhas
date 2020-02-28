package ui;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

import relatorio.Relatorio;
import servico.servicoUnico.ServicoUnicoDAO;

/**
 * Relatorios
 */
public class RelatoriosDiario extends JPanel implements ActionListener {

    private JPanel description;
    private JLabel customerIcon;

    private JLabel line;
    private JLabel lContador;
    private JLabel lServico;
    private JLabel lValor;
    private JLabel label;

    private Relatorio relatorioDAO = new Relatorio();

    private JButton bBarbeiro1;
    private JButton bBarbeiro2;
    private JButton bBarbeiro3;
    private JButton bBarbeiro4;

    RelatoriosDiarioBarbeiro relDiaBarbeiro;

    public RelatoriosDiario(RelatoriosDiarioBarbeiro relDiaBarbeiro) {
        this.relDiaBarbeiro = relDiaBarbeiro;
        relatoriosDiarios();
    }

    protected void relatoriosDiarios(){
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
        Object[] corte = relatorioDAO.nServico(1, dataString("dd/MM/yyyy"));
        lContador = new JLabel(""+corte[0]);
        lContador.setBounds(210, 70, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Corte");
        lServico.setBounds(270, 70, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+corte[1]);
        lValor.setBounds(465, 70, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Barba

        Object[] barba = relatorioDAO.nServico(0, dataString("dd/MM/yyyy"));
        lContador = new JLabel(""+barba[0]);
        lContador.setBounds(210, 110, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Barba");
        lServico.setBounds(270, 110, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+barba[1]);
        lValor.setBounds(465, 110, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Sombrancelha
        Object[] sobrancelha = relatorioDAO.nServico(7, dataString("dd/MM/yyyy"));

        lContador = new JLabel(""+sobrancelha[0]);
        lContador.setBounds(210, 150, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Sombrancelha");
        lServico.setBounds(270, 150, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+sobrancelha[1]);
        lValor.setBounds(465, 150, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Coloracao
        Object[] coloracao = relatorioDAO.nServico(2, dataString("dd/MM/yyyy"));

        lContador = new JLabel(""+coloracao[0]);
        lContador.setBounds(210, 190, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Coloração");
        lServico.setBounds(270, 190, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+coloracao[1]);
        lValor.setBounds(465, 190, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Pigmentacao em barba
        Object[] pigmentacao = relatorioDAO.nServico(5, dataString("dd/MM/yyyy"));

        lContador = new JLabel(""+pigmentacao[0]);
        lContador.setBounds(210, 230, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Pigmentação em B.");
        lServico.setBounds(270, 230, 180, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+pigmentacao[1]);
        lValor.setBounds(465, 230, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Selagem

        Object[] selagem = relatorioDAO.nServico(6, dataString("dd/MM/yyyy"));
        lContador = new JLabel(""+selagem[0]);
        lContador.setBounds(210, 270, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Selagem");
        lServico.setBounds(270, 270, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+selagem[1]);
        lValor.setBounds(465, 270, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Relaxamento

        Object[] relaxamento = relatorioDAO.nServico(4, dataString("dd/MM/yyyy"));
        lContador = new JLabel(""+relaxamento[0]);
        lContador.setBounds(210, 310, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Relaxamento");
        lServico.setBounds(270, 310, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+relaxamento[1]);
        lValor.setBounds(465, 310, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Luzes

        Object[] luzes = relatorioDAO.nServico(3, dataString("dd/MM/yyyy"));
        lContador = new JLabel(""+luzes[0]);
        lContador.setBounds(210, 350, 50, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Luzes");
        lServico.setBounds(270, 350, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+luzes[1]);
        lValor.setBounds(465, 350, 100, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
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

        Object[] hugo = relatorioDAO.nServicoBarbeiro(0, dataString("dd/MM/yyyy"));
        bBarbeiro1 = new JButton("Hugo");
        bBarbeiro1.setBounds(630, 70, 120, 24);
        bBarbeiro1.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro1.setForeground(new Color(110, 110, 110));
        bBarbeiro1.setBackground(new Color(255, 255, 255));
        bBarbeiro1.addActionListener(this);
        add(bBarbeiro1);

        lContador = new JLabel(""+ hugo[0]);
        lContador.setBounds(830, 70, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " + hugo[1]);
        lContador.setBounds(1000, 70, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " +(double) hugo[1] *0.5);
        lContador.setBounds(1160, 70, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 02
        Object[] mario = relatorioDAO.nServicoBarbeiro(1, dataString("dd/MM/yyyy"));
        bBarbeiro2 = new JButton("Mário");
        bBarbeiro2.setBounds(630, 110, 120, 24);
        bBarbeiro2.setBackground(new Color(255, 255, 255));
        bBarbeiro2.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro2.setForeground(new Color(110, 110, 110));
        bBarbeiro2.addActionListener(this);
        add(bBarbeiro2);

        lContador = new JLabel(""+ mario[0]);
        lContador.setBounds(830, 110, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " +(double) mario[1]);
        lContador.setBounds(1000, 110, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " +(double) mario[1] *0.5);
        lContador.setBounds(1160, 110, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 03
        Object[] raimundo = relatorioDAO.nServicoBarbeiro(2, dataString("dd/MM/yyyy"));
        bBarbeiro3 = new JButton("Raimundo");
        bBarbeiro3.setBackground(new Color(255, 255, 255));
        bBarbeiro3.setBounds(630, 150, 120, 24);
        bBarbeiro3.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        bBarbeiro3.setForeground(new Color(110, 110, 110));
        bBarbeiro3.addActionListener(this);
        add(bBarbeiro3);

        lContador = new JLabel(""+ raimundo[0]);
        lContador.setBounds(830, 150, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " +(double) raimundo[1]);
        lContador.setBounds(1000, 150, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ " +(double) raimundo[1] *0.5);
        lContador.setBounds(1160, 150, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        // Barbeiro 04

        Object[] sergio = relatorioDAO.nServicoBarbeiro(3, dataString("dd/MM/yyyy"));
        bBarbeiro4 = new JButton("Sérgio");
        bBarbeiro4.setBounds(630, 190, 120, 24);
        bBarbeiro4.setBackground(new Color(255, 255, 255));
        bBarbeiro4.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        bBarbeiro4.setForeground(new Color(110, 110, 110));
        bBarbeiro4.addActionListener(this);
        add(bBarbeiro4);

        lContador = new JLabel(""+sergio[0]);
        lContador.setBounds(830, 190, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ "+(double) sergio[1]);
        lContador.setBounds(1000, 190, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lContador = new JLabel("R$ "+(double) sergio[1] *0.5);
        lContador.setBounds(1160, 190, 100, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        //
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

        label = new JLabel("R$ "+relatorioDAO.somaValorCartao(dataString("dd/MM/yyyy")));
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

        label = new JLabel("R$ "+relatorioDAO.somaValorDinheiro(dataString("dd/MM/yyyy")));
        label.setBounds(835, 370, 400, 55);
        label.setForeground(new Color(80, 80, 80));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        add(label);

        label = new JLabel("=");
        label.setBounds(1000, 360, 18, 18);
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        label.setForeground(new Color(80, 80, 80));
        add(label);

        label = new JLabel("R$ "+relatorioDAO.somaValorTotal(dataString("dd/MM/yyyy")));
        label.setBounds(1050, 360, 400, 22);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);
        repaint();
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bBarbeiro1) {

            setVisible(false);
            relDiaBarbeiro.setVisible(true);
        }


        if (ae.getSource() == bBarbeiro2) {

            setVisible(false);
            relDiaBarbeiro.setVisible(true);
        }


        if (ae.getSource() == bBarbeiro3) {

            setVisible(false);
            relDiaBarbeiro.setVisible(true);
        }


        if (ae.getSource() == bBarbeiro4) {

            setVisible(false);
            relDiaBarbeiro.setVisible(true);
        }
    }
    private void relatorio(){
        Object[] corte = relatorioDAO.nServico(1, dataString("dd/MM/yyyy"));
        Object[] barba = relatorioDAO.nServico(0, dataString("dd/MM/yyyy"));
        Object[] sobrancelha = relatorioDAO.nServico(7, dataString("dd/MM/yyyy"));
        Object[] coloracao = relatorioDAO.nServico(2, dataString("dd/MM/yyyy"));
        Object[] pigmentacao = relatorioDAO.nServico(5, dataString("dd/MM/yyyy"));
        //Object[] pigmentacao = relatorioDAO.nServico(5, dataString("dd/MM/yyyy"));
    }

    private String dataString(String formato){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat(formato); //"dd/MM/yyyy"
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        return formatador.format(calendar.getTime());
    }
}