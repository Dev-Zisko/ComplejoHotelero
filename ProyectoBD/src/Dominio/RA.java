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
public class RA {
    private int codigoR;
    private String ci;

    public RA(int codigoR, String ci) {
        this.codigoR = codigoR;
        this.ci = ci;
    }

    public int getCodigoR() {
        return codigoR;
    }

    public void setCodigoR(int codigoR) {
        this.codigoR = codigoR;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    
}
