/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lesthreads;

/**
 *
 * @author setod
 */
public class ControlThread extends Thread{
    Thread t;
    public ControlThread(String name){
        super(name);
        System.out.println("Etat du thread '" + name + "' = " +this.getState());
        this.start();
        System.out.println("Etat du thread '" + name + "' = " + this.getState());
    }
    public ControlThread(String name, Thread t){
        super(name);
        this.t = t;
        System.out.println("Etat du thread '" + name + "' = " +this.getState());
        this.start();
        System.out.println("Etat du thread '" + name + "' = " +this.getState());
    }
    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
        System.out.println("Etat de " + this.getName() + " = "
        +this.getState());
        if(t != null)
            System.out.println("Etat de " + t.getName()
            + " pendant le thread " + this.getName() +" = " +t.getState());
        }
    }
    public void setThread(Thread t){
        this.t = t;
    }
    
}
