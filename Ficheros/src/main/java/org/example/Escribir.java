package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir {

    public static void main(String[] args) {

        try {

            BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/resources/prueba_escribir.txt"));
            escritor.write("Hola, mundo!");
            escritor.newLine();
            escritor.write("Esto se guarda en el archivo.");

            escritor.close();

        } catch (IOException e) {
            System.out.println("Ha habido algún problema.");
            e.printStackTrace();
        }

    }

}
