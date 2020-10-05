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
public class HotelServicio {
    private double costo;
    private int codigoS;
    private int codigoH;
    private String tipoServicio;
    private String capacidad;
    private String ci;
// el constructor no tiene capacidad por que es opcional en la clase piscina.
    public HotelServicio(double costo, int codigoS, int codigoH, String tipoServicio, String ci) {
        this.costo = costo;
        this.codigoS = codigoS;
        this.codigoH = codigoH;
        this.tipoServicio = tipoServicio;
        this.ci = ci;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getTipo() {
        return codigoS;
    }

    public void setTipo(int codigoS) {
        this.codigoS = codigoS;
    }

    public int getCodigoH() {
        return codigoH;
    }

    public void setCodigoH(int codigoH) {
        this.codigoH = codigoH;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    
}
