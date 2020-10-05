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
public class Cliente {
  
    private int añoIngreso;
    private int consecutivo;
    private String ciPasaporte;
    private String nombre;
    private String apellido;
    private String telefonoLocal;
    private String telefonoCelular;
    private String telefonoOficina;
    private Date fechaNac;
    private String nacionalidad;
    private char sexo;
    private String profesion;
    private String informacionGeneral;
    private int codigoL;
    private int codigoLu;
    private int codigoH;
    private String calle;
    private String edificio;
    private String urbanizacion;

    public Cliente(int añoIngreso, int consecutivo, String ciPasaporte, String nombre, String apellido, String telefonoLocal, String telefonoCelular, String telefonoOficina, Date fechaNac, String nacionalidad, char sexo, String profesion, String informacionGeneral, int codigoL, int codigoLu, int codigoH, String calle, String edificio, String urbanizacion) {
        
        this.añoIngreso = añoIngreso;
        this.consecutivo = consecutivo;
        this.ciPasaporte = ciPasaporte;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefonoLocal = telefonoLocal;
        this.telefonoCelular = telefonoCelular;
        this.telefonoOficina = telefonoOficina;
        this.fechaNac = fechaNac;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.profesion = profesion;
        this.informacionGeneral = informacionGeneral;
        this.codigoL = codigoL;
        this.codigoLu = codigoLu;
        this.codigoH = codigoH;
        this.calle = calle;
        this.edificio = edificio;
        this.urbanizacion = urbanizacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

  

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public String getCiPasaporte() {
        return ciPasaporte;
    }

    public void setCiPasaporte(String ciPasaporte) {
        this.ciPasaporte = ciPasaporte;
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

    public String getTelefonoLocal() {
        return telefonoLocal;
    }

    public void setTelefonoLocal(String telefonoLocal) {
        this.telefonoLocal = telefonoLocal;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNaacionalidad() {
        return nacionalidad;
    }

    public void setNaacionalidad(String naacionalidad) {
        this.nacionalidad = naacionalidad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getInformacionGeneral() {
        return informacionGeneral;
    }

    public void setInformacionGeneral(String informacionGeneral) {
        this.informacionGeneral = informacionGeneral;
    }

    public int getCodigoL() {
        return codigoL;
    }

    public void setCodigoL(int codigoL) {
        this.codigoL = codigoL;
    }

    public int getCodigoLu() {
        return codigoLu;
    }

    public void setCodigoLu(int codigoLu) {
        this.codigoLu = codigoLu;
    }

    public int getCodigoH() {
        return codigoH;
    }

    public void setCodigoH(int codigoH) {
        this.codigoH = codigoH;
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
    
}
