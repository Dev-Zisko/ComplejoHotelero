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
public class Lugar {
    
    private int codigo;
    private String descripcion;
    private String tipo;
    public int codigo1=0;

    public Lugar(int codigo, String descripcion, String tipo, int codigo1) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.codigo1 = codigo1;
    }
       public Lugar(int codigo, String descripcion, String tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigo1() {
        return codigo1;
    }

    public void setCodigo1(int codigo1) {
        this.codigo1 = codigo1;
    }
    
    
    
    
}
