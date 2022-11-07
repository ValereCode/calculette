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
public class EgalListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
            Calculette.calculeur();
            Panneau.setUpdate(true);  // On va peut ajouter un nombre
            Panneau.setClicOperateur(false);    
        }
}
