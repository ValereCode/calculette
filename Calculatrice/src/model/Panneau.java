/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vue.*;

/**
 *
 * @author setod
 */
public class Panneau extends JFrame{ 
    
    private static JPanel conteneur = new JPanel(); // Le géant conteneur de la machine
    private JPanel panNumerique = new JPanel();      // Le pavé numérique
    private JPanel panSymbole = new JPanel();      // Le pavé symbolique
    private JPanel panEcran = new JPanel();        //Le panneau d'écran
    private static JLabel ecran = new  JLabel();  // Le JLabel de l'écran  
    
    //Tableau du pavé numérique
    private String[] nombres = { "1", "2", "3", "4", "5", "6", "7",
        "8", "9", "0", ".", "=" };
    private String[] symboles =  { "C", "+", "-", "*", "/" }; //Tableau des symboles
    
    private static Dimension num = new Dimension(50, 40); //Dimension des boutons numeriques
    private static Dimension sym = new Dimension(55, 31);  //Dimension des boutons d'opération
    
    JButton[] boutonNum = new JButton[nombres.length];    //Tableau des boutons numériques
    JButton[] boutonSym = new JButton[symboles.length];   // Tableau des boutons symboliques
    
    private static String operateur = new String();
    private static double chiffre ;
    
    private static boolean clicOperateur = false, update = true;

    public static boolean isClicOperateur() {
        return clicOperateur;
    }

    public static void setOperateur(String operateur) {
        Panneau.operateur = operateur;
    }

    public static void setClicOperateur(boolean clicOperateur) {
        Panneau.clicOperateur = clicOperateur;
    }

    public static boolean isUpdate() {
        return update;
    }

    public static void setUpdate(boolean update) {
        Panneau.update = update;
    }

    public static void setChiffre(double chiffre) {
        Panneau.chiffre = chiffre;
    }

    public static JLabel getEcran() {
        return ecran;
    }

    public static String getOperateur() {
        return operateur;
    }

    public static double getChiffre() {
        return chiffre;
    }
    
    public Panneau() {
        this.setTitle("Mon calculette");
        this.setSize(250, 260);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);   //Non redimensionable
        
        //Définissons la police
        Font police = new Font("Tahoma", Font.BOLD, 16);
        ecran = new JLabel("0");
        ecran.setFont(police);
        
        // On aligne les informations à droite du tableau 
        ecran.setHorizontalAlignment(JLabel.RIGHT);
        
        //On redimensionne le JLabel
        ecran.setPreferredSize(new Dimension(220, 20));
        
        //---------------------------------------------------
        
        panNumerique.setPreferredSize(new Dimension(165, 225));
        
        panSymbole.setPreferredSize(new Dimension(52,225));
        
        panEcran.setPreferredSize(new Dimension(220, 30));
        
        //--------------------------------------------------------
        
        //Il est temps de créer nos boutons 
        for (int i=0; i<boutonNum.length; i++) {
            boutonNum[i] = new JButton(nombres[i]);
            boutonNum[i].setPreferredSize(num);
            
            switch(i) {
                case 11:
                    boutonNum[i].addActionListener(new EgalListener());
                    panNumerique.add(boutonNum[i]);
                    break;
                default:
                    panNumerique.add(boutonNum[i]);
                    boutonNum[i].addActionListener(new ChiffreListener());
                    break;
            }                   
        }
        
        for (int j = 0; j<symboles.length; j++) {
            boutonSym[j] = new JButton(symboles[j]);
            boutonSym[j].setPreferredSize(sym);
            panSymbole.add(boutonSym[j]);
            
            switch(j) {
                case 0:
                    boutonSym[j].addActionListener(new ResetListener());
                    break;
                case 1:
                    boutonSym[j].addActionListener(new PlusListener());
                    break;
                case 2:
                    boutonSym[j].addActionListener(new MoinsListener());
                    break;
                case 3:
                    boutonSym[j].addActionListener(new MultiListener());
                    break;
                case 4:
                    boutonSym[j].addActionListener(new DivListener());
                    break;
            }
        }
        
        //---------------------------------------------------
       
        panEcran.add(ecran);
        panEcran.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        conteneur.add(panEcran,BorderLayout.NORTH);
        conteneur.add(panNumerique, BorderLayout.CENTER);
        conteneur.add(panSymbole, BorderLayout.EAST);
        
        //------------------------------------------------------
        
        this.setContentPane(conteneur);
        
        this.setVisible(true);
    }
    
}