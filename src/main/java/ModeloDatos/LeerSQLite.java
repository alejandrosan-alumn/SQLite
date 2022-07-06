/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author alexP
 */
public class LeerSQLite {

    Conexion conectarse;
    Statement declaracion;
    String sentencia;
    
    public LeerSQLite() {
    
        conectarse = null;
        declaracion = null;
        sentencia = null;
    }
    
    public void LeerFicheroEmpresa(ArrayList<Empresa>listaEmpresa){
        
        sentencia = "SELECT * FROM Empresa";
        conectarse = new Conexion();
        this.conectarse.Conectarse();
        int i = 0;
        try {
            declaracion = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error en la declaración, código del error: " + ex);
        }
        try {
            ResultSet resultado = this.declaracion.executeQuery(sentencia);
            
            while(resultado.next()){
                
                Empresa empresaAux = new Empresa();
                empresaAux.setIdEmpresa(resultado.getInt(1));
                empresaAux.setNombre(resultado.getString(2));
                empresaAux.setPaisSede(resultado.getString(3));
                empresaAux.setFechaFundacion(resultado.getString(4));
                empresaAux.setCeo(resultado.getString(5));
                listaEmpresa.add(i, empresaAux);
                i++;
            }
            this.declaracion.close();
        } catch (SQLException ex) {
            System.out.println("Error en el resultado de la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void LeerFicheroSaga(ArrayList<Saga>lista){
        
        sentencia = "SELECT * FROM Sagas";
        conectarse = new Conexion();
        this.conectarse.Conectarse();
        int i = 0;
        try {
            declaracion = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error en la declaración, código del error: " + ex);
        }
        try {
            ResultSet resultado = this.declaracion.executeQuery(sentencia);
            
            while(resultado.next()){
                
                Saga SagaAux = new Saga();
                SagaAux.setIdSaga(resultado.getInt(1));
                SagaAux.setNombreSaga(resultado.getString(2));
                SagaAux.setDesarrolladora(resultado.getString(3));
                SagaAux.setAnioCreacion(resultado.getInt(4));
                SagaAux.setGenero(resultado.getString(5));
                SagaAux.setIDEmpresaAsignadaSaga(resultado.getInt(6));
                lista.add(i, SagaAux);
                i++;
            }
            this.declaracion.close();
        } catch (SQLException ex) {
            System.out.println("Error en el resultado de la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void LeerFicheroVideojuego(ArrayList<Videojuego>lista){
        
        sentencia = "SELECT * FROM Videojuegos";
        conectarse = new Conexion();
        this.conectarse.Conectarse();
        int i = 0;
        try {
            declaracion = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error en la declaración, código del error: " + ex);
        }
        try {
            ResultSet resultado = this.declaracion.executeQuery(sentencia);
            
            while(resultado.next()){
                
                Videojuego VideojuegoAux = new Videojuego();
                VideojuegoAux.setIdVideojuego(resultado.getInt(1));
                VideojuegoAux.setNombreVideojuego(resultado.getString(2));
                VideojuegoAux.setMotorVideojuego(resultado.getString(3));
                VideojuegoAux.setFechaLanzamiento(resultado.getString(4));
                VideojuegoAux.setPegi(resultado.getInt(5));
                VideojuegoAux.setIdSagaVideojuego(resultado.getInt(6));
                lista.add(i, VideojuegoAux);
                i++;
            }
            this.declaracion.close();
        } catch (SQLException ex) {
            System.out.println("Error en el resultado de la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void LeerFicheroPersonaje(ArrayList<Personaje>lista){
        
        sentencia = "SELECT * FROM Personajes";
        conectarse = new Conexion();
        this.conectarse.Conectarse();
        int i = 0;
        try {
            declaracion = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error en la declaración, código del error: " + ex);
        }
        try {
            ResultSet resultado = this.declaracion.executeQuery(sentencia);
            
            while(resultado.next()){
                
                Personaje PersonajeAux = new Personaje();
                PersonajeAux.setIdProtagonista(resultado.getInt(1));
                PersonajeAux.setNombreProtagonista(resultado.getString(2));
                PersonajeAux.setInterpreteModelo(resultado.getString(3));
                PersonajeAux.setInterpreteVoz(resultado.getString(4));
                PersonajeAux.setAnioAparicion(resultado.getInt(5));
                PersonajeAux.setIdVideojuegoPertenece(resultado.getInt(6));
                lista.add(i, PersonajeAux);
                i++;
            }
            this.declaracion.close();
        } catch (SQLException ex) {
            System.out.println("Error en el resultado de la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
}