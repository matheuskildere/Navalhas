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
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import cliente.Cliente;
import cliente.ClienteDAO;
import servico.Servico;
import servico.ServicoDAO;

/**
 * Assinaturas
 */
public class Assinaturas extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 7985355862242023300L;
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ServicoDAO servicoDAO = new ServicoDAO();
    private List<Cliente> listaClientes;
    protected Cliente clienteClicado;
    
    private AddAssinaturas addAssinaturas;
    
    private JTextField jPesquisa;

    
    private JPanel nomes;
    private JScrollPane scrollFrame;
    private JPanel historico;
    private JPanel pCards;
    private JPanel card;
    
    private JButton bPesquisa;
    private JButton bNome;
    
    private JLabel lProfilePicture;
    private JLabel lNome;
    private JLabel lQtdServicos;
    private JLabel lQtdServicosGratis;


    public Assinaturas(AddAssinaturas addAssinaturas) {
        this.addAssinaturas = addAssinaturas;
        iniciaAssinaturas();
    }

    protected void iniciaAssinaturas() {
        removeAll();
        setBounds(45, 182, 1275, 460);
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        JPanel description = new JPanel();
        description.setLayout(null);
        description.setBounds(0, 0, 175, 460);
        description.setBackground(new Color(234, 234, 234));
        add(description);

        JLabel customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/signatures-icon.png")));
        customerIcon.setBounds(65, 196, 50, 45);
        description.add(customerIcon);

        jPesquisa = new JTextField("Pesquisa");
        jPesquisa.setBounds(273,64, 384, 48);
        jPesquisa.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        jPesquisa.setForeground(new Color(90, 90, 90));
        jPesquisa.setBackground(new Color(252, 252, 252));
        jPesquisa.setHorizontalAlignment(JTextField.CENTER);
        jPesquisa.setBorder(new LineBorder(new Color(210, 210, 210)));

        add(jPesquisa);

        bPesquisa = new JButton("");
        bPesquisa.setBounds(210 , 64, 64, 48);
        bPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/search-button.png")));
        bPesquisa.setBackground(new Color(234, 234, 234));
        bPesquisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ola "+ jPesquisa.getText());
                acaoBpesquisa();
            }
        });
        add(bPesquisa);

        nomes = new JPanel();
        nomes.setLayout(new BoxLayout(nomes, BoxLayout.Y_AXIS));
        nomes.setBounds(208, 154, 449, 2000);
        nomes.setBackground(new Color(255, 255, 255));

        scrollFrame = new JScrollPane(nomes);
        scrollFrame.setBorder(null);
        scrollFrame.setBackground(new Color(255, 255, 255));
        scrollFrame.getVerticalScrollBar().setBackground(new Color(255, 255, 255));
        scrollFrame.getVerticalScrollBar().setForeground(new Color(0, 0, 0));
        nomes.setAutoscrolls(true);
        scrollFrame.setBounds(208, 154, 449, 305);
        add(scrollFrame);

        JLabel line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/division-line.png")));
        line.setBounds(683, 77, 889, 328);
        add(line);

        historico();

        panelCard();

        cards(clienteClicado);
        
        nomesClientes();

        repaint();
    }


    private void historico(){
        historico = new JPanel();
        historico.removeAll();
        historico.setLayout(null);
        historico.setBounds(564, 0, 683, 170);
        historico.setBackground(new Color(255, 255, 255));
        add(historico);
        
        lerCli();
        lProfilePicture = new JLabel();
        lProfilePicture.setBounds(137, 43, 100, 100);
        lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/picture-customer.png")));
        if (!clienteClicado.getFoto().trim().equals("")){
            lProfilePicture.setIcon(new javax.swing.ImageIcon(clienteClicado.getFoto())); 
        }
        historico.add(lProfilePicture);

        lNome = new JLabel(clienteClicado.getNome().trim());
        lNome.setBounds(250, 43, 500, 30);
        lNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        lNome.setForeground(new Color(47, 47, 47));
        historico.add(lNome);

        lQtdServicos = new JLabel("Quantidade de servicos: "+ clienteClicado.getServicosTotal());
        lQtdServicos.setBounds(250, 77, 500, 26);
        lQtdServicos.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        lQtdServicos.setForeground(new Color(110, 110, 110));
        historico.add(lQtdServicos);

        lQtdServicosGratis = new JLabel("Quantidade de servicos gratis: "+ clienteClicado.getServicosGratis());
        lQtdServicosGratis.setBounds(250, 96, 500, 26);
        lQtdServicosGratis.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        lQtdServicosGratis.setForeground(new Color(110, 110, 110));
        historico.add(lQtdServicosGratis);

    }

    private void panelCard(){
        pCards = new JPanel();
        pCards.setLayout(null);
        pCards.setBounds(700, 170, 550, 320);
        pCards.setBackground(new Color(255, 255, 255));
        add(pCards);
        
        //card add
        card = new JPanel();
        card.setLayout(null);
        card.setBounds(0, 0, 100, 100);
        pCards.add(card);

        JButton addButton = new JButton();
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/add-icon.png")));
        addButton.setBounds(0 , 0,100, 100);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.setBackground(new Color(234, 234, 234));
        addButton.setForeground(new Color(234, 234, 234));
        card.add(addButton);
        addButton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                addAssinaturas.setCliente(clienteClicado);
                setVisible(false);
                addAssinaturas.setVisible(true);
                
            }
        });
    }

    
    private void cards(Cliente clienteCard){
        pCards.removeAll();
        ArrayList<Servico> servicosDoCli = new ArrayList<>();
        int countX = 0;
        int countY = 0;
        
        pCards.add(card);
        if (clienteCard.getServicos() != 0) {
            for (Servico servico : servicoDAO.read()) {
                if (clienteCard.getId() == servico.getIdCli()) {
                    System.out.println(clienteCard.getId() +"==" +servico.getIdCli()+ "data: "+ servico.getData());
                    servicosDoCli.add(servico);
                    
                }
            }

            int servSizer = servicosDoCli.size();
            int cliServ = clienteCard.getServicos();
            for (int i = 0; i < cliServ; i++) {
                if (countX >= 440) {
                    countY = 120;
                    countX = 0;
                }else{
                    countX += 110;
                }
                Cards cards = new Cards();
                pCards.add(cards.cardConfirmado(servicosDoCli.get(servSizer - 1), countX, countY));
                servSizer--;
            }
        }
        pCards.repaint();
    }

    private void lerCli(){
        listaClientes = clienteDAO.read();
        if (listaClientes.size() >0) {
            clienteClicado = listaClientes.get(0);
        }else{
            clienteClicado = new Cliente();
        }
    }

    protected void nomesClientes(){
        nomes.removeAll();
        for (JButton button : buttoes()) {
            nomes.add(button);
        }
        nomes.repaint();
    }

    public List<JButton> buttoes(){
        List<JButton> listaButtons = new ArrayList<>();
        int cont = 1; 
        int heightCount = 0;
        for (Cliente cliente : listaClientes) {
            final Cliente cliente1 = cliente;
            bNome = new JButton(cont+" "+cliente.getNome().trim());
            bNome.setName(cont+" "+cliente.getNome().trim());
            bNome.setBounds(30, 10 + heightCount, 419, 30);
            bNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
            bNome.setForeground(new Color(47, 47, 47));
            bNome.setBackground(new Color(255, 255, 255));
            bNome.setHorizontalAlignment(JTextField.LEFT);
            bNome.setBorderPainted(false);
            bNome.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    lNome.setText(cliente1.getNome().trim());
                    lQtdServicos.setText("Quantidade de servicos: "+ cliente1.getServicos());
                    lQtdServicosGratis.setText("Quantidade de servicos gratis: "+ cliente1.getServicosGratis());
                    lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/picture-customer.png")));
                    if (!cliente1.getFoto().trim().equals("")){
                        lProfilePicture.setIcon(new javax.swing.ImageIcon(cliente1.getFoto())); 
                    }
                    clienteClicado = cliente1;
                    cards(cliente1);
                }
            });
            
            listaButtons.add(bNome);

            heightCount +=30;
            cont++;
        }
        return listaButtons;
    }
    private void acaoBpesquisa(){
        List<Cliente> listaClientes = clienteDAO.read();
        nomes.removeAll();
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.getNome().trim());
            if (jPesquisa.getText().trim().equals(cliente.getNome().trim()) ) {
                System.out.println("achou");
                lNome.setText(cliente.getNome().trim());
                lQtdServicos.setText("Quantidade de servicos: "+ cliente.getServicos());
                lQtdServicosGratis.setText("Quantidade de servicos gratis: "+ cliente.getServicosGratis());
                lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/picture-customer.png")));
                if (!cliente.getFoto().trim().equals("")){
                    lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/profile-picture.png"))); 
                }
            }else{
                System.out.println("else");
                System.out.println("txt"+jPesquisa.getText().trim());
                if(jPesquisa.getText().trim().equals("")){
                    nomesClientes();
                    System.out.println("nothing");
                }else{
                    for (JButton buttonCli : buttoes()) {
                        if (buttonCli.getName().contains(jPesquisa.getText().trim())) {
                            
                            nomes.removeAll();
                            System.out.println("contains: "+buttonCli.getName());
                            nomes.add(buttonCli); 
                            nomes.repaint();
                            repaint();
                        }
                    }
                }
                break;
            }
        }
    }
}