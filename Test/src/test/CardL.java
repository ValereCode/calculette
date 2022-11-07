/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class CardL extends JFrame {
    
    JPanel p = new JPanel();
    CardLayout cl = new CardLayout();
    
    // Déclaration de tableau indiquant les cartes
    String [] tab = {
        "carte1",
        "carte2",
        "carte3",
        "carte4",
        "carte5"
    };
    
    int indice = 0;
    
    public CardL () {
        this.setTitle("Le CardLayout");
        this.setSize(1600, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
  
//------------------------------------------------------------------------------------------------------------------------------------

        // Définirion des couleurs des différentes cartes
        JPanel c1 = new JPanel();
        c1.setBackground(Color.RED);
        
        JPanel c2 = new JPanel();
        c2.setBackground(Color.BLACK);
        
        JPanel c3 = new JPanel();
        c3.setBackground(Color.CYAN);
        
        JPanel c4 = new JPanel();
        c4.setBackground(Color.PINK);
        
        JPanel c5 = new JPanel();
        c5.setBackground(Color.YELLOW);
        
//--------------------------------------------------------------------------------------------------------------------------------------
        
        JPanel boutonPane = new JPanel();   // Le JPanel qui va contenir mes boutons de controle
        
        JButton b1 = new JButton("suivant");
        
        b1.addActionListener((ActionEvent event) -> {
            cl.next(p);          // Carte suivante
        });
        
        JButton b2 = new JButton("Contenu de votre indice");
        
        b2.addActionListener((ActionEvent event) -> {
            if(++indice > 5) indice = 0;
            cl.show(p, tab[indice]);       // Affichage de la carte courante
        });
        
        boutonPane.add(b1);
        boutonPane.add(b2);
  
//----------------------------------------------------------------------------------------------------------------------------------------

        p.setLayout(cl);
        
        p.add(c1, tab[0]);
        p.add(c2, tab[1]);
        p.add(c3, tab[2]);
        p.add(c4, tab[3]);
        p.add(c5, tab[4]);

//--------------------------------------------------------------------------------------------------------------------------------------

       this.getContentPane().add(boutonPane, BorderLayout.NORTH);
       this.getContentPane().add(p, BorderLayout.CENTER);
        
//------------------------------------------------------------------------------------------------------------------------------------
        
        this.setVisible(true);
        
    }
    
}
