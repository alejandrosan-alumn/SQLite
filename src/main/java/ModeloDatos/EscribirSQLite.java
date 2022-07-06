/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDatos;

import java.sql.PreparedStatement;
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
public class EscribirSQLite{
    
    Conexion conectarse;
    PreparedStatement sentenciaPreparada;
    public EscribirSQLite() {
        
        conectarse = null;
        sentenciaPreparada = null;
    }

    public void EscribirFicheroEmpresas(ArrayList<Empresa>objetoRef){
        
        if(objetoRef.size() > this.DimensionTablaEmpresa()){
            
            this.AniadirEmpresa(objetoRef.get(objetoRef.size()-1));
        }
        else if(objetoRef.size() < this.DimensionTablaEmpresa()){
                
                this.EliminarEmpresa(objetoRef);
        }
        else{
            this.ModificarEmpresa(objetoRef);
        }
    }
    
    public void EjecutarSentencia(String sentencia){
        
        try {
            this.sentenciaPreparada = this.conectarse.Conectarse().prepareStatement(sentencia);
            this.sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia preparada, código del error: " + ex);
        }
        
    }
    
    public void ModificarEmpresa(ArrayList<Empresa>objeto){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        int idEmpresa = -1;
        String nombreEmpresa = null;
        String paisSede = null;
        String fechaFundacion = null;
        String ceo = null;
        String sentencia = null;
        Statement devolver = null;
        ResultSet resultado = null;

        for(int i = 0; i < objeto.size(); i++){

            try {
                devolver = this.conectarse.Conectarse().createStatement();
            } catch (SQLException ex) {
                System.out.println("Error al crear el statement, código del error: " + ex);
            }
            try {
                resultado = devolver.executeQuery("SELECT * FROM Empresa");
            } catch (SQLException ex) {
                System.out.println("Error al crear el resulset, código del error: " + ex);
            }
            System.out.println(i);
            try {

                while(resultado.next()){
                    idEmpresa = resultado.getInt(1);
                    System.out.println(idEmpresa);
                    nombreEmpresa = resultado.getString(2);
                    paisSede = resultado.getString(3);
                    fechaFundacion = resultado.getString(4);
                    ceo = resultado.getString(5);
                    if(idEmpresa == objeto.get(i).getIdEmpresa()){
                        if(!nombreEmpresa.equals(objeto.get(i).getNombre())){

                            sentencia = "UPDATE Empresa SET NombreEmpresa = '" + objeto.get(i).getNombre() + "' WHERE IDEmpresa = " + idEmpresa;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(!paisSede.equals(objeto.get(i).getPaisSede())){

                            sentencia = "UPDATE Empresa SET PaisSede = '" + objeto.get(i).getPaisSede() + "' WHERE IDEmpresa = " + idEmpresa;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(!fechaFundacion.equals(objeto.get(i).getFechaFundacion())){

                            sentencia = "UPDATE Empresa SET FechaFundación = '" + objeto.get(i).getFechaFundacion() + "' WHERE IDEmpresa = " + idEmpresa;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(!ceo.equals(objeto.get(i).getCeo())){

                            sentencia = "UPDATE Empresa SET CEO = '" + objeto.get(i).getCeo() + "' WHERE IDEmpresa = " + idEmpresa;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error al repasar el resultset, código del error: " + ex);
            }
            try {
                devolver.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
            }
        }
        try {
            this.sentenciaPreparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void EliminarEmpresa(ArrayList<Empresa>objeto){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        boolean idEncontrado = false;
        String sentencia = null;
        int idTabla = -1;
        Statement devolver = null;
        ResultSet resultado = null;
        try {
            devolver = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al crear el statement, código del error: " + ex);
        }
        try {
            resultado = devolver.executeQuery("SELECT * FROM Empresa");
        } catch (SQLException ex) {
            System.out.println("Error al crear el resulset, código del error: " + ex);
        }
        if(objeto.isEmpty()){
            try {
                idTabla = resultado.getInt(1);
                try {
                    devolver.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                }
                sentencia = "DELETE FROM Empresa WHERE IDEmpresa = " + idTabla;
                this.EjecutarSentencia(sentencia);
            } catch (SQLException ex) {
                System.out.println("Error en el borrado, código del error: " + ex);
            } 
        }
        else{
        
            for(int i = 0; i < objeto.size(); i++){

                try {
                    while(resultado.next()){
                        
                        idEncontrado = false;
                        idTabla = resultado.getInt(1);
                        if(idTabla == objeto.get(i).getIdEmpresa()){

                            idEncontrado = true;
                        }
                        if (idEncontrado == false){
                            
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            sentencia = "DELETE FROM Empresa WHERE IDEmpresa = " + idTabla;
                            this.EjecutarSentencia(sentencia);
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al repasar el resultset, código del error: " + ex);
                }
            }
        }
        try {
            this.sentenciaPreparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void AniadirEmpresa(Empresa objetoAnadido){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        String sentencia = "INSERT INTO Empresa(NombreEmpresa,PaisSede,FechaFundación,CEO) VALUES (?,?,?,?);";
        try {
            //this.conectarse.Conectarse().setAutoCommit(false);
            sentenciaPreparada = this.conectarse.Conectarse().prepareStatement(sentencia);
            this.sentenciaPreparada.setString(1, objetoAnadido.getNombre());
            this.sentenciaPreparada.setString(2, objetoAnadido.getPaisSede());
            this.sentenciaPreparada.setString(3, objetoAnadido.getFechaFundacion());
            this.sentenciaPreparada.setString(4, objetoAnadido.getCeo());
            this.sentenciaPreparada.executeUpdate();
            //this.conectarse.Conectarse().commit();
            this.sentenciaPreparada.close();
            
        } catch (SQLException ex) {
            System.err.println("Error en la insercción de datos, código del error: " + ex + "Haciendo rollback.");
            try {
                conectarse.Conectarse().rollback();
            } catch (SQLException ex1) {
                System.out.println("Error en el rollback, código del error: " + ex);
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void EscribirFicheroSagas(ArrayList<Saga>objetoRef){
        
        if(objetoRef.size() > this.DimensionTablaSagas()){
            
            this.AniadirSaga(objetoRef.get(objetoRef.size()-1));
        }
        else if(objetoRef.size() < this.DimensionTablaSagas()){
                
                this.EliminarSaga(objetoRef);
        }
        else{
            
            this.ModificarSaga(objetoRef);
        }
    }
    
    public void ModificarSaga (ArrayList<Saga>objeto){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        int id = -1;
        String nombre = null;
        String Desarrolladora = null;
        int Anio = 0;
        String genero = null;
        int idEmpresa = -1;
        String sentencia = null;
        Statement devolver = null;
        ResultSet resultado = null;

        for(int i = 0; i < objeto.size(); i++){

            try {
            devolver = this.conectarse.Conectarse().createStatement();
            } catch (SQLException ex) {
                System.out.println("Error al crear el statement, código del error: " + ex);
            }
            try {
                resultado = devolver.executeQuery("SELECT * FROM Sagas");
            } catch (SQLException ex) {
                System.out.println("Error al crear el resulset, código del error: " + ex);
            }
            try {
                while(resultado.next()){
                    id = resultado.getInt(1);
                    nombre = resultado.getString(2);
                    Desarrolladora = resultado.getString(3);
                    Anio = resultado.getInt(4);
                    genero = resultado.getString(5);
                    idEmpresa = resultado.getInt(6);
                    if(id == objeto.get(i).getIdSaga()){
                        if(!nombre.equals(objeto.get(i).getNombreSaga())){

                            sentencia = "UPDATE Sagas SET NombreSaga = '" + objeto.get(i).getNombreSaga() + "' WHERE IDSagas = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(!Desarrolladora.equals(objeto.get(i).getDesarrolladora())){

                            sentencia = "UPDATE Sagas SET Desarrolladora = '" + objeto.get(i).getDesarrolladora() + "' WHERE IDSagas = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(Anio != objeto.get(i).getAnioCreacion()){

                            sentencia = "UPDATE Sagas SET AnioCreación = '" + objeto.get(i).getAnioCreacion() + "' WHERE IDSagas = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(!genero.equals(objeto.get(i).getGenero())){

                            sentencia = "UPDATE Sagas SET Género = '" + objeto.get(i).getGenero() + "' WHERE IDSagas = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(idEmpresa != objeto.get(i).getIDEmpresaAsignadaSaga()){
                            
                            sentencia = "UPDATE Sagas SET IDEmpresaSaga = '" + objeto.get(i).getIDEmpresaAsignadaSaga() + "' WHERE IDSagas = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                    }
                    
                }
            } catch (SQLException ex) {
                System.out.println("Error al repasar el resultset, código del error: " + ex);
            }
            try {
                devolver.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
            }
        }
        try {
            this.sentenciaPreparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void EliminarSaga(ArrayList<Saga>objeto){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        boolean idEncontrado = false;
        String sentencia = null;
        int idTabla = -1;
        Statement devolver = null;
        ResultSet resultado = null;
        try {
            devolver = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al crear el statement, código del error: " + ex);
        }
        try {
            resultado = devolver.executeQuery("SELECT * FROM Sagas");
        } catch (SQLException ex) {
            System.out.println("Error al crear el resulset, código del error: " + ex);
        }
        if(objeto.isEmpty()){
            try {
                idTabla = resultado.getInt(1);
                try {
                    devolver.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                }
                sentencia = "DELETE FROM Sagas WHERE IDSagas = " + idTabla;
                this.EjecutarSentencia(sentencia);
            } catch (SQLException ex) {
                System.out.println("Error en el borrado, código del error: " + ex);
            } 
        }
        else{
        
            for(int i = 0; i < objeto.size(); i++){

                try {
                    while(resultado.next()){
                        
                        idEncontrado = false;
                        idTabla = resultado.getInt(1);
                        if(idTabla == objeto.get(i).getIdSaga()){

                            idEncontrado = true;
                        }
                        if (idEncontrado == false){
                            
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            sentencia = "DELETE FROM Sagas WHERE IDSagas = " + idTabla;
                            this.EjecutarSentencia(sentencia);
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al repasar el resultset, código del error: " + ex);
                }
            }
        }
        try {
            this.sentenciaPreparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void AniadirSaga(Saga objetoAnadido){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        String sentencia = "INSERT INTO Sagas(NombreSaga,Desarrolladora,AnioCreación,Género,IDEmpresaSaga) VALUES (?,?,?,?,?);";
        try {
            //this.conectarse.Conectarse().setAutoCommit(false);
            sentenciaPreparada = this.conectarse.Conectarse().prepareStatement(sentencia);
            this.sentenciaPreparada.setString(1, objetoAnadido.getNombreSaga());
            this.sentenciaPreparada.setString(2, objetoAnadido.getDesarrolladora());
            this.sentenciaPreparada.setInt(3, objetoAnadido.getAnioCreacion());
            this.sentenciaPreparada.setString(4, objetoAnadido.getGenero());
            this.sentenciaPreparada.setInt(5, objetoAnadido.getIDEmpresaAsignadaSaga());
            this.sentenciaPreparada.executeUpdate();
            //this.conectarse.Conectarse().commit();
            this.sentenciaPreparada.close();
            
        } catch (SQLException ex) {
            System.err.println("Error en la insercción de datos, código del error: " + ex + "Haciendo rollback.");
            try {
                conectarse.Conectarse().rollback();
            } catch (SQLException ex1) {
                System.out.println("Error en el rollback, código del error: " + ex);
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void EscribirFicheroVideojuegos(ArrayList<Videojuego>objetoRef){

        if(objetoRef.size() > this.DimensionTablaVideojuegos()){
            
            this.AniadirVideojuego(objetoRef.get(objetoRef.size()-1));
        }
        else if(objetoRef.size() < this.DimensionTablaVideojuegos()){
                
                this.EliminarVideojuego(objetoRef);
        }
        else{
            
            this.ModificarVideojuego(objetoRef);
        }
    }
    
        public void ModificarVideojuego (ArrayList<Videojuego>objeto){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        int id = -1;
        String nombre = null;
        String motorVideojuego = null;
        String fecha = null;
        int pegi = 0;
        int idExtra = -1;
        String sentencia = null;
        Statement devolver = null;
        ResultSet resultado = null;

        for(int i = 0; i < objeto.size(); i++){

            try {
            devolver = this.conectarse.Conectarse().createStatement();
            } catch (SQLException ex) {
                System.out.println("Error al crear el statement, código del error: " + ex);
            }
            try {
                resultado = devolver.executeQuery("SELECT * FROM Videojuegos");
            } catch (SQLException ex) {
                System.out.println("Error al crear el resulset, código del error: " + ex);
            }
            try {
                while(resultado.next()){
                    id = resultado.getInt(1);
                    nombre = resultado.getString(2);
                    motorVideojuego = resultado.getString(3);
                    fecha = resultado.getString(4);
                    pegi = resultado.getInt(5);
                    idExtra = resultado.getInt(6);
                    if(id == objeto.get(i).getIdVideojuego()){
                        if(!nombre.equals(objeto.get(i).getNombreVideojuego())){

                            sentencia = "UPDATE Videojuegos SET NombreVideojuego = '" + objeto.get(i).getNombreVideojuego() + "' WHERE IDVideojuego = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(!motorVideojuego.equals(objeto.get(i).getMotorVideojuego())){

                            sentencia = "UPDATE Videojuegos SET MotorVideojuego = '" + objeto.get(i).getMotorVideojuego() + "' WHERE IDVideojuego = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(!fecha.equals(objeto.get(i).getFechaLanzamiento())){

                            sentencia = "UPDATE Videojuegos SET FechaLanzamiento = '" + objeto.get(i).getFechaLanzamiento() + "' WHERE IDVideojuego = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(pegi != objeto.get(i).getPegi()){

                            sentencia = "UPDATE Videojuegos SET PEGI = '" + objeto.get(i).getPegi() + "' WHERE IDVideojuego = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(idExtra != objeto.get(i).getIdSagaVideojuego()){
                            
                            sentencia = "UPDATE Videojuegos SET IDSagaVideojuego = '" + objeto.get(i).getIdSagaVideojuego() + "' WHERE IDVideojuego = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                    }
                    
                }
            } catch (SQLException ex) {
                System.out.println("Error al repasar el resultset, código del error: " + ex);
            }
            try {
                devolver.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
            }
        }
        try {
            this.sentenciaPreparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void EliminarVideojuego(ArrayList<Videojuego>objeto){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        boolean idEncontrado = false;
        String sentencia = null;
        int idTabla = -1;
        Statement devolver = null;
        ResultSet resultado = null;
        try {
            devolver = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al crear el statement, código del error: " + ex);
        }
        try {
            resultado = devolver.executeQuery("SELECT * FROM Videojuegos");
        } catch (SQLException ex) {
            System.out.println("Error al crear el resulset, código del error: " + ex);
        }
        if(objeto.isEmpty()){
            try {
                idTabla = resultado.getInt(1);
                try {
                    devolver.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                }
                sentencia = "DELETE FROM Videojuegos WHERE IDVideojuego = " + idTabla;
                this.EjecutarSentencia(sentencia);
            } catch (SQLException ex) {
                System.out.println("Error en el borrado, código del error: " + ex);
            } 
        }
        else{
        
            for(int i = 0; i < objeto.size(); i++){

                try {
                    while(resultado.next()){
                        
                        idEncontrado = false;
                        idTabla = resultado.getInt(1);
                        if(idTabla == objeto.get(i).getIdVideojuego()){

                            idEncontrado = true;
                        }
                        if (idEncontrado == false){
                            
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            sentencia = "DELETE FROM Videojuegos WHERE IDVideojuego = " + idTabla;
                            this.EjecutarSentencia(sentencia);
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al repasar el resultset, código del error: " + ex);
                }
            }
        }
        try {
            this.sentenciaPreparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void AniadirVideojuego(Videojuego objetoAnadido){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        String sentencia = "INSERT INTO Videojuegos(NombreVideojuego,MotorVideojuego,FechaLanzamiento,PEGI,IDSagaVideojuego) VALUES (?,?,?,?,?);";
        try {
            //this.conectarse.Conectarse().setAutoCommit(false);
            sentenciaPreparada = this.conectarse.Conectarse().prepareStatement(sentencia);
            this.sentenciaPreparada.setString(1, objetoAnadido.getNombreVideojuego());
            this.sentenciaPreparada.setString(2, objetoAnadido.getMotorVideojuego());
            this.sentenciaPreparada.setString(3, objetoAnadido.getFechaLanzamiento());
            this.sentenciaPreparada.setInt(4, objetoAnadido.getPegi());
            this.sentenciaPreparada.setInt(5, objetoAnadido.getIdSagaVideojuego());
            this.sentenciaPreparada.executeUpdate();
            //this.conectarse.Conectarse().commit();
            this.sentenciaPreparada.close();
            
        } catch (SQLException ex) {
            System.err.println("Error en la insercción de datos, código del error: " + ex + "Haciendo rollback.");
            try {
                conectarse.Conectarse().rollback();
            } catch (SQLException ex1) {
                System.out.println("Error en el rollback, código del error: " + ex);
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public void EscribirFicheroPersonajes(ArrayList<Personaje>objetoRef){
        
        if(objetoRef.size() > this.DimensionTablaPersonajes()){
            
            this.AniadirPersonaje(objetoRef.get(objetoRef.size()-1));
        }
        else if(objetoRef.size() < this.DimensionTablaPersonajes()){
                
                this.EliminarPersonaje(objetoRef);
        }
        else{
            
            this.ModificarPersonaje(objetoRef);
        }
    }
    
    public void ModificarPersonaje (ArrayList<Personaje>objeto){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        int id = -1;
        String nombre = null;
        String interpreteModelo = null;
        String interpreteVoz = null;
        int anoAparicion = 0;
        int idExtra = -1;
        String sentencia = null;
        Statement devolver = null;
        ResultSet resultado = null;

        for(int i = 0; i < objeto.size(); i++){

            try {
                devolver = this.conectarse.Conectarse().createStatement();
            } catch (SQLException ex) {
                System.out.println("Error al crear el statement, código del error: " + ex);
            }
            try {
                resultado = devolver.executeQuery("SELECT * FROM Personajes");
            } catch (SQLException ex) {
                System.out.println("Error al crear el resulset, código del error: " + ex);
            }
            try {
                while(resultado.next()){
                    id = resultado.getInt(1);
                    nombre = resultado.getString(2);
                    interpreteModelo = resultado.getString(3);
                    interpreteVoz = resultado.getString(4);
                    anoAparicion = resultado.getInt(5);
                    idExtra = resultado.getInt(6);
                    if(id == objeto.get(i).getIdProtagonista()){
                        if(!nombre.equals(objeto.get(i).getNombreProtagonista())){

                            sentencia = "UPDATE Personajes SET NombrePersonaje = '" + objeto.get(i).getNombreProtagonista() + "' WHERE IDPersonaje = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(!interpreteModelo.equals(objeto.get(i).getInterpreteModelo())){

                            sentencia = "UPDATE Personajes SET IntérpreteModelo = '" + objeto.get(i).getInterpreteModelo() + "' WHERE IDPersonaje = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(!interpreteVoz.equals(objeto.get(i).getInterpreteVoz())){

                            sentencia = "UPDATE Personajes SET IntérpreteVoz = '" + objeto.get(i).getInterpreteVoz() + "' WHERE IDPersonaje = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(anoAparicion != objeto.get(i).getAnioAparicion()){

                            sentencia = "UPDATE Personajes SET AnoAparición = '" + objeto.get(i).getAnioAparicion() + "' WHERE IDPersonaje = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                        if(idExtra != objeto.get(i).getIdVideojuegoPertenece()){
                            
                            sentencia = "UPDATE Personajes SET IDVideojuegoPersonaje = '" + objeto.get(i).getIdVideojuegoPertenece() + "' WHERE IDPersonaje = " + id;
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            this.EjecutarSentencia(sentencia);
                        }
                    }
                    
                }
            } catch (SQLException ex) {
                System.out.println("Error al repasar el resultset, código del error: " + ex);
            }
            try {
                devolver.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
            }
        }
        try {
            this.sentenciaPreparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void EliminarPersonaje(ArrayList<Personaje>objeto){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        boolean idEncontrado = false;
        String sentencia = null;
        int idTabla = -1;
        Statement devolver = null;
        ResultSet resultado = null;
        try {
            devolver = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al crear el statement, código del error: " + ex);
        }
        try {
            resultado = devolver.executeQuery("SELECT * FROM Personajes");
        } catch (SQLException ex) {
            System.out.println("Error al crear el resulset, código del error: " + ex);
        }
        if(objeto.isEmpty()){
            try {
                idTabla = resultado.getInt(1);
                try {
                    devolver.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                }
                sentencia = "DELETE FROM Personajes WHERE IDPersonaje = " + idTabla;
                this.EjecutarSentencia(sentencia);
            } catch (SQLException ex) {
                System.out.println("Error en el borrado, código del error: " + ex);
            } 
        }
        else{
        
            for(int i = 0; i < objeto.size(); i++){

                try {
                    while(resultado.next()){
                        
                        idEncontrado = false;
                        idTabla = resultado.getInt(1);
                        if(idTabla == objeto.get(i).getIdProtagonista()){

                            idEncontrado = true;
                        }
                        if (idEncontrado == false){
                            
                            try {
                                devolver.close();
                            } catch (SQLException ex) {
                                System.out.println("Error al cerrar la sentencia, código del error: " + ex);
                            }
                            sentencia = "DELETE FROM Personajes WHERE IDPersonaje = " + idTabla;
                            this.EjecutarSentencia(sentencia);
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al repasar el resultset, código del error: " + ex);
                }
            }
        }
        try {
            this.sentenciaPreparada.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la sentencia, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
    }
    
    public void AniadirPersonaje(Personaje objetoAnadido){
        
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        String sentencia = "INSERT INTO Personajes(NombrePersonaje,IntérpreteModelo,IntérpreteVoz,AnoAparición,IDVideojuegoPersonaje) VALUES (?,?,?,?,?);";
        try {
            //this.conectarse.Conectarse().setAutoCommit(false);
            sentenciaPreparada = this.conectarse.Conectarse().prepareStatement(sentencia);
            this.sentenciaPreparada.setString(1, objetoAnadido.getNombreProtagonista());
            this.sentenciaPreparada.setString(2, objetoAnadido.getInterpreteModelo());
            this.sentenciaPreparada.setString(3, objetoAnadido.getInterpreteVoz());
            this.sentenciaPreparada.setInt(4, objetoAnadido.getAnioAparicion());
            this.sentenciaPreparada.setInt(5, objetoAnadido.getIdVideojuegoPertenece());
            this.sentenciaPreparada.executeUpdate();
            //this.conectarse.Conectarse().commit();
            this.sentenciaPreparada.close();
            
        } catch (SQLException ex) {
            System.err.println("Error en la insercción de datos, código del error: " + ex + "Haciendo rollback.");
            try {
                conectarse.Conectarse().rollback();
            } catch (SQLException ex1) {
                System.out.println("Error en el rollback, código del error: " + ex);
            }
        }
        this.conectarse.Desconectarse();
    }
    
    public int DimensionTablaPersonajes(){
        
        int tamanoTabla = 0;
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        Statement devolver = null;
        ResultSet resultado = null;
        try {
            devolver = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al crear el statement, código del error: " + ex);
        }
        try {
            resultado = devolver.executeQuery("SELECT * FROM Personajes");
            while(resultado.next()){
            
                ++tamanoTabla;
            }
            devolver.close();
        } catch (SQLException ex) {
            System.out.println("Error al crear el resulset, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
        return tamanoTabla;
    }
    
    public int DimensionTablaVideojuegos(){
        
        int tamanoTabla = 0;
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        Statement devolver = null;
        ResultSet resultado = null;
        try {
            devolver = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al crear el statement, código del error: " + ex);
        }
        try {
            resultado = devolver.executeQuery("SELECT * FROM Videojuegos");
            while(resultado.next()){
            
                ++tamanoTabla;
            }
            devolver.close();
        } catch (SQLException ex) {
            System.out.println("Error al crear el resulset, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
        return tamanoTabla;
    }
    
    public int DimensionTablaSagas(){
        
        int tamanoTabla = 0;
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        Statement devolver = null;
        ResultSet resultado = null;
        try {
            devolver = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al crear el statement, código del error: " + ex);
        }
        try {
            resultado = devolver.executeQuery("SELECT * FROM Sagas");
            while(resultado.next()){
            
                ++tamanoTabla;
            }
            devolver.close();
        } catch (SQLException ex) {
            System.out.println("Error al crear el resulset, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
        return tamanoTabla;
    }
    
    public int DimensionTablaEmpresa(){
        
        int tamanoTabla = 0;
        this.conectarse = new Conexion();
        this.conectarse.Conectarse();
        Statement devolver = null;
        ResultSet resultado = null;
        try {
            devolver = this.conectarse.Conectarse().createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al crear el statement, código del error: " + ex);
        }
        try {
            resultado = devolver.executeQuery("SELECT * FROM Empresa");
            while(resultado.next()){
            
                ++tamanoTabla;
            }
            devolver.close();
        } catch (SQLException ex) {
            System.out.println("Error al crear el resulset, código del error: " + ex);
        }
        this.conectarse.Desconectarse();
        return tamanoTabla;  
    }
}
