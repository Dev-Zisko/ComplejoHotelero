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
public class Paquete {
    private int codigo = 0 ;
    private String nombre;
    private String descripcion;

    public Paquete(String nombre, String descripcion) {
        
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     public Paquete(String nombre, String descripcion, int codigo) {
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
    
}
