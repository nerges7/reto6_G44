/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_pkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model_pkg.DataDB;
import model_pkg.DataModelDB;
import views_pkg.Doctors;

public class ControllerDoctor implements ActionListener {

    private final Doctors view;

    public ControllerDoctor(Doctors view) {
        this.view = view;
        getClinicas();
        ItemHospital item = (ItemHospital) view.cb_hospitals.getSelectedItem();
        events();
    }

    public final void events() {
        view.cb_hospitals.addActionListener(this);
    }

    public final void getClinicas() {
        ArrayList<DataDB> list;
        DataModelDB model = new DataModelDB();
        list = model.getHospitals();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int id_hospital = list.get(i).getIdHospital();
                String hospital = list.get(i).getHospital();
                view.cb_hospitals.addItem(new ItemHospital(id_hospital, hospital));
                view.setIdhospital(list.get(0).getIdHospital());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron registro de clinicas", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void set_cb_hospital(Object owner, int id) {
        view.cb_hospitals.getModel().setSelectedItem(owner);
        view.setIdhospital(id);
        

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object evt = ae.getSource();
        if (evt.equals(view.cb_hospitals)) {
            ItemHospital item = (ItemHospital) view.cb_hospitals.getSelectedItem();
            view.setIdhospital(item.getIdHospital());
        }
    }

}
