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
public class Hotel {
    private int codigo;
    private String nombre;
    private String categoria;
    private String tipoServicio;
    private String calle;
    private String edificio;
    private String urbanizacion;
    private String ciG;
    private int codigoL;

    public Hotel(int codigo, String nombre, String categoria, String tipoServicio, String calle, String edificio, String urbanizacion,String ciG, int codigoL) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipoServicio = tipoServicio;
        this.calle = calle;
        this.edificio = edificio;
        this.urbanizacion = urbanizacion;
        this.ciG = ciG;
        this.codigoL = codigoL;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
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


    public int getCodigoL() {
        return codigoL;
    }

    public void setCodigoL(int codigoL) {
        this.codigoL = codigoL;
      
    }

    public String getCiG() {
        return ciG;
    }

    public void setCiG(String ciG) {
        this.ciG = ciG;
    }
    
    
    
    
    
    
}
