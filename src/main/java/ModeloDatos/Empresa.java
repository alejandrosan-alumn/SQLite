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
public class Empresa implements Serializable{

    private String nombre, paisSede, ceo, fechaFundacion;
    private int idEmpresa;
    
    public Empresa() {
    
        this.nombre = null;
        this.paisSede = null;
        this.ceo = null;
        this.idEmpresa = 0;
        this.fechaFundacion = null;
    }

    public Empresa(String nombre, String paisSede, String ceo, String fechaFundacion, int idEmpresa) {
        this.nombre = nombre;
        this.paisSede = paisSede;
        this.ceo = ceo;
        this.fechaFundacion = fechaFundacion;
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisSede() {
        return paisSede;
    }

    public void setPaisSede(String paisSede) {
        this.paisSede = paisSede;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(String fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    
}
