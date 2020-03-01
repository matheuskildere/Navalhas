package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import cliente.Cliente;
import cliente.ClienteDAO;
import servico.Servico;
import servico.ServicoDAO;

/**
 * Customer Screen
 */
public class Assinaturas2 extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel description;
    private JLabel customerIcon;

    private JTextField tPesquisa;
    private JButton bPesquisa;
    private JButton bNome;

    private JLabel lNome;
    private JLabel lContador;

    private JTextField tPesquisa2;

    private JLabel line;

    private JPanel historico;
    private JPanel pCards;

    private JLabel lProfilePicture;
    private JLabel lQtdServicos;
    private JLabel lQtdServicosGratis;

    private final int WIDTH = 1366;
    private final int HEIGHT = 768;

    private ClienteDAO clienteDAO = new ClienteDAO();
    private ServicoDAO servicoDAO = new ServicoDAO();
    private List<Cliente> listaClientes;//= clienteDAO.read();
    private JPanel nomes = new JPanel();
    private JScrollPane scrollFrame = new JScrollPane(nomes);
    protected Cliente clienteClicado;// = listaClientes.get(0);

    private JPanel card;
    AddAssinaturas addAss;

    public Assinaturas2(AddAssinaturas addAss) {
        this.addAss = addAss;
        assinaturas();
    }
    private void assinaturas(){
        lerCli();
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


        tPesquisa = new JTextField("");
        tPesquisa.setBounds(WIDTH / 5, HEIGHT / 12, 384, 48);
        tPesquisa.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tPesquisa.setForeground(new Color(90, 90, 90));
        tPesquisa.setBackground(new Color(252, 252, 252));
        tPesquisa.setHorizontalAlignment(JTextField.CENTER);
        tPesquisa.setBorder(new LineBorder(new Color(210, 210, 210)));
        
        add(tPesquisa);

        bPesquisa = new JButton("");
        bPesquisa.setBounds(WIDTH / 5 - WIDTH / 21, HEIGHT / 12, 65, 48);
        bPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/search-button.png")));
        bPesquisa.setBackground(new Color(234, 234, 234));
        bPesquisa.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("p2-"+tPesquisa2.getText());
                
            }
        });
        add(bPesquisa);

        nomes.setLayout(new BoxLayout(nomes, BoxLayout.Y_AXIS));
        nomes.setBounds(WIDTH / 5 - WIDTH/21, HEIGHT / 5, 449, 2000);
        //nomes.setLayout(new GridLayout(WIDTH / 5 - WIDTH/21, HEIGHT / 5, 449, 500));
        nomes.setBackground(new Color(255, 255, 255));
        scrollFrame.setBorder(null);
        scrollFrame.getVerticalScrollBar().setBackground(new Color(255, 255, 255));
        scrollFrame.getVerticalScrollBar().setForeground(new Color(0, 0, 0));
        nomes.setAutoscrolls(true);
        scrollFrame.setBounds(WIDTH / 5 - WIDTH/21, HEIGHT / 5, 449, 305);
        
        add(scrollFrame);

        line = new JLabel();
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/division-line.png")));
        line.setBounds(WIDTH / 2, HEIGHT / 10, 889, 328);
        add(line);
        historico();
        add(historico);
        nomesClientes();
        cards(clienteClicado);
        repaint();
    }
    private void historico(){
        historico = new JPanel();
        historico.setLayout(null);
        historico.setBounds(WIDTH / 2 - 119, 0, WIDTH / 2, WIDTH / 4);
        historico.setBackground(new Color(255, 255, 255));
        historico.removeAll();
        
        lProfilePicture = new JLabel();
        lProfilePicture.setBounds(WIDTH / 10, HEIGHT / 18, 100, 100);
        lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/picture-customer.png")));
        if (!clienteClicado.getFoto().trim().equals("")){
            lProfilePicture.setIcon(new javax.swing.ImageIcon(clienteClicado.getFoto())); 
        }
        historico.add(lProfilePicture);

        lNome = new JLabel(clienteClicado.getNome().trim());
        lNome.setBounds(WIDTH / 5, HEIGHT / 18, 500, 30);
        lNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        lNome.setForeground(new Color(47, 47, 47));
        historico.add(lNome);

        lQtdServicos = new JLabel("Quantidade de servicos: "+ clienteClicado.getServicosTotal());
        lQtdServicos.setBounds(WIDTH / 5, HEIGHT / 10, 500, 26);
        lQtdServicos.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        lQtdServicos.setForeground(new Color(110, 110, 110));
        historico.add(lQtdServicos);

        lQtdServicosGratis = new JLabel("Quantidade de servicos gratis: "+ clienteClicado.getServicosGratis());
        lQtdServicosGratis.setBounds(WIDTH / 5, HEIGHT / 8, 500, 26);
        lQtdServicosGratis.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        lQtdServicosGratis.setForeground(new Color(110, 110, 110));
        historico.add(lQtdServicosGratis);

        //
        pCards = new JPanel();
        pCards.setLayout(null);
        pCards.setBounds(700, HEIGHT / 4 - 20, 550, 320);
        pCards.setBackground(new Color(255, 255, 255));
        add(pCards);


        // Cards aqui
        card = new JPanel();
        card.setLayout(null);
        card.setBounds(0, 0, 100, 100);

        JButton addButton = new JButton();
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/add-icon.png")));
        addButton.setBounds(0 , 0,100, 100);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.setBackground(new Color(234, 234, 234));
        addButton.setForeground(new Color(234, 234, 234));
        card.add(addButton);
        addButton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                addAss.setCliente(clienteClicado);
                setVisible(false);
                addAss.setVisible(true);
                
            }
        });
        
        //Cards cards = new Cards(addAss, actionPerformed());
        //historico.add(cards.cardAdd(this));
        //cards(clienteClicado);
        repaint();
    }

    private void cards(Cliente clienteCard){
        pCards.removeAll();
        //Cards cards = null;
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
            /*
            for (Servico servicosServico : servicosDoCli) {
                    if (countX >= 440) {
                        countY = 120;
                        countX = 0;
                    }else{
                        countX += 110;
                    }
                    Cards cards = new Cards();
                    pCards.add(cards.cardConfirmado(servicosServico, countX, countY));
                    
            }
            */
        }
        pCards.repaint();
        
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bPesquisa) {
            acaoBpesquisa();
            System.out.println("p2-"+tPesquisa2.getText());
        }
    }
    private void acaoBpesquisa(){
        System.out.println("nome-"+tPesquisa.getText().trim());
            List<Cliente> listaClientes = clienteDAO.read();
            nomes.removeAll();
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente.getNome().trim());
                if (tPesquisa.getText().trim().equals(cliente.getNome().trim()) ) {
                    System.out.println("achou");
                    lNome.setText(cliente.getNome().trim());
                    lQtdServicos.setText("Quantidade de servicos: "+ cliente.getServicos());
                    lQtdServicosGratis.setText("Quantidade de servicos gratis: "+ cliente.getServicosGratis());
                    lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/picture-customer.png")));
                    if (!cliente.getFoto().trim().equals("")){
                        lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/profile-picture.png"))); 
                    }
                }else{
                    System.out.println("else");
                    System.out.println("txt"+tPesquisa.getText().trim());
                    if(tPesquisa.getText().trim() == ""){
                        nomesClientes();
                        System.out.println("nothing");
                    }else{
                        for (JButton buttonCli : buttoes()) {
                            if (buttonCli.getName().contains(tPesquisa.getText().trim())) {
                                
                                nomes.removeAll();
                                System.out.println("contains: "+buttonCli.getName());
                                nomes.add(buttonCli); 
                                repaint();
                                nomes.repaint();
                            }
                        }
                    }
                    break;
                }
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
        nomes.removeAll();
        int cont = 1; 
        int heightCount = 0;
        for (Cliente cliente : listaClientes) {
            
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
                    lNome.setText(cliente.getNome().trim());
                    lQtdServicos.setText("Quantidade de servicos: "+ cliente.getServicos());
                    lQtdServicosGratis.setText("Quantidade de servicos gratis: "+ cliente.getServicosGratis());
                    lProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/picture-customer.png")));
                    if (!cliente.getFoto().trim().equals("")){
                        lProfilePicture.setIcon(new javax.swing.ImageIcon(cliente.getFoto())); 
                    }
                    clienteClicado = cliente;
                    cards(cliente);
                }
            });
            
            listaButtons.add(bNome);

            heightCount +=30;
            cont++;
        }

        System.out.println(heightCount);
        return listaButtons;
    }
    protected void inicia(){
        assinaturas();
        //nomesClientes();
        //historico();
        //cards();
        //tPesquisa.setText("Pesquisa");
    }

    private void lerCli(){
        listaClientes = clienteDAO.read();
        if (listaClientes.size() >0) {
            clienteClicado = listaClientes.get(0);
        }else{
            clienteClicado = new Cliente();
        }
    }
}
