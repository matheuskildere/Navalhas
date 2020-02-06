package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Customer Screen
 */
public class Assinaturas extends JPanel implements ActionListener {

    private JPanel description;
    private JLabel customerIcon;

    private JTextField tPesquisa;
    private JButton bPesquisa;

    private JLabel lNome;
    private JLabel lContador;

    private JLabel line;

    private JPanel historico;

    private JLabel lProfilePicture;
    private JLabel lQtdServicos;
    private JLabel lQtdServicosGratis;

    private JPanel jServicoExecutado;
    private JButton jAddServicoExecutado;

    private JLabel statusIcon;
    private JLabel dateIcon;
    private JLabel date;

    private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public Assinaturas() {

        setBounds(WIDTH / 30, WIDTH / 5, WIDTH - WIDTH / 15, WIDTH / 4);
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        description = new JPanel();
        description.setLayout(null);
        description.setBounds(0, 0, WIDTH / 8, WIDTH / 4);
        description.setBackground(new Color(234, 234, 234));
        add(description);

        customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-icon.png")));
        customerIcon.setBounds(WIDTH / 20, WIDTH / 11, 100, 100);
        description.add(customerIcon);

        tPesquisa = new JTextField("Pesquisa");
        tPesquisa.setBounds(WIDTH / 5, HEIGHT / 12, 384, 48);
        tPesquisa.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tPesquisa.setForeground(new Color(90, 90, 90));
        tPesquisa.setBackground(new Color(252, 252, 252));
        tPesquisa.setHorizontalAlignment(JTextField.CENTER);
        tPesquisa.setBorder(new LineBorder(new Color(210, 210, 210)));
        add(tPesquisa);

        bPesquisa = new JButton("");
        bPesquisa.setBounds(WIDTH / 6, HEIGHT / 12, 65, 48);
        bPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/search-button.png")));
        bPesquisa.setBackground(new Color(234, 234, 234));
        bPesquisa.addActionListener(this);
        add(bPesquisa);

        lContador = new JLabel("09");
        lContador.setBounds(WIDTH / 6, HEIGHT / 5, 500, 24);
        lContador.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        lContador.setForeground(new Color(110, 110, 110));
        add(lContador);

        lNome = new JLabel("Vinicius Correia Martins");
        lNome.setBounds(WIDTH / 5, HEIGHT / 5, 500, 24);
        lNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        lNome.setForeground(new Color(47, 47, 47));
        add(lNome);

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/division-line.png")));
        line.setBounds(WIDTH / 3 + 200, HEIGHT / 20, 889, 328);
        add(line);

        historico = new JPanel();
        historico.setLayout(null);
        historico.setBounds(WIDTH / 2 - 119, 0, WIDTH / 2, WIDTH / 4);
        historico.setBackground(new Color(255, 255, 255));
        add(historico);

        lProfilePicture = new JLabel();
        lProfilePicture.setBounds(WIDTH / 20 - 20, HEIGHT / 18, 100, 100);
        lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/profile-picture.png")));
        historico.add(lProfilePicture);

        lNome = new JLabel("Vinicius Correia Martins");
        lNome.setBounds(WIDTH / 9, HEIGHT / 18, 500, 25);
        lNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        lNome.setForeground(new Color(47, 47, 47));
        historico.add(lNome);

        lQtdServicos = new JLabel("Quantidade de serviรงos: 29");
        lQtdServicos.setBounds(WIDTH / 9, HEIGHT / 11, 500, 26);
        lQtdServicos.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        lQtdServicos.setForeground(new Color(110, 110, 110));
        historico.add(lQtdServicos);

        lQtdServicosGratis = new JLabel("Quantidade de serviรงos grรกtis: 02");
        lQtdServicosGratis.setBounds(WIDTH / 9, HEIGHT / 9, 500, 26);
        lQtdServicosGratis.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        lQtdServicosGratis.setForeground(new Color(110, 110, 110));
        historico.add(lQtdServicosGratis);

        jServicoExecutado = new JPanel();
        jServicoExecutado.setLayout(null);
        jServicoExecutado.setBackground(new Color(245, 245, 245));
        jServicoExecutado.setBounds(WIDTH / 20 - 20, HEIGHT / 4 - 20, 150, 150);
        
        statusIcon = new JLabel();
        statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/confirm-icon.png")));
        statusIcon.setBounds(WIDTH-WIDTH + 115 , HEIGHT-HEIGHT + 15 , 22, 22);
        jServicoExecutado.add(statusIcon);

        dateIcon = new JLabel();
        dateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/calendar-icon.png")));
        dateIcon.setBounds(WIDTH-WIDTH + 65 , HEIGHT-HEIGHT + 30 , 25, 25);
        jServicoExecutado.add(dateIcon);

        date = new JLabel("02/01/2020");
        date.setBounds(WIDTH-WIDTH + 30 , HEIGHT-HEIGHT + 80 , 200, 25);
        date.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        jServicoExecutado.add(date);
        historico.add(jServicoExecutado);

        /** Outro quadrado */

        jServicoExecutado = new JPanel();
        jServicoExecutado.setLayout(null);
        jServicoExecutado.setBounds(WIDTH / 20 + 140, HEIGHT / 4 - 20, 150, 150);
        jServicoExecutado.setBackground(new Color(245, 245, 245));
        
        statusIcon = new JLabel();
        statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/undo-icon.png")));
        statusIcon.setBounds(WIDTH-WIDTH + 115 , HEIGHT-HEIGHT + 15 , 22, 22);
        jServicoExecutado.add(statusIcon);

        dateIcon = new JLabel();
        dateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/calendar-icon.png")));
        dateIcon.setBounds(WIDTH-WIDTH + 65 , HEIGHT-HEIGHT + 30 , 25, 25);
        jServicoExecutado.add(dateIcon);

        date = new JLabel("16/01/2020");
        date.setBounds(WIDTH-WIDTH + 30 , HEIGHT-HEIGHT + 80 , 200, 25);
        date.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        jServicoExecutado.add(date);
        historico.add(jServicoExecutado);

        /** Quadrado de adicionar */

        jAddServicoExecutado = new JButton();
        jAddServicoExecutado.setLayout(null);
        jAddServicoExecutado.setBounds(WIDTH / 20 + 300, HEIGHT / 4 - 20, 150, 150);
        
        statusIcon = new JLabel();
        statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/add-icon.png")));
        statusIcon.setBounds(WIDTH-WIDTH + 57 , HEIGHT-HEIGHT + 45 , 60, 60);
        jAddServicoExecutado.add(statusIcon);

        historico.add(jAddServicoExecutado);

    }

    public void actionPerformed(ActionEvent ae) {

    }

}
