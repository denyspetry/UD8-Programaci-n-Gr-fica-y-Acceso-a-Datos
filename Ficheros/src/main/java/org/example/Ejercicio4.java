package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Cuántos ficheros quieres?: ");
        int num = teclado.nextInt();
        System.out.println("¿En qué carpeta lo quieres?: ");
        teclado.nextLine();
        String carpeta = teclado.next();

        File comprobar_carpeta = new File(carpeta);
        if (comprobar_carpeta.exists()){
            for (int i = 1; i <= num; i++) {
                File fichero = new File(carpeta + "/nombre(" + i + ").txt");
                try {
                    fichero.createNewFile();
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
