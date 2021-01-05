/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import data.Actores;
import data.Filmoteca;
import data.Peliculas;
import data.Directores;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author fiz
 */
public class Controller {
    
    Filmoteca m = new Filmoteca();

    public void lectura() {
        m.lectura();
    }

    public void escritura() {
        m.escritura();
    }

    public String[] consultarPeliculas(String pelicula) {
        List <Peliculas> pelis = m.getPeliculas();
        int size = pelis.size();
        String[] tmp = new String[11];
       
            for(int i = 0; i < size; i++){                
                if(pelis.get(i).getTitulo().toLowerCase().contentEquals(pelicula.toLowerCase())){
                    tmp[0] = pelis.get(i).getTitulo();
                    try{
                    tmp[1] = Integer.toString(pelis.get(i).getAno());
                    }catch(Exception ex){
                    tmp[1] = "-1";
                    }
                    try{
                    tmp[2] = Integer.toString(pelis.get(i).getDuracion()); 
                    }catch(Exception ex){
                    tmp[2] = "-1";
                    }
                    if("".equals(pelis.get(i).getPais())){
                        tmp[3] = "No info";
                    }else {
                        tmp[3] = pelis.get(i).getPais();
                    }
                    if("".equals(pelis.get(i).getGuion())){
                        tmp[4] = "No info";
                    }else {
                        tmp[4] = pelis.get(i).getGuion();
                    }
                    if("".equals(pelis.get(i).getMusica())){
                        tmp[5] = "No info";
                    }else {
                        tmp[5] = pelis.get(i).getMusica();
                    }
                    if("".equals(pelis.get(i).getFotografia())){
                        tmp[6] = "No info";
                    }else {
                        tmp[6] = pelis.get(i).getFotografia();
                    }
                    if("".equals(pelis.get(i).getProductora())){
                        tmp[7] = "No info";
                    }else {
                        tmp[7] = pelis.get(i).getProductora();
                    }
                    if("".equals(pelis.get(i).getGenero())){
                        tmp[8] = "No info";
                    }else {
                        tmp[8] = pelis.get(i).getGenero();
                    }
                    if("".equals(pelis.get(i).getSinopsis())){
                        tmp[9] = "No info";
                    }else {
                        tmp[9] = pelis.get(i).getSinopsis();
                    }
                    tmp[10] = Integer.toString(i);
                    return tmp;
                }
            }
        return tmp = null;
    }
    
    public boolean consultarPeliculasBoolean(String pelicula) {
        List <Peliculas> pelis = m.getPeliculas();
        int size = pelis.size();
        boolean encontrado;
       
            for(int i = 0; i < size; i++){                
                if(pelis.get(i).getTitulo().toLowerCase().contentEquals(pelicula.toLowerCase())){
                    return encontrado = true;
                }
            }
        return encontrado = false;
    }

    public String[] consultarDirectores(String director) {
        List <Directores> direc = m.getDirectores();
        int size = direc.size();
        String[] tmp = new String[5];
        
            for(int i = 0; i < size; i++){                
                if(direc.get(i).getNombre().toLowerCase().contentEquals(director.toLowerCase())){
                    tmp[0] = direc.get(i).getNombre();
                    try{
                    tmp[1] = direc.get(i).getFechaDeNacimiento().toString();
                    if(tmp[1].equals(null))
                        tmp[1] = "";
                    }catch(Exception ex){
                        tmp[1] = "-1";
                    }
                    if("".equals(direc.get(i).getNacionalidad())){
                        tmp[2] = "No info";
                    }else{
                        tmp[2] = direc.get(i).getNacionalidad();
                    }
                    if("".equals(direc.get(i).getOcupacion())){
                        tmp[3] = "No info";
                    }else{
                        tmp[3] = direc.get(i).getOcupacion();
                    }
                    tmp[4] = Integer.toString(i);
                    return tmp;
                }
            }
            
        return tmp = null;
    }
    
