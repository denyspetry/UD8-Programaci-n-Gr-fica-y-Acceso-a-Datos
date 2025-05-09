package org.example;

import java.io.File;

public class Listar {
    public static void main(String[] args) {
        File carpeta = new File("src/main/resources");

        //1ª OPCIÓN LISTAR SÓLO NOMBRES
        String ficheros[] = carpeta.list();

        if (ficheros != null && ficheros.length > 0){
            for (String fichero : ficheros){
                System.out.println(fichero);
            }
        } else {
            System.out.println("El directorio está vacío.");
        }

        //2ª OPCIÓN LISTAR OBJETOS DE TIPO FILE
        File listaFicheros[] = carpeta.listFiles();

        if (listaFicheros != null && listaFicheros.length > 0){
            for (File fichero : listaFicheros){
                if (fichero.isFile()) {
                    System.out.println("Fichero con nombre " + fichero.getName() + " con tamaño " + fichero.length() + " bytes.");
                }
            }
        } else {
            System.out.println("El directorio está vacío.");
        }
    }
}
