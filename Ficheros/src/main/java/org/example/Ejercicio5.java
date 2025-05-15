package org.example;

import java.io.File;
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce la ruta de la carpeta: ");
        File carpeta = new File(teclado.nextLine());

        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("La ruta indicada no es válida o no es una carpeta.");
            return;
        }

        mostrarArchivosTxt(carpeta);
        listarPorExtension(teclado, carpeta);
    }

    public static void mostrarArchivosTxt(File carpeta) {
        String[] ficheros = carpeta.list();
        boolean existeTxt = false;

        if (ficheros != null && ficheros.length > 0) {
            for (String nombre : ficheros) {
                File fichero = new File(carpeta, nombre);
                if (fichero.isFile() && nombre.toLowerCase().endsWith(".txt")) {
                    System.out.println("El fichero " + nombre + " tiene un tamaño de " + fichero.length() + " bytes.");
                    existeTxt = true;
                }
            }
            if (!existeTxt) {
                System.out.println("No hay archivos .txt en la carpeta.");
            }
        } else {
            System.out.println("El directorio está vacío o no se puede acceder.");
        }
    }

    public static void listarPorExtension(Scanner teclado, File carpeta) {
        System.out.print("¿Qué extensión de archivo deseas listar (sin punto)?: ");
        String extension = teclado.next().toLowerCase();

        File[] ficheros = carpeta.listFiles();
        boolean existeExtension = false;

        if (ficheros != null && ficheros.length > 0) {
            for (File fichero : ficheros) {
                if (fichero.isFile() && fichero.getName().toLowerCase().endsWith("." + extension)) {
                    System.out.println(fichero.getName() + " tiene un tamaño de " + fichero.length() + " bytes.");
                    existeExtension = true;
                }
            }
            if (!existeExtension) {
                System.out.println("No se encontraron archivos con la extensión ." + extension);
            }
        } else {
            System.out.println("El directorio no contiene archivos.");
        }
    }
}
