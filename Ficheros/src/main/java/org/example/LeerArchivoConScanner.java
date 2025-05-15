package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LeerArchivoConScanner {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            File archivo = new File("src/main/resources/datos_personas.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                System.out.println("Línea: " + linea);
            }

            lector.close();

            System.out.println("Introduce la palabra a buscar:");
            String palabraBuscar = teclado.next();

            int contador = contarPalabraScanner("src/main/resources/datos.txt", palabraBuscar);
            System.out.println("La palabra '" + palabraBuscar + "' aparece " + contador + " veces en el fichero.");

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
    }

    public static int contarPalabraScanner(String rutaArchivo, String palabra) throws FileNotFoundException {
        int contador = 0;
        File archivo = new File(rutaArchivo);

        try {
            Scanner lector = new Scanner(archivo);

            while (lector.hasNext()) {
                String linea = lector.nextLine();
                String[] palabras = linea.split(" ");

                for (String palabrita : palabras) {
                    if (palabrita.equalsIgnoreCase(palabra)) {
                        contador++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

        return contador;
    }
}
