

package view;

import static com.coti.tools.Esdia.readString;
import static com.coti.tools.Esdia.readString_ne;
import static com.coti.tools.Esdia.yesOrNo;
import controller.Controller;
import static java.lang.System.out;
import static com.coti.tools.DiaUtil.clear;
import static com.coti.tools.Esdia.readInt;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author fiz
 */
public class View {
    
    Controller c = new Controller();
    
    /**
     *
     * @param menu
     */
    
    public void runMenu(String menu){
        
        boolean salir = false;
        boolean permitido = false;
        String opcion;
        String[] availableOptions = {"1","2","3","4","5","q"};
        
        clear();
        
        this.lectura();
        
        do{
            opcion = readString(menu, availableOptions).toLowerCase();
            switch(opcion){
                case "1":
                    this.archivos();
                    break;
                case "2":
                    this.peliculas();
                    break;
                case "3":
                    this.directores();
                    break; 
                 case "4":
                    this.actores();
                    break;
                 case "5":
                    this.listados();
                    break;
                case"q":
                    salir = yesOrNo("%n¿Desea realmente "
                            + "salir de la aplicación? ");
                    this.escritura();
                    break;
                default:
                    out.printf("%n%nOpción Incorrecta%n%n");
                    break;
            }
        }while(!salir); 
    }
    
    private void actores() {
        
        clear();
                
        String menu = "%nACTORES%n"
                + "%n1.- Altas%n"
                + "2.- Bajas%n"
                + "3.- Modificaciones%n"
                + "4.- Películas de un Actor%n"
                + "q.- Volver al menú inicial%n";
        
        boolean salir = false;
        
        String opcion;
        String[] availableOptions = {"1","2","3","4","q"};
         do{
            opcion = readString(menu, availableOptions).toLowerCase();
            switch(opcion){
                case "1":
                    this.altasActores();
                    break;
                case "2":
                    this.bajasActores();
                    break;
                case "3":
                    this.modificacionesActores();
                    break; 
                 case "4":
                    this.peliculasDeUnActor();
                    break;
                case"q":
                    salir = true;
                    break;
                default:
                    out.printf("%n%nOpción Incorrecta%n%n");
                    break;
            }
        }while(!salir);  
    }
    
    private void archivos() {
        
        clear();
        
        String menu = "%nARCHIVOS%n"
                + "%n1.- Exportar Directores%n"
                + "2.- Exportar Películas%n"
                + "q.- Volver al menú inicial%n";
        
        boolean salir = false;
        
        String opcion;
        String[] availableOptions = {"1","2","q"};
         do{
            opcion = readString(menu, availableOptions).toLowerCase();
            switch(opcion){
                case "1":
                    this.exportarDirectores();
                    break;
                case "2":
                    this.exportarPeliculas();
                    break;
                case"q":
                    salir = true;
                    break;
                default:
                    out.printf("%n%nOpción Incorrecta%n%n");
                    break;
            }
        }while(!salir);        
    }    

    private void listados() {
        
        clear();
        
        String menu = "%nLISTADOS%n"
                + "%n1.- Ver películas alfabéticamente%n"
                + "2.- Ver directores por nacionalidad y año de nacimiento%n"
                + "3.- Ver actores por año de debut y nombre%n"
                + "q.- Volver al menú inicial%n";
        
        boolean salir = false;
        
        String opcion;
        String[] availableOptions = {"1","2","3","q"};
         do{
            opcion = readString(menu, availableOptions).toLowerCase();
            switch(opcion){
                case "1":
                    this.verPeliculas();
                    break;
                case "2":
                    this.verDirectores();
                    break;
                case "3":
                    this.verActores();
                    break; 
                case"q":
                    salir = true;
                    break;
                default:
                    out.printf("%n%nOpción Incorrecta%n%n");
                    break;
            }
        }while(!salir);     
    }

    private void escritura() {
        c.escritura();
    }

    private void lectura() {
        c.lectura();
    }

    private void exportarDirectores() {
        c.exportarDirectores();
        
        System.out.println();
        readString("Exportación de directores finalizada con éxito, pulse intro para continuar."); 
    }

