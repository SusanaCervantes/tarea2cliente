/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import task2.model.Proyectodto;
import task2.model.Seguimientodto;
import task2.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Susana
 */
public class SeguimientoProyectosController extends Controller implements Initializable {

    @FXML
    private JFXComboBox<Proyectodto> cbProyecto;
    @FXML
    private TableView<Seguimientodto> tblSeguimiento;
    @FXML
    private TableColumn<Seguimientodto, String> tcId;
    @FXML
    private TableColumn<Seguimientodto, String> tcFecha;
    @FXML
    private TableColumn<Seguimientodto, String> tcDetalle;
    @FXML
    private TableColumn<Seguimientodto, String> tcPorcentaje;
    @FXML
    private JFXDatePicker dpFecha;
    @FXML
    private JFXTextArea taDetalle;
    @FXML
    private JFXTextField tfPorcentajeAvance;

    ObservableList<Seguimientodto> seguimientos;
    ObservableList<Proyectodto> proyectos;
    Seguimientodto seg;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tcId.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().id.toString()));
        tcFecha.setCellValueFactory(x-> x.getValue().fecha);
        tcDetalle.setCellValueFactory(x -> x.getValue().detalle);
        tcPorcentaje.setCellValueFactory(x-> x.getValue().porcentaje);
        
        seguimientos = FXCollections.observableArrayList();
        proyectos = FXCollections.observableArrayList();
    }    

    @Override
    public void initialize() {
        seg = new Seguimientodto();
        
        proyectos.clear();
        cbProyecto.getItems().clear();
        
        //proyectos 
        cbProyecto.getItems().addAll(proyectos);
    }

    @FXML
    private void btnLimpiar(ActionEvent event) {
        limpiar();
    }

    @FXML
    private void btnGuardar(ActionEvent event) {
    }

    @FXML
    private void btnEliminar(ActionEvent event) {
    }
    
    private void limpiar(){
        tfPorcentajeAvance.clear();
        taDetalle.clear();
        dpFecha.setValue(null);
        
        cbProyecto.getSelectionModel().clearSelection();
        tblSeguimiento.getItems().clear();
    }

    @FXML
    private void btnAtras(ActionEvent event) {
        FlowController.getInstance().goView("Menu");
    }
}
