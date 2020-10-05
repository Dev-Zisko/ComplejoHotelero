/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author Christian D
 */
public class LimpiezaPiscina {
    private Date fecha;
    private String ci;
    private Time hora;
    private int codigoS;
    private int codigoHS;

    public LimpiezaPiscina(Date fecha, String ci, Time hora, int codigoS, int codigoHS) {
        this.fecha = fecha;
        this.ci = ci;
        this.hora = hora;
        this.codigoS = codigoS;
        this.codigoHS = codigoHS;
    }

    public int getCodigoS() {
        return codigoS;
    }

    public void setCodigoS(int codigoS) {
        this.codigoS = codigoS;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getTipo() {
        return codigoS;
    }

    public void setTipo(int codigoS) {
        this.codigoS = codigoS;
    }

    public int getCodigoHS() {
        return codigoHS;
    }

    public void setCodigoHS(int codigoHS) {
        this.codigoHS = codigoHS;
    }
    
}
