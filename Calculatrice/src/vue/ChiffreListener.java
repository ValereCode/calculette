/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.Panneau;

/**
 *
 * @author setod
 */
public class ChiffreListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
            String str = ((JButton)e.getSource()).getText();
            if(Panneau.isUpdate()) {   //Il n'y en avait pas de nombre sur l'écran
                Panneau.setUpdate(false);
            } else {  //Il y a un nombre sur l'écran
                if(!Panneau.getEcran().getText().equals("0")) str = Panneau.getEcran().getText() + str;
            }
            Panneau.getEcran().setText(str);   // De toute évidence on met le string mettable
        }
}
