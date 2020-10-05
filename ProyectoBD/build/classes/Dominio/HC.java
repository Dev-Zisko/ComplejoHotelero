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
public class HC {
    private int numero;
    private int codigoC;
    private int codigoH;

    public HC(int numero, int codigoC, int codigoH) {
        this.numero = numero;
        this.codigoC = codigoC;
        this.codigoH = codigoH;
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

    public int getCodigoH() {
        return codigoH;
    }

    public void setCodigoH(int codigoH) {
        this.codigoH = codigoH;
    }
    
}
