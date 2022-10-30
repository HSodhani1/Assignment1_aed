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
public class personDirectory {
    private ArrayList<person> personDirectory;

    public personDirectory() {
        personDirectory = new ArrayList<>();
    }
    
//    public ArrayList<person> getPersonDirectory() {
//        return personDirectory;
//    }

    public ArrayList<person> getPersonHistory() {
        return personDirectory;
    }
    
    public void setPersonHistory(ArrayList<person> personHistory) {
        this.personDirectory = personHistory;
    }
    
//    public void setPersonDirectory(ArrayList<person> personDirectory) {
//        this.personDirectory = personDirectory;
//    }
        
    public person createAndAddPerson() {
        person person = new person();
        personDirectory.add(person);
        return person;
    }
    
    public void deletePerson(person person) {
        personDirectory.remove(person);
    }
    
    public ArrayList<person> searchPatient(String key)
    {
        ArrayList<person> searchPatientDirectory = new ArrayList();
        for(person person: personDirectory)
        {
            if(person.getPersonName().toLowerCase().startsWith(key.toLowerCase()))
            {
                if(person.getPatient()!=null)
                {
                    searchPatientDirectory.add(person);
                }
            }
        }
        return searchPatientDirectory;
    }
    
    public ArrayList<person> searchPerson(String key)
    {
        ArrayList<person> searchPersonDirectory = new ArrayList();
        for(person person: personDirectory)
        {
            if(person.getPersonName().toLowerCase().startsWith(key.toLowerCase()))
            {
                searchPersonDirectory.add(person);
            }
        }
        return searchPersonDirectory;
    }
    
    
 
}
