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
public class Servicio {
    private int codigo; //Es un nombre no codigo como tal
    private String descripcion;
    private boolean equipoEspecial;
    private double tarifa;

    public Servicio(int codigo, String descripcion, boolean equipoEspecial, double tarifa) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.equipoEspecial = equipoEspecial;
        this.tarifa = tarifa;
    }

    public int getTipo() {
        return codigo;
    }

    public void setTipo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEquipoEspecial() {
        return equipoEspecial;
    }

    public void setEquipoEspecial(boolean equipoEspecial) {
        this.equipoEspecial = equipoEspecial;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
   
}