    private void exportarPeliculas() {
        c.exportarPeliculas();
        
        System.out.println();
        readString("Exportación de películas finalizada con éxito, pulse intro para continuar."); 
    }
    
    public void peliculas() {
        
        clear();
        
        String menu = "%nPELÍCULAS%n"
                + "%n1.- Altas%n"
                + "2.- Bajas%n"
                + "3.- Modificaciones%n"
                + "4.- Consultas%n"
                + "q.- Volver al menú inicial%n";
        
        boolean salir = false;
        
        String opcion;
        String[] availableOptions = {"1","2","3","4","q"};
         do{
            opcion = readString(menu, availableOptions).toLowerCase();
            switch(opcion){
                case "1":
                    this.altasPeliculas();
                    break;
                case "2":
                    this.bajasPeliculas();
                    break;
                case "3":
                    this.modificacionesPeliculas();
                    break; 
                 case "4":
                    this.consultasPeliculas();
                    break;
                case"q":
                    salir = true;
                    break;
                default:
                    out.printf("%n%nOpción Incorrecta%n%n");
                    break;
            }
        }while(!salir);    
    }
    
    public void altasPeliculas() {
        boolean encontrado;
        int numPelicula;
        
        String pelicula = readString_ne("Introduzca el nombre de la película que desea dar de alta ( o q para salir): ");
        if("q".equals(pelicula))
            return;
        encontrado = c.consultarPeliculasBoolean(pelicula);
        
        while(encontrado == true){
            pelicula = readString_ne("Película encontrada, introduzca otra película (o q para salir): ");
            if("q".equals(pelicula))
            return;
            encontrado = c.consultarPeliculasBoolean(pelicula);
        }
        
        String[] respuesta = new String[8];
        int respuestaInt1,respuestaInt2;
        
        respuestaInt1 = readInt("%nIntroduzca el año: ",1800,2100);
        respuestaInt2 = readInt("%nIntroduzca la duración: ",0,1000);
        respuesta[0] = readString_ne("%nIntroduzca el país: ");
        respuesta[1] = readString_ne("%nIntroduzca el guión: ");
        respuesta[2] = readString_ne("%nIntroduzca la música: ");
        respuesta[3] = readString_ne("%nIntroduzca la fotografía: ");
        respuesta[4] = readString_ne("%nIntroduzca la productora: ");
        respuesta[5] = readString_ne("%nIntroduzca el género: ");
        respuesta[6] = readString_ne("%nIntroduzca la sinópsis: ");
  
        numPelicula = c.altaPeliculas(pelicula,respuestaInt1,respuestaInt2,respuesta[0]
        ,respuesta[1],respuesta[2],respuesta[3],respuesta[4],respuesta[5],respuesta[6]);
        
        List <String> actores = new ArrayList<>();
        String actor;
        
        for(int i = 0;;i++){
            actor = readString_ne("Introduzca el actor a añadir (o q para terminar de añadir actores): ");
            if(actor.equals("q"))
                break;
            actores.add(actor);
        }
        
        c.setRepartoPelicula(actores,numPelicula);
        
        List <String> directores = new ArrayList<>();
        String director;
        
        for(int i = 0;;i++){
            director = readString_ne("Introduzca el director a añadir (o q para terminar de añadir directores): ");
            if(director.equals("q"))
                break;
            directores.add(director);
        }
        
        c.setDireccionPelicula(directores,numPelicula);
        
        System.out.println();
        readString("Película dada de alta con éxito, pulse intro para continuar.");    
    }

    public void bajasPeliculas() {
        String[] peliculas = null;
        int numPelicula;
        
        String pelicula = readString_ne("Introduzca el nombre de la película que desea dar de baja ( o q para salir): ");
        if("q".equals(pelicula))
            return;
        peliculas = c.consultarPeliculas(pelicula);
        
        while(peliculas == null){
            pelicula = readString_ne("Película no encontrada, introduzca otra película (o q para salir): ");
            if("q".equals(pelicula))
                return;
            peliculas = c.consultarPeliculas(pelicula);
        }
        
        numPelicula = Integer.parseInt(peliculas[10]);
        
        c.bajasPeliculas(numPelicula);
        
        System.out.println();
        readString("Película dado de baja con éxito, pulse intro para continuar."); 
        
    }

