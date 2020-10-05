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
public class PaqueteCompra {
    private int codigoC;
    private int codigoHPH;
    private int codigoHPP;

    public PaqueteCompra(int codigoC, int codigoHPH, int codigoHPP) {
        this.codigoC = codigoC;
        this.codigoHPH = codigoHPH;
        this.codigoHPP = codigoHPP;
    }

    public int getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(int codigoC) {
        this.codigoC = codigoC;
    }

    public int getCodigoHPH() {
        return codigoHPH;
    }

    public void setCodigoHPH(int codigoHPH) {
        this.codigoHPH = codigoHPH;
    }

    public int getCodigoHPP() {
        return codigoHPP;
    }

    public void setCodigoHPP(int codigoHPP) {
        this.codigoHPP = codigoHPP;
    }
    
}
