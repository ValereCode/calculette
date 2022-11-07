/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import observer.Observable;
import observer.Observateur;
/**
 *
 * @author setod
 */
public class Horloge implements Observable{
  
    //Objet calendrier pour récupérer l'heure courante
    private Calendar cal;
    private String hour = "";
    // La liste des observateurs de notre horloge
    private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
    
    public void run() {
        while(true){
            //On récupère l'instance d'un calendrier à chaque tour
            //Elle va nous permettre de récupérer l'heure actuelle
            this.cal = Calendar.getInstance();
            this.hour = //Les heures
            this.cal.get(Calendar.HOUR_OF_DAY) + " : " + 
            ( //Les minutes 
            this.cal.get(Calendar.MINUTE) < 10 ? "0" + this.cal.get(Calendar.MINUTE)
            : this.cal.get(Calendar.MINUTE))
            + " : " +
            ( //Les secondes
            (this.cal.get(Calendar.SECOND)< 10) ? "0"+this.cal.get(Calendar.SECOND)
            : this.cal.get(Calendar.SECOND));

            /*
                On met à jour les observateurs que 
                l'heure à été mis à jour
            */
            this.updateObservateur();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    // Ajout d'observateurs
    @Override
    public void addObservateur(Observateur obs) {
        this.listObservateur.add(obs);
    }

    /*
    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
    */
    
    // Mise à jour d'observateur
    @Override
    public void updateObservateur() {
        for(Observateur obs : this.listObservateur) {
            obs.update(this.hour);
        }
    }

    // Suppression de tous les observateurs
    @Override
    public void delObservateur() {
        this.listObservateur = new ArrayList<Observateur>();
    }
    
}

