package org.example.Practica2JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.demo.Estudiante;

import java.time.LocalDate;

public class HelloController {
    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    @FXML
    private TableColumn<Estudiante, Integer> niacolumn;

    @FXML
    private TableColumn<Estudiante, String> nombrecolumn;

    @FXML
    private TableColumn<Estudiante, LocalDate> fechacolumn;

    @FXML
    private TextField NIATEXTFIELD;

    @FXML
    private TextField NOMBRETEXTFIELD;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Button anyadirboton;

    @FXML
    public void initialize(){

    }

    @FXML
    protected void onAnyadirButtonClick() {

    }
}