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
public class Videojuego implements Serializable{
    
    private String nombreVideojuego, motorVideojuego, fechaLanzamiento;
    private int pegi, idVideojuego, idSagaVideojuego;

    public Videojuego() {
        
        this.nombreVideojuego = null;
        this.motorVideojuego = null;
        this.fechaLanzamiento = null;
        this.pegi = 0;
        this.idVideojuego = 0;
        this.idSagaVideojuego = 0;
    }

    public Videojuego(String nombreVideojuego, String motorVideojuego, String fechaLanzamiento, int pegi, int idVideojuego, int idSagaVideojuego) {
        this.nombreVideojuego = nombreVideojuego;
        this.motorVideojuego = motorVideojuego;
        this.fechaLanzamiento = fechaLanzamiento;
        this.pegi = pegi;
        this.idVideojuego = idVideojuego;
        this.idSagaVideojuego = idSagaVideojuego;
    }

    public int getIdSagaVideojuego() {
        return idSagaVideojuego;
    }

    public void setIdSagaVideojuego(int idSagaVideojuego) {
        this.idSagaVideojuego = idSagaVideojuego;
    }

    public String getNombreVideojuego() {
        return nombreVideojuego;
    }

    public void setNombreVideojuego(String nombreVideojuego) {
        this.nombreVideojuego = nombreVideojuego;
    }

    public String getMotorVideojuego() {
        return motorVideojuego;
    }

    public void setMotorVideojuego(String motorVideojuego) {
        this.motorVideojuego = motorVideojuego;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public int getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(int idVideojuego) {
        this.idVideojuego = idVideojuego;
    }
    
    
}
