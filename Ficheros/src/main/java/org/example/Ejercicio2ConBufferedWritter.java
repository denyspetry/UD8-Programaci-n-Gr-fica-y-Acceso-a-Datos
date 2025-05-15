package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2ConBufferedWritter {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Cuántos ficheros quieres?: ");
        int num = teclado.nextInt();

        System.out.println("¿En qué carpeta lo quieres?: ");
        teclado.nextLine();  // Limpiar el buffer
        String carpeta = teclado.next();

        File comprobar_carpeta = new File(carpeta);

        if (comprobar_carpeta.exists()) {
            for (int i = 1; i <= num; i++) {
                File fichero = new File(carpeta + "/nombre" + i + ".txt");

                try {
                    fichero.createNewFile();
                    FileWriter escritor = new FileWriter(fichero);
                    escritor.write("Este es el fichero nombre" + i + ".txt");
                    escritor.close();
                    System.out.println("Fichero " + fichero.getName() + " creado.");

                } catch (IOException e) {
                    System.out.println("Algo ha ido mal.");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("La ruta no existe");
        }
    }
}