    public void modificacionesPeliculas() {
        int numPelicula;
        String[] peliculas = null;
        String[] availableOptions = {"1","2","3","4","5","6","7","8","9","q"};        
        String opcion, respuesta;
        boolean valido = false;
        int tmp;
        
        String pelicula = readString_ne("Introduzca el título de la película que desea modificar (o q para salir): ");
        if("q".equals(pelicula))
                return;
        peliculas = c.consultarPeliculas(pelicula);
        while(peliculas == null){
            pelicula = readString_ne("Película no encontrada, introduzca otra película (o q para salir): ");
            if("q".equals(pelicula))
                return;
            peliculas = c.consultarPeliculas(pelicula);
        }
        
        numPelicula = Integer.parseInt(peliculas[10]);
        String separador = "---------------------------------------------------------------------------------------------------";
        
        List <String> sinopsis = c.splitString(peliculas[9],80);
        int size = sinopsis.size();
        int respuestaInt;
        
        System.out.printf("%n%s%n| %-12s | %-80s |%n%s%n| %-12s | %-80s |%n%s%n|"
                + " %-12s | %s minutos%69s |%n%s%n| %-12s | %-80s |%n%s%n| %-12s | %-80s"
                + " |%n%s%n| %-12s | %-80s |%n%s%n| %-12s | %-80s |%n%s%n|"
                + " %-12s | %-80s |%n%s%n| %-12s | %-80s |%n%s%n| %-12s | "
                ,separador,"Título",peliculas[0],separador,"Año",peliculas[1],
                separador,"Duración",peliculas[2],"",separador,"País",peliculas[3],
                separador,"Guión",peliculas[4],separador,"Música",peliculas[5],
                separador,"Fotografía",peliculas[6],separador,"Productora",peliculas[7],
                separador,"Género",peliculas[8],separador,"Sinópsis");
        
        System.out.printf("%-80s |%n", sinopsis.get(0));
        
        if(size < 2){
            System.out.printf("%s%n", separador);
        } else{
            for(int i = 1; i < size; i++){
            System.out.printf("| %-12s | %-80s |%n","",sinopsis.get(i));
            }
            System.out.printf("%s",separador);
        }        
        
        opcion = readString("%n%nEliga una opción:%n1-Año%n2-Duración%n3-País%n4-"
                + "Guión%n5-Música%n6-Fotografía%n7-Productora%n8-Género%n9-Sinópsis%nq-Salir%n", availableOptions);   
        
        switch(opcion){
            case "1":   respuestaInt = readInt("%nIntroduzca el año: ",1800,2100);
                        c.setAnoPelicula(respuestaInt,numPelicula);
                break;
            case "2":   respuestaInt = readInt("%nIntroduzca la duración: ",0,1000);
                        c.setDuracionPelicula(respuestaInt,numPelicula);
                break;
            case "3":   respuesta = readString_ne("%nIntroduzca el país (o q para salir): ");
                        if(respuesta.equals("q"))
                            return;
                        c.setPaisPelicula(respuesta,numPelicula);
                break;
            case "4":   respuesta = readString_ne("%nIntroduzca el guión (o q para salir): ");
                        if(respuesta.equals("q"))
                            return;
                        c.setGuionPelicula(respuesta,numPelicula);
                break;
            case "5":    respuesta = readString_ne("%nIntroduzca la música (o q para salir): ");
                        if(respuesta.equals("q"))
                            return;
                        c.setMusicaPelicula(respuesta,numPelicula);
                break;
            case "6":   respuesta = readString_ne("%nIntroduzca la fotografía (o q para salir): ");
                        if(respuesta.equals("q"))
                            return;
                        c.setFotografiaPelicula(respuesta,numPelicula);
                break;
            case "7":   respuesta = readString_ne("%nIntroduzca la productora (o q para salir): ");
                        if(respuesta.equals("q"))
                            return;
                        c.setProductoraPelicula(respuesta,numPelicula);
                break;
            case "8":    respuesta = readString_ne("%nIntroduzca el género (o q para salir): ");
                        if(respuesta.equals("q"))
                            return;
                        c.setGeneroPelicula(respuesta,numPelicula);
                break;
            case "9":   respuesta = readString_ne("%nIntroduzca la sinópsis (o q para salir): ");
                        if(respuesta.equals("q"))
                            return;
                        c.setSinopsisPelicula(respuesta,numPelicula);
                break;
            case "q":   
                break;
        }    
        
        System.out.println();
        readString("Datos modificados con éxito, pulse intro para continuar.");
        
    }

