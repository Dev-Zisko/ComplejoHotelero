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
public class CA {
    private int codigoC;
    private String ci;

    public CA(int codigoC, String ci) {
        this.codigoC = codigoC;
        this.ci = ci;
    }

    public int getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(int codigoC) {
        this.codigoC = codigoC;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    
}
