package org.example.Practica2JavaFX;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class Estudiante {

    private int nia;
    private String nombre;
    private LocalDate fecha_nacimiento;

}