    public void consultasPeliculas() {
        int numPelicula;
        String[] peliculas = null;
        String pelicula = readString_ne("Introduzca el título de la película que desea consultar (o q para salir): ");
        if("q".equals(pelicula))
            return;
        
        
        peliculas = c.consultarPeliculas(pelicula);
        while(peliculas == null){
            pelicula = readString_ne("Película no encontrada, introduzca otra película (o q para salir): ");
            if("q".equals(pelicula))
                return;
            peliculas = c.consultarPeliculas(pelicula);
        }
        
        numPelicula = Integer.parseInt(peliculas[10]);
        String separador = "---------------------------------------------------------------------------------------------------";
                
        List <String> direccion = c.splitString(String.join(", ",c.consultasPeliculasDireccion(numPelicula)),80);
        int size = direccion.size();
        
        System.out.printf("%n%s%n| %-12s | %-80s |%n%s%n| %-12s | %-80s |%n%s%n|"
                + " %-12s | %s minutos%69s |%n%s%n| %-12s | %-80s |%n%s%n| %-12s | "
                ,separador,"Título",peliculas[0],separador,"Año",peliculas[1],
                separador,"Duración",peliculas[2],"",separador,"País",peliculas[3],
                separador,"Dirección");
        
        System.out.printf("%-80s |", direccion.get(0));
        
        if(size < 2){
            System.out.printf("%n%s%n", separador);
        } else{
            for(int i = 1; i < size; i++){
            System.out.printf("%n| %-12s | %-80s |","",direccion.get(i));
            }
            System.out.printf("%n%s%n",separador);
        }
        
        
        List <String> reparto = c.splitString(String.join(", ",c.consultasPeliculasReparto(numPelicula)),80);
        size = reparto.size();
        
        System.out.printf("| %-12s | %-80s |%n%s%n| %-12s | %-80s |%n%s%n|"
                 + " %-12s | %-80s |%n%s%n| %-12s | ","Guión",peliculas[4],separador,
                 "Música",peliculas[5],separador,"Fotografía",peliculas[6],
                 separador,"Reparto");
        
        System.out.printf("%-80s |", reparto.get(0));
        
        if(size < 2){
            System.out.printf("%n%s%n", separador);
        } else{
            for(int i = 1; i < size; i++){
            System.out.printf("%n| %-12s | %-80s |","",reparto.get(i));
            }
            System.out.printf("%n%s%n",separador);
        }
        
        List <String> productora = c.splitString(peliculas[7],80);
        size = productora.size();
        
        System.out.printf("| %-12s | ","Productora");
        
        System.out.printf("%-80s |", productora.get(0));
        
        if(size < 2){
            System.out.printf("%n%s%n", separador);
        } else{
            for(int i = 1; i < size; i++){
            System.out.printf("%n| %-12s | %-80s |","",productora.get(i));
            }
            System.out.printf("%n%s%n",separador);
        }
        
        
        System.out.printf("| %-12s | %-80s |%n%s%n| %-12s | "
                ,"Género", peliculas[8],separador,"Sinópsis");
        
        List <String> sinopsis = c.splitString(peliculas[9],80);
        size = sinopsis.size();
        
        System.out.printf("%-80s |", sinopsis.get(0));
        
        if(size < 2){
            System.out.printf("%n%s%n", separador);
        } else{
            for(int i = 1; i < size; i++){
            System.out.printf("%n| %-12s | %-80s |","",sinopsis.get(i));
            }
            System.out.printf("%n%s%n",separador);
        }        
        
        System.out.println();
        readString("Datos consultados con éxito, pulse intro para continuar.");
        
    }
    
