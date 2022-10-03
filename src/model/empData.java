/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
 
public class empData {
    private ArrayList<employeeData> history;
    
    public empData() {
        this.history= new ArrayList<employeeData>();
    }

    public ArrayList<employeeData> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<employeeData> history) {
        this.history = history;
    }

   
    public employeeData add(){
        employeeData newdata = new employeeData();
        history.add(newdata);
        return newdata;
    }
    
    public void deleteColumns(employeeData ed) {
    history.remove(ed);
    }
}
    

