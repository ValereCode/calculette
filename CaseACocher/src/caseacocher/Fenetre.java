/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caseacocher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class Fenetre extends JFrame{
    private JPanel container = new JPanel();
    private JCheckBox check1 = new JCheckBox("Case 1");
    private JCheckBox check2 = new JCheckBox("Case 2");

    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(1600, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    
        container.setBackground(Color.RED);
        //container.setLayout(new BorderLayout());

        check1.addActionListener(new StateListener());
        check2.addActionListener(new StateListener());
        
        JPanel top = new JPanel();    
        top.add(check1);
        top.add(check2);

        container.add(top, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }

    class StateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("source : " +
            ((JCheckBox)e.getSource()).getText() +
            " - état : " + ((JCheckBox)e.getSource()).isSelected());
        }

    }
    
}
