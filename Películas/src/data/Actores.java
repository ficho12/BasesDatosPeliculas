/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author fiz
 */
public class Actores implements Serializable {
    
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String nacionalidad;
    private int anoDebut;
    private List <String> peliculas;
    
    public Actores(String nombre, LocalDate fechaDeNacimiento, String nacionalidad, int anoDebut, List<String> peliculas) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.anoDebut = anoDebut;
        this.peliculas = peliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getAnoDebut() {
        return anoDebut;
    }

    public void setAnoDebut(int anoDebut) {
        this.anoDebut = anoDebut;
    }

    public List<String> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<String> peliculas) {
        this.peliculas = peliculas;
    }
    
}

