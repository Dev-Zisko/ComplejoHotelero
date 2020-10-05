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
public class Compra {
    private int codigo;
    private String tipoPago;
    private double montoTotal;
    private int codigoR;
    private Date AñoIngreso;
    private int consecutivo;

    public Compra(int codigo, String tipoPago, double montoTotal, int codigoR, Date AñoIngreso, int consecutivo) {
        this.codigo = codigo;
        this.tipoPago = tipoPago;
        this.montoTotal = montoTotal;
        this.codigoR = codigoR;
        this.AñoIngreso = AñoIngreso;
        this.consecutivo = consecutivo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getCodigoR() {
        return codigoR;
    }

    public void setCodigoR(int codigoR) {
        this.codigoR = codigoR;
    }

    public Date getAñoIngreso() {
        return AñoIngreso;
    }

    public void setAñoIngreso(Date AñoIngreso) {
        this.AñoIngreso = AñoIngreso;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }
    
}
