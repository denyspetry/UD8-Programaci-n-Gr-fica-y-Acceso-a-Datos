package org.example.JSON.Videojuegos;

import java.util.ArrayList;
import java.util.List;

public class Videojuego {
    private String nombre;
    private String plataforma;
    private double precio;
    private boolean disponible;
    private List<String> listaGeneros;

    public Videojuego() {}

    public Videojuego(String nombre, String plataforma, double precio, boolean disponible, List<String> generos) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.precio = precio;
        this.disponible = disponible;
        this.listaGeneros = new ArrayList<>(generos);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<String> getListaGeneros() {
        return listaGeneros;
    }

    public void setListaGeneros(List<String> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "Nombre = '" + nombre + '\'' +
                ", Plataforma = '" + plataforma + '\'' +
                ", Precio = " + precio +
                ", Disponible = " + disponible +
                ", Géneros = " + listaGeneros +
                '}';
    }
}
