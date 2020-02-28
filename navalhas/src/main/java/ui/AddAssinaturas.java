package ui;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import barbeiros.Barbeiro;
import cliente.Cliente;
import cliente.ClienteDAO;
import servico.Servico;
import servico.ServicoDAO;
import servico.servicoUnico.ServicoUnico;
import servico.servicoUnico.ServicoUnicoDAO;
import servico.servicoUnico.trabalho.Trabalho;

/**
 * Customer Screen
 */
public class AddAssinaturas extends JPanel implements ActionListener {

    private JPanel description;
    private JLabel customerIcon;

    private JLabel lNome;
    private JLabel lProfilePicture;
    private JLabel lData;

    private JLabel tabela;
    private JLabel total;

    private JButton bAddIcon;
    private JButton bAddIcon1;
    private JButton bAddIcon2;
    private JButton bAddIcon3;
    private JButton bAddIcon4;
    private JButton bAddIcon5;
    private JButton bAddIcon6;
    private JButton bAddIcon7;
    private JButton bAddIcon8;

    private JLabel lDesc;
    private JLabel lValor;
    
    private JTextField tValorBarba;
    private JTextField tValorCorte;
    private JTextField tValorSombrancelha;
    private JTextField tValorColoracao;
    private JTextField tValorPigmentacao;
    private JTextField tValorSelagem;
    private JTextField tValorRelaxamento;
    private JTextField tValorLuzes;

    private JLabel lBarbeiro;

    private JCheckBox barb1;
    private JCheckBox barb2;
    private JCheckBox barb3;
    private JCheckBox barb4;

    private JLabel lFormaPagamento;
    private JLabel lValorTotal;
    
    private JCheckBox dinheiro;
    private JCheckBox cartao;

    private JButton bCancelar;
    private JButton bConfirmar;
    private Cliente cliente = new Cliente();
    

    public AddAssinaturas(){
        addAssinaturas();
    }

