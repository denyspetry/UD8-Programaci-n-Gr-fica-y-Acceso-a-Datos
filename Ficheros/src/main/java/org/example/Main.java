package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File fichero = new File("src/main/resources/ejemplo1.txt");

        if(fichero.exists()){
            System.out.println("El fichero " + fichero.getName() + " existe");
        } else {
            System.out.println("El fichero " + fichero.getName() + " no existe");
        }

        try {
            fichero.createNewFile();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        System.out.println("Nombre del fichero: " + fichero.getName());
        System.out.println("Tamaño del fichero: " + fichero.length());
        System.out.println("Ruta del fichero: " + fichero.getAbsolutePath());

        File carpeta = new File("src/main/resources/Denys");

        carpeta.mkdir();

        if (carpeta.exists()){
            System.out.println("La carpeta " + carpeta.getName() + " existe");
        } else {
            System.out.println("La carpeta " + carpeta.getName() + " no existe");
        }

    }
}