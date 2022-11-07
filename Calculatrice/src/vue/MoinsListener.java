/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Panneau;

/**
 *
 * @author setod
 */
public class MoinsListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
            if(Panneau.isClicOperateur()) {
                Calculette.calculeur();
                Panneau.getEcran().setText(String.valueOf(Panneau.getChiffre()));
            }else {
                Panneau.setChiffre(Double.valueOf(Panneau.getEcran().getText()).doubleValue()) ;
                Panneau.setClicOperateur(true);
            }
            Panneau.setOperateur("-");
            Panneau.setUpdate(true);      
        }
}
