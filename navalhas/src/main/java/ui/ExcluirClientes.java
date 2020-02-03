package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;

import cliente.Cliente;
import cliente.ClienteDAO;

/**
 * ExcluirClientes
 */
public class ExcluirClientes extends JPanel implements ActionListener {

    private JPanel description;
    private JLabel customerIcon;

    private JLabel lClientes;
    private JLabel lConsultaNome;
    private JTextField tConsultaNome;

    private JButton bEnviar;
    private JButton bLimpar;
    private JButton bVoltar;
    
    private ClienteDAO clienteDAO = new ClienteDAO();

    ExcluirClientes() {

        setBounds(65, 330, 1790, 540);
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        description = new JPanel();
        description.setBounds(0, 0, 246, 530);
        description.setBackground(new Color(234, 234, 234));
        add(description);

        customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-delete.png")));
        customerIcon.setBounds(50, 50, 0, 0);
        description.add(customerIcon);

        lClientes = new JLabel("Excluir Cliente");
        lClientes.setBounds(880, 100, 350, 60);
        lClientes.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        lClientes.setForeground(new Color(128, 128, 128));
        add(lClientes);

        lConsultaNome = new JLabel("Nome");
        lConsultaNome.setBounds(700, 230, 350, 40);
        lConsultaNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        lConsultaNome.setForeground(new Color(128, 128, 128));
        add(lConsultaNome);

        tConsultaNome = new JTextField("");
        tConsultaNome.setBounds(800, 220, 400, 60);
        tConsultaNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        tConsultaNome.setForeground(new Color(131, 131, 131));
        // tConsultaCpf.setDocument(new Tratamento());
        add(tConsultaNome);

        bVoltar = new JButton("<");
        bVoltar.setBounds(300, 20, 40, 40);
        bVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
        bVoltar.setForeground(new Color(205, 92, 92));
        bVoltar.addActionListener(this);
        add(bVoltar);

        bEnviar = new JButton("Enviar");
        bEnviar.setBounds(1020, 380, 180, 60);
        bEnviar.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bEnviar.addActionListener(this);
        bEnviar.setForeground(new Color(0, 128, 128));
        add(bEnviar);

        bLimpar = new JButton("Limpar");
        bLimpar.setBounds(800, 380, 180, 60);
        bLimpar.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bLimpar.setForeground(new Color(205, 92, 92));
        bLimpar.addActionListener(this);
        add(bLimpar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bEnviar) {
            String nomePesquisado = tConsultaNome.getText().trim();
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
                clienteDAO.delete(clientePesquisado);
            }else{
                System.out.println("Cliente nao encontrado");
            }
        }

        if (e.getSource() == bLimpar) {
            tConsultaNome.setText("");

        }

        if (e.getSource() == bVoltar) {

            setVisible(false);
            Clientes cli = new Clientes();
            Inicio.add(cli);
            cli.setVisible(true);
        }

    }

}