    public void directores() {
        
        clear();
        
        String menu = "%nDIRECTORES%n"
                + "%n1.- Altas%n"
                + "2.- Bajas%n"
                + "3.- Modificaciones%n"
                + "q.- Volver al menú inicial%n";
        
        boolean salir = false;
        
        String opcion;
        String[] availableOptions = {"1","2","3","q"};
         do{
            opcion = readString(menu, availableOptions).toLowerCase();
            switch(opcion){
                case "1":
                    this.altasDirectores();
                    break;
                case "2":
                    this.bajasDirectores();
                    break;
                case "3":
                    this.modificacionesDirectores();
                    break; 
                case"q":
                    salir = true;
                    break;
                default:
                    out.printf("%n%nOpción Incorrecta%n%n");
                    break;
            }
        }while(!salir);  
    }
    
    public void altasDirectores() {
        boolean encontrado = false;
        int numDirector;
        
        String director = readString_ne("Introduzca el nombre del director que desea dar de alta ( o q para salir): ");
        if("q".equals(director))
            return;
        encontrado = c.consultarDirectoresBoolean(director);
        
        while(encontrado == true){
            director = readString_ne("Director encontrado, introduzca otro director (o q para salir): ");
            if("q".equals(director))
                return;
            encontrado = c.consultarDirectoresBoolean(director);
        }        
        
        String[] respuesta = new String[2];
        int ano,mes,dia;
        ano = readInt("%nIntroduzca el año: ",1800,2100);
        mes = readInt("%nIntroduzca el mes: ",01,12);
        dia = readInt("%nIntroduzca el dia: ",01,31);
        LocalDate tmp = LocalDate.of(ano, mes, dia);
        respuesta[0] = readString_ne("%nIntroduzca la nacionalidad: ");
        respuesta[1] = readString_ne("%nIntroduzca la ocupación: ");
       
        List <String> peliculas = new ArrayList<>();
        String pelicula;
        
        for(int i = 0;;i++){
            pelicula = readString_ne("Introduzca la película a añadir (o q para terminar de añadir películas): ");
            if(pelicula.equals("q"))
                break;
            peliculas.add(pelicula);
        }
        
        c.altaDirectores(director,tmp,respuesta[0],respuesta[1],peliculas);
                
        System.out.println();
        readString("Director dado de alta con éxito, pulse intro para continuar.");
    }

    public void bajasDirectores() {
        String[] directores = new String[4];
        int numDirector;
        
        String director = readString_ne("Introduzca el nombre del director que desea dar de baja ( o q para salir): ");
        if("q".equals(director))
            return;
        directores = c.consultarDirectores(director);
        
        while(directores == null){
            director = readString_ne("Director no encontrado, introduzca otro director (o q para salir): ");
            if("q".equals(director))
                return;
            directores = c.consultarDirectores(director);
        }
            
        numDirector = Integer.parseInt(directores[4]);
        List <String> pelis = c.comprobarPeliculasDirector(numDirector);
        
        while(!pelis.isEmpty()){
            System.out.println("El director tiene películas dadas de alta :"+pelis);
            director = readString_ne("Introduzca otro director (o q para salir): ");
            if("q".equals(director))
                return;
            directores = c.consultarDirectores(director);
            while(directores == null){
            director = readString_ne("Director no encontrado, introduzca otro director (o q para salir): ");
            if("q".equals(director))
                return;
            directores = c.consultarDirectores(director);
            }
            numDirector = Integer.parseInt(directores[4]);
            pelis = c.comprobarPeliculasDirector(numDirector);
        }
        
        c.bajasDirectores(numDirector);
        
        System.out.println();
        readString("Director dado de baja con éxito, pulse intro para continuar.");
    }
    
