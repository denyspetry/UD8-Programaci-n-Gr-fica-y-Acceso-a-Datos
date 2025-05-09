package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File fichero = new File("src/main/resources/prueba.txt");

        try {
            fichero.createNewFile();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        System.out.println("Tamaño del fichero: " + fichero.length());
        System.out.println("Ruta del fichero: " + fichero.getAbsolutePath());

        File carpeta = new File("src/main/resources/Denys");

        carpeta.mkdir();

        if (carpeta.exists()){
            System.out.println("La carpeta " + carpeta.getName() + " existe");
        } else {
            System.out.println("La carpeta " + carpeta.getName() + " no existe");
        }

        fichero.delete();

        if(fichero.exists()){
            System.out.println(fichero.getName() + " existe");
        } else {
            System.out.println(fichero.getName() + " no existe");
        }
    }
}