    public boolean consultarDirectoresBoolean(String director) {
        List <Directores> direc = m.getDirectores();
        int size = direc.size();
        boolean encontrado;
        
            for(int i = 0; i < size; i++){                
                if(direc.get(i).getNombre().toLowerCase().contentEquals(director.toLowerCase()))
                    return encontrado = true;
            }
            
        return encontrado = false;
    }
    

    public void setFechaDeNacimientoDirector(LocalDate fechatmp, int numDirector) {
        m.getDirectores().get(numDirector).setFechaDeNacimiento(fechatmp);
    }

    public void setNacionalidadDirector(String respuesta, int numDirector) {
        m.getDirectores().get(numDirector).setNacionalidad(respuesta);
    }

    public void setOcupacionDirector(String respuesta, int numDirector) {
        m.getDirectores().get(numDirector).setOcupacion(respuesta);
    }

    public List<String> consultasPeliculasReparto(int numPelicula) {
        return m.getPeliculas().get(numPelicula).getReparto();
    }

    public List<String> consultasPeliculasDireccion(int numPelicula) {
        return m.getPeliculas().get(numPelicula).getDireccion();
    }

    public void setAnoPelicula(int tmp, int numPelicula) {
        m.getPeliculas().get(numPelicula).setAno(tmp);
    }

    public void setDuracionPelicula(int tmp, int numPelicula) {
        m.getPeliculas().get(numPelicula).setDuracion(tmp);
    }

    public void setPaisPelicula(String respuesta, int numPelicula) {
        m.getPeliculas().get(numPelicula).setPais(respuesta);
    }

    public void setGuionPelicula(String respuesta, int numPelicula) {
        m.getPeliculas().get(numPelicula).setGuion(respuesta);
    }

    public void setMusicaPelicula(String respuesta, int numPelicula) {
        m.getPeliculas().get(numPelicula).setMusica(respuesta);
    }

    public void setFotografiaPelicula(String respuesta, int numPelicula) {
        m.getPeliculas().get(numPelicula).setFotografia(respuesta);
    }

    public void setProductoraPelicula(String respuesta, int numPelicula) {
        m.getPeliculas().get(numPelicula).setProductora(respuesta);
    }

    public void setGeneroPelicula(String respuesta, int numPelicula) {
        m.getPeliculas().get(numPelicula).setGenero(respuesta);
    }

    public void setSinopsisPelicula(String respuesta, int numPelicula) {
        m.getPeliculas().get(numPelicula).setSinopsis(respuesta);
    }

    public String[] consultarActores(String actor) {
        List <Actores> actores = m.getActores();
        int size = actores.size();
        String[] tmp = new String[5];
        
            for(int i = 0; i < size; i++){                
                if(actores.get(i).getNombre().toLowerCase().contentEquals(actor.toLowerCase())){
                    tmp[0] = actores.get(i).getNombre();
                    try{
                    tmp[1] = actores.get(i).getFechaDeNacimiento().toString();
                    }catch(Exception ex){
                        tmp[1] = "-1";
                    }
                    if("".equals(actores.get(i).getNacionalidad())){
                        tmp[2] = "No info";
                    }else{
                        tmp[2] = actores.get(i).getNacionalidad();
                    }                    
                    try{
                    tmp[3] = Integer.toString(actores.get(i).getAnoDebut());
                    }catch(Exception ex){
                        tmp[3] = "-1";
                    }
                    tmp[4] = Integer.toString(i);
                    return tmp;
                }
            }
            
        return tmp = null;
    }
    
    public boolean consultarActoresBoolean(String actor) {
        List <Actores> actores = m.getActores();
        int size = actores.size();
        boolean encontrado;
        
            for(int i = 0; i < size; i++){                
                if(actores.get(i).getNombre().toLowerCase().contentEquals(actor.toLowerCase())){
                    return encontrado = true;
                }
            }
            
        return encontrado = false;
    }

