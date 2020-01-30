package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ExcluirClientes
 */
public class ExcluirClientes extends JPanel implements ActionListener {

    private JPanel body;
    private JPanel description;
    private JLabel customerIcon;

    private JLabel lClientes;
    private JLabel lConsultaNome;
    private JTextField tConsultaNome;

    private JButton bEnviar;
    private JButton bLimpar;
    private JButton bVoltar;

    ExcluirClientes() {

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
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-delete.png")));
        customerIcon.setBounds(50, 50, 0, 0);
        description.add(customerIcon);

        lClientes = new JLabel("Excluir Cliente");
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
             * } else { resultadoConsulta();
             * 
             */
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