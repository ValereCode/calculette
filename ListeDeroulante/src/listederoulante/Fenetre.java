/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listederoulante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JComboBox combo = new JComboBox();
    private JLabel label = new JLabel("Une ComboBox");
    
    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        //Propriétés du conteneur
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        
        /**
         * 
         * Utilisons l'interface ItemListener 
         * il est appelé à la siute d'un changement d'etat d'un élément
         * 
         * 
         */
        String tab[] = {"Réné","Mawuko", "Yvette", "Lolo", "Edmond"};
        combo = new JComboBox(tab);
        combo.setPreferredSize(new Dimension(100, 20));
        combo.addItem("Valere");
        combo.addItem("Bienvenu");
        combo.addItem("Honoré");
        combo.addItem(3);
        combo.addItemListener(new ItemState());
        combo.addActionListener(new Ecouteur());
        combo.setForeground(Color.red);
        
        //Le panneau contenant la liste
        JPanel top = new JPanel();
        top.add(label);
        top.add(combo);

        container.add(top, BorderLayout.CENTER);

        this.setContentPane(container);
        this.setVisible(true);
    }
    
    class ItemState implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println("évenement déclencher par : " + e.getItem());
        }
        
    }
    
    class Ecouteur implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionListener : action sur " + combo.getSelectedItem());
        }
    }
    
}
