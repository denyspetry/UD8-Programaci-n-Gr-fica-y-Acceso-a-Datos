package org.example.Practica2JavaFX;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.Practica2JavaFX.Estudiante;
import org.mariadb.jdbc.Connection;

import java.time.LocalDate;

public class HelloController {
    Connection conexion;

    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    @FXML
    private TableColumn<Estudiante, Integer> niaTableView;

    @FXML
    private TableColumn<Estudiante, String> nombreTableView;

    @FXML
    private TableColumn<Estudiante, LocalDate> fechaTableView;

    @FXML
    private TextField niaTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private DatePicker fechaDatePicker;

    @FXML
    private Button anyadirBoton;

    public void onEditarButtonClick(ActionEvent actionEvent){
        anyadirBoton.setDisable(true);
    }

    ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        conexion = (Connection) Mantenimiento.conectar();

        niaTableView.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getNia()).asObject());
        nombreTableView.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        fechaTableView.setCellValueFactory(data ->
                new ReadOnlyObjectWrapper<>(data.getValue().getFecha_nacimiento())
        );

        tablaEstudiantes.setItems(Mantenimiento.consultar(conexion));
    }

    @FXML
    protected void onAnyadirButtonClick() {
        int nia = Integer.parseInt(niaTextField.getText());
        String nombre = nombreTextField.getText();
        LocalDate fecha_nacimiento = fechaDatePicker.getValue();

        Estudiante estudiante = new Estudiante(nia, nombre, fecha_nacimiento);

        Mantenimiento.insertar(conexion, estudiante);

        niaTextField.clear();
        nombreTextField.clear();
        fechaDatePicker.setValue(null);

        tablaEstudiantes.setItems(Mantenimiento.consultar(conexion));
    }
}