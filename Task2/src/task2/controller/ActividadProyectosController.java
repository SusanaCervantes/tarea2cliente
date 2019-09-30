/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import task2.model.Actividaddto;
import task2.model.Administradordto;
import task2.model.Proyectodto;
import task2.service.ActividadService;
import task2.service.ProyectoService;
import task2.util.AppContext;
import task2.util.Correo;
import task2.util.FlowController;
import task2.util.Formato;
import task2.util.Mensaje;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ActividadProyectosController extends Controller implements Initializable {

    @FXML
    private JFXButton btnAtras;
    @FXML
    private JFXComboBox<Proyectodto> cbxProyecto;
    @FXML
    private JFXTextField txtNombreAct;
    @FXML
    private JFXTextField txtEncargado;
    @FXML
    private JFXComboBox<String> cbxEstado;
    @FXML
    private JFXTextArea txtDetalle;
    @FXML
    private JFXDatePicker dIPlan;
    @FXML
    private JFXDatePicker dFPlan;
    @FXML
    private JFXDatePicker dIReal;
    @FXML
    private JFXDatePicker dFReal;
    @FXML
    private TableView<Actividaddto> tvActividades;
    @FXML
    private TableColumn<Actividaddto, String> tcNombre;
    @FXML
    private TableColumn<Actividaddto, String> tcEncargado;
    @FXML
    private TableColumn<Actividaddto, String> tcDescripcion;
    
    ObservableList<Proyectodto> proyectos;
    Proyectodto proyecto;
    Administradordto adm = new Administradordto();
    
    ObservableList<Actividaddto> actividades;
    Actividaddto act;
    ActividadService as;
    @FXML
    private JFXTextField txtOrden;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcNombre.setCellValueFactory(x -> x.getValue().nombre);
        tcEncargado.setCellValueFactory(x-> x.getValue().encargado);
        tcDescripcion.setCellValueFactory(x -> x.getValue().descripcion);
        
        txtDetalle.setTextFormatter(Formato.getInstance().letrasFormat(200));
        
        actividades = FXCollections.observableArrayList();
        proyectos = FXCollections.observableArrayList();
        as = new ActividadService();
        
        ArrayList<String> liscbxE = new ArrayList<String>();
        liscbxE.add("Planificada");
        liscbxE.add("En curso");
        liscbxE.add("Postergada");
        liscbxE.add("Finalizada");
        ObservableList<String> lis=FXCollections.observableArrayList(liscbxE);
        cbxEstado.setItems(lis);
        
        cbxProyecto.setConverter(new StringConverter<Proyectodto>() {
            @Override
            public String toString(Proyectodto object) {
                return object.getProNombre();
            }

            @Override
            public Proyectodto fromString(String string) {
                return null;
            }
    });
        
    }    

    @FXML
    private void actAtras(ActionEvent event) {
         FlowController.getInstance().goView("Menu");
    }

    @FXML
    private void evtCbProyectos(MouseEvent event) {
        if(cbxProyecto.getSelectionModel().getSelectedItem() != null){
            proyecto = cbxProyecto.getSelectionModel().getSelectedItem();
            act.setPro(proyecto);
            
            actividades = (FXCollections.observableArrayList(as.getActividades(new Long(proyecto.proId.get()))));
            tvActividades.setItems(actividades);
        }
    }

   
    private String estado;
    @FXML
    private void actEstado(ActionEvent event) {
        String e=cbxEstado.getValue();    
        if (e.equals("Planificada")){
            estado="1";
        }
        if (e.equals("En curso")){
            estado="2";
        }
        if (e.equals("Postergada")){
            estado="3";
        }
        if (e.equals("Finalizada")){
            estado="4";
        }
    }
    
    public String conEstado(String e){  
        if (e.equals("1")){
            return "Planificada";
        }
        if (e.equals("2")){
            return "En curso";
        }
        if (e.equals("3")){
            return "Postergada";
        }
        if (e.equals("4")){
            return "Finalizada";
        }
        return null;
    }

    @FXML
    private void actIPlan(ActionEvent event) {
    }

    @FXML
    private void actFPlan(ActionEvent event) {
    }

    @FXML
    private void actIReal(ActionEvent event) {
    }

    @FXML
    private void actFReal(ActionEvent event) {
    }

    public void limpiar(){
        txtNombreAct.clear();
        txtEncargado.clear();
        txtDetalle.clear();
        dIPlan.setValue(null);
        dFPlan.setValue(null);
        dIReal.setValue(null);
        dFReal.setValue(null); 
    }
    
    @FXML
    private void btnLimpiar(ActionEvent event) {
        limpiar();
    }

    @FXML
    private void btnGuardar(ActionEvent event) {
        if(txtDetalle.getText().isEmpty() || dIPlan.getValue() == null || dFPlan.getValue() == null || txtNombreAct.getText().isEmpty() || txtEncargado.getText().isEmpty() || estado.isEmpty()){
            new Mensaje().show(Alert.AlertType.INFORMATION, "Guardar actividad", "Falta informacion");
        }else{
            if(proyecto.proId != null){
                act.setNombre(txtNombreAct.getText());
                act.setDescripcion(txtDetalle.getText());
                act.setEncargado(txtEncargado.getText());
                act.setEstado(estado);
                act.setFpfinal(dFPlan.getValue().toString());
                act.setFpinicio(dIPlan.getValue().toString());
                act.setFrfinal(dFReal.getValue().toString());
                act.setFrinicio(dIReal.getValue().toString());
                act.setOrden(Long.parseLong(txtOrden.getText()));
                act.setPro(proyecto);

                act = as.guardarActividad(act);
                if(act == null){
                    new Mensaje().show(Alert.AlertType.INFORMATION, "Guardar actividad", "Ocurrio un error al guardar la actividad");
                }
            }else{
                new Mensaje().show(Alert.AlertType.INFORMATION, "Guardar actividad", "Primero debe seleccionar un proyecto");
            }
        }
        
    }

    @FXML
    private void btnEliminar(ActionEvent event) {
        if(act.getId() == null){
            new Mensaje().show(Alert.AlertType.INFORMATION, "", "Primero debe seleccionar una actividad");
        }else{
            new Mensaje().show(Alert.AlertType.INFORMATION, "", as.eliminarAct(act.id));
            limpiar();
        }
    }

    @FXML
    private void actTable(MouseEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        if(tvActividades.getSelectionModel().getSelectedItem() != null){
            act = tvActividades.getSelectionModel().getSelectedItem();
            txtNombreAct.setText(act.getNombre().get());
            txtEncargado.setText(act.getEncargado().get());
            txtDetalle.setText(act.getDescripcion().get());
            txtOrden.setText(act.getOrden().toString());
            cbxEstado.setValue(conEstado(act.getEstado().get()));
            dIPlan.setValue(LocalDate.parse(act.getFpinicio().get(), formatter));
            dFPlan.setValue(LocalDate.parse(act.getFpfinal().get(), formatter));
            dIReal.setValue(LocalDate.parse(act.getFrinicio().get(), formatter));
            dFReal.setValue(LocalDate.parse(act.getFrfinal().get(), formatter)); 
            
        }
    }

    @Override
    public void initialize() {
        proyectos.clear();
        ProyectoService ps = new ProyectoService();
        proyectos = (FXCollections.observableArrayList(ps.getActivos()));
        cbxProyecto.setItems(proyectos);
        proyecto = new Proyectodto();
        act = new Actividaddto();
        adm = (Administradordto) AppContext.getInstance().get("Usuario");
    }
    
    void enviarCorreo(){
        //correos a enviar 
        new Correo().EnviarTexto(proyecto.getProCorrepLtecnico(), proyecto.getProNombre(), "Actividad agregada al proyecto: " +
        act.getNombre() + " Descripcion: " + act.getDescripcion() + " Encargado de la actividad: " + act.encargado +
        " Estado: " + act.estado
        );
        new Correo().EnviarTexto(proyecto.getProCorreoPatrocinador(), proyecto.getProNombre(), "Actividad agregada al proyecto: " +
        act.getNombre() + " Descripcion: " + act.getDescripcion() + " Encargado de la actividad: " + act.encargado +
        " Estado: " + act.estado
        );
        new Correo().EnviarTexto(adm.getCorreo(), proyecto.getProNombre(), "Actividad agregada al proyecto: " +
        act.getNombre() + " Descripcion: " + act.getDescripcion() + " Encargado de la actividad: " + act.encargado +
        " Estado: " + act.estado
        );
    }
    
}
