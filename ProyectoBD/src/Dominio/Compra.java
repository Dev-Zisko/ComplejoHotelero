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
    private int codigo; ;
    private Date fechaCompra;
    private Date fechaInicio;
    private Date fechaFinal;
    private double montoTotal;
    private int codigoR;
    private int AñoIngreso;
    private int consecutivo;

    public Compra(int codigo, Date fechaInicio, Date fechaFinal, int codigoR, int AñoIngreso, int consecutivo) {
    
        this.codigo = codigo;
        this.fechaCompra = null;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
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

    public int getAñoIngreso() {
        return AñoIngreso;
    }

    public void setAñoIngreso(int AñoIngreso) {
        this.AñoIngreso = AñoIngreso;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
}
