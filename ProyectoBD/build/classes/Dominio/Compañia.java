/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Christian D
 */
public class Compañia {
    private String rif;
    private String nombre;
    private String calle;
    private String urbanizacion;
    private String edificio;
    private String telefono;
    private String tipoCompañia;
    private int codigoL;

    public Compañia(String rif, String nombre, String calle, String urbanizacion, String edificio, String telefono, String tipoCompañia, int codigoL) {
        this.rif = rif;
        this.nombre = nombre;
        this.calle = calle;
        this.urbanizacion = urbanizacion;
        this.edificio = edificio;
        this.telefono = telefono;
        this.tipoCompañia = tipoCompañia;
        this.codigoL = codigoL;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoCompañia() {
        return tipoCompañia;
    }

    public void setTipoCompañia(String tipoCompañia) {
        this.tipoCompañia = tipoCompañia;
    }

    public int getCodigoL() {
        return codigoL;
    }

    public void setCodigoL(int codigoL) {
        this.codigoL = codigoL;
    }
    
}
