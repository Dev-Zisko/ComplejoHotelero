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
public class FacturaLimpieza {
 private int codigo;
 private Date fechaInicio;
 private Date fechaFinal;
 private Date fechaEmision;
 private String tipoPago;
 private Date fechaPago;

 private int codigoH;
 private String rif;

    public FacturaLimpieza() {
    }

    public FacturaLimpieza(int codigo, Date fechaInicio, Date fechaFinal, Date fechaEmision, String tipoPago, Date fechaPago, int codigoH, String rif) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaEmision = fechaEmision;
        this.tipoPago = tipoPago;
        this.fechaPago = fechaPago;
        this.codigoH = codigoH;
        this.rif = rif;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getCodigoH() {
        return codigoH;
    }

    public void setCodigoH(int codigoH) {
        this.codigoH = codigoH;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }
 
}
