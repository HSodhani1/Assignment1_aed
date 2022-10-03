/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import java.util.ArrayList;

/**
 *
 * @author hardiksodhani
 */
public class EmployeeInfo {
    private ArrayList<Employee> history;
   
    public EmployeeInfo() {
        this.history = new ArrayList<Employee>();        
        
    }

    public ArrayList<Employee> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Employee> history) {
        this.history = history;
    }
    
    public Employee addNewEmployee(){
        
        Employee newEmployee = new Employee();
        history.add(newEmployee);
        return newEmployee;
    
    }
    
    public void deleteEmployee(Employee em){
        history.remove(em);
        
    }

}
