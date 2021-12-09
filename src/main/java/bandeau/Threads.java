/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandeau;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Johana Dahan
 */
class Threads extends Thread{
    
    private List<ScenarioElement> myElements = new LinkedList<>();
    private Bandeau monBandeau;
    
    public Threads(Bandeau b, List<ScenarioElement> pList) {
        this.monBandeau = b;
        this.myElements = pList;
    }

    public void run() {

        synchronized(monBandeau){
            for (ScenarioElement element : myElements) {
                for (int repeats = 0; repeats < element.repeats; repeats++) {
                    element.effect.playOn(monBandeau);
                }
            }
        }
    }
}