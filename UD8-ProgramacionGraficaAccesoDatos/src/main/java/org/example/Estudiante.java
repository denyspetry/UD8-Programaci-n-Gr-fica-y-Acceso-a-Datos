package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;

@Getter
@AllArgsConstructor
@ToString
public class Estudiante {
    private int nia;
    private String nombre;
    private Date fecha_nacimiento;
}
