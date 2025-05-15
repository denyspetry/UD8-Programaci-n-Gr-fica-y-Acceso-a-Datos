package org.example;

import java.io.*;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        File rutaArchivo1 = new File("src/main/resources/Denys/archivo1.txt");
        File rutaArchivo2 = new File("src/main/resources/Denys/archivo2.txt");
        File rutaArchivoCombinado = new File("src/main/resources/Denys/archivoCombinado.txt");

        combinarArchivos(rutaArchivo1, rutaArchivo2, rutaArchivoCombinado);
    }

    public static void combinarArchivos(File archivo1, File archivo2, File archivoCombinado) {
        try {
            Scanner lector1 = new Scanner(archivo1);
            Scanner lector2 = new Scanner(archivo2);
            PrintWriter escritor = new PrintWriter(new FileWriter(archivoCombinado));

            while (lector1.hasNext() || lector2.hasNext()) {
                if (lector1.hasNext()) {
                    escritor.print(lector1.next() + " ");
                }
                if (lector2.hasNext()) {
                    escritor.print(lector2.next() + " ");
                }
            }
            lector1.close();
            lector2.close();
            escritor.close();
            System.out.println("Archivos combinados!!!");
            System.out.println("Ruta del archivo combinado: " + archivoCombinado.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error inesperado durante la combinación.");
            e.printStackTrace();
        }
    }
}
