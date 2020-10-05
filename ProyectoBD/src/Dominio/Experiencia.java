/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.sql.Date;

/**
 *
 * @author Christian D
 */
public class Experiencia {
    private String nombreCompañia;
    private String cargo;
    private Date fechaInicio;
    private Date fechaFin;
    private String ci;

    public Experiencia(String nombreCompañia, String cargo, Date fechaInicio, Date fechaFin, String ci) {
        this.nombreCompañia = nombreCompañia;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ci = ci;
    }

    public String getNombreCompañia() {
        return nombreCompañia;
    }

    public void setNombreCompañia(String nombreCompañia) {
        this.nombreCompañia = nombreCompañia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    
    
    
}
