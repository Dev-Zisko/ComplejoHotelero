/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author ANA MARIA
 */
public class Pago {
    private double monto;
    private String tipoPago;
    private Date fechaPago;
    private int codigoC;

    public Pago(double monto, String tipoPago, Date fechaPago, int codigoC) {
        this.monto = monto;
        this.tipoPago = tipoPago;
        this.fechaPago = fechaPago;
        this.codigoC = codigoC;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(int codigoC) {
        this.codigoC = codigoC;
    }
}
