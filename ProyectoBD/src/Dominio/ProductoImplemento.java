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
public class ProductoImplemento {
    private int codigo;
    private String nombre;
    private int cantidadMin;
    private int cantidadT;
    private int cantidadF;
    private Date fechaInventario;
    private int codigoH;

    public ProductoImplemento(int codigo, String nombre, int cantidadMin, int cantidadT, int cantidadF, Date fechaInventario, int codigoH) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadMin = cantidadMin;
        this.cantidadT = cantidadT;
        this.cantidadF = cantidadF;
        this.fechaInventario = fechaInventario;
        this.codigoH = codigoH;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(int cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    public int getCantidadT() {
        return cantidadT;
    }

    public void setCantidadT(int cantidadT) {
        this.cantidadT = cantidadT;
    }

    public int getCantidadF() {
        return cantidadF;
    }

    public void setCantidadF(int cantidadF) {
        this.cantidadF = cantidadF;
    }

    public Date getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(Date fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public int getCodigoH() {
        return codigoH;
    }

    public void setCodigoH(int codigoH) {
        this.codigoH = codigoH;
    }
    
}
