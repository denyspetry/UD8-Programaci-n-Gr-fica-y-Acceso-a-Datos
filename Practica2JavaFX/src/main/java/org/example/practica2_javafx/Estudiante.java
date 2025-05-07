package org.example.practica2_javafx;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Estudiante {
    private int nia;
    private String nombre;
    private LocalDate date;
}
