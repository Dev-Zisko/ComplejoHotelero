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

    public ServicioCompra(int codigoC, int codigoHS, int codigoS) {
        this.codigoC = codigoC;
        this.codigoHS = codigoHS;
        this.codigoS = codigoS;
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
