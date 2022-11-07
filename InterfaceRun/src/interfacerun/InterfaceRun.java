/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfacerun;

/**
 *
 * @author setod
 */
public class InterfaceRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CompteEnBanque cb = new CompteEnBanque();
        
        //Effectue le thread muni de la méthode run de RunImpl(cb)
        Thread t = new Thread(new RunImpl(cb, "Honoré"));   
        Thread t2 = new Thread(new RunImpl(cb, " Bienvenu"));
        t.start();
        t2.start();
    }
    
}
