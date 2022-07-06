/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexP
 */
public class Conexion {

    Connection conexion;
    String rutaConexion;
    
    public Conexion() {
        
        conexion = null;
        rutaConexion = null;
    }
    
    public Connection Conectarse(){
        
        this.rutaConexion = "jdbc:sqlite:PracticaSQLite.db";
        try {
            conexion = DriverManager.getConnection(this.rutaConexion);
        } catch (SQLException ex) {
            System.out.println("Error ocurrido al conectarse, código de error: " + ex);
        }
        return conexion;
    }
    public void Desconectarse(){
        
        try {
            this.conexion.close();
        } catch (SQLException ex) {
           System.out.println("Error ocurrido al desconectarse, código de error: " + ex);
        }
    }
}
