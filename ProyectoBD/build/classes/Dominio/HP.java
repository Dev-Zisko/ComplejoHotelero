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
public class HP {
    private int codigoP;
    private int codigoH;

    public HP(int codigoP, int codigoH) {
        this.codigoP = codigoP;
        this.codigoH = codigoH;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

    public int getCodigoH() {
        return codigoH;
    }

    public void setCodigoH(int codigoH) {
        this.codigoH = codigoH;
    }
    
}
