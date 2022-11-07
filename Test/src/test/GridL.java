/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class GridL extends JFrame{
    
    JPanel p = new JPanel();
    
    public GridL () {
        this.setTitle("Le GridLayout");
        this.setSize(1600, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.setContentPane(p);
        
        this.setLayout(new GridLayout(2, 3));
        
        p.add(new JButton("1"));
        p.add(new JButton("2"));
        p.add(new JButton("3"));
        p.add(new JButton("4"));
        p.add(new JButton("5"));
        p.add(new JButton("6"));
        p.add(new JButton("7"));
        
        this.setVisible(true);
    }
}
