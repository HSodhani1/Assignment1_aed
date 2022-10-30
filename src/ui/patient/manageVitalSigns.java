/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.patient;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Patient;
import model.person;
import model.personDirectory;
import model.stringVerifier;
import model.vitalSign;

/**
 *
 * @author hardiksodhani
 */
public class manageVitalSigns extends javax.swing.JPanel {

    private personDirectory personDirectory;
    private JPanel userProcessContainer;
    /**
     * Creates new form manageVitalSigns
     */
    public manageVitalSigns(JPanel userProcessContainer, personDirectory personDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.personDirectory= personDirectory;
        InputVerifier stringVerifier = new stringVerifier();
        txtPatientSearch.setInputVerifier(stringVerifier);
        ArrayList<person> personList = personDirectory.getPersonHistory();
        populatePatientsTable(personList);
        populateVitalSignTable(null);
    }
    
    private void populatePatientsTable(ArrayList<person> personList) {
        DefaultTableModel model = (DefaultTableModel) tblPatientInfo.getModel();
        model.setRowCount(0);
        if(personList.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No Persons found. Please add Persons",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (person person : personList) {
            Object[] row = new Object[3];
            row[0] = person;
            row[1]= person.getAge();
            if(person.getPatient()!=null)
            {
                row[2] = person.getPatient().getPatientID();
            }
            else
            {
                row[2] = "Patient Not Created";
            }
            
            model.addRow(row);
        }
    }
    