    public void modificacionesDirectores() {
        String[] availableOptions = {"1","2","3","q"};
        String[] directores = new String[4];
        String opcion, respuesta;
        boolean valido = false;
        
        String director = readString_ne("Introduzca el nombre del director que desea modificar ( o q para salir): ");
        if("q".equals(director))
            return;
        directores = c.consultarDirectores(director);
        
        while(directores == null){
            director = readString_ne("Director no encontrado, introduzca otro director (o q para salir): ");
            if("q".equals(director))
                return;
            directores = c.consultarDirectores(director);
        }
        
        String separador = "----------------------------------------------------------------------------------------------------------";
        List <String> ocupacion = c.splitString(directores[3],80);
        String tmp;
        int size = ocupacion.size();
        int respuestaInt;
        int numDirector = Integer.parseInt(directores[4]);
        
        if(size == 0){
            tmp = "";
        } else{
            tmp = ocupacion.get(0);
        }
        
        System.out.printf("%n%s%n| %-19s | %-80s |%n%s%n| %-19s | %-80s |%n%s%n|"
                + " %-19s | %-80s |%n%s%n| %-19s | "
                ,separador,"Nombre",directores[0],separador,"Fecha de Nacimiento",directores[1],
                separador,"Nacionalidad", directores[2],separador,"Ocupación");
        
        System.out.printf("%-80s |%n", tmp);
        
        if(size < 2){
            System.out.printf("%s%n", separador);
        } else{
            for(int i = 1; i < size; i++){
            System.out.printf("| %-19s | %-80s |%n","",ocupacion.get(i));
            }
            System.out.printf("%s",separador);
        }        
        opcion = readString("%nEliga una opción:%n1-Fecha de nacimiento%n2-Nacionalidad%n3-Ocupación%nq-Salir%n", availableOptions);   
        
        switch(opcion){
            case "1":       int ano,mes,dia;
                            ano = readInt("%nIntroduzca la fecha de nacimiento%nIntroduzca el año: ",1800,2100);
                            mes = readInt("%nIntroduzca el mes: ",01,12);
                            dia = readInt("%nIntroduzca el dia: ",01,31);
                            LocalDate fechatmp = LocalDate.of(ano, mes, dia);
                            c.setFechaDeNacimientoDirector(fechatmp,numDirector);
                break;
            case "2":   
                        respuesta = readString_ne("%nIntroduzca la nacionalidad (o q para salir): ");
                        if(respuesta.equals("q"))
                            return;
                        c.setNacionalidadDirector(respuesta,numDirector);
                break;
            case "3":   
                        respuesta = readString_ne("%nIntroduzca la ocupación (o q para salir): "); 
                        if(respuesta.equals("q"))
                            return;
                        c.setOcupacionDirector(respuesta,numDirector);
                break;    
        }
        
        System.out.println();
        readString("Datos modificados con éxito, pulse intro para continuar.");
        
    }
    
    private void altasActores() {
        boolean encontrado = false;
        
        String actor = readString_ne("Introduzca el nombre del actor que desea dar de alta ( o q para salir): ");
        if("q".equals(actor))
            return;
        encontrado = c.consultarActoresBoolean(actor);
        
        while(encontrado == true){
            actor = readString_ne("Actor encontrado, introduzca otro actor (o q para salir): ");
            if("q".equals(actor))
            return;
            encontrado = c.consultarActoresBoolean(actor);
        }
        
        String respuesta;
        int respuestaInt;
        int ano,mes,dia;
        ano = readInt("%nIntroduzca la fecha de nacimiento%nIntroduzca el año: ",1800,2100);
        mes = readInt("%nIntroduzca el mes: ",01,12);
        dia = readInt("%nIntroduzca el dia: ",01,31);
        LocalDate tmp = LocalDate.of(ano, mes, dia);
        respuesta = readString_ne("%nIntroduzca la nacionalidad: ");
        respuestaInt = readInt("%nIntroduzca el año de debut: ",1800,2100);
        
        List <String> peliculas = new ArrayList<>();
        String pelicula;
        
        for(int i = 0;;i++){
            pelicula = readString_ne("Introduzca la película a añadir (o q para terminar de añadir películas): ");
            if(pelicula.equals("q"))
                break;
            peliculas.add(pelicula);
        }
        
        c.altaActores(actor,tmp,respuesta,respuestaInt,peliculas);        
                
        System.out.println();
        readString("Actor dado de alta con éxito, pulse intro para continuar.");   
        
    }