    public void setFechaDeNacimientoActor(LocalDate fechatmp, int numActor) {
        m.getActores().get(numActor).setFechaDeNacimiento(fechatmp);
    }

    public void setNacionalidadActor(String respuesta, int numActor) {
        m.getActores().get(numActor).setNacionalidad(respuesta);
    }

    public void setAnoDebutActor(int anoDebut, int numActor) {
        m.getActores().get(numActor).setAnoDebut(anoDebut);
    }

    public void altaDirectores(String director,LocalDate fecha,String tmp1, String tmp2, List <String> pelis){
        m.getDirectores().add(new Directores(director,fecha,tmp1,tmp2,pelis));
    }

    public void bajasDirectores(int numDirector) {
        m.getDirectores().remove(numDirector);
    }

    public void altaActores(String actor,LocalDate fecha,String nacionalidad, int anoDebut, List <String> tmpList) {
        m.getActores().add(new Actores(actor,fecha,nacionalidad,anoDebut,tmpList));
    }

    public List<String> comprobarPeliculasDirector(int numDirector) {
        List <String> peliculas;
        List <String> res = new ArrayList<>();
        int size;
        peliculas = m.getDirectores().get(numDirector).getPeliculas();
        size = m.getPeliculas().size();
        for (int i = 0; i < size; i++){
            if(peliculas.contains(m.getPeliculas().get(i).getTitulo())){
                res.add(m.getPeliculas().get(i).getTitulo());
            }
        }
        return res;
    }

    public void bajasActores(int numActor) {
        m.getActores().remove(numActor);
    }

    public void bajasPeliculas(int numPelicula) {
        String pelicula = m.getPeliculas().get(numPelicula).getTitulo();
        List <Directores> direc = m.getDirectores();
        List <Actores> act = m.getActores();
        int direcSize = direc.size();
        int actSize = act.size();
        
        for(int i = 0; i < direcSize; i++){
            for(int j = 0; j < direc.get(i).getPeliculas().size(); j++){
                if(direc.get(i).getPeliculas().get(j).toLowerCase().equals(pelicula.toLowerCase()))
                    direc.get(i).getPeliculas().remove(j);
            }
        }
        
        for(int i = 0; i < actSize; i++){
            for(int j = 0; j < act.get(i).getPeliculas().size(); j++){
                if(act.get(i).getPeliculas().get(j).toLowerCase().equals(pelicula.toLowerCase()))
                    act.get(i).getPeliculas().remove(j);
            }
        }
        
        m.getPeliculas().remove(numPelicula);
    }

    public List<String> comprobarPeliculasActor(int numActor) {
        List <String> peliculas;
        List <String> res = new ArrayList<>();
        int size;
        peliculas = m.getActores().get(numActor).getPeliculas();
        size = m.getPeliculas().size();
        for (int i = 0; i < size; i++){
            if(peliculas.contains(m.getPeliculas().get(i).getTitulo())){
                res.add(m.getPeliculas().get(i).getTitulo());
            }
        }
        return res;    
    }

    public int altaPeliculas(String pelicula, int ano, int duracion, String tmp1,
            String tmp2, String tmp3,String tmp4,String tmp5,String tmp6,String tmp7) {
        List <String> tmpList = null;
        List <String> tmpList2 = null;
        
        m.getPeliculas().add(new Peliculas(pelicula,ano,duracion,tmp1,tmpList,
                tmp2,tmp3,tmp4,tmpList2,tmp5,tmp6,tmp7));
        
        return m.getPeliculas().size()-1;
    }

    public void setRepartoPelicula(List<String> actores, int numPelicula) {
        int sizeAct = actores.size();
        LocalDate fecha = null;
        String[] tmp = new String[5];
        String titulo = m.getPeliculas().get(numPelicula).getTitulo();
        List <String> pelisActor;
        List <String> pelis = new ArrayList<>();
        pelis.add(titulo);
        
        m.getPeliculas().get(numPelicula).setReparto(actores);
        
        for (int i = 0;  i < sizeAct; i++){
        tmp = this.consultarActores(actores.get(i));
        if(tmp == null){
            this.altaActores(actores.get(i),fecha,"",0,pelis);
        } else{
            m.getActores().get(Integer.parseInt(tmp[4])).getPeliculas().add(titulo);
        }
            
        }
    }

