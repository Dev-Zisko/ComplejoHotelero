/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author Christian D
 */
public class Horario {
    private String diaSemana;
    private String hora;
    private String ci;

    public Horario(String diaSemana, String hora, String ci) {
        this.diaSemana = diaSemana;
        this.hora = hora;
        this.ci = ci;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    
    
    
    
    
}
