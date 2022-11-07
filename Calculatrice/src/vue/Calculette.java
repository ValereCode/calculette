/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import javax.swing.JFrame;
import model.Panneau;

/**
 *
 * @author setod
 */
public class Calculette {
       
        public static void calculeur() {
        if(Panneau.getOperateur().equals("+")) {
            Panneau.setChiffre(Panneau.getChiffre() + Double.valueOf(Panneau.getEcran().getText()).doubleValue());
            Panneau.getEcran().setText(String.valueOf(Panneau.getChiffre()));
        }
        if(Panneau.getOperateur().equals("-")) {
            Panneau.setChiffre(Panneau.getChiffre() - Double.valueOf(Panneau.getEcran().getText()).doubleValue());
            Panneau.getEcran().setText(String.valueOf(Panneau.getChiffre()));
        } 
        if(Panneau.getOperateur().equals("*")) {
            Panneau.setChiffre(Panneau.getChiffre() * Double.valueOf(Panneau.getEcran().getText()).doubleValue());
            Panneau.getEcran().setText(String.valueOf(Panneau.getChiffre()));
        } 
        if(Panneau.getOperateur().equals("/")) {
            try {
                Panneau.setChiffre(Panneau.getChiffre() / Double.valueOf(Panneau.getEcran().getText()).doubleValue());
            Panneau.getEcran().setText(String.valueOf(Panneau.getChiffre()));
            } catch (ArithmeticException e) {
                Panneau.getEcran().setText("0");
            }            
        }       
    }
    
}
