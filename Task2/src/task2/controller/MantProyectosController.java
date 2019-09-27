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
import controller.ProyectosController_Service;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import task2.model.Administradordto;
import task2.model.Proyectodto;
import task2.util.FlowController;
import task2.util.Formato;
import task2.util.Mensaje;

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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    Proyectodto proyecto;
    Mensaje men;
    
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
        men = new Mensaje();
    }
    
    /**
     * Se le da un formato a los text-field
     */
    public void Formato(){
        tf_LiderTecnico.setTextFormatter(Formato.getInstance().letrasFormat(30));
        tf_Patrocinador.setTextFormatter(Formato.getInstance().letrasFormat(30));
        tf_nombreProyecto.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
    }
    
    /**
     * Verifica que los campos requeridos esten llenos
     * @return true si lo cumple
     */
    public Boolean validarRequeridos(){
        proyecto = new Proyectodto();
        if(!tf_nombreProyecto.getText().isEmpty() || !tf_nombreProyecto.getText().equals(" ")){
            proyecto.setProNombre(tf_nombreProyecto.getText());
            if(!tf_LiderTecnico.getText().isEmpty()|| !tf_nombreProyecto.getText().equals(" ")){
                proyecto.setProLtecnico(tf_Patrocinador.getText());
                if(!tf_Patrocinador.getText().isEmpty()|| !tf_Patrocinador.getText().equals(" ")){
                    proyecto.setProPatrocinador(tf_Patrocinador.getText());
                    if(dp_fechainicio.getValue() != null){
                        proyecto.setProFpInicio(dp_fechainicio.getValue().toString());
                        if(dp_fechafinal.getValue() != null){
                            proyecto.setProFpFinal(dp_fechafinal.getValue().toString());
                            if(cb_Lider.getValue() != null){
                                proyecto.setAdmId(cb_Lider.getValue());
                                if(tg_estado.getSelectedToggle() != null){
                                    proyecto.setProEstado(tg_estado.getSelectedToggle().getUserData().toString());
                                    if(dp_fechainicio.getValue() != null){
                                        proyecto.setProFrInicio(dp_fechaRealInicio.getValue().toString());
                                        if(dp_fechaRealFinal.getValue() != null){
                                            proyecto.setProFrFinal(dp_fechaRealFinal.getValue().toString());
                                        }else{
                                            proyecto.setProFrFinal("N");
                                        }
                                    }else{
                                        proyecto.setProFrInicio("N");
                                    }
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        proyecto = null;
        men.show(Alert.AlertType.ERROR, "ERROR", "Algunos campos aun estan vacios");
        return false;
    }
    
    /**
     * Limpiar los nodos
     */
    public void Limpiar(){
        try{
            tf_LiderTecnico.clear();
            tf_Patrocinador.clear();
            tf_nombreProyecto.clear();
            dp_fechaRealFinal.setValue(null);
            dp_fechaRealInicio.setValue(null);
            dp_fechafinal.setValue(null);
            dp_fechainicio.setValue(null);
            cb_Lider.setValue(null);
            tg_estado.getSelectedToggle().setSelected(false);
        }catch(Exception ex){}
    }
    
    @FXML
    private void accionAtras(ActionEvent event) {
        this.getStage().close();
        FlowController.getInstance().goMain();
        FlowController.getInstance().goView("Menu");
    }

    @FXML
    private void accionLimpiar(ActionEvent event) {
        Limpiar();
    }

    @FXML
    private void accionEliminar(ActionEvent event) {
        if(proyecto != null){
            
        }else{
            men.showModal(Alert.AlertType.WARNING, "ADVERTENCIA", this.getStage(), "No existe proyecto que eliminar");
        }
    }

    @FXML
    private void accionGuardarProyecto(ActionEvent event) {
        if(proyecto != null && validarRequeridos()){
            
        }else{
            men.showModal(Alert.AlertType.WARNING, "ADVERTENCIA", this.getStage(), "No existe proyecto que guardar");
        }
    }

    @FXML
    private void accionBuscarP(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("BuscarProyecto", Boolean.FALSE, Boolean.FALSE);
    }

    @FXML
    private void accionBuscarLider(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("BuscarLider", Boolean.FALSE, Boolean.FALSE);
    }

    @Override
    public void initialize() {}
    
}