    private void populateVitalSignTable(person person) {
        
        DefaultTableModel model = (DefaultTableModel) tblViewVitalSigns.getModel();
        model.setRowCount(0);
        if (person != null) {
            int patientAge = person.getAge();
            ArrayList<vitalSign> vitalSignList = person.getPatient().getVitalSignHistory().getHistory();
            
            if (vitalSignList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No vital signs found. Please"
                        + " add vital signs", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            for (vitalSign vitalSign : vitalSignList) {
                Object[] row = new Object[2];
                row[0] = vitalSign;
                row[1] = vitalSignStatus(patientAge, vitalSign);
                if(row[1].equals("Abnormal")){
                    person.setHasVitalSigns(true);
                }
                else{
                    person.setHasVitalSigns(false);
                }
                model.addRow(row);
            }
        }
    }
    
    private String vitalSignStatus(int patientAge, vitalSign vitalSign) {
        String vitalSignStatus = "Normal";
        
        int bloodPressure = (int) vitalSign.getBloodPressure();
        
        if (bloodPressure < 80 || bloodPressure > 120){
            
            vitalSignStatus = "Abnormal";
        }

        return vitalSignStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientInfo = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnAddVitalSigns = new javax.swing.JButton();
        btnDisplayDetails = new javax.swing.JButton();
        btnSearchPatient = new javax.swing.JButton();
        btnRefreshPatient = new javax.swing.JButton();
        txtPatientSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblViewVitalSigns = new javax.swing.JTable();
        btnViewVitalSigns = new javax.swing.JButton();
        btnEditVitalSigns = new javax.swing.JButton();
        btnDeleteVitalSigns = new javax.swing.JButton();
        btnRefreshVitalSigns = new javax.swing.JButton();

        tblPatientInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Patient Name", "Age", "Patient ID"
            }
        ));
        jScrollPane1.setViewportView(tblPatientInfo);

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAddVitalSigns.setText("Add Vital SIgn");
        btnAddVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVitalSignsActionPerformed(evt);
            }
        });

        btnDisplayDetails.setText("Display Details");
        btnDisplayDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayDetailsActionPerformed(evt);
            }
        });

        btnSearchPatient.setText("Search Patient");
        btnSearchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPatientActionPerformed(evt);
            }
        });

        btnRefreshPatient.setText("Refresh Patients");
        btnRefreshPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPatientActionPerformed(evt);
            }
        });

        txtPatientSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientSearchActionPerformed(evt);
            }
        });

        tblViewVitalSigns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Timestamp", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblViewVitalSigns);

        btnViewVitalSigns.setText("View Vital Signs");
        btnViewVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVitalSignsActionPerformed(evt);
            }
        });

        btnEditVitalSigns.setText("Edit Vital Signs");
        btnEditVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditVitalSignsActionPerformed(evt);
            }
        });

        btnDeleteVitalSigns.setText("Delete Vital Signs");
        btnDeleteVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteVitalSignsActionPerformed(evt);
            }
        });

        btnRefreshVitalSigns.setText("Refresh Vital Signs");
        btnRefreshVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshVitalSignsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddVitalSigns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPatientSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDisplayDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefreshPatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnViewVitalSigns)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRefreshVitalSigns)
                                    .addComponent(btnEditVitalSigns))
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteVitalSigns)))
                        .addGap(18, 18, 18)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddVitalSigns, btnBack, btnDisplayDetails, btnRefreshPatient, btnSearchPatient});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDeleteVitalSigns, btnEditVitalSigns, btnRefreshVitalSigns, btnViewVitalSigns});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnAddVitalSigns)
                    .addComponent(btnDisplayDetails))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchPatient)
                    .addComponent(btnRefreshPatient)
                    .addComponent(txtPatientSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewVitalSigns)
                    .addComponent(btnEditVitalSigns)
                    .addComponent(btnDeleteVitalSigns))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefreshVitalSigns)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddVitalSigns, btnDisplayDetails, btnRefreshPatient});

    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVitalSignsActionPerformed
        int selectedRow = tblPatientInfo.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.");
            return;
        }
        person person = (person) tblPatientInfo.getValueAt(selectedRow, 0);
        Patient patient= person.getPatient();
        if(patient==null)
        {
            JOptionPane.showMessageDialog(this, "Patient not created, Please create"
                    + " Patient first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        selectedRow = tblViewVitalSigns.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        vitalSign vitalSign = (vitalSign) tblViewVitalSigns.getValueAt(selectedRow, 0);
        
        int flag= JOptionPane.showConfirmDialog(this, "Are you sure want to remove?",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(flag==0)
        {
            patient.getVitalSignHistory().deleteVitalSign(vitalSign);
            refreshVialSigns();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteVitalSignsActionPerformed

    private void txtPatientSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientSearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDisplayDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayDetailsActionPerformed
                int selectedRow = tblPatientInfo.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        person person = (person) tblPatientInfo.getValueAt(selectedRow, 0);
        Patient patient= person.getPatient();
        if(patient!=null)
        {
            populateVitalSignTable(person);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Patient not created, Please create "
                    + "Patient first.", "Error", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnDisplayDetailsActionPerformed

    private void btnAddVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVitalSignsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddVitalSignsActionPerformed

    private void btnSearchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPatientActionPerformed
        String key = txtPatientSearch.getText().trim();
        if(key.length()==0)
        {
            JOptionPane.showMessageDialog(this, "Please enter key.","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /*Storing searched patients in an array to display in table.*/
        ArrayList<person> searchPatients = personDirectory.searchPatient(key);
        populatePatientsTable(searchPatients);        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchPatientActionPerformed

    private void btnRefreshPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPatientActionPerformed
        txtPatientSearch.setText("");
        populatePatientsTable(personDirectory.getPersonHistory());        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshPatientActionPerformed

    private void btnViewVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVitalSignsActionPerformed
        int selectedRow = tblViewVitalSigns.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        vitalSign vitalSign = (vitalSign) tblViewVitalSigns.getValueAt(selectedRow, 0);
        viewUpdateVitalSigns vuvsJPanel = new viewUpdateVitalSigns(userProcessContainer, vitalSign, Boolean.FALSE);
        userProcessContainer.add("vuvsJPanel", vuvsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewVitalSignsActionPerformed

    private void btnEditVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditVitalSignsActionPerformed
        int selectedRow = tblViewVitalSigns.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        vitalSign vitalSign = (vitalSign) tblViewVitalSigns.getValueAt(selectedRow, 0);
        
        viewUpdateVitalSigns vuvsJPanel = new viewUpdateVitalSigns(userProcessContainer,
                vitalSign, Boolean.TRUE);
        userProcessContainer.add("vuvsJPanel", vuvsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditVitalSignsActionPerformed

    private void btnRefreshVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshVitalSignsActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshVitalSignsActionPerformed
    
    private void refreshVialSigns() {
        int selectedRow = tblPatientInfo.getSelectedRow();
        if (selectedRow < 0) {
            populateVitalSignTable(null);
        } else {
            person person = (person) tblPatientInfo.getValueAt(selectedRow, 0);
            Patient patient= person.getPatient();
            if(patient!=null)
            {
                populateVitalSignTable(person);
            }
            else
            {
                populateVitalSignTable(null);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVitalSigns;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteVitalSigns;
    private javax.swing.JButton btnDisplayDetails;
    private javax.swing.JButton btnEditVitalSigns;
    private javax.swing.JButton btnRefreshPatient;
    private javax.swing.JButton btnRefreshVitalSigns;
    private javax.swing.JButton btnSearchPatient;
    private javax.swing.JButton btnViewVitalSigns;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPatientInfo;
    private javax.swing.JTable tblViewVitalSigns;
    private javax.swing.JTextField txtPatientSearch;
    // End of variables declaration//GEN-END:variables
}
