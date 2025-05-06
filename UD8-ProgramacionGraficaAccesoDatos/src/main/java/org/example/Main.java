package org.example;

import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Connection bd = conexion();
        System.out.println("Realizando consultas...");
        consulta_a_lista(bd);
        desconectar(bd);
    }

    public static Connection conexion(){
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3307/";
        String user = "root";
        String psw = "";
        String bd = "prueba";
        System.out.println("Conectando...");

        try{
            conexion = (Connection) DriverManager.getConnection(host+bd, user, psw);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return conexion;
    }

    public static void desconectar(Connection conexion){
        System.out.println("Desconectando...");

        try{
            conexion.close();
            System.out.println("Conexión finalizada.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void consulta (Connection conexion){
        String query = "SELECT * FROM estudiantes";

        Statement stmt;
        ResultSet respuesta;

        try{
            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while (respuesta.next()){
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                Date fecha_nacimiento = respuesta.getDate("fecha_nacimiento");
                System.out.println("NIA: " + nia + " - Nombre: " + nombre + " - Fecha de nacimiento: " + fecha_nacimiento);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void insertar(Connection conexion){
        String query = "INSERT INTO estudiantes (nia, nombre, fecha_nacimiento) VALUES (43214321, 'Patricia', '1990-04-19')";
        Statement stmt;

        try{
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void modificar(Connection conexion){
        System.out.println("Modificando...");
        String query = "UPDATE estudiantes SET nombre = 'Patri' WHERE nombre = 'Patricia'";
        Statement stmt;

        try{
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void borrar(Connection conexion){
        System.out.println("Borrando...");
        String query = "DELETE FROM estudiantes WHERE nombre = 'Patri'";
        Statement stmt;

        try{
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void consulta_a_lista (Connection conexion){
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

        String query = "SELECT * FROM estudiantes";

        Statement stmt;
        ResultSet respuesta;

        try{
            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while (respuesta.next()){
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                Date fecha_nacimiento = respuesta.getDate("fecha_nacimiento");
                listaEstudiantes.add(new Estudiante(nia,nombre,fecha_nacimiento));
            }

            System.out.println(listaEstudiantes);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
