/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;

/**
 *
 * @author hardiksodhani
 */
public class Patient {
    private String patientID;
    private String primaryDoctorName;
    private vitalSignHistory vitalSignHistory;

    
    public Patient() {
        this.vitalSignHistory = new vitalSignHistory();
    }
    
    public vitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }
    
    public void setVitalSignHistory(vitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }
    
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPrimaryDoctorName() {
        return primaryDoctorName;
    }

    public void setPrimaryDoctorName(String primaryDoctorName) {
        this.primaryDoctorName = primaryDoctorName;
    }

    
}
