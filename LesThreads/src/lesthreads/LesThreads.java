/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lesthreads;

/**
 *
 * @author setod
 */
public class LesThreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("Le nom du thread principal est "
        //        +Thread.currentThread().getName());
        
        ControlThread t = new ControlThread("A");
        ControlThread t2 = new ControlThread(" B", t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("statut du thread " + t.getName() + " = "
        + t.getState());
        System.out.println("statut du thread " + t2.getName() + " = "
        +t2.getState());
    }
    
}
