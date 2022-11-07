/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

/**
 *
 * @author setod
 */
public interface Observable {
    public void addObservateur(Observateur obs);
    public void updateObservateur();
    public void delObservateur();
}
