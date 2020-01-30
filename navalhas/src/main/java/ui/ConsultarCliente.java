package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsultarCliente extends JPanel implements ActionListener {
    private JPanel body;
    private JPanel description;
    private JLabel customerIcon;

    private JLabel lClientes;
    private JLabel lConsultaNome;
    private JTextField tConsultaNome;
    private JButton bVoltar;
    private JButton bLimpar;
    private JButton bEnviar;

    public ConsultarCliente() {
        body = new JPanel();
        body.setBounds(65, 330, 1790, 540);
        body.setBackground(new Color(255, 255, 255));
        body.setLayout(null);
        Janela.frame.getContentPane().add(body);

        description = new JPanel();
        description.setBounds(0, 0, 246, 530);
        description.setBackground(new Color(234, 234, 234));
        body.add(description);

        customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-search.png")));
        customerIcon.setBounds(50, 50, 0, 0);
        description.add(customerIcon);

        lClientes = new JLabel("Consultar Cliente");
        lClientes.setBounds(880, 100, 350, 60);
        lClientes.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        lClientes.setForeground(new Color(128, 128, 128));
        body.add(lClientes);

        lConsultaNome = new JLabel("Nome");
        lConsultaNome.setBounds(700, 230, 350, 40);
        lConsultaNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        lConsultaNome.setForeground(new Color(128, 128, 128));
        body.add(lConsultaNome);

        tConsultaNome = new JTextField("");
        tConsultaNome.setBounds(800, 220, 400, 60);
        tConsultaNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        tConsultaNome.setForeground(new Color(131, 131, 131));
        // tConsultaCpf.setDocument(new Tratamento());
        body.add(tConsultaNome);

        bVoltar = new JButton("<");
        bVoltar.setBounds(300, 20, 40, 40);
        bVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
        bVoltar.setForeground(new Color(205, 92, 92));
        bVoltar.addActionListener(this);
        body.add(bVoltar);

        bEnviar = new JButton("Enviar");
        bEnviar.setBounds(1020, 380, 180, 60);
        bEnviar.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bEnviar.addActionListener(this);
        bEnviar.setForeground(new Color(0, 128, 128));
        body.add(bEnviar);

        bLimpar = new JButton("Limpar");
        bLimpar.setBounds(800, 380, 180, 60);
        bLimpar.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bLimpar.setForeground(new Color(205, 92, 92));
        bLimpar.addActionListener(this);
        body.add(bLimpar);

    }

    void resultadoConsulta() {

        JButton bFoto = new JButton();
        bFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/picture-customer.png")));
        bFoto.setBounds(770, 40, 120, 120);
        bFoto.setContentAreaFilled(false);
        bFoto.setBorderPainted(false);
        bFoto.setFocusable(false);
        bFoto.addActionListener(this);
        body.add(bFoto);

        JLabel nome = new JLabel("Nome");
        nome.setBounds(600, 130, 200, 60);
        nome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        nome.setForeground(new Color(131, 131, 131));
        body.add(nome);

        JTextField tNome = new JTextField("");
        tNome.setBounds(600, 200, 448, 60);
        tNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tNome.setForeground(new Color(47, 47, 47));
        body.add(tNome);

        JLabel contatos = new JLabel("Contatos");
        contatos.setBounds(600, 270, 200, 60);
        contatos.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        contatos.setForeground(new Color(131, 131, 131));
        body.add(contatos);

        JTextField tDDDContato1 = new JTextField("");
        tDDDContato1.setBounds(600, 350, 70, 60);
        tDDDContato1.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tDDDContato1.setForeground(new Color(47, 47, 47));
        body.add(tDDDContato1);

        JTextField tContato1 = new JTextField("");
        tContato1.setBounds(687, 350, 362, 60);
        tContato1.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tContato1.setForeground(new Color(47, 47, 47));
        body.add(tContato1);

        JTextField tDDDContato2 = new JTextField("");
        tDDDContato2.setBounds(600, 430, 70, 60);
        tDDDContato2.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tDDDContato2.setForeground(new Color(47, 47, 47));
        body.add(tDDDContato2);

        JTextField tContato2 = new JTextField("");
        tContato2.setBounds(687, 430, 362, 60);
        tContato2.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tContato2.setForeground(new Color(47, 47, 47));
        body.add(tContato2);

        JButton bCancelar = new JButton();
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/cancel-button.png")));
        bCancelar.setBounds(1520, 420, 80, 80);
        bCancelar.setContentAreaFilled(false);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusable(false);
        bCancelar.addActionListener(this);
        body.add(bCancelar);

        JButton bConfirmar = new JButton();
        bConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/confirm-button.png")));
        bConfirmar.setBounds(1600, 420, 160, 80);
        bConfirmar.setContentAreaFilled(false);
        bConfirmar.setBorderPainted(false);
        bConfirmar.setFocusable(false);
        bConfirmar.addActionListener(this);
        body.add(bConfirmar);

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bEnviar) {
            /*
             * String cpfStg = tConsultaCpf.getText(); long cpf = Long.parseLong(cpfStg);
             * 
             * if (GerenciarClientes.existe(cpf) == false) {
             * 
             * Component frame = null; JOptionPane.showMessageDialog(frame,
             * "Nenhum cliente com este CPF foi encontrado! \nPor favor, tente outro cpf válido."
             * , ":(", JOptionPane.ERROR_MESSAGE); tConsultaCpf.setText("");
             * 
             * 
             * } else {
             */
            resultadoConsulta();
        }

        if (e.getSource() == bLimpar) {
            tConsultaNome.setText("");

        }

        if (e.getSource() == bVoltar) {

            body.setVisible(false);
            Clientes cli = new Clientes();

            Janela.frame.getContentPane().add(cli);
            cli.setVisible(true);
        }
    }
}
