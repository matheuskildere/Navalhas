package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import servico.Servico;

/**
 * cards
 */
public class Cards extends JPanel implements ActionListener{


    private JLabel statusIcon;

    private JButton addButton;

    private JLabel dateIcon;
    private JLabel date;

    private final int WIDTH = 1366;
    private final int HEIGHT = 768;

    Assinaturas ass;

    JPanel addAss;

    protected JPanel cardConfirmado(Servico servico, int countX,int countY) {

        setLayout(null);
        setBackground(new Color(245, 245, 245));
        setBounds(0+ countX, 0 + countY, 100, 100);

        JLabel statusIcon = new JLabel();
        statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/confirm-icon.png")));
        statusIcon.setBounds(70,-33,100,100);
        add(statusIcon);

        JLabel dateIcon = new JLabel();
        dateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/calendar-icon.png")));
        dateIcon.setBounds(38, 0, 100, 100);
        add(dateIcon);

        String data = servico.getData().trim();
        JLabel date = new JLabel(data);
        date.setBounds(12, 60, 200, 25);
        date.setFont(new Font("Helvetica Neue", Font.ROMAN_BASELINE, 14));
        date.setForeground(new Color(0, 0, 0,90));
        add(date);

        return this;
    }

    JPanel cardUndo() {

        setLayout(null);
        setBounds(WIDTH / 20 + 140, HEIGHT / 4 - 20, 100, 100);
        setBackground(new Color(245, 245, 245));

        statusIcon = new JLabel();
        statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/undo-icon.png")));
        statusIcon.setBounds(WIDTH - WIDTH + 115, HEIGHT - HEIGHT + 15, 22, 22);
        add(statusIcon);

        dateIcon = new JLabel();
        dateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/calendar-icon.png")));
        dateIcon.setBounds(WIDTH - WIDTH + 65, HEIGHT - HEIGHT + 30, 25, 25);
        add(dateIcon);

        date = new JLabel("16/01/2020");
        date.setBounds(WIDTH - WIDTH + 30, HEIGHT - HEIGHT + 80, 200, 25);
        date.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        add(date);

        return this;
    }

    /* Quadrado de adicionar */

    JPanel cardAdd(JPanel panel) {

        

        return this;

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

}