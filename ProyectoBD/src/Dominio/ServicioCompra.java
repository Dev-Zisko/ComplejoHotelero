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
public class ServicioCompra {
    private int codigoC;
    private int codigoHS;
    private int codigoS;
    private double costo;

    public ServicioCompra(int codigoC, int codigoHS, int codigoS, double costo) {
        this.codigoC = codigoC;
        this.codigoHS = codigoHS;
        this.codigoS = codigoS;
        this.costo = costo;
    }

    public int getCodigoS() {
        return codigoS;
    }

    public void setCodigoS(int codigoS) {
        this.codigoS = codigoS;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(int codigoC) {
        this.codigoC = codigoC;
    }

    public int getCodigoHS() {
        return codigoHS;
    }

    public void setCodigoHS(int codigoHS) {
        this.codigoHS = codigoHS;
    }

    public int getTipo() {
        return codigoS;
    }

    public void setTipo(int codigoS) {
        this.codigoS = codigoS;
    }
    
}
