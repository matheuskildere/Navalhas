package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import cliente.Cliente;
import cliente.ClienteDAO;

/**
 * Customer Screen
 */
public class AddClientes extends JPanel implements ActionListener {

    private JPanel description;
    private JLabel customerIcon;
    private JLabel lFoto;

    private JButton bVoltar;
    private JButton bConfirmar;
    private JButton bFoto;

    private JTextField tNome;
    private JTextField tDDDContato1;
    private JTextField tContato1;
    private JTextField tDDDContato2;
    private JTextField tContato2;
    private final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public AddClientes() {
        setBounds( WIDTH/30 , WIDTH/6, WIDTH - WIDTH/15,WIDTH/ 4);
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        description = new JPanel();
        description.setBounds(0, 0, WIDTH/8, WIDTH/4);
        description.setBackground(new Color(234, 234, 234));
        add(description);

        customerIcon = new JLabel();
        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/customer-add.png")));
        customerIcon.setBounds(WIDTH/38, HEIGHT/2, 0, 0);
        description.add(customerIcon);

        bFoto = new JButton();
        bFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/picture-customer.png")));
        bFoto.setBounds(WIDTH/2, WIDTH/48, WIDTH/17, WIDTH/17);
        bFoto.setContentAreaFilled(false);
        bFoto.setBorderPainted(false);
        bFoto.setFocusable(false);
        bFoto.addActionListener(this);
        add(bFoto);

        JLabel lFoto = new JLabel();
        lFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/picture-customer.png")));
        lFoto.setBounds(WIDTH/1, WIDTH/48, WIDTH/17, WIDTH/17);
        lFoto.setFocusable(false);
        add(lFoto);

        JLabel nome = new JLabel("Nome");
        nome.setBounds(WIDTH/3 + WIDTH/13, WIDTH/15, WIDTH/10, WIDTH/32);
        nome.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        nome.setForeground(new Color(131, 131, 131));
        add(nome);

        tNome = new JTextField("");
        tNome.setBounds(WIDTH/3 + WIDTH/13, WIDTH/10, WIDTH/4, WIDTH/32);
        tNome.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tNome.setForeground(new Color(47, 47, 47));
        add(tNome);

        JLabel contatos = new JLabel("Contatos");
        contatos.setBounds(WIDTH/3+ WIDTH/13, WIDTH/8, WIDTH/10, WIDTH/32);
        contatos.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        contatos.setForeground(new Color(131, 131, 131));
        add(contatos);

        tDDDContato1 = new JTextField("");
        tDDDContato1.setBounds(WIDTH/3+ WIDTH/13, WIDTH/6 - WIDTH /85, WIDTH/27, WIDTH/32);
        tDDDContato1.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tDDDContato1.setForeground(new Color(47, 47, 47));
        add(tDDDContato1);

        tContato1 = new JTextField("");
        tContato1.setBounds(WIDTH/3+ WIDTH/8, WIDTH/6 - WIDTH /85, WIDTH/5, WIDTH/32);
        tContato1.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tContato1.setForeground(new Color(47, 47, 47));
        add(tContato1);

        tDDDContato2 = new JTextField("");
        tDDDContato2.setBounds(WIDTH/3+ WIDTH/13, WIDTH/5 - WIDTH /85, WIDTH/27, WIDTH/32);
        tDDDContato2.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tDDDContato2.setForeground(new Color(47, 47, 47));
        add(tDDDContato2);

        tContato2 = new JTextField("");
        tContato2.setBounds(WIDTH/3+ WIDTH/8, WIDTH/5- WIDTH /85, WIDTH/5, WIDTH/32);
        tContato2.setFont(new Font("Helvetica Neue", Font.PLAIN, 23));
        tContato2.setForeground(new Color(47, 47, 47));
        add(tContato2);

        JButton bCancelar = new JButton();
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/cancel-button.png")));
        bCancelar.setBounds(WIDTH - WIDTH/4, WIDTH/5, WIDTH/24, WIDTH/24);
        bCancelar.setContentAreaFilled(false);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusable(false);
        bCancelar.addActionListener(this);
        add(bCancelar);

        bConfirmar = new JButton();
        bConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/confirm-button.png")));
        bConfirmar.setBounds(WIDTH - WIDTH/5, WIDTH/5, WIDTH/12, WIDTH/24);
        bConfirmar.setContentAreaFilled(false);
        bConfirmar.setBorderPainted(false);
        bConfirmar.setFocusable(false);
        bConfirmar.addActionListener(this);
        add(bConfirmar);

        bVoltar = new JButton("<");
		bVoltar.setBounds(WIDTH/6, HEIGHT/54, WIDTH/32, HEIGHT/24);
		bVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
        bVoltar.setForeground(new Color(205, 92, 92));
        bVoltar.setBackground(new Color(255, 255, 255));
		bVoltar.addActionListener(this);
		add(bVoltar);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bVoltar) {
            
            setVisible(false);
            Clientes cli = new Clientes();
            Inicio.add(cli);
            Inicio.remove(this);
            //Janela.frame.getContentPane().add(cli);
            cli.setVisible(true);
        }

        if (e.getSource() == bFoto) {
            
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Escolha uma foto para o perfil");

            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println(fc.getSelectedFile().toString());
                repaint();
            }
        }

        if (e.getSource() == bConfirmar) {
            
            try {
                Cliente novo_Cliente = new Cliente();
                novo_Cliente.setNome(tNome.getText().trim());
                novo_Cliente.setContato1(tDDDContato1.getText().trim()+" "+tContato1.getText());
                novo_Cliente.setContato2(tDDDContato2.getText().trim()+" "+tContato2.getText());
                
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.create(novo_Cliente);

                setVisible(false);
                Clientes cliInterface = new Clientes();
                //Janela.frame.getContentPane().add(cliInterface);
                cliInterface.setVisible(true);
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }
    
    }

}
