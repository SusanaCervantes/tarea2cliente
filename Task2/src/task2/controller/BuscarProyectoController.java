/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import task2.model.Administradordto;

/**
 * FXML Controller class
 *
 * @author IVAN
 */
public class BuscarProyectoController extends Controller implements Initializable {

    @FXML
    private BorderPane bp_bus_root;
    @FXML
    private JFXComboBox<Administradordto> cb_lider;
    @FXML
    private JFXButton btn_buscarLider;
    @FXML
    private JFXTextField tf_nombre;
    @FXML
    private JFXButton btn_buscar;
    @FXML
    private JFXButton btn_limpiar;
    @FXML
    private JFXButton btn_aceptar;
    @FXML
    private TableView<?> tv_lideres;
    @FXML
    private TableColumn<?, ?> col_Cedula;
    @FXML
    private TableColumn<?, ?> col_Apellidos;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @Override
    public void initialize() {
        
    }

    @FXML
    private void accionBuscarLider(ActionEvent event) {
    }

    @FXML
    private void accionBuscar(ActionEvent event) {
    }

    @FXML
    private void accionLimpiar(ActionEvent event) {
    }

    @FXML
    private void accionAceptar(ActionEvent event) {
    }

    @FXML
    private void accionTabla(MouseEvent event) {
    }

}