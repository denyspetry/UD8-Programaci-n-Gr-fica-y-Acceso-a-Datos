package org.example.practica2_javafx;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

public class HelloController {

    @FXML
    private TableView<Estudiante> tablaEstudiante;

    @FXML
    private TableColumn<Estudiante, Integer> niaTableview;

    @FXML
    private TableColumn<Estudiante, String> nombreTableview;

    @FXML
    private TableColumn<Estudiante, LocalDate> fechaTableview;

    @FXML
    private TextField niaTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button addButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button borrarDisable;

    @FXML
    private Button guardarButton;

    ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    Connection bd;
    //siempre el controlador tiene que initializarse
    @FXML
    public void initialize(){
        bd = Mantenimiento.conectar();
        niaTableview.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getNia()).asObject());
        nombreTableview.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        fechaTableview.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getDate()));

        tablaEstudiante.setItems(Mantenimiento.consultar(bd));
    }

    @FXML
    protected void onAnyadirEstudiante() {
        int nia = Integer.parseInt(niaTextField.getText());
        String nombre = nombreTextField.getText();
        LocalDate fecha = datePicker.getValue();

        Estudiante estudiante = new Estudiante(nia, nombre, fecha);

        Mantenimiento.insertar(bd, estudiante);

        niaTextField.clear();
        nombreTextField.clear();
        datePicker.setValue(null);

        tablaEstudiante.setItems(Mantenimiento.consultar(bd));

    }

    public void onEditarButton(ActionEvent actionEvent) {

        addButton.setDisable(true);
        guardarButton.setDisable(false);

        Estudiante estudiante = tablaEstudiante.getSelectionModel().getSelectedItem();
    }

    public void onBorrarButton(ActionEvent actionEvent) {
    }

    public void onGuardarButton(ActionEvent actionEvent) {
    }
}