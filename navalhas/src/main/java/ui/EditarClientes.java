package ui;

import java.awt.*;
import javax.swing.*;

import cliente.Cliente;
import cliente.ClienteDAO;
import java.util.List;

import java.awt.event.*;


/**
 * ExcluirClientes
 */
public class EditarClientes extends JPanel implements ActionListener {

    private JPanel description;
    private JLabel customerIcon;

    private JLabel lClientes;
    private JLabel lConsultaNome;
    private JTextField tConsultaNome;
    private JTextField tNome;
    private JTextField tDDDContato1;
    private JTextField tContato1;
    private JTextField tDDDContato2;
    private JTextField tContato2;

    private JButton bVoltar;
    private JButton bLimpar;
    private JButton bEnviar;
    private JButton bConfirmar;
    private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    private ClienteDAO clienteDAO = new ClienteDAO();

    public EditarClientes() {
        
        setBounds(WIDTH/30, HEIGHT/3, WIDTH - WIDTH/15, WIDTH/4);
        setBackground(new Color(255, 255, 255));
        //setForeground(new Color(255, 255, 255));
        setLayout(null);

        description = new JPanel();
        description.setBounds(0, 0, WIDTH/8, WIDTH/4);
        description.setBackground(new Color(234, 234, 234));
        add(description);

        customerIcon = new JLabel("");
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-edit.png")));
        customerIcon.setBounds(50, 200, 0, 0);
        description.add(customerIcon);

       
        lClientes = new JLabel("Editar Cliente");
		lClientes.setBounds(WIDTH/2 - WIDTH/20, WIDTH/19, WIDTH/5, WIDTH/32);
		lClientes.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		lClientes.setForeground(new Color(128, 128, 128));
		add(lClientes);

		lConsultaNome = new JLabel("Nome");
		lConsultaNome.setBounds(WIDTH/2 - WIDTH/5, HEIGHT/5, WIDTH/5, HEIGHT/27);
		lConsultaNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
		lConsultaNome.setForeground(new Color(128, 128, 128));
		add(lConsultaNome);

		tConsultaNome = new JTextField("");
        tConsultaNome.setBounds(WIDTH/2 - WIDTH/8, HEIGHT/5, WIDTH/4 + WIDTH/35, HEIGHT/18);
        tConsultaNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        tConsultaNome.setForeground(new Color(131, 131, 131));
		//tConsultaCpf.setDocument(new Tratamento());
		add(tConsultaNome);

		bVoltar = new JButton("<");
		bVoltar.setBounds(WIDTH/6, HEIGHT/54, WIDTH/32, HEIGHT/24);
		bVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
        bVoltar.setForeground(new Color(205, 92, 92));
        bVoltar.setBackground(new Color(255, 255, 255));
		bVoltar.addActionListener(this);
		add(bVoltar);

		bEnviar = new JButton("Enviar");
		bEnviar.setBounds(WIDTH/2 + WIDTH/35, HEIGHT/4 + HEIGHT/15, WIDTH/11, HEIGHT/18);
		bEnviar.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bEnviar.addActionListener(this);
        bEnviar.setBackground(new Color(255, 255, 255));
		bEnviar.setForeground(new Color(0, 128, 128));
		add(bEnviar);

		bLimpar = new JButton("Limpar");
		bLimpar.setBounds(WIDTH/3 + WIDTH/20, HEIGHT/4 + HEIGHT/15,WIDTH/11, HEIGHT/18);
		bLimpar.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bLimpar.setForeground(new Color(205, 92, 92));
        bLimpar.setBackground(new Color(255, 255, 255));
		bLimpar.addActionListener(this);
		add(bLimpar);


    }



