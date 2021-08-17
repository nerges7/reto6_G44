/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_pkg;

import model_pkg.Conexion;
import views_pkg.MainFrame;

/**
 *
 * @author SUPERFERRETERIA
 */
public class Reto6_G44 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion inst_connect = new Conexion();
        MainFrame inst_frame = new MainFrame();
        inst_connect.getConnection();
        inst_frame.setVisible(true);

    }
    
}
