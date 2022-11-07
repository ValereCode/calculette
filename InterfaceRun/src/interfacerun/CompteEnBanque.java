/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacerun;

/**
 *
 * @author setod
 */
class CompteEnBanque {
    private int solde = 100;
    public int getSolde(){
        if(this.solde < 0) System.out.println("Vous êtes à découvert !");
        return this.solde;
    }
    public synchronized void retraitArgent(int retrait){
        solde -= retrait;
        System.out.println("Solde = " + solde);
    }
}
