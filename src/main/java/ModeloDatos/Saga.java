/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDatos;

import java.io.Serializable;

/**
 *
 * @author alexP
 */
public class Saga implements Serializable{
    
    private String nombreSaga, desarrolladora, genero;
    private int anioCreacion, idSaga, idEmpresaAsignada;

    public Saga() {
        
        this.nombreSaga = null;
        this.desarrolladora = null;
        this.genero = null;
        this.anioCreacion = 0;
        this.idSaga = 0;
        this.idEmpresaAsignada = 0;
    }

    public Saga(String nombreSaga, String desarrolladora, String genero, int anioCreacion, int idSaga, int idEmpresaAsignada) {
        this.nombreSaga = nombreSaga;
        this.desarrolladora = desarrolladora;
        this.genero = genero;
        this.anioCreacion = anioCreacion;
        this.idSaga = idSaga;
        this.idEmpresaAsignada = idEmpresaAsignada;
    }

    public int getIDEmpresaAsignadaSaga() {
        return idEmpresaAsignada;
    }

    public void setIDEmpresaAsignadaSaga(int idEmpresaAsignada) {
        this.idEmpresaAsignada = idEmpresaAsignada;
    }

    public String getNombreSaga() {
        return nombreSaga;
    }

    public void setNombreSaga(String nombreSaga) {
        this.nombreSaga = nombreSaga;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public int getIdSaga() {
        return idSaga;
    }

    public void setIdSaga(int idSaga) {
        this.idSaga = idSaga;
    }
    
    
}
