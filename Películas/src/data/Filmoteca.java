/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import com.coti.tools.Rutas;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import static java.lang.System.err;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 *
 * @author fiz
 */
public class Filmoteca {
    
    private final int NUM_FILES = 6;
    private final String nameOfFolder = "Filmot18";    
    
    private List <Peliculas> peliculas = new ArrayList<>();
    private List <Directores> directores = new ArrayList<>();
    private List <Actores> actores = new ArrayList<>();
  
    public List<Peliculas> getPeliculas(){
        return this.peliculas;
    }
    
    public List<Directores> getDirectores(){
        return this.directores;
    }
        
    public List<Actores> getActores(){
        return this.actores;
    }    
    
    public void lectura() {
        Path p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "peliculas.bin");
        //String filepath = "/home/user/Escritorio/Filmot18/peliculas.bin";
        
        FileInputStream fis;
        BufferedInputStream bis;
        ObjectInputStream ois;
        
        try{            
            fis = new FileInputStream(p.toFile());
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            try {
                peliculas =  (ArrayList<Peliculas>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.err.printf("No fue posible guardar el archivo películas.bin%n");
                System.err.println(ex.toString());
            }
            ois.close();
        } catch (IOException ex){
            err.println("No fue posible leer el archivo películas.bin");
            err.println(ex.toString());
            
            p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "peliculas.txt");
            //filepath = "/home/user/Escritorio/Filmot18/peliculas.txt";
            
            String[] tmp = new String[8];
            int[] tmpInt = new int[2];
            
            try
            {
                Scanner x = new Scanner(p);
                x.useDelimiter("[#|\\n]");

                while(x.hasNext())
                {                                    
                    tmp[0] = x.next();
                    try{
                    tmpInt[0] = x.nextInt();
                    }catch(InputMismatchException e){
                        System.err.printf("Error en el formato del archivo peliculas.txt%n");
                        System.err.println(e.toString());
                    }
                    try{
                    tmpInt[1] = x.nextInt();
                    }catch(InputMismatchException e){
                        System.err.printf("Error en el formato del archivo peliculas.txt%n");
                        System.err.println(e.toString());
                    }
                    tmp[1] = x.next();
                    List <String> tmpList = new ArrayList<>(Arrays.asList(x.next().split("\t")));  
                    tmp[2] = x.next();
                    tmp[3] = x.next();
                    tmp[4] = x.next();
                    List <String> tmpList2 = new ArrayList<>(Arrays.asList(x.next().split("\t")));  
                    tmp[5] = x.next();
                    tmp[6] = x.next();
                    tmp[7] = x.next();
                    
                    peliculas.add(new Peliculas(tmp[0],tmpInt[0],tmpInt[1],tmp[1],tmpList,
                            tmp[2],tmp[3],tmp[4],tmpList2,tmp[5],tmp[6],tmp[7]));                    
                }
            }
            catch(Exception e)
            {
                System.err.println("No fue posible leer el archivo peliculas.txt");
                err.println(e.toString());
            }
        }
        
        
        p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "directores.bin");
        //filepath = "/home/user/Escritorio/Filmot18/directores.bin";
        
        try{            
            fis = new FileInputStream(p.toFile());
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            try {
                directores =  (ArrayList<Directores>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.err.printf("No fue posible leer el archivo directores.bin%n");
                System.err.println(ex.toString());
            }
            ois.close();
        } catch (IOException ex){
            err.println("No fue posible leer el archivo directores.bin");
            err.println(ex.toString());
            
            p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "directores.txt");
            //filepath = "/home/user/Escritorio/Filmot18/directores.txt";
            String[] tmp = new String[3];
            LocalDate fechatmp = null;           
            
            try
            {
                Scanner x = new Scanner(p);
                x.useDelimiter("[#|\\n]");

                while(x.hasNext())
                {                
                    tmp[0] = x.next();
                    try{
                    fechatmp = LocalDate.parse(x.next());
                    } catch(Exception e){
                        fechatmp = null;
                    }
                    tmp[1] = x.next();
                    tmp[2] = x.next();
                    List <String> tmpList2 = new ArrayList<>(Arrays.asList(x.next().split("\t")));  
                    
                    directores.add(new Directores(tmp[0],fechatmp,tmp[1],tmp[2],tmpList2));
                }
            }
            catch(Exception e)
            {
                System.err.println("No fue posible leer el archivo directores.txt");
                err.println(e.toString());
            }    
        }
        
        p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "actores.bin");
        //filepath = "/home/user/Escritorio/Filmot18/actores.bin";
        
        try{            
            fis = new FileInputStream(p.toFile());
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
            try {
                actores =  (ArrayList<Actores>) ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.err.printf("No fue posible guardar el archivo actores.bin%n");
                System.err.println(ex.toString());
            }
            ois.close();
        } catch (IOException ex){
            err.println("No fue posible leer el archivo actores.bin");
            err.println(ex.toString());
            
            p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "actores.txt");
            //filepath = "/home/user/Escritorio/Filmot18/actores.txt";
            
            String[] tmp = new String[2];
            LocalDate fechatmp = null;           
            int tmpInt = 0;
            
            try
            {
                Scanner x = new Scanner(p);
                x.useDelimiter("[#|\\n]");

                while(x.hasNext())
                {                
                    tmp[0] = x.next();
                    try{
                    fechatmp = LocalDate.parse(x.next());
                    } catch(Exception e){
                        fechatmp = null;
                    }
                    tmp[1] = x.next();
                    try{
                        tmpInt = x.nextInt();
                    }catch(Exception e){
                        tmpInt = 0;
                    }
                    List <String> tmpList2 = new ArrayList<>(Arrays.asList(x.next().split("\t")));  
                    
                    actores.add(new Actores(tmp[0],fechatmp,tmp[1],tmpInt,tmpList2));
                }
            }
            catch(Exception e)
            {
                System.err.println("No fue posible leer el archivo actores.txt");
                err.println(e.toString());
            }    
        }
    }

    public void escritura() {
        
        Path p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "peliculas.bin");
        //String filepath = "/home/user/Escritorio/Filmot18/peliculas.bin";
        
        FileOutputStream fos;
        BufferedOutputStream bos;
        ObjectOutputStream oos = null;
        
       try{
            fos = new FileOutputStream(p.toFile());
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            oos.writeObject(peliculas);
            oos.close();
        } catch (IOException ex){
            err.println("No fue posible leer el archivo películas.bin");
            err.println(ex.toString());
        }
        
        p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "directores.bin");
        //filepath = "/home/user/Escritorio/Filmot18/directores.bin";
        
        try{
            fos = new FileOutputStream(p.toFile());
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            oos.writeObject(directores);
            oos.close();
        } catch (IOException ex){
            err.println("No fue posible leer el archivo directores.bin");
            err.println(ex.toString());
        }
        
        p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "actores.bin");
        //filepath = "/home/user/Escritorio/Filmot18/actores.bin";
        
        try{
            fos = new FileOutputStream(p.toFile());
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);
            oos.writeObject(actores);
            oos.close();
        } catch (IOException ex){
            err.println("No fue posible leer el archivo actores.bin");
            err.println(ex.toString());
        }
        
    }

    public void exportarPeliculas() {
        
            Path p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "peliculas.html");
            //String filepath = "/home/user/Escritorio/Filmot18/peliculas.html";
            String principio = "<html>" +
                                "<html lang=\"es\">"+
                                "<head>" +
                                "<meta charset=\"utf-8\"/>"+
                                "<style>" +
                                "table, th, td {" +
                                "  border: 1px solid black;" +
                                "}" +
                                "</style>" +
                                "</head>" +
                                "<body>" +
                                "<table>";
            String fin = "</table>" +
                            "</body>" +
                            "</html>";

            
            
            int size = this.peliculas.size();
            
            try
            {
                FileWriter x = new FileWriter(p.toString());
                
                x.append(principio);
                
                x.append(String.format("<TR><TD>Título</TD><TD>Año</TD><TD>Duración</TD>"
                        + "<TD>País</TD><TD>Dirección</TD><TD>Guión</TD><TD>Música</TD>"
                        + "<TD>Fotografía</TD><TD>Reparto</TD><TD>Productora</TD>"
                        + "<TD>Género</TD><TD>Sinópsis</TD><TR>"));
               
                for(int i = 0; i < size; i++){
                    x.append(this.peliculas.get(i).exportStateAsHTMLRow());
                }
                
                x.append(fin);
                
                x.close();
            } catch(Exception e)
            {
                System.err.println("No fue posible guardar el archivo peliculas.html");
                err.println(e.toString());
            }    
    }

    public void exportarDirectores() {
        
        if (null == getDirectores()) {
            System.err.printf("No se han encontrado directores para exportar");
        }
        
        Path p = Rutas.pathToFileInFolderOnDesktop(nameOfFolder, "directores.col");
        //String filepath = "/home/user/Escritorio/Filmot18/directores.col";
        
        String nl = String.format("%n");
        List <Directores> listaDir = getDirectores();        
        
        try
            {
                FileWriter x = new FileWriter(p.toString());
                
                for (int i = 0; i < listaDir.size(); i++) {
                    System.out.println(listaDir.get(i).exportStateAsColumns());
                    x.append(listaDir.get(i).exportStateAsColumns());
                    x.append(nl);
                }
                
                x.close();
            } catch(Exception e)
            {
                System.err.println("No fue posible guardar el archivo directores.col");
                err.println(e.toString());
            }    
        
    }

}
