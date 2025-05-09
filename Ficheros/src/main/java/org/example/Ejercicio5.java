package org.example;

import java.io.File;

public class Ejercicio5 {
    public static void main(String[] args) {
        File carpeta = new File("src/main/resources");

        String ficheros[] = carpeta.list();

        if (ficheros != null && ficheros.length > 0){
            for (String fichero : ficheros){
                if (!fichero.endsWith(".txt")){
                    System.out.println("No se han encontrado archivos .txt");
                } else {
                    System.out.println(fichero);
                }
            }
        } else {
            System.out.println("El directorio está vacío.");
        }
    }
}
