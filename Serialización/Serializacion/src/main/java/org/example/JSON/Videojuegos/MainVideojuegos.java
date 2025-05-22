package org.example.JSON.Videojuegos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainVideojuegos {
    public static void main(String[] args) {
        System.out.println("** BIENVENIDO AL SISTEMA DE GESTIÓN DE VIDEOJUEGOS **\n");
        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Creación de videojuegos
        System.out.println("Creando videojuegos...");
        Videojuego videojuego1 = new Videojuego("Minecraft", "PC", 19.99, true, Arrays.asList("Aventura", "Construcción", "Mundo abierto"));
        Videojuego videojuego2 = new Videojuego("Fortnite", "PS5", 0.00, true, Arrays.asList("Shooter", "Construcción", "Acción"));
        Videojuego videojuego3 = new Videojuego("FIFA 28", "XBOX", 69.69, true, Arrays.asList("Deporte", "Multijugador", "Fútbol"));

        listaVideojuegos.add(videojuego1);
        listaVideojuegos.add(videojuego2);
        listaVideojuegos.add(videojuego3);

        System.out.println("Videojuegos creados: " + listaVideojuegos + "\n");

        // Guardar videojuegos en archivo JSON
        System.out.println("Guardando listaVideojuegos en archivo JSON...");

        try (FileWriter archivo = new FileWriter("src/main/resources/videojuegos.json")) {
            gson.toJson(listaVideojuegos, archivo);
            System.out.println("listaVideojuegos guardada en 'videojuegos.json'\n");
        } catch (IOException e) {
            System.out.println("Algo muy malo ha pasado y no sé el qué.");
            e.printStackTrace();
        }

        // Leer el archivo JSON y mostrarlo por pantalla
        System.out.println("Leyendo videojuegos.json ...");
        String json_lista = gson.toJson(listaVideojuegos);
        System.out.println("Lista de videojuegos:");
        System.out.println(json_lista);

        // Reconstruir la colección de Objetos a partir del archivo guardado
        ArrayList<Videojuego> videojuegosCargados = null;
        try {
            FileReader objeto_leido = new FileReader("src/main/resources/videojuegos.json");
            Videojuego[] videojuegosVector = gson.fromJson(objeto_leido, Videojuego[].class);
            videojuegosCargados = new ArrayList<>(Arrays.asList(videojuegosVector));

            System.out.println("\nVideojuegos cargados desde videojuegos.json:");
            for (Videojuego videojuego : videojuegosCargados) {
                System.out.println(videojuego);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Algo malo ha pasado, creo que no se ha encontrado el archivo.");
            e.printStackTrace();
        }

        // Añadir un videojuego nuevo a la colección
        System.out.println("\nAñadiendo un nuevo videojuego a la lista...");

        Videojuego videojuego4 = new Videojuego("Cyberpunk 2077", "Xbox", 39.99, false, Arrays.asList("RPG", "Acción"));
        videojuegosCargados.add(videojuego4);
        System.out.println(videojuego4 + "\n");

        // Mostrar en consola los videojuegos cuyo precio sea menor a 30€
        System.out.println("Videojuegos con precio menor a 30€:");
        for (Videojuego videojuego : videojuegosCargados) {
            if (videojuego.getPrecio() < 30) {
                System.out.println(videojuego);
            }
        }

        // Volver a guardar la lista actualizada en el archivo JSON
        System.out.println("\nVolviendo a guardar la lista actualizada en JSON...");

        try (FileWriter archivo2 = new FileWriter("src/main/resources/videojuegos.json")) {
            gson.toJson(videojuegosCargados, archivo2);
            System.out.println("videojuegos.json actualizado correctamente!\n");
        } catch (IOException e) {
            System.out.println("Algo ha ido mal...");
            e.printStackTrace();
        }

        String json_lista_actualizada = gson.toJson(videojuegosCargados);
        System.out.println("Lista de videojuegos actualizada:");
        System.out.println(json_lista_actualizada);
    }
}
