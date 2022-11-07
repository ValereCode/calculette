/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boitedialogue;

import javax.swing.JOptionPane;

/**
 *
 * @author setod
 */
public class BoiteDialogue {

    static JOptionPane jop1, jop2, jop3;
        
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Boite de message d'information
        jop1 = new JOptionPane();
        jop1.showMessageDialog(null, "Message informatif", "Information", JOptionPane.INFORMATION_MESSAGE);
    
        // Boite du message préventif
        jop2 = new JOptionPane();
        jop2.showMessageDialog(null, "Message préventif", "Attention", JOptionPane.WARNING_MESSAGE);
        
        // Boite du message préventif
        jop3 = new JOptionPane();
        jop3.showMessageDialog(null, "Message d'erreur", "erreur", JOptionPane.ERROR_MESSAGE);
    }
    
}
