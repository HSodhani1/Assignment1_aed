/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author hardiksodhani
 */
public class vitalSignHistory {
    
    private ArrayList<vitalSign> history;

    public ArrayList<vitalSign> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<vitalSign> history) {
        this.history = history;
    }
    
    public vitalSign createAndAddVitalSign() {
        vitalSign vitalSign = new vitalSign();
        history.add(vitalSign);
        return vitalSign;
    }
    
    public void deleteVitalSign(vitalSign vitalSign) {
        history.remove(vitalSign);
    }
}
