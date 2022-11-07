/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interface1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class Panneau2 extends JPanel {

    private int posX = -50;
    private int posY = -50;
    private int drawSize = -50;   // pour le morphing
    //Un booléen pour le mode morphing
    //Un autre pour savoir si la taille doit être réduite
    private boolean morph = false, reduce = false;
    private String forme = "ROND";
    //Le compteur de rafraîchissements
    private int increment = 0;
    
    @Override
    public void paintComponent(Graphics g){
    g.setColor(Color.white);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    g.setColor(Color.red);
    //Si le mode morphing est activé, on peint le morphing
    if(this.morph) drawMorph(g);
    //Sinon, on peint le mode normal
    else draw(g);
    }
    
    private void draw(Graphics g){
        if(this.forme.equals("ROND")) g.fillOval(posX, posY, 50, 50);
        
        if(this.forme.equals("CARRE")) g.fillRect(posX, posY, 50, 50);

        if(this.forme.equals("TRIANGLE")){
            int s1X = posX + 50/2;
            int s1Y = posY;
            int s2X = posX + 50;
            int s2Y = posY + 50;
            int s3X = posX;
            int s3Y = posY + 50;
        
            int[] ptsX = {s1X, s2X, s3X};
            int[] ptsY = {s1Y, s2Y, s3Y};
            g.fillPolygon(ptsX, ptsY, 3);
        }

        if(this.forme.equals("ETOILE")){
            int s1X = posX + 50/2;
            int s1Y = posY;
            int s2X = posX + 50;
            int s2Y = posY + 50;
            g.drawLine(s1X, s1Y, s2X, s2Y);
            int s3X = posX;
            int s3Y = posY + 50/3;
            g.drawLine(s2X, s2Y, s3X, s3Y);
            int s4X = posX + 50;
            int s4Y = posY + 50/3;
            g.drawLine(s3X, s3Y, s4X, s4Y);
            int s5X = posX;
            int s5Y = posY + 50;
            g.drawLine(s4X, s4Y, s5X, s5Y);
            g.drawLine(s5X, s5Y, s1X, s1Y);
        }
}
    
    //Méthode qui peint le morphing
    private void drawMorph(Graphics g){
    //On incrémente
    increment++;
    //On regarde si on doit réduire ou non
    if(drawSize >= 50) reduce = true;
    if(drawSize <= 10) reduce = false;
    
    if(reduce) drawSize -= getUsedSize();
    else drawSize += getUsedSize();
    
    if(this.forme.equals("ROND")) g.fillOval(posX, posY, drawSize, drawSize);

    if(this.forme.equals("CARRE")) g.fillRect(posX, posY, drawSize, drawSize);


        if(this.forme.equals("TRIANGLE")){
            int s1X = posX + 50/2;
            int s1Y = posY;
            int s2X = posX + 50;
            int s2Y = posY + 50;
            int s3X = posX;
            int s3Y = posY + 50;
        
            int[] ptsX = {s1X, s2X, s3X};
            int[] ptsY = {s1Y, s2Y, s3Y};
            g.fillPolygon(ptsX, ptsY, 3);
        }

        if(this.forme.equals("ETOILE")){
            int s1X = posX + 50/2;
            int s1Y = posY;
            int s2X = posX + 50;
            int s2Y = posY + 50;
            g.drawLine(s1X, s1Y, s2X, s2Y);
            int s3X = posX;
            int s3Y = posY + 50/3;
            g.drawLine(s2X, s2Y, s3X, s3Y);
            int s4X = posX + 50;
            int s4Y = posY + 50/3;
            g.drawLine(s3X, s3Y, s4X, s4Y);
            int s5X = posX;
            int s5Y = posY + 50;
            g.drawLine(s4X, s4Y, s5X, s5Y);
            g.drawLine(s5X, s5Y, s1X, s1Y);
        }
}
    
    //Retourne le nombre à retrancher ou à ajouter pour le morphing
    private int getUsedSize(){
        int res = 0;
        //Si le nombre de tours est de dix, on réinitialise l'incrément et on retourne 1
        if(increment / 10 == 1){
            increment = 0;
            res = 1;
        }
        return res;
    }
    
    public int getDrawSize(){
        return drawSize;
    }
    
    public boolean isMorph(){
        return morph;
    }

    public void setMorph(boolean bool){
        this.morph = bool;
        //On réinitialise la taille
        drawSize = 50;
    }

    public void setForme(String form){
        this.forme = form;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
    
    public int getPosY() {
        return posY;
    }
    
    public void setPosY(int posY) {
        this.posY = posY;
    }
}