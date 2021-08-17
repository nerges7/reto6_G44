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
import views_pkg.Pets;

public class ControllerPets implements ActionListener {

    private final Pets view;

    public final void events() {
        view.cb_owners.addActionListener(this);
    }

    public ControllerPets (Pets view) {
        this.view = view;
        getOwners();
        ItemOwner item = (ItemOwner) view.cb_owners.getSelectedItem();
        events();
    }

    
     public final void getOwners() {
        ArrayList<DataDB> list;
        DataModelDB model = new DataModelDB();
        list = model.getOwners();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int idOwner = list.get(i).getIdOwner();
                String owner = list.get(i).getOwner();
                view.cb_owners.addItem(new ItemOwner(idOwner, owner));
                view.setIdowners(list.get(0).getIdOwner());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron registro de clientes", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void set_cb_owners(Object owner, int id){
        view.cb_owners.getModel().setSelectedItem(owner);
        view.setIdowners(id);
        
    }

  @Override
    public void actionPerformed(ActionEvent ae) {
        Object evt = ae.getSource();
        if (evt.equals(view.cb_owners)) {
            ItemOwner item = (ItemOwner) view.cb_owners.getSelectedItem();
            view.setIdowners(item.getIdOwner());
        
        }  
    }

}
