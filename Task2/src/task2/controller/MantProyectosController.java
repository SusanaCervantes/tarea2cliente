/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import task2.model.Administradordto;

/**
 * FXML Controller class
 *
 * @author IVAN
 */
public class MantProyectosController extends Controller implements Initializable {

    @FXML private BorderPane bp_rootP;
    @FXML private Label lbl_titulo;
    @FXML private JFXButton btn_Atras;
    @FXML private JFXTextField tf_nombreProyecto;
    @FXML private JFXDatePicker dp_fechainicio;
    @FXML private JFXDatePicker dp_fechafinal;
    @FXML private JFXDatePicker dp_fechaRealInicio;
    @FXML private JFXDatePicker dp_fechaRealFinal;
    @FXML private JFXButton btn_Limpiar;
    @FXML private JFXButton btn_Eliminar;
    @FXML private JFXButton btn_GuardarP;
    @FXML private JFXButton btn_BuscarP;
    @FXML private JFXComboBox<Administradordto> cb_Lider;
    @FXML private JFXButton btn_BuscarLider;
    @FXML private JFXTextField tf_Patrocinador;
    @FXML private JFXTextField tf_LiderTecnico;
    @FXML private JFXRadioButton rb_activo;
    @FXML private ToggleGroup tg_estado;
    @FXML private JFXRadioButton rb_encurso;
    @FXML private JFXRadioButton rb_suspendido;
    @FXML private JFXRadioButton rb_finalizado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
        initVariables();
    }    

    /**
     * Se inicializan los componentes para el binding
     */
    public void initComponentes(){
        rb_activo.setUserData("P");
        rb_suspendido.setUserData("S");
        rb_finalizado.setUserData("F");
        rb_encurso.setUserData("C");
        cb_Lider.setMouseTransparent(true);
    }
    
    /**
     * Se inicializan la variables
     */
    public void initVariables(){
        
    }
   
    /**
     * 
     */
    public void bind(){
        
    }
    
    /**
     * 
     */
    public void unbind(){
        
    }
    
    /**
     * 
     */
    public void validarRequeridos(){
        
    }
    
    @FXML
    private void accionAtras(ActionEvent event) {
    }

    @FXML
    private void accionLimpiar(ActionEvent event) {
    }

    @FXML
    private void accionEliminar(ActionEvent event) {
    }

    @FXML
    private void accionGuardarProyecto(ActionEvent event) {
    }

    @FXML
    private void accionBuscarP(ActionEvent event) {
    }

    @FXML
    private void accionBuscarLider(ActionEvent event) {
    }

    @Override
    public void initialize() {}
    
}
