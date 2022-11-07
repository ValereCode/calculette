/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class BorderL extends JFrame {
    
    JPanel p = new JPanel();
    
    public BorderL () {
        this.setTitle("Le BorderLayout");
        this.setSize(1600, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.setContentPane(p);
        
        this.setLayout(new BorderLayout());
        
        p.add(new JButton("EAST"), BorderLayout.EAST);
        p.add(new JButton("WEST"), BorderLayout.WEST);
        p.add(new JButton("NORTH"),BorderLayout.NORTH);
        p.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        p.add(new JButton("CENTER"), BorderLayout.CENTER);
        
        this.setVisible(true);
                
    }
}
