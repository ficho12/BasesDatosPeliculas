/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.View;

/**
 *
 * @author fiz
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
         View v = new View();
        v.runMenu("%n1.- Archivos%n"
                + "2.- Películas%n"
                + "3.- Directores%n"
                + "4.- Actores%n"
                + "5.- Listados%n"
                + "q.- Salir%n");
    }
}
