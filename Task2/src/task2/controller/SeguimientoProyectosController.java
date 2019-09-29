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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import task2.model.Proyectodto;
import task2.model.Seguimientodto;
import task2.service.ProyectoService;
import task2.service.SeguimientoService;
import task2.util.AppContext;
import task2.util.FlowController;
import task2.util.Formato;
import task2.util.Mensaje;

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
    SeguimientoService ss;
    Proyectodto proyecto;
    ProyectoService ps;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tcId.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().id.toString()));
        tcFecha.setCellValueFactory(x-> x.getValue().fecha);
        tcDetalle.setCellValueFactory(x -> x.getValue().detalle);
        tcPorcentaje.setCellValueFactory(x-> x.getValue().porcentaje);
        
        seguimientos = FXCollections.observableArrayList();
        proyectos = FXCollections.observableArrayList();
        ss = new SeguimientoService();
        ps = new ProyectoService();
        
        cbProyecto.setConverter(new StringConverter<Proyectodto>() {
            @Override
            public String toString(Proyectodto object) {
                return object.getProNombre();
            }

            @Override
            public Proyectodto fromString(String string) {
                return null;
            }
    });
        
        tfPorcentajeAvance.setTextFormatter(Formato.getInstance().integerFormat());
        taDetalle.setTextFormatter(Formato.getInstance().letrasFormat(200));
        
    }    

    @Override
    public void initialize() {
        seg = new Seguimientodto();
        
        proyectos.clear();
        cbProyecto.getItems().clear();
        limpiar();
        
        //proyectos 
        proyectos.addAll(ps.getTodos()); //= (FXCollections.observableArrayList(ps.getTodos()));
        cbProyecto.getItems().addAll(proyectos);
        
        if(AppContext.getInstance().get("resSeguimiento") != null){
            seg = (Seguimientodto) AppContext.getInstance().get("resSeguimiento");
            proyecto = seg.getProyecto();
            cbProyecto.getSelectionModel().select(seg.getProyecto());
            seguimientos = (FXCollections.observableArrayList(ss.getSeguimientos(new Long(proyecto.proId.get()))));
            tblSeguimiento.setItems(seguimientos);
            AppContext.getInstance().set("resSeguimiento", null); 
        }
        
    }

    @FXML
    private void btnLimpiar(ActionEvent event) {
        limpiar();
    }

    @FXML
    private void btnGuardar(ActionEvent event) {
        if(taDetalle.getText().isEmpty() || dpFecha.getValue() == null || tfPorcentajeAvance.getText().isEmpty()){
            new Mensaje().show(Alert.AlertType.INFORMATION, "Guardar seguimiento", "Falta informacion");
        }else{
            if(proyecto.proId != null){
                seg.setDetalle(taDetalle.getText());
                seg.setFecha(dpFecha.getValue().toString());
                seg.setPorcentaje(tfPorcentajeAvance.getText());

                seg = ss.guardarSeguimiento(seg);
                if(seg == null){
                    new Mensaje().show(Alert.AlertType.INFORMATION, "Guardar seguimiento", "Ocurrio un error al guardar el seguimiento");
                }
            }else{
                new Mensaje().show(Alert.AlertType.INFORMATION, "Guardar seguimiento", "Primero debe seleccionar un proyecto");
            }
        }
    }

    @FXML
    private void btnEliminar(ActionEvent event) {
        if(seg.getId() == null){
            new Mensaje().show(Alert.AlertType.INFORMATION, "", "Primero debe seleccionar un seguimiento");
        }else{
            new Mensaje().show(Alert.AlertType.INFORMATION, "", ss.eliminarSeguimiento(seg.id));
            limpiar();
        }
    }
    
    
    private void limpiar(){
        
        tfPorcentajeAvance.clear();
        taDetalle.clear();
        dpFecha.setValue(null);
        
        cbProyecto.getSelectionModel().clearSelection();
        tblSeguimiento.getItems().clear();
        seg = new Seguimientodto();

    }

    @FXML
    private void btnAtras(ActionEvent event) {
        FlowController.getInstance().goView("Menu");
    }

    @FXML
    private void evtTblSeguimientos(MouseEvent event) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        if(tblSeguimiento.getSelectionModel().getSelectedItem() != null){
            seg = tblSeguimiento.getSelectionModel().getSelectedItem();
            tfPorcentajeAvance.setText(seg.getPorcentaje());
            taDetalle.setText(seg.getDetalle());
            dpFecha.setValue(LocalDate.parse(seg.getFecha(), formatter));
        }

    }

    @FXML
    private void evtCbProyectos(ActionEvent event) {
        if(cbProyecto.getSelectionModel().getSelectedItem() != null){
            proyecto = cbProyecto.getSelectionModel().getSelectedItem();
            seg.setProyecto(proyecto);
            seguimientos = (FXCollections.observableArrayList(ss.getSeguimientos(new Long(proyecto.proId.get()))));
            tblSeguimiento.setItems(seguimientos);
        }
    }
}