    public void setDireccionPelicula(List<String> directores, int numPelicula) {
        int sizeDir = directores.size();
        LocalDate fechatmp = null;
        String[] tmp = new String[5];
        String titulo = m.getPeliculas().get(numPelicula).getTitulo();
        List <String> pelis = new ArrayList<>();
        pelis.add(titulo);
        
        m.getPeliculas().get(numPelicula).setDireccion(directores);
        
        for (int i = 0;  i < sizeDir; i++){
        tmp = this.consultarDirectores(directores.get(i));
        if(tmp == null){
            this.altaDirectores(directores.get(i),fechatmp,"","",pelis);
        } else{
            m.getDirectores().get(Integer.parseInt(tmp[4])).getPeliculas().add(titulo);
        }
            
        }
    }

    public List<String> peliculasDeUnActor(int numActores) {
       List <String> pelis = m.getActores().get(numActores).getPeliculas();
       int size = pelis.size();
       List <String> res = new ArrayList<>();
       List <Peliculas> p = new ArrayList<>();
       String[] tmp;
       
       for(int i = 0; i < size; i++ ){
           tmp = this.consultarPeliculas(pelis.get(i));
           if(tmp == null){
            res.add(pelis.get(i));
           }else{
            p.add(m.getPeliculas().get(Integer.parseInt(tmp[10])));
           }
       }
       
       List <String> respuesta =  new ArrayList<>();
       int size2 = p.size();
       int size3 = res.size();
        
       p.sort(Comparator.comparing(Peliculas::getAno));
       
       for(int i = 0; i < size2; i++){
           respuesta.add(p.get(i).getTitulo());
           respuesta.add(Integer.toString(p.get(i).getAno()));
           respuesta.add(Integer.toString(p.get(i).getDuracion()));
           respuesta.add(p.get(i).getPais());
           respuesta.add(p.get(i).getGenero());
       }
       
       for(int i = 0; i < size3; i++){
           respuesta.add(res.get(i));
           respuesta.add("-1");
           respuesta.add("-1");
           respuesta.add("No info");
           respuesta.add("No info");
       }
       
       return respuesta;
    }

    public void exportarPeliculas() {
        m.exportarPeliculas();
    }

    public void exportarDirectores() {
        m.exportarDirectores();
    }

    public List<String> getPeliculasString() {
       List <Peliculas> p = m.getPeliculas();
       int size = p.size();
       List <String> respuesta =  new ArrayList<>();
        
       p.sort(Comparator.comparing(Peliculas::getTitulo));
       
       for(int i = 0; i < size; i++){
           respuesta.add(p.get(i).getTitulo());
           respuesta.add(Integer.toString(p.get(i).getAno()));
           respuesta.add(Integer.toString(p.get(i).getDuracion()));
           respuesta.add(p.get(i).getPais());
           respuesta.add(p.get(i).getGenero());
       }
       
       return respuesta;
    }

