/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import task2.model.Administradordto;
import task2.model.Proyectodto;
import task2.service.AdministradorService;
import task2.service.ProyectoService;
import task2.util.AppContext;
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
    ProyectoService pservice;
    AdministradorService aservice;
    ObservableList<Administradordto> lista;
    @FXML
    private JFXTextField tf_cep;
    @FXML
    private JFXTextField tf_celt;
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
    }
    
    /**
     * Se inicializan la variables
     */
    public void initVariables(){
        men = new Mensaje();
        pservice = new ProyectoService();
        aservice = new AdministradorService();
        proyecto = new Proyectodto();
    }
    
    /**
     * Se le da un formato a los text-field
     */
    public void Formato(){
        tf_LiderTecnico.setTextFormatter(Formato.getInstance().letrasFormat(30));
        tf_Patrocinador.setTextFormatter(Formato.getInstance().letrasFormat(30));
        tf_nombreProyecto.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
        tf_cep.setTextFormatter(Formato.getInstance().maxLengthFormat(50));
        tf_celt.setTextFormatter(Formato.getInstance().maxLengthFormat(50));
    }
    
    /**
     * Verifica que los campos requeridos esten llenos
     * @return true si lo cumple
     */
    public Boolean validarRequeridos(){
        if(!tf_nombreProyecto.getText().isEmpty() || !tf_nombreProyecto.getText().equals(" ")){
            if(!tf_LiderTecnico.getText().isEmpty()|| !tf_LiderTecnico.getText().equals(" ")){
                if(!tf_Patrocinador.getText().isEmpty()|| !tf_Patrocinador.getText().equals(" ")){
                    if(dp_fechainicio.getValue() != null){
                        if(dp_fechafinal.getValue() != null){
                            if(tg_estado.getSelectedToggle() != null){
                                if(!tf_cep.getText().isEmpty()|| !tf_cep.getText().equals(" ")){
                                    if(!tf_celt.getText().isEmpty()|| !tf_celt.getText().equals(" ")){
                                        return true;
                                    }
                                }
                            }                           
                        }
                    }
                }
            }
        }
        //proyecto = null;
        men.show(Alert.AlertType.ERROR, "ERROR", "Algunos campos aun estan vacios");
        return false;
    }
    
    /**
     * Limpiar los nodos
     */
    
    public void Limpiar(){
        try{
            tf_celt.clear();
            tf_cep.clear();
            tf_LiderTecnico.clear();
            tf_Patrocinador.clear();
            tf_nombreProyecto.clear();
            dp_fechaRealFinal.setValue(null);
            dp_fechaRealInicio.setValue(null);
            dp_fechafinal.setValue(null);
            dp_fechainicio.setValue(null);
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
        if(proyecto != null && proyecto.getProId() != null && Long.valueOf(proyecto.getProId()) != 0){
            int v = pservice.Eliminar(Long.valueOf(proyecto.getProId()));
            switch(v){
                case 0: men.show(Alert.AlertType.ERROR, "ELIMINAR PROYECTOS", "No se encontro el proyecto con esos datos"); break;
                case 1: men.show(Alert.AlertType.INFORMATION, "ELIMINAR PROYECTOS", "Eliminado exitosamente"); break;
                case 2: men.show(Alert.AlertType.ERROR, "ELIMINAR PROYECTOS", "No puede ser eliminado, posee relacion con otros datos"); break;
                case 3: men.show(Alert.AlertType.ERROR, "ELIMINAR PROYECTOS", "Ocurrio un error al eliminar el proyecto"); break;
            }
            if(v == 1){
                Limpiar();
            }
        }else{
            men.showModal(Alert.AlertType.WARNING, "ADVERTENCIA", this.getStage(), "No existe proyecto que eliminar");
        }
    }

    @FXML
    private void accionGuardarProyecto(ActionEvent event) {
        if(validarRequeridos()){
            String val = "NR";
            proyecto.setProPatrocinador(tf_Patrocinador.getText());
            proyecto.setProNombre(tf_nombreProyecto.getText());
            proyecto.setProLtecnico(tf_LiderTecnico.getText());
            proyecto.setProFpInicio(dp_fechainicio.getValue().toString());
            proyecto.setProFpFinal(dp_fechafinal.getValue().toString());
            proyecto.setProEstado(tg_estado.getSelectedToggle().getUserData().toString());
            proyecto.setProCorreoPatrocinador(tf_cep.getText());
            proyecto.setProCorrepLtecnico(tf_celt.getText());
            if(dp_fechaRealInicio.getValue() != null){
                val = dp_fechaRealInicio.getValue().toString();
            }
            proyecto.setProFrInicio(val);
            val = "NR";
            if(dp_fechaRealFinal.getValue() != null){
                val = dp_fechaRealFinal.getValue().toString();
            }
            proyecto.setProFrFinal(val);
            proyecto.setAdmId((Administradordto)AppContext.getInstance().get("Usuario"));
            proyecto.setProVersion(Long.valueOf(1));
            if(proyecto != null){
                Administradordto adm = new Administradordto();
                adm = (Administradordto) AppContext.getInstance().get("Usuario");
                proyecto.setAdmId(adm);
                proyecto = pservice.Guardar(proyecto);
                if(proyecto != null){
                    men.show(Alert.AlertType.INFORMATION, "INFORMATION", "Proyecto guardado");
                }else{
                    men.show(Alert.AlertType.WARNING, "WARNING", "Error al guardar el proyecto");
                }
            }
        }else{
            men.show(Alert.AlertType.WARNING, "WARNING", "No existe proyecto que guardar");
        }
    }

    @FXML
    private void accionBuscarP(ActionEvent event) {
        BuscarProyectoController bpc = (BuscarProyectoController)FlowController.getInstance().getController("BuscarProyecto");
        FlowController.getInstance().goViewInWindow("BuscarProyecto", Boolean.FALSE, Boolean.FALSE);
        proyecto = bpc.getProyecto();
        bpc.setProyecto();
        llenarCampos();
        
    }

    void llenarCampos(){
        if(proyecto != null){
            tf_nombreProyecto.setText(proyecto.getProNombre());
            tf_LiderTecnico.setText(proyecto.getProLtecnico());
            tf_Patrocinador.setText(proyecto.getProPatrocinador());
            tf_celt.setText(proyecto.getProCorrepLtecnico());
            tf_cep.setText(proyecto.getProCorreoPatrocinador());
            dp_fechainicio.setValue(LocalDate.parse(proyecto.getProFpInicio()));
            dp_fechafinal.setValue(LocalDate.parse(proyecto.getProFpFinal()));
            if(!proyecto.getProFrInicio().equals("NR")){
                dp_fechaRealInicio.setValue(LocalDate.parse(proyecto.getProFrInicio()));
            }
            if(!proyecto.getProFrFinal().equals("NR")){
                dp_fechaRealFinal.setValue(LocalDate.parse(proyecto.getProFrFinal()));
            }
            EstablecerEstado(proyecto.getProEstado());
        }
    }
    
    public void EstablecerEstado(String est){
        switch(est){
            case "P": rb_activo.setSelected(true); break;
            case "F": rb_finalizado.setSelected(true); break;
            case "S": rb_suspendido.setSelected(true); break;
            case "C": rb_encurso.setSelected(true); break;
        }
    }
    
    @Override
    public void initialize() {
        Limpiar();
    }
}
