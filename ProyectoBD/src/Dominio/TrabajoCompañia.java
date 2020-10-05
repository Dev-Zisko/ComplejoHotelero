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
public class TrabajoCompañia {
    private int codigoTL;
    private String rif;
    private double costo;

    public TrabajoCompañia(int codigoTL, String rif, double costo) {
        this.codigoTL = codigoTL;
        this.rif = rif;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }



    public int getCodigoTL() {
        return codigoTL;
    }

    public void setCodigoTL(int codigoTL) {
        this.codigoTL = codigoTL;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }
    
    
}
