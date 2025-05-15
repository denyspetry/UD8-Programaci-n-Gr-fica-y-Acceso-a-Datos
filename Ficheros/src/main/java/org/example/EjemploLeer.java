package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjemploLeer {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/datos.txt"));
            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            lector.close();

            System.out.println("Introduce la palabra a buscar:");
            String palabraBuscar = teclado.next();

            int contador = contarPalabra("src/main/resources/datos.txt", palabraBuscar);
            System.out.println("La palabra '" + palabraBuscar + "' aparece " + contador + " veces en el fichero.");

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }

    }

    public static int contarPalabra(String rutaArchivo, String palabra){
        int contador = 0;

        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] palabras = linea.split(" ");

                for (String palabrita : palabras) {
                    if (palabrita.equalsIgnoreCase(palabra)) {
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e);
        }
        return contador;
    }

}