    private void addAssinaturas() {
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
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-icon.png")));
        customerIcon.setBounds(65, 196, 50, 45);
        description.add(customerIcon);

        lProfilePicture = new JLabel();
        lProfilePicture.setBounds(230, 5, 100, 100);
        lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/picture-customer.png")));
        if (!cliente.getFoto().trim().equals("")){
            lProfilePicture.setIcon(new javax.swing.ImageIcon(cliente.getFoto())); 
        }add(lProfilePicture);

        lNome = new JLabel(cliente.getNome().trim());
        lNome.setBounds(340, 35, 500, 25);
        lNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lNome.setForeground(new Color(47, 47, 47));
        add(lNome);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        lData = new JLabel(dateFormat.format(new Date()));
        lData.setBounds(340, 60, 300, 25);
        lData.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        lData.setForeground(new Color(110, 110, 110));
        add(lData);

        tabela = new JLabel();
        tabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-table.png")));
        tabela.setBounds(230, 110, 450, 350);
        add(tabela);

        total = new JLabel("VALOR");
        total.setBounds(605, 90, 100, 21);
        total.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
        total.setForeground(new Color(110, 110, 110));
        add(total);

        // Corte

        bAddIcon1 = new JButton();
        bAddIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon1.setBounds(230, 130, 22,22);
        bAddIcon1.setContentAreaFilled(false);
        bAddIcon1.setBorderPainted(false);
        bAddIcon1.setFocusable(false);
        bAddIcon1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (bAddIcon1.getIcon().toString().contains("signatures-add-icon.png")) {
                    bAddIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-remove-icon.png")));
                    tValorCorte.setEnabled(true);
                }else {
                    bAddIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
                    tValorCorte.setEnabled(false);
                }
            }
        });
        add(bAddIcon1);

        lDesc = new JLabel("Corte");
        lDesc.setBounds(270, 130, 500, 25);
        lDesc.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lDesc.setForeground(new Color(110, 110, 110));
        add(lDesc);

        tValorCorte = new JTextField("");
        tValorCorte.setBounds(581, 118, 90, 45);
        tValorCorte.setForeground(new Color(90, 90, 90));
        tValorCorte.setBackground(new Color(252, 252, 252));
        tValorCorte.setHorizontalAlignment(JTextField.CENTER);
        tValorCorte.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        tValorCorte.setEnabled(false);
        tValorCorte.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            //faz alguma coisa quando um texto for inserido.
            valor();
            }
            
            public void removeUpdate(DocumentEvent e) {
                        //faz alguma coisa quando um texto for removido.
            }
            
            public void changedUpdate(DocumentEvent e) {} //usado em style document.
            });
        add(tValorCorte);

        // Barba

        bAddIcon2 = new JButton();
        bAddIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon2.setBounds(230, 170, 22, 22);
        bAddIcon2.setContentAreaFilled(false);
        bAddIcon2.setBorderPainted(false);
        bAddIcon2.setFocusable(false);
        bAddIcon2.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (bAddIcon2.getIcon().toString().contains("signatures-add-icon.png")) {
                    bAddIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-remove-icon.png")));
                    tValorBarba.setEnabled(true);
                }else {
                    bAddIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
                    tValorBarba.setEnabled(false);
                }
            }
        });
        add(bAddIcon2);

        lDesc = new JLabel("Barba");
        lDesc.setBounds(270, 171, 500, 25);
        lDesc.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lDesc.setForeground(new Color(110, 110, 110));
        add(lDesc);

        tValorBarba = new JTextField();
        tValorBarba.setBounds(581, 161, 90, 45);
        tValorBarba.setHorizontalAlignment(JTextField.CENTER);
        tValorBarba.setForeground(new Color(90, 90, 90));
        tValorBarba.setBackground(new Color(252, 252, 252));
        tValorBarba.setHorizontalAlignment(JTextField.CENTER);
        tValorBarba.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        tValorBarba.setEnabled(false);
        tValorBarba.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            valor();
            }
            
            public void removeUpdate(DocumentEvent e) {
                        //faz alguma coisa quando um texto for removido.
            }
            
            public void changedUpdate(DocumentEvent e) {} //usado em style document.
            });
        add(tValorBarba);

        // Sombrancelha

        bAddIcon3 = new JButton();
        bAddIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon3.setBounds(230, 213, 22, 22);
        bAddIcon3.setContentAreaFilled(false);
        bAddIcon3.setBorderPainted(false);
        bAddIcon3.setFocusable(false);
        bAddIcon3.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (bAddIcon3.getIcon().toString().contains("signatures-add-icon.png")) {
                    tValorSombrancelha.setEnabled(true);
                    bAddIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-remove-icon.png")));
                }else {
                    tValorSombrancelha.setEnabled(false);
                    bAddIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
                }
            }
        });
        add(bAddIcon3);

        lDesc = new JLabel("Sombrancelha");
        lDesc.setBounds(270, 213, 500, 25);
        lDesc.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lDesc.setForeground(new Color(110, 110, 110));
        add(lDesc);

        tValorSombrancelha = new JTextField();
        tValorSombrancelha.setBounds(581, 202, 90, 45);
        tValorSombrancelha.setHorizontalAlignment(JTextField.CENTER);
        tValorSombrancelha.setForeground(new Color(90, 90, 90));
        tValorSombrancelha.setBackground(new Color(252, 252, 252));
        tValorSombrancelha.setHorizontalAlignment(JTextField.CENTER);
        tValorSombrancelha.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        tValorSombrancelha.setEnabled(false);
        add(tValorSombrancelha);
    
        // Coloracao

        bAddIcon4 = new JButton();
        bAddIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon4.setBounds(230, 254, 22, 22);
        bAddIcon4.setContentAreaFilled(false);
        bAddIcon4.setBorderPainted(false);
        bAddIcon4.setFocusable(false);
        bAddIcon4.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (bAddIcon4.getIcon().toString().contains("signatures-add-icon.png")) {
                    bAddIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-remove-icon.png")));
                    tValorColoracao.setEnabled(true);
                }else {
                    bAddIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
                    tValorColoracao.setEnabled(false);
                }
            }
        });
        add(bAddIcon4);

        lDesc = new JLabel("Coloracao");
        lDesc.setBounds(270, 254, 500, 25);
        lDesc.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lDesc.setForeground(new Color(110, 110, 110));
        add(lDesc);

        tValorColoracao = new JTextField();
        tValorColoracao.setBounds(581, 243, 90, 45);
        tValorColoracao.setHorizontalAlignment(JTextField.CENTER);
        tValorColoracao.setForeground(new Color(90, 90, 90));
        tValorColoracao.setBackground(new Color(252, 252, 252));
        tValorColoracao.setEnabled(false);
        tValorColoracao.setHorizontalAlignment(JTextField.CENTER);
        tValorColoracao.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        add(tValorColoracao);

        // Pigmentacao em barba

        bAddIcon5 = new JButton();
        bAddIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon5.setBounds(230, 295, 22, 22);
        bAddIcon5.setContentAreaFilled(false);
        bAddIcon5.setBorderPainted(false);
        bAddIcon5.setFocusable(false);
        bAddIcon5.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (bAddIcon5.getIcon().toString().contains("signatures-add-icon.png")) {
                    tValorPigmentacao.setEnabled(true);
                    bAddIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-remove-icon.png")));
                }else {
                    tValorPigmentacao.setEnabled(false);
                    bAddIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
                }
            }
        });
        add(bAddIcon5);
 
        lDesc = new JLabel("Pigmentacao em barba");
        lDesc.setBounds(270, 295, 500, 25);
        lDesc.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lDesc.setForeground(new Color(110, 110, 110));
        add(lDesc);

        tValorPigmentacao = new JTextField();
        tValorPigmentacao.setBounds(581, 287, 90, 44);
        tValorPigmentacao.setHorizontalAlignment(JTextField.CENTER);
        tValorPigmentacao.setForeground(new Color(90, 90, 90));
        tValorPigmentacao.setBackground(new Color(252, 252, 252));
        tValorPigmentacao.setHorizontalAlignment(JTextField.CENTER);
        tValorPigmentacao.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        tValorPigmentacao.setEnabled(false);
        add(tValorPigmentacao);

        // Selagem

        bAddIcon6 = new JButton();
        bAddIcon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon6.setBounds(230, 335, 22, 22);
        bAddIcon6.setContentAreaFilled(false);
        bAddIcon6.setBorderPainted(false);
        bAddIcon6.setFocusable(false);
        bAddIcon6.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (bAddIcon6.getIcon().toString().contains("signatures-add-icon.png")) {
                    bAddIcon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-remove-icon.png")));
                    tValorSelagem.setEnabled(true);
                }else {
                    bAddIcon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
                    tValorSelagem.setEnabled(false);
                }
            }
        });
        add(bAddIcon6);

        lDesc = new JLabel("Selagem");
        lDesc.setBounds(270, 335, 500, 25);
        lDesc.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lDesc.setForeground(new Color(110, 110, 110));
        add(lDesc);

        tValorSelagem = new JTextField();
        tValorSelagem.setBounds(581, 325, 90, 43);
        tValorSelagem.setHorizontalAlignment(JTextField.CENTER);
        tValorSelagem.setForeground(new Color(90, 90, 90));
        tValorSelagem.setBackground(new Color(252, 252, 252));
        tValorSelagem.setHorizontalAlignment(JTextField.CENTER);
        tValorSelagem.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        tValorSelagem.setEnabled(false);
        add(tValorSelagem);


        // Relaxamento

        bAddIcon7 = new JButton();
        bAddIcon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon7.setBounds(230, 378, 22, 22);
        bAddIcon7.setContentAreaFilled(false);
        bAddIcon7.setBorderPainted(false);
        bAddIcon7.setFocusable(false);
        bAddIcon7.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (bAddIcon7.getIcon().toString().contains("signatures-add-icon.png")) {
                    bAddIcon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-remove-icon.png")));
                    tValorRelaxamento.setEnabled(true);
                }else {
                    bAddIcon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
                    tValorRelaxamento.setEnabled(false);
                }
            }
        });
        add(bAddIcon7);

        lDesc = new JLabel("Relaxamento");
        lDesc.setBounds(270, 376, 500, 25);
        lDesc.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lDesc.setForeground(new Color(110, 110, 110));
        add(lDesc);

        tValorRelaxamento = new JTextField();
        tValorRelaxamento.setBounds(581, 367, 90, 45);
        tValorRelaxamento.setHorizontalAlignment(JTextField.CENTER);
        tValorRelaxamento.setForeground(new Color(90, 90, 90));
        tValorRelaxamento.setBackground(new Color(252, 252, 252));
        tValorRelaxamento.setHorizontalAlignment(JTextField.CENTER);
        tValorRelaxamento.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        tValorRelaxamento.setEnabled(false);
        add(tValorRelaxamento);

        // Luzes

        bAddIcon8 = new JButton();
        bAddIcon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon8.setBounds(230, 420, 22, 22);
        bAddIcon8.setContentAreaFilled(false);
        bAddIcon8.setBorderPainted(false);
        bAddIcon8.setFocusable(false);
        bAddIcon8.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (bAddIcon8.getIcon().toString().contains("signatures-add-icon.png")) {
                    bAddIcon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-remove-icon.png")));
                    tValorLuzes.setEnabled(true);
                }else {
                    bAddIcon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
                    tValorLuzes.setEnabled(false);
                }
            }
        });
        add(bAddIcon8);

        lDesc = new JLabel("Luzes");
        lDesc.setBounds(270, 420, 500, 25);
        lDesc.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lDesc.setForeground(new Color(110, 110, 110));
        add(lDesc);

        tValorLuzes = new JTextField();
        tValorLuzes.setBounds(581, 411, 90, 45);
        tValorLuzes.setHorizontalAlignment(JTextField.CENTER);
        tValorLuzes.setForeground(new Color(90, 90, 90));
        tValorLuzes.setBackground(new Color(252, 252, 252));
        tValorLuzes.setHorizontalAlignment(JTextField.CENTER);
        tValorLuzes.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        tValorLuzes.setEnabled(false);
        add(tValorLuzes);


        lDesc = new JLabel("Barba");
        lDesc.setBounds(270, 171, 500, 25);
        lDesc.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        lDesc.setForeground(new Color(110, 110, 110));
        add(lDesc);

        lValor = new JLabel("-");
        lValor.setBounds(625, 171, 20, 21);
        lValor.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        lValor.setForeground(new Color(110, 110, 110));
        add(lValor);

        lBarbeiro = new JLabel("Barbeiro");
        lBarbeiro.setBounds(780, 90, 120, 21);
        lBarbeiro.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lBarbeiro.setForeground(new Color(47, 47, 47));
        add(lBarbeiro);

        barb1 = new JCheckBox(" Mário");
        barb1.setBounds(780, 140, 180, 22);
        barb1.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        barb1.setForeground(new Color(110, 110, 110));
        barb1.setBackground(new Color(255, 255, 255));
        barb1.addActionListener(this);
        add(barb1);

        barb2 = new JCheckBox(" Raimundo");
        barb2.setBounds(780, 180, 180, 22);
        barb2.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        barb2.setForeground(new Color(110, 110, 110));
        barb2.setBackground(new Color(255, 255, 255));
        barb2.addActionListener(this);
        add(barb2);

        barb3 = new JCheckBox(" Hugo");
        barb3.setBounds(980, 140, 180, 22);
        barb3.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        barb3.setForeground(new Color(110, 110, 110));
        barb3.setBackground(new Color(255, 255, 255));
        barb3.addActionListener(this);
        add(barb3);

        barb4 = new JCheckBox(" Sérgio");
        barb4.setBounds(980, 180, 180, 22);
        barb4.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        barb4.setForeground(new Color(110, 110, 110));
        barb4.setBackground(new Color(255, 255, 255));
        barb4.addActionListener(this);
        add(barb4);


        lFormaPagamento = new JLabel("Forma de pagamento");
        lFormaPagamento.setBounds(780, 250, 250, 21);
        lFormaPagamento.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lFormaPagamento.setForeground(new Color(47, 47, 47));
        add(lFormaPagamento);

        dinheiro = new JCheckBox(" Dinheiro");
        dinheiro.setBounds(780, 300, 180, 22);
        dinheiro.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        dinheiro.setForeground(new Color(110, 110, 110));
        dinheiro.setBackground(new Color(255, 255, 255));
        dinheiro.addActionListener(this);
        add(dinheiro);

        cartao = new JCheckBox(" Cartão");
        cartao.setBounds(980, 300, 180, 22);
        cartao.setFont(new Font("Helvetica Neue", Font.PLAIN, 19));
        cartao.setForeground(new Color(110, 110, 110));
        cartao.setBackground(new Color(255, 255, 255));
        cartao.addActionListener(this);
        add(cartao);

        
        lValorTotal = new JLabel("Valor total: R$ " + valor);
        lValorTotal.setBounds(780, 350, 250, 21);
        lValorTotal.setFont(new Font("Helvetica Neue", Font.PLAIN, 21));
        lValorTotal.setForeground(new Color(47, 47, 47));
        add(lValorTotal);

        bCancelar = new JButton();
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/cancel-button.png")));
        bCancelar.setBounds(1080, 385, 58, 58);
        bCancelar.setContentAreaFilled(false);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusable(false);
        bCancelar.addActionListener(this);
        add(bCancelar);

        bConfirmar = new JButton();
        bConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/confirm-button.png")));
        bConfirmar.setBounds(1135, 385, 120, 60);
        bConfirmar.setContentAreaFilled(false);
        bConfirmar.setBorderPainted(false);
        bConfirmar.setFocusable(false);
        bConfirmar.addActionListener(this);
        add(bConfirmar);

        repaint();
    }


	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bAddIcon){
            if (bAddIcon.getIcon().toString().contains("signatures-add-icon.png")) {
                bAddIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-remove-icon.png")));
            }else {
                bAddIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
            }
        }

        if (ae.getSource() == bConfirmar){
            Cliente clienteID = getCliente();
            ServicoDAO servicoDAO = new ServicoDAO();
            ClienteDAO clienteDAO = new ClienteDAO();

            Servico servico = new Servico(clienteID, barbeiro(),servicosU(), pagamento());
            servicoDAO.create(servico);
            
            Servico novoServico = null;
            for (Servico servicoId : servicoDAO.read()) {
                if (servicoId.getIdCli()== servico.getCliente().getId() && servicoId.getData().trim().equals(servico.getData().trim())) {
                    novoServico = servicoId;
                }
            }
            servicosDao(novoServico);
            clienteDAO.updateService(clienteID);
            limparCampos();
        }
        if (ae.getSource()== bCancelar) {
            limparCampos();
        }
        if (ae.getSource() == barb1) {
            if(barb1.isSelected()){
                barb2.setEnabled(false);
                barb3.setEnabled(false);
                barb4.setEnabled(false);
            }else{
                barb2.setEnabled(true);
                barb3.setEnabled(true);
                barb4.setEnabled(true);
            }
        }
        if (ae.getSource() == barb2) {
            if(barb2.isSelected()){
                barb1.setEnabled(false);
                barb3.setEnabled(false);
                barb4.setEnabled(false);
            }else{
                barb1.setEnabled(true);
                barb3.setEnabled(true);
                barb4.setEnabled(true);
            }
        }
        if (ae.getSource() == barb3) {
            if(barb3.isSelected()){
                barb2.setEnabled(false);
                barb1.setEnabled(false);
                barb4.setEnabled(false);
            }else{
                barb2.setEnabled(true);
                barb1.setEnabled(true);
                barb4.setEnabled(true);
            }
        }
        if (ae.getSource() == barb4) {
            if(barb4.isSelected()){
                barb2.setEnabled(false);
                barb3.setEnabled(false);
                barb1.setEnabled(false);
            }else{
                barb2.setEnabled(true);
                barb3.setEnabled(true);
                barb1.setEnabled(true);
            }
        }

        if (ae.getSource() == cartao) {
            if(cartao.isSelected()){
                dinheiro.setEnabled(false);
            }else{
                dinheiro.setEnabled(true);
            }
        }
        if (ae.getSource() == dinheiro) {
            if(dinheiro.isSelected()){
                cartao.setEnabled(false);
            }else{
                cartao.setEnabled(true);
            }
        }
    }

    private void limparCampos() {
        tValorBarba.setText("");
        tValorCorte.setText("");
        tValorSombrancelha.setText("");
        tValorColoracao.setText("");
        tValorPigmentacao.setText("");
        tValorSelagem.setText("");
        tValorRelaxamento.setText("");
        tValorLuzes.setText("");

        valor = 0.0;
        lValorTotal.setText("Valor total R$ " + valor);

        tValorBarba.setEnabled(false);
        tValorCorte.setEnabled(false);
        tValorSombrancelha.setEnabled(false);
        tValorColoracao.setEnabled(false);
        tValorPigmentacao.setEnabled(false);
        tValorSelagem.setEnabled(false);
        tValorRelaxamento.setEnabled(false);
        tValorLuzes.setEnabled(false);

        barb1.setSelected(false);
        barb2.setSelected(false);
        barb3.setSelected(false);
        barb4.setSelected(false);
        dinheiro.setSelected(false);
        cartao.setSelected(false);
        barb1.setEnabled(true);
        barb2.setEnabled(true);
        barb3.setEnabled(true);
        barb4.setEnabled(true);
        dinheiro.setEnabled(true);
        cartao.setEnabled(true);

        
        bAddIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));
        bAddIcon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/signatures-add-icon.png")));

    }
    double valor = 0;
    private void valor(){
        valor = 0;
        //double valor = 0;//  +  + + ;
        //valor +=  + + + ;
        if (tValorBarba.isEnabled()) {
            valor += Double.parseDouble(tValorBarba.getText());
        }
        if (tValorCorte.isEnabled()) {
            valor += Double.parseDouble(tValorCorte.getText());
        }
        if (tValorColoracao.isEnabled()) {
            valor+= Double.parseDouble(tValorColoracao.getText());
        }
        if (tValorLuzes.isEnabled()) {
            valor+= Double.parseDouble(tValorLuzes.getText());
        }
        if (tValorRelaxamento.isEnabled()) {
            valor+= Double.parseDouble(tValorRelaxamento.getText());
        }
        if (tValorPigmentacao.isEnabled()) {
            valor+= Double.parseDouble(tValorPigmentacao.getText());
        }
        if (tValorSelagem.isEnabled()) {
            valor+= Double.parseDouble(tValorSelagem.getText());
        }
        if (tValorSombrancelha.isEnabled()) {
            valor+= Double.parseDouble(tValorSombrancelha.getText());
        }
        lValorTotal.setText("Valor total R$ "+ valor);
    }

    private ArrayList<ServicoUnico> servicosU() {
        ArrayList<ServicoUnico> lista = new ArrayList<>();
        Trabalho barba = new Trabalho(0,"barba");
        Trabalho corte = new Trabalho(1,"corte");
        Trabalho coloracao = new Trabalho(2,"coloracao");
        Trabalho luzes = new Trabalho(3,"luzes");
        Trabalho relaxamento = new Trabalho(4,"relaxamento");
        Trabalho pigmentacao = new Trabalho(5,"pigmentacao");
        Trabalho selagem = new Trabalho(6,"selagem");
        Trabalho sobrancelha = new Trabalho(7,"sobrancelha");

        if (tValorBarba.isEnabled()) {
            lista.add(new ServicoUnico(Double.parseDouble(tValorBarba.getText().replace(",", ".")),barba));
        }
        if (tValorCorte.isEnabled()) {
            lista.add(new ServicoUnico(Double.parseDouble(tValorCorte.getText().replace(",", ".")),corte));
        }
        if (tValorColoracao.isEnabled()) {
            lista.add(new ServicoUnico(Double.parseDouble(tValorColoracao.getText().replace(",", ".")),coloracao));
        }
        if (tValorLuzes.isEnabled()) {
            lista.add(new ServicoUnico(Double.parseDouble(tValorLuzes.getText().replace(",", ".")),luzes));
            }
        if (tValorRelaxamento.isEnabled()) {
            lista.add(new ServicoUnico(Double.parseDouble(tValorRelaxamento.getText().replace(",", ".")),relaxamento));
        }
        if (tValorPigmentacao.isEnabled()) {
            lista.add(new ServicoUnico(Double.parseDouble(tValorPigmentacao.getText().replace(",", ".")),pigmentacao));
        }
        if (tValorSelagem.isEnabled()) {
            lista.add(new ServicoUnico(Double.parseDouble(tValorSelagem.getText().replace(",", ".")),selagem));
        }
        if (tValorSombrancelha.isEnabled()) {
            lista.add(new ServicoUnico(Double.parseDouble(tValorSombrancelha.getText().replace(",", ".")),sobrancelha));
        }

        return lista;
    }
    private ArrayList<ServicoUnico> servicosDao(Servico serv){
        ServicoUnicoDAO servicoUnicoDAO = new ServicoUnicoDAO();
        ArrayList<ServicoUnico> lista = new ArrayList<>();
        Trabalho barba = new Trabalho(0,"barba");
        Trabalho corte = new Trabalho(1,"corte");
        Trabalho coloracao = new Trabalho(2,"coloracao");
        Trabalho luzes = new Trabalho(3,"luzes");
        Trabalho relaxamento = new Trabalho(4,"relaxamento");
        Trabalho pigmentacao = new Trabalho(5,"pigmentacao");
        Trabalho selagem = new Trabalho(6,"selagem");
        Trabalho sobrancelha = new Trabalho(7,"sobrancelha");

        if (tValorBarba.isEnabled()) {
            servicoUnicoDAO.create(new ServicoUnico(Double.parseDouble(tValorBarba.getText().replace(",", ".")),barba),serv);
        }
        if (tValorCorte.isEnabled()) {
      
            servicoUnicoDAO.create(new ServicoUnico(Double.parseDouble(tValorCorte.getText().replace(",", ".")),corte),serv);
            
        }
        if (tValorColoracao.isEnabled()) {
  
            servicoUnicoDAO.create(new ServicoUnico(Double.parseDouble(tValorColoracao.getText().replace(",", ".")),coloracao),serv);
        }
        if (tValorLuzes.isEnabled()) {
            servicoUnicoDAO.create(new ServicoUnico(Double.parseDouble(tValorLuzes.getText().replace(",", ".")),luzes),serv);
        }
        if (tValorRelaxamento.isEnabled()) {

            servicoUnicoDAO.create(new ServicoUnico(Double.parseDouble(tValorRelaxamento.getText().replace(",", ".")),relaxamento),serv);
        }
        if (tValorPigmentacao.isEnabled()) {

            servicoUnicoDAO.create(new ServicoUnico(Double.parseDouble(tValorPigmentacao.getText().replace(",", ".")),pigmentacao),serv);
        }
        if (tValorSelagem.isEnabled()) {
            servicoUnicoDAO.create(new ServicoUnico(Double.parseDouble(tValorSelagem.getText().replace(",", ".")),selagem),serv);
        }
        if (tValorSombrancelha.isEnabled()) {
            servicoUnicoDAO.create(new ServicoUnico(Double.parseDouble(tValorSombrancelha.getText().replace(",", ".")),sobrancelha),serv);
        }
        return lista;
    }

    private Barbeiro barbeiro(){
        Barbeiro hugo = new Barbeiro(0, "hugo");
        Barbeiro mario = new Barbeiro(1, "mario");
        Barbeiro raimundo = new Barbeiro(2, "raimundo");
        Barbeiro sergio = new Barbeiro(3, "sergio");

        if (barb1.isSelected()) {
            return mario;
        } else if(barb2.isSelected()){
            return raimundo;
        } else if(barb3.isSelected()){
            return hugo;
        } else if(barb4.isSelected()){
            return sergio;
        } else{
            return null;
        }
    }

    private Boolean pagamento(){
        if(cartao.isSelected()){
            return false;
        } else if(dinheiro.isSelected()){
            return true;
        } else{
            return null;
        }
    }
    private Cliente getCliente(){
        return cliente;
    }

    protected void setCliente(Cliente cli) {
        this.cliente = cli;
        addAssinaturas();
    }
}
