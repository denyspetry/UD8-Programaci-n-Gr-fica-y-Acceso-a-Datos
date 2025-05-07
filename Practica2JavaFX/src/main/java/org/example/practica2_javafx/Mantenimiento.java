package org.example.practica2_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class Mantenimiento {

    public static Connection conectar(){
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3307/";
        String user = "root";
        String pass = "";
        String bd = "prueba";

        try {
            conexion = DriverManager.getConnection(host+bd, user, pass);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;

    }

    public static void desconectar(Connection conexion){
        try {
            conexion.close();
            System.out.println("Conexión finalizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<Estudiante> consultar(Connection conexion){

        ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();
        String query = "SELECT * FROM estudiantes";

        Statement stmt;
        ResultSet resultado;

        try {
            stmt = conexion.createStatement();
            resultado = stmt.executeQuery(query);

            while (resultado.next()){
                int nia = resultado.getInt("nia");
                String nombre = resultado.getString("nombre");
                LocalDate date = resultado.getDate("fecha_nacimiento").toLocalDate();

                listaEstudiantes.add(new Estudiante(nia, nombre, date));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return listaEstudiantes;

    }

    public static void insertar(Connection conexion, Estudiante estudiante){

        StringBuilder query = new StringBuilder();

        query.append("INSERT INTO estudiante (nia, nombre, fecha_nacimiento) VALUES ('");
        query.append(estudiante.getNia() + "'");
        query.append(", '" + estudiante.getNombre() + "'");
        query.append(", '" + estudiante.getDate() + "')");

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query.toString());
            System.out.println("--- FILA INSERTADA ---");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