    private void bajasActores() {
        String[] actores = new String[4];
        int numActores;
        
        String actor = readString_ne("Introduzca el nombre del actor que desea dar de baja ( o q para salir): ");
        if("q".equals(actor))
            return;
        actores = c.consultarActores(actor);
        
        while(actores == null){
            actor = readString_ne("Actor no encontrado, introduzca otro actor (o q para salir): ");
            if("q".equals(actor))
                return;
            actores = c.consultarActores(actor);
        }
            
        numActores = Integer.parseInt(actores[4]);
        List <String> pelis = c.comprobarPeliculasActor(numActores);
        
        while(!pelis.isEmpty()){
            System.out.println("El actor tiene películas dadas de alta :"+pelis);
            actor = readString_ne("Introduzca otro actor (o q para salir): ");
            if("q".equals(actor))
                return;
            actores = c.consultarActores(actor);
            while(actores == null){
            actor = readString_ne("Actor no encontrado, introduzca otro actor (o q para salir): ");
            if("q".equals(actor))
                return;
            actores = c.consultarActores(actor);
            }
            numActores = Integer.parseInt(actores[4]);
            pelis = c.comprobarPeliculasActor(numActores);
        }
        
        c.bajasActores(numActores);
        
        System.out.println();
        readString("Actor dado de baja con éxito, pulse intro para continuar.");
        
    }

    private void modificacionesActores() {
        String[] actores = new String[4];
        
        String actor = readString_ne("Introduzca el nombre del actor que desea modificar ( o q para salir): ");
        if("q".equals(actor))
            return;
        actores = c.consultarActores(actor);
        
        while(actores == null){
            actor = readString_ne("Actor no encontrado, introduzca otro actor (o q para salir): ");
            if("q".equals(actor))
                return;
            actores = c.consultarActores(actor);
        }
        
        String separador = "--------------------------------------------------------------------------------------";
        String[] availableOptions = {"1","2","3","q"};
        String opcion, respuesta;
        int respuestaInt;
        boolean valido = false;
        
        int numActor = Integer.parseInt(actores[4]);
        
        System.out.printf("%n%s%n| %-19s | %-60s |%n%s%n| %-19s | %-60s |%n%s%n|"
                + " %-19s | %-60s |%n%s%n| %-19s | %-60s |%n%s%n"
                ,separador,"Nombre",actores[0],separador,"Fecha de Nacimiento",actores[1],
                separador,"Nacionalidad", actores[2],separador,"Año de Debut",actores[3],separador);
        
        opcion = readString("%nEliga una opción:%n1-Fecha de nacimiento%n2-Nacionalidad%n3-Año de debut%nq-Salir%n", availableOptions);   
        
        switch(opcion){
            case "1":   
                            int ano,mes,dia;
                            ano = readInt("%nIntroduzca la fecha de nacimiento%nIntroduzca el año: ",1800,2100);
                            mes = readInt("%nIntroduzca el mes: ",01,12);
                            dia = readInt("%nIntroduzca el dia: ",01,31);
                            LocalDate fechatmp = LocalDate.of(ano, mes, dia);
                            c.setFechaDeNacimientoActor(fechatmp,numActor);
                        
                break;
            case "2":   
                        respuesta = readString_ne("%nIntroduzca la nacionalidad (o q para salir): ");
                        if(respuesta.equals("q"))
                            return;
                        c.setNacionalidadActor(respuesta,numActor);
                break;
            case "3":   
                        respuestaInt = readInt("%nIntroduzca el año de debut: ",1800,2100);
                        c.setAnoDebutActor(respuestaInt,numActor);
                break;    
        }
        
        System.out.println();
        readString("Datos modificados con éxito, pulse intro para continuar.");
        
    }
    
