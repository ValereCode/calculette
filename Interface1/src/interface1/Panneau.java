/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interface1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class Panneau extends JPanel {
    @Override
    public void paintComponent( Graphics g ) {
        System.out.println("Succes");

        //g.fillOval(10, 10, 100, 100);
        
        g.drawRect(this.getWidth()/4, this.getHeight()/4, this.getWidth()/2, this.getHeight()/2);
        
        g.drawLine(0, 0, this.getWidth()/4, this.getHeight()/4);
        
        double s2 = this.getWidth()*0.75;
        double s = this.getHeight()*0.75 ;
        int refx = (int)s2;
        int refy = (int)s;
       
        g.drawLine(0, this.getHeight(), this.getWidth()/4, refy);
        g.drawLine(this.getWidth(), 0, refx, this.getHeight()/4);
        g.drawLine(this.getWidth(), this.getHeight(), refx, refy);
        
        Font font = new Font("Courier", Font.BOLD,20);
        
        g.setFont(font);
        g.setColor(Color.blue);
        
        g.drawString("ME VOICI DE RETOUR !!!", this.getWidth()/2, this.getHeight()/2);
        
        try{
            Image img = ImageIO.read(new File ("ecole.jpg"));
        
            g.drawImage(img, 0, 0, this); 
        
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        
        } catch (IOException e) {
        }
        
        Graphics2D g2d = (Graphics2D) g;
        
        GradientPaint gp = new GradientPaint(0, 0, Color.MAGENTA, 30,30, Color.ORANGE, true);
        
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getWidth());
    }
}
