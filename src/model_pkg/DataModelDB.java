/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_pkg;

/**
 *
 * @author SUPERFERRETERIA
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DataModelDB {

    public ArrayList<DataDB> getHospitals() {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
        DataDB datosDB;
        ArrayList list = new ArrayList();
        try {
            String sql = "SELECT * FROM `tb_hospital`";
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (cn != null) {
                System.out.println("Conexión éxitosa DataModelDB Hospitales");
                while (rs.next()) {
                    datosDB = new DataDB();
                    datosDB.setIdHospital(rs.getInt("id"));
                    datosDB.setHospital(rs.getString("name"));
                    datosDB.setAddress(rs.getString("address"));
                    list.add(datosDB);
                }
            } else {
                JOptionPane.showMessageDialog(null, ".::Error al realizar la consulta::.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    public void addHospitals(String hospital, String addres) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql = "INSERT INTO `tb_hospital`(name, `address`) VALUES('" + hospital + "', '" + addres + "')";
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setHospitals(int id, String hospital, String addres) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql = "UPDATE tb_hospital SET name = '" + hospital + "', address= '" + addres + "' WHERE id = " + id;
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteHospitals(int id) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql = "DELETE FROM tb_hospital WHERE id = " + id;
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<DataDB> getOwners() {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
        DataDB datosDB;
        ArrayList list = new ArrayList();
        try {
            String sql = "SELECT * FROM `tb_pet_owners`";
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (cn != null) {
                System.out.println("Conexión éxitosa DataModelDB Clientes");
                while (rs.next()) {
                    datosDB = new DataDB();
                    datosDB.setIdOwner(rs.getInt("id"));
                    datosDB.setOwner(rs.getString("owner"));
                    datosDB.setDocument_type(rs.getString("document_type"));
                    datosDB.setDocument(rs.getInt("document"));
                    datosDB.setContact(rs.getString("contact"));
                    datosDB.setGender(rs.getString("gender"));

                    list.add(datosDB);
                }
            } else {
                JOptionPane.showMessageDialog(null, ".::Error al realizar la consulta::.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

    public void addOwners(String owner, String document_type, int document, String contact, String gender) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql = "INSERT INTO `tb_pet_owners`(`owner`, `document_type`, `document`, `contact`, `gender`) VALUES('" + owner + "', '" + document_type + "'," + document + "," + contact + ",'" + gender + "')";
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setOwners(int id, String owner, String document_type, int document, String contact, String gender) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql = "UPDATE tb_pet_owners SET owner= '" + owner + "', document_type= '" + document_type + "', document = " + document + ", contact=" + contact + ",gender= '" + gender + "' WHERE id = " + id;
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteOwners(int id) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql = "DELETE FROM tb_pet_owners WHERE id = " + id;
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<DataDB> getPets() {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
        DataDB datosDB;
        ArrayList list = new ArrayList();
        try {
            String sql = "SELECT tb_pet.id, tb_pet.name,tb_pet.type_pet, tb_pet.race,tb_pet_owners.owner, tb_pet.id_owner_pet FROM tb_pet INNER JOIN tb_pet_owners ON (tb_pet_owners.id=tb_pet.id_owner_pet) ORDER BY tb_pet.id";
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (cn != null) {
                System.out.println("Conexión éxitosa DataModelDB Pets");
                while (rs.next()) {
                    datosDB = new DataDB();
                    datosDB.setIdPets(rs.getInt("id"));
                    datosDB.setPets(rs.getString("name"));
                    datosDB.setPet_type(rs.getString("type_pet"));
                    datosDB.setRace(rs.getString("race"));
                    datosDB.setOwner(rs.getString("owner"));
                    datosDB.setIdOwner(rs.getInt("id_owner_pet"));
                    list.add(datosDB);
                }
            } else {
                JOptionPane.showMessageDialog(null, ".::Error al realizar la consulta::.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
    public void addPets(String pet, String pet_type, String race, int id_owner_pet) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            
            String sql = "INSERT INTO `tb_pet` (name, `type_pet`, race, id_owner_pet) VALUES('" + pet + "', '" + pet_type + "','"+ race+"',"+ id_owner_pet+")";
        
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setPets(int id, String pet, String pet_type,String race, int id_owner_pet) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql = "UPDATE tb_pet SET name = '" + pet + "', type_pet= '"+pet_type + "', race ='"+race+"', id_owner_pet ="+id_owner_pet+" WHERE id = " + id;
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la consulta::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePets(int id) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql = "DELETE FROM tb_pet WHERE id = " + id;
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public ArrayList<DataDB> getDoctors() {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        ResultSet rs;
        DataDB datosDB;
        ArrayList list = new ArrayList();
        try {
            String sql = "SELECT tb_doctor.id, tb_doctor.doctor, tb_doctor.document_type, tb_doctor.document, tb_hospital.name, tb_doctor.id_hospital FROM `tb_doctor` INNER JOIN tb_hospital ON (tb_hospital.id=tb_doctor.id_hospital);";
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (cn != null) {
                System.out.println("Conexión éxitosa DataModelDB Doctor");
                while (rs.next()) {
                    datosDB = new DataDB();
                    datosDB.setIdDoctors(rs.getInt("id"));
                    datosDB.setDoctor(rs.getString("doctor"));
                    datosDB.setDoc_type(rs.getString("document_type"));
                    datosDB.setDocument_doc(rs.getInt("document"));
                    datosDB.setHospital(rs.getString("name"));
                    datosDB.setIdHospital(rs.getInt("id_hospital"));
                    list.add(datosDB);
                }
            } else {
                JOptionPane.showMessageDialog(null, ".::Error al realizar la consulta::.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }
    public void addDoctors(String name, String document_type, int document, int id_hospital) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            
            String sql = "INSERT INTO `tb_doctor`(`doctor`, `document_type`, `document`, `id_hospital`) VALUES('" + name + "', '" + document_type + "'," + document + ","+id_hospital + ")";


            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setDoctors(int id, String name, String document_type,int document, int id_hospital) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql = "UPDATE tb_doctor SET doctor = '" + name + "', document_type= '" + document_type + "', document =" + document + ", id_hospital =" +id_hospital +" WHERE id = " + id;
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteDoctors(int id) {
        Conexion con = new Conexion();
        Connection cn;
        Statement st;
        try {
            String sql =  "DELETE FROM tb_doctor WHERE id = " + id;
            cn = con.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ".::Error en la conexión::.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
