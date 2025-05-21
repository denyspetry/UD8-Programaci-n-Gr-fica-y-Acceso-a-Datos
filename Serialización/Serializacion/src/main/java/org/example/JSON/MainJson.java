package org.example.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainJson {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Bicicletas bici = new Bicicletas("ORBEA", "ABC", 1000, Arrays.asList("David, Mario, Patricia"));

        String json = gson.toJson(bici);
        System.out.println(json);

        try (FileWriter archivo = new FileWriter("src/main/resources/bicicleta.json")) {
            gson.toJson(bici, archivo);
        } catch (IOException e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }

        Bicicletas bici2 = gson.fromJson(json, Bicicletas.class);
        System.out.println(bici2.getMarca() + " " + bici2.getModelo() + " " + bici2.getPrecio() + " " + bici2.getCorredores());

        try {
            FileReader objeto_leido = new FileReader("src/main/resources/bicicleta.json");
            Bicicletas bici3 = gson.fromJson(objeto_leido, Bicicletas.class);
            System.out.println(bici3.getMarca() + " " + bici3.getModelo() + " " + bici3.getPrecio() + " " + bici3.getCorredores());
        } catch (FileNotFoundException e) {
            System.out.println("Algo ha ido mal");
            e.printStackTrace();
        }

        ArrayList<Bicicletas> bicicletas = new ArrayList<>();
        bicicletas.add(new Bicicletas("ORBEA", "ABC", 1000, Arrays.asList("David, Mario, Patricia")));
        bicicletas.add(new Bicicletas("TREK", "DEF", 1500, Arrays.asList("César, Iván")));
        bicicletas.add(new Bicicletas("SPECIALIZED", "KJFLM", 3000, Arrays.asList("David, Mauro, Denys")));

        String json_lista = gson.toJson(bicicletas);
        System.out.println(json_lista);

        

    }
}
