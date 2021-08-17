/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_pkg;

/**
 *
 * @author SUPERFERRETERIA
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model_pkg.DataDB;
import model_pkg.DataModelDB;
import views_pkg.*;

public class ControllerMainFrame {

    private final MainFrame view; 
    
    public ControllerMainFrame(MainFrame view) {
        this.view = view;
        getHospitals();
        getOwners();
        getPets();
        getDoctors();
    }
    
    
    public final void getHospitals() {
        ArrayList<DataDB> list;
        DataModelDB model = new DataModelDB();
        list = model.getHospitals();
        clear_rows_table(view.tb_hospitals);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                DefaultTableModel modelTable = (DefaultTableModel) view.tb_hospitals.getModel();
                Object[] fila = new Object[3];
                fila[0] = list.get(i).getIdHospital();
                fila[1] = list.get(i).getHospital();
                fila[2] = list.get(i).getAddress();
                modelTable.addRow(fila);
                view.tb_hospitals.setModel(modelTable);
            }
        }
    }

    
     public final void getOwners() {
        ArrayList<DataDB> list;
        DataModelDB model = new DataModelDB();
        list = model.getOwners();
        clear_rows_table(view.tb_owners);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                DefaultTableModel modelTable = (DefaultTableModel) view.tb_owners.getModel();
                Object[] fila = new Object[6];
                fila[0] = list.get(i).getIdOwner();
                fila[1] = list.get(i).getOwner();
                fila[2] = list.get(i).getDocument_type();
                fila[3] = list.get(i).getDocument();
                fila[4] = list.get(i).getContact();
                fila[5] = list.get(i).getGender();
                modelTable.addRow(fila);
                view.tb_owners.setModel(modelTable);
            }
            System.out.println("Llenar cli");
        } 
    }
     
    public void getPets() {
        ArrayList<DataDB> list;
        DataModelDB model = new DataModelDB();
        list = model.getPets();
        clear_rows_table(view.tb_pets);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                DefaultTableModel modelTable = (DefaultTableModel) view.tb_pets.getModel();
                Object[] fila = new Object[6];
                fila[0] = list.get(i).getIdPets();
                fila[1] = list.get(i).getPets();
                fila[2] = list.get(i).getPet_type();
                fila[3] = list.get(i).getRace();
                fila[4] = list.get(i).getOwner();
                fila[5] = list.get(i).getIdOwner();
                modelTable.addRow(fila);
                view.tb_pets.setModel(modelTable);
            }
            System.out.println("Llenar pets");
        } 
    }
    
    public final void getDoctors() {
        ArrayList<DataDB> list;
        DataModelDB model = new DataModelDB();
        list = model.getDoctors();
        clear_rows_table(view.tb_doctors);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                DefaultTableModel modelTable = (DefaultTableModel) view.tb_doctors.getModel();
                Object[] fila = new Object[6];
                fila[0] = list.get(i).getIdDoctors();
                fila[1] = list.get(i).getDoctor();
                fila[2] = list.get(i).getDoc_type();
                fila[3] = list.get(i).getDocument_doc();
                fila[4] = list.get(i).getHospital();
                fila[5] = list.get(i).getIdHospital();

                modelTable.addRow(fila);
                view.tb_doctors.setModel(modelTable);
            }
        } 
    }
    
   void clear_rows_table(JTable table){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       System.out.println("Clear");
        while (table.getRowCount() > 0) {
            model.removeRow(0);
        }
   }

    public void actionPerformed(ActionEvent ae) {

    }

}

