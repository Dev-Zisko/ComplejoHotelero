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
public class HR {
    private int numero;
    private int codigoR;
    private int codigoH;
    private double costo;

    public HR(int numero, int codigoR, int codigoH, double costo) {
        this.numero = numero;
        this.codigoR = codigoR;
        this.codigoH = codigoH;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigoR() {
        return codigoR;
    }

    public void setCodigoR(int codigoR) {
        this.codigoR = codigoR;
    }

    public int getCodigoH() {
        return codigoH;
    }

    public void setCodigoH(int codigoH) {
        this.codigoH = codigoH;
    }
    
}
