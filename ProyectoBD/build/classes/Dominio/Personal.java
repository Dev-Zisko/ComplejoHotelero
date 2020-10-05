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
public class Personal {
    private String ci;
    private String nombre;
    private String apellido;
    private String calle;
    private String edificio;
    private String urbanizacion;
    private char sexo;
    private Date fechaNac;
    private Date fechaInicio;
    private String cargo;
    private String nivelEstudio;
    private int codigoH;
 
    private int codigoL;
    private boolean despedido;
    private String ciSupervisor;
    // Se omitio el nivelEstudi en el constructor pues es campo opcional de la clase.

    public Personal() {
    }

    public Personal(String ci, String nombre, String apellido, String calle, String edificio, String urbanizacion, char sexo, Date fechaNac, Date fechaInicio, String cargo, String nivelEstudio, int codigoH, int codigoL,boolean despedido, String ciSupervisor) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.edificio = edificio;
        this.urbanizacion = urbanizacion;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.fechaInicio = fechaInicio;
        this.cargo = cargo;
        if (this.cargo=="Administrador")
            this.nivelEstudio = "'"+nivelEstudio+"'";
        else
            this.nivelEstudio = "NULL";
        this.codigoH = codigoH;
        this.codigoL = codigoL;
        this.despedido=despedido;
        if (this.cargo == "Supervisor")
            this.ciSupervisor = "NULL";
        else
        this.ciSupervisor = "'"+ciSupervisor+"'";
    }

    public boolean isDespedido() {
        return despedido;
    }

    public void setDespedido(boolean despedido) {
        this.despedido = despedido;
    }
   
    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public int getCodigoH() {
        return codigoH;
    }

    public void setCodigoH(int codigoH) {
        this.codigoH = codigoH;
    }
    

    public int getCodigoL() {
        return codigoL;
    }

    public void setCodigoL(int codigoL) {
        this.codigoL = codigoL;
    }

    public String getCiSupervisor() {
        return ciSupervisor;
    }

    public void setCiSupervisor(String ciSupervisor) {
        this.ciSupervisor = ciSupervisor;
    }
    
}
