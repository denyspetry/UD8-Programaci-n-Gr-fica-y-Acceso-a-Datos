package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@Data
public class Festival implements Serializable {

    private String nombre;
    private Date fecha;
    private transient int aforo;
    private String lugar;

}
