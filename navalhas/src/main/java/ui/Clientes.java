package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Customer Screen
 */
public class Clientes extends JPanel implements ActionListener {

    private JPanel body;
    private JPanel description;
    private JLabel customerIcon;

    private JButton bAddCliente;
    private JButton bConsultarCliente;
    private JButton bEditarCliente;
    private JButton bExcluirCliente;

    public Clientes() {
        body = new JPanel();
        body.setBounds(65, 460, 1790, 400);
        // height de 200 originalmente
        body.setBackground(new Color(255, 255, 255));
        body.setLayout(null);
        Janela.frame.getContentPane().add(body);

        description = new JPanel();
        description.setBounds(0, 0, 246, 200);
        description.setBackground(new Color(234, 234, 234));
        body.add(description);

        customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-users.png")));
        customerIcon.setBounds(0, 50, 0, 0);
        description.add(customerIcon);

        bAddCliente = new JButton("\nAdicionar");
        bAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-add.png")));
        bAddCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bAddCliente.setForeground(new Color(0, 0, 0));
        bAddCliente.setBounds(350, 0, 300, 200);
        bAddCliente.setContentAreaFilled(false);
        bAddCliente.setBorderPainted(false);
        bAddCliente.setFocusable(false);
        bAddCliente.addActionListener(this);
        body.add(bAddCliente);

        bConsultarCliente = new JButton("\nConsultar");
        bConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-search.png")));
        bConsultarCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bConsultarCliente.setForeground(new Color(0, 0, 0));
        bConsultarCliente.setBounds(700, 0, 300, 200);
        bConsultarCliente.setContentAreaFilled(false);
        bConsultarCliente.setBorderPainted(false);
        bConsultarCliente.setFocusable(false);
        bConsultarCliente.addActionListener(this);
        body.add(bConsultarCliente);

        bEditarCliente = new JButton("\nEditar");
        bEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-edit.png")));
        bEditarCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bEditarCliente.setForeground(new Color(0, 0, 0));
        bEditarCliente.setBounds(1050, 0, 300, 200);
        bEditarCliente.setContentAreaFilled(false);
        bEditarCliente.setBorderPainted(false);
        bEditarCliente.setFocusable(false);
        bEditarCliente.addActionListener(this);
        body.add(bEditarCliente);

        bExcluirCliente = new JButton("\nExcluir");
        bExcluirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-delete.png")));
        bExcluirCliente.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        bExcluirCliente.setForeground(new Color(0, 0, 0));
        bExcluirCliente.setBounds(1400, 0, 300, 200);
        bExcluirCliente.setContentAreaFilled(false);
        bExcluirCliente.setBorderPainted(false);
        bExcluirCliente.setFocusable(false);
        bExcluirCliente.addActionListener(this);
        body.add(bExcluirCliente);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bAddCliente) {

            body.setVisible(false);
            AddClientes addClientes = new AddClientes();

            Janela.frame.getContentPane().add(addClientes);
            addClientes.setVisible(true);

        }

        if (ae.getSource() == bConsultarCliente) {

            body.setVisible(false);
            ConsultarCliente conClientes = new ConsultarCliente();

            Janela.frame.getContentPane().add(conClientes);
            conClientes.setVisible(true);

        }

        if (ae.getSource() == bEditarCliente) {

            body.setVisible(false);
            EditarClientes edtClientes = new EditarClientes();

            Janela.frame.getContentPane().add(edtClientes);
            edtClientes.setVisible(true);
        }

        if (ae.getSource() == bExcluirCliente) {

            body.setVisible(false);
            ExcluirClientes excClientes = new ExcluirClientes();

            Janela.frame.getContentPane().add(excClientes);
            excClientes.setVisible(true);
        }
    }

}