    void resultadoConsulta(Cliente cliente) {
        
 
        JButton bFoto = new JButton();
        bFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/picture-customer.png")));
        bFoto.setBounds(770, 40, 120, 120);
        bFoto.setContentAreaFilled(false);
        bFoto.setBorderPainted(false);
        bFoto.setFocusable(false);
        bFoto.addActionListener(this);
        add(bFoto);

        JLabel nome = new JLabel("Nome");
        nome.setBounds(WIDTH/3 + WIDTH/13, WIDTH/15, WIDTH/10, WIDTH/32);
        nome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        nome.setForeground(new Color(131, 131, 131));
        add(nome);

        tNome = new JTextField(cliente.getNome());
        tNome.setBounds(WIDTH/3 + WIDTH/13, WIDTH/10, WIDTH/4, WIDTH/32);
        tNome.setEditable(false);
        tNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tNome.setForeground(new Color(47, 47, 47));
        add(tNome);

        JLabel contatos = new JLabel("Contatos");
        contatos.setBounds(600, 270, 200, 60);
        contatos.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        contatos.setForeground(new Color(131, 131, 131));
        add(contatos);

        tDDDContato1 = new JTextField(cliente.getContato1().substring(0,1));
        tDDDContato1.setBounds(600, 350, 70, 60);
        tDDDContato1.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tDDDContato1.setForeground(new Color(47, 47, 47));
        add(tDDDContato1);

        tContato1 = new JTextField(4);
        tContato1.setBounds(687, 350, 362, 60);
        tContato1.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tContato1.setForeground(new Color(47, 47, 47));
        add(tContato1);

        tDDDContato2 = new JTextField(cliente.getContato2().substring(0,1));
        tDDDContato2.setBounds(600, 430, 70, 60);
        tDDDContato2.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tDDDContato2.setForeground(new Color(47, 47, 47));
        add(tDDDContato2);

        tContato2 = new JTextField(cliente.getContato2().substring(4));
        tContato2.setBounds(687, 430, 362, 60);
        tContato2.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tContato2.setForeground(new Color(47, 47, 47));
        add(tContato2);

        JButton bCancelar = new JButton();
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/cancel-button.png")));
        bCancelar.setBounds(1520, 420, 80, 80);
        bCancelar.setContentAreaFilled(false);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusable(false);
        bCancelar.addActionListener(this);
        add(bCancelar);

        bConfirmar = new JButton();
        bConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/confirm-button.png")));
        bConfirmar.setBounds(1600, 420, 160, 80);
        bConfirmar.setContentAreaFilled(false);
        bConfirmar.setBorderPainted(false);
        bConfirmar.setFocusable(false);
        bConfirmar.addActionListener(this);
        add(bConfirmar);

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bEnviar) {
            String nomePesquisado =tConsultaNome.getText().trim();
            List<Cliente> listaClientes = clienteDAO.read();
            Cliente clientePesquisado = null;
            
            for (Cliente cliente : listaClientes) {
                String nomeCliente = cliente.getNome().trim();
                
                if (nomePesquisado.equalsIgnoreCase(nomeCliente)) {
                    clientePesquisado = cliente;
                }   
            }

            if (clientePesquisado != null) {
                System.out.println(clientePesquisado.getContato1());
                
                resultadoConsulta(clientePesquisado);
            }else{
                System.out.println("Cliente nao encontrado");
            }
		}

				

		if (e.getSource() == bLimpar) {
			//tConsultaNome.setText("")

        }

        if (e.getSource() == bConfirmar) {
            Cliente updateCliente = new Cliente();
            updateCliente.setNome(tNome.getText());
            updateCliente.setContato1(tDDDContato1.getText()+" "+tContato1.getText());
            updateCliente.setContato2(tDDDContato2.getText()+" "+tContato2.getText());
            clienteDAO.update(updateCliente);
        }
        
        if (e.getSource() == bVoltar) {
            
            setVisible(false);
            Clientes cli = new Clientes();
            Inicio.add(cli);
            //Janela.frame.getContentPane().add(cli);
            cli.setVisible(true);
        }

	

    }
}