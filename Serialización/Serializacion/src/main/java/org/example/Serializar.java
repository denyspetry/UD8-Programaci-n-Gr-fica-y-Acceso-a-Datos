package org.example;

import java.io.*;
import java.sql.Date;

public class Serializar {

    public static void main(String[] args) {

        Festival fest = new Festival("RBF", new Date(2025-8-7),12000, "Alicante");

        //serializar
        try {
            ObjectOutputStream objeto_serializado = new ObjectOutputStream(new FileOutputStream("src/main/resources/festival.ser"));
            objeto_serializado.writeObject(fest);
            objeto_serializado.close();
        } catch (IOException e) {
            System.out.println("Ups. Algo ha salido mal.");
            e.printStackTrace();
        }

        System.out.println("Objeto serializado en festival.ser");

        //deserializar
        try {
            ObjectInputStream leer_obg = new ObjectInputStream(new FileInputStream("src/main/resources/festival.ser"));
            Festival festival_leer = (Festival) leer_obg.readObject();
            leer_obg.close();
            System.out.println("Nombre del Festival: " + festival_leer.getNombre() + ", fecha " + festival_leer.getFecha() + ". Aforo: " + festival_leer.getAforo());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ups. Algo ha salido mal.");
            e.printStackTrace();
        }
    }

}
