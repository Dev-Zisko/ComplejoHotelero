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
public class OrdenCompra {
    private int numero;
    private Date fechaOrden;
    private Date fechaPago;
    private String rif;
    private int codigoH;

    public OrdenCompra() {
    }

    
    public OrdenCompra(int numero, Date fechaOrden, Date fechaPago, String rif, int codigoH) {
        this.numero = numero;
        this.fechaOrden = fechaOrden;
        
        this.fechaPago = fechaPago;
        this.rif = rif;
        this.codigoH = codigoH;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

   

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public int getCodigoH() {
        return codigoH;
    }

    public void setCodigoH(int codigoH) {
        this.codigoH = codigoH;
    }
    
}
