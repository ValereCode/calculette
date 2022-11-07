/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Horloge;
/**
 *
 * @author setod
 */
public class Fenetre extends JFrame {
    
    private JLabel label = new JLabel();
    private Horloge horloge;
    
    public Fenetre(){
        
        //On initialise la JFrame
        this.setTitle("Mon Programme");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(1600, 900);
        
        //On initialise l'horloge
        this.horloge = new Horloge();
        
        // On place un observateur sur l'horloge
        this.horloge.addObservateur((String hour) -> {
            label.setText(hour);
        }); 
        
        //On initialise le JLabel
        Font police = new Font("Tahoma", Font.BOLD, 16); 
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        
        //On ajoute le JLabel à la JFrame
        this.getContentPane().add(this.label, BorderLayout.CENTER);
        this.setVisible(true);
   
        this.horloge.run();
    }

}
