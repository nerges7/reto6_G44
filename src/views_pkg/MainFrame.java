/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views_pkg;

import controller_pkg.ControllerMainFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import model_pkg.DataModelDB;

/**
 *
 * @author SUPERFERRETERIA
 */
public class MainFrame extends javax.swing.JFrame {

    public final ControllerMainFrame controller_main;
    DataModelDB DataModel = new DataModelDB();

    /**
     * Creates new form FrameHospitals
     */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        controller_main = new ControllerMainFrame(this);

    }

    void addHospitals() {
        Clinics add_clinics = new Clinics(this, true);
        add_clinics.setAction_performer(true);
        add_clinics.setLocationRelativeTo(null);
        add_clinics.title.setText("REGISTRO DE CLINICAS");
        add_clinics.setVisible(true);
        controller_main.getHospitals();

    }

    void editHospitals() {
        Clinics edit_clinc = new Clinics(this, true);
        edit_clinc.setAction_performer(false);
        edit_clinc.setLocationRelativeTo(null);
        int fila = tb_hospitals.getSelectedRow();
        if (fila >= 0) {
            Object[] filaselect = {
                tb_hospitals.getValueAt(fila, 0),
                tb_hospitals.getValueAt(fila, 1),
                tb_hospitals.getValueAt(fila, 2)};
            edit_clinc.setTxt_id(String.valueOf(filaselect[0]));
            edit_clinc.setTxt_clinic(String.valueOf(filaselect[1]));
            edit_clinc.setTxt_addres(String.valueOf(filaselect[2]));
        }
        edit_clinc.title.setText("EDICION DE CLINICAS");
        edit_clinc.setVisible(true);
        controller_main.getHospitals();
    }

    void deleteHospital() {
        int fila = tb_hospitals.getSelectedRow();
        int id = Integer.parseInt((String) tb_hospitals.getValueAt(fila, 0).toString());
        DataModel.deleteHospitals(id);
        JOptionPane.showMessageDialog(this, "La clinica ha sido eliminada con exito");
        controller_main.getHospitals();
    }

    void addOwners() {
        Owner add_owners = new Owner(this, true);
        add_owners.setAction_performer(true);
        add_owners.setLocationRelativeTo(null);
        add_owners.title.setText("REGISTRO DE CLIENTES");
        add_owners.setVisible(true);
        controller_main.getOwners();
    }

    void editOwners() {
        Owner edit_owners = new Owner(this, true);
        edit_owners.setAction_performer(false);
        edit_owners.setLocationRelativeTo(null);
        int fila = tb_owners.getSelectedRow();
        if (fila >= 0) {
            Object[] filaselect = {
                tb_owners.getValueAt(fila, 0),
                tb_owners.getValueAt(fila, 1),
                tb_owners.getValueAt(fila, 2),
                tb_owners.getValueAt(fila, 3),
                tb_owners.getValueAt(fila, 4),
                tb_owners.getValueAt(fila, 5)};
            edit_owners.setTxt_id(String.valueOf(filaselect[0]));
            edit_owners.setTxt_name(String.valueOf(filaselect[1]));
            edit_owners.cb_document_type.setSelectedItem(String.valueOf(filaselect[2]));
            edit_owners.setTxt_document(String.valueOf(filaselect[3]));
            edit_owners.setTxt_contact(String.valueOf(filaselect[4]));
            if (String.valueOf(filaselect[5]).equals("Femenino")) {
                edit_owners.rb_f.setSelected(true);
                edit_owners.rb_m.setSelected(false);
            }
            if (String.valueOf(filaselect[5]).equals("Masculino")) {
                edit_owners.rb_m.setSelected(true);
                edit_owners.rb_f.setSelected(false);
            }
            edit_owners.title.setText("EDICION DE CLIENTES");
            edit_owners.setVisible(true);
            controller_main.getOwners();
        }
    }

    void deleteOwners() {
        int fila = tb_owners.getSelectedRow();
        int id = Integer.parseInt((String) tb_owners.getValueAt(fila, 0).toString());
        DataModel.deleteOwners(id);
        JOptionPane.showMessageDialog(this, "El cliente ha sido eliminado con exito");
        controller_main.getOwners();
    }

    void addPets() {
        Pets add_Pets = new Pets(this, true);
        add_Pets.setAction_performer(true);
        add_Pets.setLocationRelativeTo(null);
        add_Pets.title.setText("REGISTRO DE MASCOTAS");
        add_Pets.setVisible(true);
        controller_main.getPets();

    }

    void editPets() {
        Pets edit_Pets = new Pets(this, true);
        edit_Pets.setAction_performer(false);
        edit_Pets.setLocationRelativeTo(null);
        int fila = tb_pets.getSelectedRow();
        if (fila >= 0) {
            Object[] filaselect = {
                tb_pets.getValueAt(fila, 0),
                tb_pets.getValueAt(fila, 1),
                tb_pets.getValueAt(fila, 2),
                tb_pets.getValueAt(fila, 3),
                tb_pets.getValueAt(fila, 4),
                tb_pets.getValueAt(fila, 5)};
            edit_Pets.setTxt_id_pet(String.valueOf(filaselect[0]));
            edit_Pets.setTxt_pet(String.valueOf(filaselect[1]));
            edit_Pets.cb_pet_type.setSelectedItem(String.valueOf(filaselect[2]));
            edit_Pets.setTxt_race(String.valueOf(filaselect[3]));
            edit_Pets.cb_owners(String.valueOf(filaselect[5]), String.valueOf(filaselect[4]));
        }
        edit_Pets.title.setText("EDICION DE MASCOTAS");
        edit_Pets.setVisible(true);
        controller_main.getPets();
    }

    void deletePets() {
        int fila = tb_pets.getSelectedRow();
        int id = Integer.parseInt((String) tb_pets.getValueAt(fila, 0).toString());
        DataModel.deletePets(id);
        JOptionPane.showMessageDialog(this, "La mascota ha sido eliminada con exito");
        controller_main.getPets();
    }

    void addDoctors() {
        Doctors add_doctor = new Doctors(this, true);
        add_doctor.setAction_performer(true);
        add_doctor.setLocationRelativeTo(null);
        add_doctor.title.setText("REGISTRO DE DOCTORES");
        add_doctor.setVisible(true);
        controller_main.getDoctors();

    }

    void editDoctors() {
        Doctors edit_doctor = new Doctors(this, true);
        edit_doctor.setAction_performer(false);
        edit_doctor.setLocationRelativeTo(null);
        int fila = tb_doctors.getSelectedRow();
        if (fila >= 0) {
            Object[] filaselect = {
                tb_doctors.getValueAt(fila, 0),
                tb_doctors.getValueAt(fila, 1),
                tb_doctors.getValueAt(fila, 2),
                tb_doctors.getValueAt(fila, 3),
                tb_doctors.getValueAt(fila, 4),
                tb_doctors.getValueAt(fila, 5)};
            edit_doctor.setTxt_id(String.valueOf(filaselect[0]));
            edit_doctor.setTxt_doctor(String.valueOf(filaselect[1]));
            edit_doctor.cb_typedocument.setSelectedItem(String.valueOf(filaselect[2]));
            edit_doctor.setTxt_document(String.valueOf(filaselect[3]));
            edit_doctor.cb_hospitals(String.valueOf(filaselect[5]), String.valueOf(filaselect[4]));
        }
        edit_doctor.title.setText("EDICION DE DOCTORES");
        edit_doctor.setVisible(true);
        controller_main.getDoctors();

    }

    void deleteDoctors() {
        int fila = tb_doctors.getSelectedRow();
        int id = Integer.parseInt((String) tb_doctors.getValueAt(fila, 0).toString());
        DataModel.deleteDoctors(id);
        JOptionPane.showMessageDialog(this, "El doctor ha sido eliminado con exito");
        controller_main.getDoctors();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Mainpanel = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hospitals = new javax.swing.JTable();
        add_clinic = new javax.swing.JButton();
        edit_clinic = new javax.swing.JButton();
        delete_clinic = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_owners = new javax.swing.JTable();
        add_owner = new javax.swing.JButton();
        edit_owner = new javax.swing.JButton();
        delete_owner = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_pets = new javax.swing.JTable();
        btn_add_pet = new javax.swing.JButton();
        edit_pet = new javax.swing.JButton();
        delete_pet = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_doctors = new javax.swing.JTable();
        add_doctors = new javax.swing.JButton();
        edit_doctors = new javax.swing.JButton();
        delete_doctors = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setText("HISTORIAL DE CLINICAS");

        tb_hospitals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_hospitals.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tb_hospitals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hospitalsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_hospitals);

        add_clinic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/plus.png"))); // NOI18N
        add_clinic.setToolTipText("Crear Clinica");
        add_clinic.setBorderPainted(false);
        add_clinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_clinicActionPerformed(evt);
            }
        });

        edit_clinic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/pencil.png"))); // NOI18N
        edit_clinic.setToolTipText("Editar Clinica");
        edit_clinic.setBorderPainted(false);
        edit_clinic.setEnabled(false);
        edit_clinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_clinicActionPerformed(evt);
            }
        });

        delete_clinic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/remove .png"))); // NOI18N
        delete_clinic.setToolTipText("Eliminar Clinica");
        delete_clinic.setBorderPainted(false);
        delete_clinic.setEnabled(false);
        delete_clinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_clinicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(add_clinic, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_clinic, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_clinic, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(272, 272, 272))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2)
                        .addComponent(add_clinic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit_clinic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(delete_clinic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        Mainpanel.addTab("CLINICAS", jPanel3);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setText("LISTADO DE CLIENTES");

        tb_owners.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo Documento", "Numero", "Contacto", "Genero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_owners.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tb_owners.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ownersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_owners);

        add_owner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/plus.png"))); // NOI18N
        add_owner.setToolTipText("Crear Cliente");
        add_owner.setBorderPainted(false);
        add_owner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ownerActionPerformed(evt);
            }
        });

        edit_owner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/pencil.png"))); // NOI18N
        edit_owner.setToolTipText("Editar Cliente");
        edit_owner.setBorderPainted(false);
        edit_owner.setEnabled(false);
        edit_owner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_ownerActionPerformed(evt);
            }
        });

        delete_owner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/remove .png"))); // NOI18N
        delete_owner.setToolTipText("Eliminar Cliente");
        delete_owner.setBorderPainted(false);
        delete_owner.setEnabled(false);
        delete_owner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_ownerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(add_owner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_owner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_owner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(272, 272, 272))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(add_owner)
                    .addComponent(edit_owner)
                    .addComponent(delete_owner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        Mainpanel.addTab("CLIENTES", jPanel4);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setText("HISTORIAL MASCOTAS");

        tb_pets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mascota", "Tipo", "Raza", "Dueño", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_pets.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tb_pets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_petsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_pets);
        if (tb_pets.getColumnModel().getColumnCount() > 0) {
            tb_pets.getColumnModel().getColumn(5).setMinWidth(0);
            tb_pets.getColumnModel().getColumn(5).setPreferredWidth(0);
            tb_pets.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        btn_add_pet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/plus.png"))); // NOI18N
        btn_add_pet.setToolTipText("Crear Mascota");
        btn_add_pet.setBorderPainted(false);
        btn_add_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_petActionPerformed(evt);
            }
        });

        edit_pet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/pencil.png"))); // NOI18N
        edit_pet.setToolTipText("Editar Mascota");
        edit_pet.setBorderPainted(false);
        edit_pet.setEnabled(false);
        edit_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_petActionPerformed(evt);
            }
        });

        delete_pet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/remove .png"))); // NOI18N
        delete_pet.setToolTipText("Eliminar Mascota");
        delete_pet.setBorderPainted(false);
        delete_pet.setEnabled(false);
        delete_pet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_petActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_add_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_pet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(284, 284, 284))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(btn_add_pet)
                    .addComponent(edit_pet)
                    .addComponent(delete_pet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        Mainpanel.addTab("MASCOTAS", jPanel5);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel6.setText("LISTA DE DOCTORES");

        tb_doctors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Doctor", "Tipo Documento", "Numero Documento", "Clinica", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_doctors.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tb_doctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_doctorsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_doctors);
        if (tb_doctors.getColumnModel().getColumnCount() > 0) {
            tb_doctors.getColumnModel().getColumn(5).setMinWidth(0);
            tb_doctors.getColumnModel().getColumn(5).setPreferredWidth(0);
            tb_doctors.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        add_doctors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/plus.png"))); // NOI18N
        add_doctors.setToolTipText("Crear Doctor");
        add_doctors.setBorderPainted(false);
        add_doctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_doctorsActionPerformed(evt);
            }
        });

        edit_doctors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/pencil.png"))); // NOI18N
        edit_doctors.setToolTipText("Editar Doctor");
        edit_doctors.setBorderPainted(false);
        edit_doctors.setEnabled(false);
        edit_doctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_doctorsActionPerformed(evt);
            }
        });

        delete_doctors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public_pkg/remove .png"))); // NOI18N
        delete_doctors.setToolTipText("Eliminar Doctor");
        delete_doctors.setBorderPainted(false);
        delete_doctors.setEnabled(false);
        delete_doctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_doctorsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(add_doctors, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_doctors, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_doctors, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(284, 284, 284))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(add_doctors)
                    .addComponent(edit_doctors)
                    .addComponent(delete_doctors))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        Mainpanel.addTab("DOCTORES", jPanel6);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("SISTEMA DE GESTION VETERINARIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mainpanel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Mainpanel)
                .addContainerGap())
        );

        Mainpanel.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_clinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_clinicActionPerformed
        addHospitals();
    }//GEN-LAST:event_add_clinicActionPerformed

    private void edit_clinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_clinicActionPerformed
        editHospitals();
    }//GEN-LAST:event_edit_clinicActionPerformed

    private void delete_clinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_clinicActionPerformed
        deleteHospital();
    }//GEN-LAST:event_delete_clinicActionPerformed

    private void add_ownerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ownerActionPerformed
        addOwners();
    }//GEN-LAST:event_add_ownerActionPerformed

    private void edit_ownerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_ownerActionPerformed
        editOwners();
    }//GEN-LAST:event_edit_ownerActionPerformed

    private void delete_ownerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_ownerActionPerformed
        deleteOwners();
    }//GEN-LAST:event_delete_ownerActionPerformed

    private void btn_add_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_petActionPerformed
        addPets();
    }//GEN-LAST:event_btn_add_petActionPerformed

    private void edit_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_petActionPerformed
        editPets();
    }//GEN-LAST:event_edit_petActionPerformed

    private void delete_petActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_petActionPerformed
        deletePets();
    }//GEN-LAST:event_delete_petActionPerformed

    private void add_doctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_doctorsActionPerformed
        addDoctors();
    }//GEN-LAST:event_add_doctorsActionPerformed

    private void edit_doctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_doctorsActionPerformed
        editDoctors();
    }//GEN-LAST:event_edit_doctorsActionPerformed

    private void delete_doctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_doctorsActionPerformed
        deleteDoctors();
    }//GEN-LAST:event_delete_doctorsActionPerformed

    private void tb_hospitalsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hospitalsMouseClicked
        edit_clinic.setEnabled(true);
        delete_clinic.setEnabled(true);
    }//GEN-LAST:event_tb_hospitalsMouseClicked

    private void tb_ownersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ownersMouseClicked
        edit_owner.setEnabled(true);
        delete_owner.setEnabled(true);
    }//GEN-LAST:event_tb_ownersMouseClicked

    private void tb_petsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_petsMouseClicked
        edit_pet.setEnabled(true);
        delete_pet.setEnabled(true);
    }//GEN-LAST:event_tb_petsMouseClicked

    private void tb_doctorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_doctorsMouseClicked
        edit_doctors.setEnabled(true);
        delete_doctors.setEnabled(true);
    }//GEN-LAST:event_tb_doctorsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Mainpanel;
    private javax.swing.JButton add_clinic;
    private javax.swing.JButton add_doctors;
    private javax.swing.JButton add_owner;
    private javax.swing.JButton btn_add_pet;
    private javax.swing.JButton delete_clinic;
    private javax.swing.JButton delete_doctors;
    private javax.swing.JButton delete_owner;
    private javax.swing.JButton delete_pet;
    private javax.swing.JButton edit_clinic;
    private javax.swing.JButton edit_doctors;
    private javax.swing.JButton edit_owner;
    private javax.swing.JButton edit_pet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable tb_doctors;
    public javax.swing.JTable tb_hospitals;
    public javax.swing.JTable tb_owners;
    public javax.swing.JTable tb_pets;
    // End of variables declaration//GEN-END:variables
}
