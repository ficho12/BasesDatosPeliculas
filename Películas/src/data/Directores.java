/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fiz
 */
public class Directores implements Serializable{
    
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String nacionalidad;
    private String ocupacion;
    private List <String> peliculas;
    
    public Directores(String nombre, LocalDate fechaDeNacimiento, String nacionalidad, String ocupacion, List<String> peliculas) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.ocupacion = ocupacion;
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
    
    public int getAno(){
        if(this.fechaDeNacimiento == null){
            return 0000;
        }else{
            List <String> tmpList = new ArrayList<>(Arrays.asList(this.fechaDeNacimiento.toString().split("-")));
            return Integer.parseInt(tmpList.get(0));
        }
        
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public List<String> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<String> peliculas) {
        this.peliculas = peliculas;
    }
    
    public String exportStateAsColumns() {
        String[] tmp = new String[3];
        
        try{
            tmp[0] = this.fechaDeNacimiento.toString();
        }catch(Exception e){
            tmp[0] = "-1";
        }
        
        if(this.nacionalidad.equals("")){
            tmp[1] = "No info";
        }else{
            tmp[1] = this.nacionalidad;
        }
        
        if(this.ocupacion.equals("")){
            tmp[2] = "-1";
        }else{
            tmp[2] = this.ocupacion;
        }
        
        return String.format("| %-30s | %-19s | %-42s | %-75s | %-100s |",
                this.nombre,
                tmp[0],
                tmp[1],
                tmp[2],
                String.join(", ", this.peliculas));
    }
    
}
