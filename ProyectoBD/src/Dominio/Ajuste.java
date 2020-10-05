/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.sql.Date;
/**
 *
 * @author Christian D
 */
public class Ajuste {
    private Date fecha;
    private int cantidad;
    private String tipo;
    private int codigoP;

    public Ajuste(Date fecha, int cantidad, String tipo, int codigoP) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.codigoP = codigoP;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }
    
}
