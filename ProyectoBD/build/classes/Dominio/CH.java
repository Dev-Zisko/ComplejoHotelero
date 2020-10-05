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
public class CH {
   private int numero;
   private int codigoC;
   private int codigoHH;

    public CH(int numero, int codigoC, int codigoHH) {
        this.numero = numero;
        this.codigoC = codigoC;
        this.codigoHH = codigoHH;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(int codigoC) {
        this.codigoC = codigoC;
    }

    public int getCodigoHH() {
        return codigoHH;
    }

    public void setCodigoHH(int codigoHH) {
        this.codigoHH = codigoHH;
    }
   
}