    public List<String> getDirectoresString() {
       List <Directores> d = m.getDirectores();
       int size = d.size();
       List <String> respuesta =  new ArrayList<>();
       
       Comparator compDirNac;
        compDirNac = new Comparator<Directores>(){
            public int compare(Directores a, Directores b){
                if (a.getNacionalidad().equals("")) {
                    if (b.getNacionalidad().equals("")) {
                        return 0; // they're both null
                    }else {
                        return 1; // only o1 is null
                    }
                }
                else if (b.getNacionalidad().equals("")) {
                    return -1; // only o2 is null
                }
                else {
                    return a.getNacionalidad().compareTo(b.getNacionalidad());
                }
            }
        };
        
        Comparator compDirAno;
        compDirAno = new Comparator<Directores>(){
            public int compare(Directores a, Directores b){
                if (a.getAno() == 0) {
                    if (b.getAno() == 0) {
                        return 0; // they're both null
                    }else {
                        return 1; // only o1 is null
                    }
                }
                else if (b.getAno() == 0) {
                    return -1; // only o2 is null
                }
                else {
                    return a.getAno()- b.getAno();
                }
            }
        };
        
        Comparator compDirNom;
        compDirNom = new Comparator<Directores>(){
            public int compare(Directores a, Directores b){
                if (a.getNombre().equals("")) {
                    if (b.getNombre().equals("")) {
                        return 0; // they're both null
                    }else {
                        return 1; // only o1 is null
                    }
                }
                else if (b.getNombre().equals("")) {
                    return -1; // only o2 is null
                }
                else {
                    return a.getNombre().compareTo(b.getNombre());
                }
            }
        };
        
       d.sort(compDirNac.thenComparing(compDirAno).thenComparing(compDirNom));
       
       for(int i = 0; i < size; i++){
           respuesta.add(d.get(i).getNombre());
           try{
           respuesta.add(d.get(i).getFechaDeNacimiento().toString());
           } catch(Exception e){
               respuesta.add("-1");
           }
           if(d.get(i).getNacionalidad().equals("")){
               respuesta.add("No info");
           }else{
               respuesta.add(d.get(i).getNacionalidad());
           }
           if(d.get(i).getOcupacion().equals("")){
               respuesta.add("No info");
           }else{
               respuesta.add(d.get(i).getOcupacion());
           }
       }
       
       return respuesta;
    }

    public List<String> getActoresString() {
       List <Actores> a = m.getActores();
       int size = a.size();
       List <String> respuesta =  new ArrayList<>();
       
       Comparator compActAno;
        compActAno = new Comparator<Actores>(){
            public int compare(Actores a, Actores b){
                if (a.getAnoDebut() == 0) {
                    if (b.getAnoDebut() == 0) {
                        return 0; // they're both null
                    }else {
                        return 1; // only o1 is null
                    }
                }
                else if (b.getAnoDebut() == 0) {
                    return -1; // only o2 is null
                }
                else {
                    return a.getAnoDebut() - b.getAnoDebut(); // normal integer comparison
                }
            }
        };
        
        Comparator compActNom;
        compActNom = new Comparator<Actores>(){
            public int compare(Actores a, Actores b){
                if (a.getNombre().equals("")) {
                    if (b.getNombre().equals("")) {
                        return 0; // they're both null
                    }else {
                        return 1; // only o1 is null
                    }
                }
                else if (b.getNombre().equals("")) {
                    return -1; // only o2 is null
                }
                else {
                    return a.getNombre().compareTo(b.getNombre());
                }
            }
        };
       
       a.sort(compActAno.thenComparing(compActNom));
       
       for(int i = 0; i < size; i++){
           respuesta.add(a.get(i).getNombre());
           try{
           respuesta.add(a.get(i).getFechaDeNacimiento().toString());
           } catch(Exception e){
               respuesta.add("-1");
           }
           if(a.get(i).getNacionalidad().equals("")){
                respuesta.add("No info");
           }else{
                respuesta.add(a.get(i).getNacionalidad());
           }
           if(a.get(i).getAnoDebut() == 0){
               respuesta.add("-1");
           }else{
               respuesta.add(Integer.toString(a.get(i).getAnoDebut()));
           }
       }
       
       return respuesta;    
    }
    
    public List<String> splitString(String msg, int lineSize) {
        List<String> res = new ArrayList<String>();

        Pattern p = Pattern.compile("\\b.{1," + (lineSize-1) + "}\\b\\W?");
        Matcher m = p.matcher(msg);

        while(m.find()) {
                m.group().trim();   
                res.add(m.group());
        }
        return res;
    }


}
