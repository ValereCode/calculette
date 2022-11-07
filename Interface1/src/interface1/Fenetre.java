/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interface1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class Fenetre extends JFrame {   
    
   private  Panneau2 panneauAnimable = new Panneau2();
   private JPanel panneauPrincipal = new JPanel();
   private JButton GO = new JButton("GO");
   private JButton STOP   = new JButton("STOP");
   private JLabel label = new JLabel("Le JLabel");  
   private int compteur = 0;
   private boolean animation = true;
   Thread t ;
   private JComboBox combo = new JComboBox();
   private JCheckBox morph = new JCheckBox("Morphing");
   private boolean animated = true;
   //------------------------------------------------------------
    
    public Fenetre(){
        this.setTitle("Mon animation");  // Le titre
        this.setSize(1600, 900);   // Longueur puis Largeur
        this.setResizable(true);   // Emp_che le redimensionnement
        this.setAlwaysOnTop(true);  // Garde la fenetre au premie plan
        this.setLocationRelativeTo(null); // Positionnement au centre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                
        this.setBackground(Color.red);        // Sa couleur sera rouge      
        
        //---------------------------------------------------------------------------------------------------------------------------------
   
        // Remplissons notre liste
        combo.addItem("ROND");
        combo.addItem("CARRE");
        combo.addItem("TRIANGLE");
        combo.addItem("ETOILE");
        combo.addActionListener(new FormeListener()); //Un listener de notre liste
        
        // Définition d'une police d'écriture
        Font police = new Font("Tahoma", Font.BOLD, 16);
        label.setFont(police); // Application de la police d'écriture au label
        
        label.setForeground(Color.BLUE);  //Couleur de notre label
        
        //On modifie l'alignement du texte grâce aux attributs statiques
        //de la classe JLabel
        label.setHorizontalAlignment(JLabel.CENTER);
   
        //----------------------------------------------------------------
        
        //On définit un panneau de top et lui attribut le label et nos formes comme contenu
        JPanel top = new JPanel();
        top.add(label);
        top.add(combo);
        top.add(morph);
        
        panneauPrincipal.setLayout(new BorderLayout());
        panneauPrincipal.add(top,BorderLayout.NORTH);  // le label au dessus
        panneauPrincipal.add(panneauAnimable, BorderLayout.CENTER);   // l'animation du panneau2 au centre
           
        // Ajoutons la fenetre à la liste des auditeur de notre bouton
        GO.addActionListener (new Bouton1Listener()); 
        STOP.addActionListener (new Bouton2Listener() );
        morph.addActionListener(new MorphListener());
        
        // Voyons un peu les classes anonymes
        //  tout en utilisant une expression lambda
        STOP.addActionListener((ActionEvent event) -> {
            //System.out.println("hi");
            GO.setEnabled(true);      // Appuyable
            STOP.setEnabled(false);    //Non appuyable
            animation = false;
        });
        
        // Etat initial des boutons
        GO.setEnabled(false);      //Non appuyable
        STOP.setEnabled(true);    // Appuyable
        
        // Créons un JPanel au quel on ajoutera les deux boutons pour enfin ce JPanel au sud
        JPanel panneauBouton = new JPanel();
        panneauBouton.add(GO);
        panneauBouton.add(STOP);
        panneauPrincipal.add(panneauBouton, BorderLayout.SOUTH);
        
        //--------------------------------------------------------------------------------------------------------------------------------------
        
        this.setContentPane(panneauPrincipal);      // Le contentPane sera notre JPanel
        this.setVisible(true);           // Rendu visible
        bouger();     
    }
    
    private void bouger() {
            
        // On met les attrivuts de notre dessin dans des variables locales
        int x = panneauAnimable.getPosX();
        int y = panneauAnimable.getPosY();
        boolean backX = false ;
        boolean backY = false ;
            
        while(this.animation){
            //Si le mode morphing est activé, on utilise la taille actuelle de la forme
            if(panneauAnimable.isMorph()){
                if(x < 1) backX = false;
                if(x > panneauAnimable.getWidth() - panneauAnimable.getDrawSize()) backX = true;
                if(y < 1) backY = false;
                if(y > panneauAnimable.getHeight() - panneauAnimable.getDrawSize()) backY = true;
            }

            //Sinon, on fait comme d'habitude
            
            
        
        
             // On incrémente ses variables  si elles sont inférieures aux bords
            if (x < 1)  backX = false;
           
            if (y  < 1)  backY = false;
             
            // On décrémente ses variables si elles sont supérieures aux bords
            if (x > panneauAnimable.getWidth() - 50)  backX = true;
            
            if(y > panneauAnimable.getHeight() - 50) backY = true;
           
            if (backX) panneauAnimable.setPosX(--x);
            else panneauAnimable.setPosX(++x);
            
            if (backY) panneauAnimable.setPosY(--y);
            else panneauAnimable.setPosY(++y);
            
            // On redéssine le dessin
            panneauAnimable.repaint();
            
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
            }           
        }
    }
    
    // Créons une classe interne qui écoutera le GO
    public class Bouton1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Vous venez de cliquer sur le GO");
            animation = true;
            t = new Thread(new animateur());
            t.start();
            GO.setEnabled(false);
            STOP.setEnabled(true);         
        } 
        
    }
    
    // Créons une classe interne qui écoutera le STOP
    public class Bouton2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Vous venez de cliquer sur le STOP");
            animation = false;
            GO.setEnabled(true);
            STOP.setEnabled(false);
        } 
        
    }
    
    public class animateur implements Runnable {
        
       /**
        *
        */
       @Override
        public void run() {
            bouger();
        }
        
    }
    
    public class FormeListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
            panneauAnimable.setForme(combo.getSelectedItem().toString());
        }
    }
    
    class MorphListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //Si la case est cochée, on active le mode morphing
            if(morph.isSelected()) panneauAnimable.setMorph(true);
            //Sinon, on ne fait rien
            else panneauAnimable.setMorph(false);
        }

    }
    
}
