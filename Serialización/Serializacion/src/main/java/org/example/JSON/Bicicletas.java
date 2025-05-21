package org.example.JSON;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Bicicletas {
    private String marca;
    private String modelo;
    private double precio;
    private List<String> corredores;

    public Bicicletas(){

    }

    public Bicicletas(String marca, String modelo, double precio, List<String> corredores){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.corredores = new ArrayList<>(corredores);
    }
}
