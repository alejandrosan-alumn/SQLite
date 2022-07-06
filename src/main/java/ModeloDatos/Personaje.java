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
public class Personaje implements Serializable{
    
    private String nombreProtagonista, interpreteModelo, interpreteVoz;
    private int anioAparicion, idProtagonista, idVideojuegoPertenece;

    public Personaje() {
        
        this.nombreProtagonista = null;
        this.interpreteModelo = null;
        this.interpreteVoz = null;
        this.anioAparicion = 0;
        this.idProtagonista = 0;
        this.idVideojuegoPertenece = 0;
    }

    public Personaje(String nombreProtagonista, String interpreteModelo, String interpreteVoz, int anioAparicion, int idProtagonista, int idVideojuegoPertenece) {
        this.nombreProtagonista = nombreProtagonista;
        this.interpreteModelo = interpreteModelo;
        this.interpreteVoz = interpreteVoz;
        this.anioAparicion = anioAparicion;
        this.idProtagonista = idProtagonista;
        this.idVideojuegoPertenece = idVideojuegoPertenece;
    }

    public int getIdVideojuegoPertenece() {
        return idVideojuegoPertenece;
    }

    public void setIdVideojuegoPertenece(int idVideojuegoPertenece) {
        this.idVideojuegoPertenece = idVideojuegoPertenece;
    }

    public String getNombreProtagonista() {
        return nombreProtagonista;
    }

    public void setNombreProtagonista(String nombreProtagonista) {
        this.nombreProtagonista = nombreProtagonista;
    }

    public String getInterpreteModelo() {
        return interpreteModelo;
    }

    public void setInterpreteModelo(String interpreteModelo) {
        this.interpreteModelo = interpreteModelo;
    }

    public String getInterpreteVoz() {
        return interpreteVoz;
    }

    public void setInterpreteVoz(String interpreteVoz) {
        this.interpreteVoz = interpreteVoz;
    }

    public int getAnioAparicion() {
        return anioAparicion;
    }

    public void setAnioAparicion(int anioAparicion) {
        this.anioAparicion = anioAparicion;
    }

    public int getIdProtagonista() {
        return idProtagonista;
    }

    public void setIdProtagonista(int idProtagonista) {
        this.idProtagonista = idProtagonista;
    }
    
    
}
