/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interface1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author setod
 */
public class Bouton extends JButton implements MouseListener{
    
    private String nom;
    private Image img;
    
    public Bouton (String nom) {
        this.nom = nom;
        try {
            this.img = ImageIO.read(new File("ecole.jpg")); 
        } catch (IOException e) { 
        }
        this.addMouseListener(this); // Le bouton sera écouté par lui-meme 
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        GradientPaint gp = new GradientPaint(0, 0, Color.yellow, 50, 50, Color.black);
        
        g2d.setPaint(gp);
        
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.WHITE);
        //g2d.drawString(this.nom, this.getWidth() /  2 - (this.getWidth() / 8), (this.getHeight() / 2) + 5);
        g2d.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
    
    //Méthode appelée lors du clic de souris
    @Override
    public void mouseClicked(MouseEvent event) { }
    
    //Méthode appelée lors du survol de la souris
    @Override
    public void mouseEntered(MouseEvent event) {
        try {
            this.img = ImageIO.read(new File("dessus.jfif"));
        } catch (IOException e) {
            
        }
    }
    
    //Méthode appelée lorsque la souris sort de la zone du bouton

    /**
     *
     * @param event
     */
    @Override
    public void mouseExited(MouseEvent event) {
        try {
            this.img = ImageIO.read(new File("dessous.jfif"));
        } catch (IOException e) {
            
        }
    }
    
    //Méthode appelée lorsque l'on presse le bouton gauche de la souris

    /**
     *
     * @param event
     */
    @Override
    public void mousePressed(MouseEvent event) {
        try { 
            this.img = ImageIO.read(new File("africa.jfif"));
        } catch (IOException e) {
            
        }
    }
    
    //Méthode appelée lorsque l'on relâche le clic de souris
    @Override
    public void mouseReleased(MouseEvent event) {
        if ((event.getY()> 0 && event.getY() < this.getHeight()) &&
            (event.getX()> 0 && event.getX() < this.getWidth())) {
            try {
                this.img = ImageIO.read(new File("imag1.jfif"));
            } catch (IOException e) { } 
        } else {
            try {
                this.img = ImageIO.read(new File("ecole.jpg")); 
            } catch (IOException e) { }
        }
        
    } 
}
