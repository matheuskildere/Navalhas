package ui;

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
public class RelatorioAnualBarbeiro extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 7814798060849246968L;
    private JPanel description;
    private JLabel customerIcon;

    private JLabel line;
    private JLabel lContador;
    private JLabel lServico;
    private JLabel lValor;
    private JLabel label;

    private Relatorio relatorioDAO = new Relatorio();
    private int idBarbeiro = 0;
    private String nomeBarbeiro = "Hugo";

    public RelatorioAnualBarbeiro() {
        relatorioAnualBarbeiro();
    }

    protected void relatorioAnualBarbeiro(){
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

        Object[] corte = relatorioDAO.nServiBarb(1,idBarbeiro, dataString("yyyy"));
        lContador = new JLabel(""+corte[0]);
        lContador.setBounds(210, 90, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Corte");
        lServico.setBounds(300, 90, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+corte[1]);
        lValor.setBounds(465, 90, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Barba

        Object[] barba = relatorioDAO.nServiBarb(0,idBarbeiro, dataString("yyyy"));
        lContador = new JLabel(""+barba[0]);
        lContador.setBounds(210, 135, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Barba");
        lServico.setBounds(300, 135, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+barba[1]);
        lValor.setBounds(465, 135, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Sombrancelha

        Object[] somb = relatorioDAO.nServiBarb(7,idBarbeiro, dataString("yyyy"));
        lContador = new JLabel(""+somb[0]);
        lContador.setBounds(210, 180, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Sombrancelha");
        lServico.setBounds(300, 180, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+somb[1]);
        lValor.setBounds(465, 180, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Coloracao

        Object[] colo = relatorioDAO.nServiBarb(2,idBarbeiro, dataString("yyyy"));
        lContador = new JLabel(""+colo[0]);
        lContador.setBounds(210, 225, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Coloração");
        lServico.setBounds(300, 225, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+colo[1]);
        lValor.setBounds(465, 225, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Pigmentacao em barba

        Object[] pig = relatorioDAO.nServiBarb(5,idBarbeiro, dataString("yyyy"));
        lContador = new JLabel(""+pig[0]);
        lContador.setBounds(210, 270, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Pigmentação");
        lServico.setBounds(300, 270, 180, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+pig[1]);
        lValor.setBounds(465, 270, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Selagem

        Object[] sela = relatorioDAO.nServiBarb(6,idBarbeiro, dataString("yyyy"));
        lContador = new JLabel(""+sela[0]);
        lContador.setBounds(210, 315, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Selagem");
        lServico.setBounds(300, 315, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+sela[1]);
        lValor.setBounds(465, 315, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Relaxamento

        Object[] rela = relatorioDAO.nServiBarb(4,idBarbeiro, dataString("yyyy"));
        lContador = new JLabel(""+rela[0]);
        lContador.setBounds(210, 360, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Relaxamento");
        lServico.setBounds(300, 360, 150, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+rela[1]);
        lValor.setBounds(465, 360, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        // Luzes

        Object[] luz = relatorioDAO.nServiBarb(3,idBarbeiro, dataString("yyyy"));
        lContador = new JLabel(""+luz[0]);
        lContador.setBounds(210, 405, 80, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lServico = new JLabel("Luzes");
        lServico.setBounds(300, 405, 100, 24);
        lServico.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lServico.setForeground(new Color(110, 110, 110));
        add(lServico);

        lValor = new JLabel("R$ "+luz[1]);
        lValor.setBounds(465, 405, 200, 24);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        //

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon("./src/main/java/ui/icons/line1.png"));
        line.setBounds(600, 5, 889, 450);
        add(line);

        label = new JLabel(nomeBarbeiro);
        label.setBounds(630, 120, 150, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        add(label);

        int quantServicos = (int) corte[0] +(int) barba[0] + (int)somb[0] + (int)colo[0] + (int)pig[0]+ (int)sela[0]+ (int)rela[0]+ (int)luz[0];
        label = new JLabel("Quantidade de serviços: "+quantServicos);
        label.setBounds(630, 180, 300, 55);
        label.setForeground(new Color(115, 115, 115));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        double valorServicos = (double) corte[1] +(double) barba[1] + (double)somb[1] + (double)colo[1] + (double)pig[1]+ (double)sela[1]+ (double)rela[1]+ (double)luz[1];
        label = new JLabel("Valor total: R$ "+valorServicos);
        label.setBounds(630, 230, 300, 55);
        label.setForeground(new Color(115, 115, 115));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

        label = new JLabel("Comissão: R$ "+ (valorServicos *0.5));
        label.setBounds(630, 280, 300, 55);
        label.setForeground(new Color(47, 47, 47));
        label.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        add(label);

    }

    public void actionPerformed(ActionEvent ae) {

    }

    protected void barbeiro(int barbeiro){
        idBarbeiro = barbeiro;
        if (barbeiro == 0) {
            nomeBarbeiro = "Hugo";
        } else if(barbeiro == 1){
            nomeBarbeiro = "Mário";
        }else if(barbeiro == 2){
            nomeBarbeiro = "Raimundo";
        }else if(barbeiro == 3){
            nomeBarbeiro = "Sérgio";
        }
        relatorioAnualBarbeiro();
    }

    private String dataString(String formato){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat(formato); //"dd/MM/yyyy"
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        return formatador.format(calendar.getTime());
    }

}