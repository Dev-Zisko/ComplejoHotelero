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
public class DetalleFactura {
    
    private int codigoFL;
    private int codigoTL;
    private double costo;

    public DetalleFactura(int codigoFL, int codigoTL, double costo) {
        this.codigoFL = codigoFL;
        this.codigoTL = codigoTL;
        this.costo = costo;
    }
  
    

    public int getCodigoFL() {
        return codigoFL;
    }

    public void setCodigoFL(int codigoFL) {
        this.codigoFL = codigoFL;
    }

    public int getCodigoTL() {
        return codigoTL;
    }

    public void setCodigoTL(int codigoTL) {
        this.codigoTL = codigoTL;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}