    private void peliculasDeUnActor() {
        String[] actores = new String[4];
        int numActores;
        
        String actor = readString_ne("Introduzca el nombre del actor que desea consultar ( o q para salir): ");
        if("q".equals(actor))
            return;
        actores = c.consultarActores(actor);
        
        while(actores == null){
            actor = readString_ne("Actor no encontrado, introduzca otro actor (o q para salir): ");
            if("q".equals(actor))
                return;
            actores = c.consultarActores(actor);
        }
            
        numActores = Integer.parseInt(actores[4]);
        
        List <String> pelis = c.peliculasDeUnActor(numActores);
        int size = pelis.size();
        
        String separador = "--------------------------------------------------------------------------------------------------------------------------------------------";
        System.out.printf("%n%s%n| %-50s | %-4s | %-8s | %-42s | %-20s |%n%s%n",
                separador,"Título","Año","Duración","País","Género",separador);
        for (int i = 0; i < size; i = i+5){
        System.out.printf("| %-50s | %-4s | %-4smin  | %-42s | %-20s |%n%s%n",
                pelis.get(i), pelis.get(i+1), pelis.get(i+2),
                pelis.get(i+3), pelis.get(i+4),separador);
        }
    }

    private void verPeliculas() {        
        List <String> pelis = c.getPeliculasString();
        int size = pelis.size();
        
        String separador = "-----------------------------------------------------------------------------------------------------------------------------------";
        String titulo = "Título", ano = "Año", duracion = "Duración",
                pais = "País", genero = "Género";
        System.out.printf("%n%s%n| %-46s | %-4s | %-8s | %-42s | %-15s |%n%s%n",
                separador,titulo,ano,duracion,pais,genero,separador);
        for (int i = 0; i < size; i = i+5){
        System.out.printf("| %-46s | %-4s | %-4smin  | %-42s | %-15s |%n%s%n",
                pelis.get(i), pelis.get(i+1), pelis.get(i+2),
                pelis.get(i+3), pelis.get(i+4),separador);
        }
        
        System.out.println();
        readString("Datos visualizados con éxito, pulse intro para continuar.");
        
    }

    private void verDirectores() {        
        List <String> direc = c.getDirectoresString();
        int size = direc.size();
        
        String separador = "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
        String nombre = "Nombre", fechaDeNacimiento = "Fecha de Nacimiento",
                nacionalidad = "Nacionalidad", ocupacion = "Ocupación";
        System.out.printf("%n%s%n| %-30s | %-19s | %-42s | %-75s |%n%s%n",
                separador,nombre,fechaDeNacimiento,nacionalidad,ocupacion,separador);
        for (int i = 0; i < size; i = i+4){
        System.out.printf("| %-30s | %-19s | %-42s | %-75s |%n%s%n",
                direc.get(i), direc.get(i+1), direc.get(i+2),
                direc.get(i+3),separador);
        }
        
        System.out.println();
        readString("Datos visualizados con éxito, pulse intro para continuar.");
    }

    private void verActores() {
        List <String> actor = c.getActoresString();
        int size = actor.size();
        
        String separador = "-----------------------------------------------------------------------------------------------------------------";
        String nombre = "Nombre", fechaDeNacimiento = "Fecha de Nacimiento",
                nacionalidad = "Nacionalidad", anoDebut = "Año Debut";
        System.out.printf("%n%s%n| %-30s | %-19s | %-42s | %-9s |%n%s%n",
                separador,nombre,fechaDeNacimiento,nacionalidad,anoDebut,separador);
        for (int i = 0; i < size; i = i+4){
        System.out.printf("| %-30s | %-19s | %-42s | %-9s |%n%s%n",
                actor.get(i), actor.get(i+1), actor.get(i+2),
                actor.get(i+3),separador);
        }
        
        System.out.println();
        readString("Datos visualizados con éxito, pulse intro para continuar.");    }
}