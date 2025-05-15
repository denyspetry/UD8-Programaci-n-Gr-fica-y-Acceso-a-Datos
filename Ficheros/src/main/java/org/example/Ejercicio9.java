package org.example;

import java.io.*;

public class Ejercicio9 {
    public static void main(String[] args) {
        String rutaArchivo = "src/main/resources/prueba_escribir.txt";
        convertirPrimeraLetraMayuscula(rutaArchivo);
    }

    public static void convertirPrimeraLetraMayuscula(String rutaArchivo) {
        // Crear objetos File para el archivo original y el temporal
        File archivo = new File(rutaArchivo);
        File archivoTemp = new File(rutaArchivo + ".temp");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemp));

            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split(" ");

                for (int i = 0; i < palabras.length; i++) {
                    if (!palabras[i].isEmpty()) {
                        palabras[i] = Character.toUpperCase(palabras[i].charAt(0)) +
                                palabras[i].substring(1);
                    }
                    writer.write(palabras[i]);
                    // Añadir espacio entre palabras menos la última
                    if (i < palabras.length - 1) {
                        writer.write(" ");
                    }
                }
                // Salto de línea
                writer.newLine();
            }
            reader.close();
            writer.close();

            if (archivo.delete()) {
                archivoTemp.renameTo(archivo);
                System.out.println("Archivo modificado");
            } else {
                System.out.println("No se ha podido reemplazar el archivo original");
            }

        } catch (IOException e) {
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }
    }
}
