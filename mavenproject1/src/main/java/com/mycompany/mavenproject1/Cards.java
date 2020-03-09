/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.*;
import javax.swing.*;

import servico.Servico;

/**
 * cards
 */
public class Cards extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 2320624532937564287L;

    Assinaturas ass;

    JPanel addAss;

    protected JPanel cardConfirmado(Servico servico, int countX,int countY) {

        setLayout(null);
        setBackground(new Color(245, 245, 245));
        setBounds(0+ countX, 0 + countY, 100, 100);

        JLabel statusIcon = new JLabel();
        statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/confirm-icon.png")));
        statusIcon.setBounds(70,-33,100,100);
        add(statusIcon);

        JLabel dateIcon = new JLabel();
        dateIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/icons/calendar-icon.png")));
        dateIcon.setBounds(38, 0, 100, 100);
        add(dateIcon);

        String data = servico.getData().trim();
        String dia = data.substring(8, 10);
        String mes = data.substring(5, 7);
        String ano = data.substring(0, 4);

        String dataPT = dia+"/"+mes+"/"+ano;

        JLabel date = new JLabel(dataPT);
        date.setBounds(12, 60, 200, 25);
        date.setFont(new Font("Helvetica Neue", Font.ROMAN_BASELINE, 14));
        date.setForeground(new Color(0, 0, 0,90));
        add(date);

        return this;
    }
}