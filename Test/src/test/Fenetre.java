/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class Fenetre extends JFrame {
    
    JPanel p = new JPanel();
    JButton bouton = new JButton("cliquer-ici");
    public Fenetre() {
        this.setTitle("Bouton");
        this.setSize(1600, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        
        
        this.setContentPane(p);
        
        p.add(bouton);
        
        this.setVisible(true);
    }
   
    
}
