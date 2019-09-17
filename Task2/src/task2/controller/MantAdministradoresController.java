/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.uitoolkit.impl.fx.ui.FXAboutDialog;
import controller.AdministradorDto;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import task2.service.AdministradorService;
import task2.util.FlowController;
import task2.util.Mensaje;

/**
 * FXML Controller class
 *
 * @author Susana
 */
public class MantAdministradoresController extends Controller implements Initializable {

    @FXML
    private JFXTextField tfCedula;
    @FXML
    private JFXTextField tfNombre;
    @FXML
    private JFXTextField tfApellidos;
    @FXML
    private JFXTextField tfCorreo;
    @FXML
    private JFXTextField tfUsuario;
    @FXML
    private JFXPasswordField pfContrasena;
    @FXML
    private JFXCheckBox cbEstado;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXButton btnLimpiar;
    @FXML
    private TableView<AdministradorDto> tblAdministradores;
    @FXML
    private TableColumn<AdministradorDto, String> tcCedula;
    @FXML
    private TableColumn<AdministradorDto, String> tcNombre;
    @FXML
    private TableColumn<AdministradorDto, String> tcApellidos;
    @FXML
    private JFXTextField tfBuscarNombre;
    @FXML
    private JFXTextField tfBuscarApellidos;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnAtras;
    
    AdministradorService admS;
    ObservableList<AdministradorDto> admin;
    List<Node> requeridos = new ArrayList<>();
    AdministradorDto adm;
    @FXML
    private JFXButton btnEliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        admS = new AdministradorService();
        
  /*      tcCedula.setCellValueFactory(x -> x.getValue().getCedula());
        tcNombre.setCellValueFactory(x -> x.getValue().getNombre());
        tcApellidos.setCellValueFactory(x-> x.getValue().getApellidos());*/
        
        admin = FXCollections.observableArrayList();
        adm = new AdministradorDto();
        
        nuevo();
        indicarRequeridos();
    }

    public void indicarRequeridos() {
        requeridos.clear();
        requeridos.addAll(Arrays.asList(tfApellidos, tfCedula, tfCorreo, tfNombre, tfUsuario, pfContrasena));
    }
    
    public void nuevo(){
        unBind();
        adm = new AdministradorDto();
        bind();
    }
    
    @Override
    public void initialize() {
        limpiar();
    }

    @FXML
    private void evtBtnGuardar(ActionEvent event) {
        String invalidos = "";
        invalidos = validarRequeridos();
        if (invalidos.isEmpty()){
            bind();
            System.out.println(adm.getUsuario());
            String respuesta = admS.guardarAdministrador(adm);
            new Mensaje().show(Alert.AlertType.INFORMATION, "", respuesta);
        }else{
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar administrador", getStage(), invalidos);
        }
    }

    @FXML
    private void evtBtnLimpiar(ActionEvent event) {
        limpiar();
    }

    @FXML
    private void evtTblAdministradores(MouseEvent event) {
        if(tblAdministradores.getSelectionModel().getSelectedItem() != null){
            adm = tblAdministradores.getSelectionModel().getSelectedItem();
            bind();
        }
    }

    @FXML
    private void evtBtnBuscar(ActionEvent event) {
        String nom = "%";
        String ap = "%"; 
        if(!tfBuscarNombre.getText().isEmpty()){
            nom = tfBuscarNombre.getText();
        }
        if(!tfBuscarApellidos.getText().isEmpty()){
            ap = tfBuscarApellidos.getText();
        }
        admin = (FXCollections.observableArrayList((List<AdministradorDto>)admS.getAdministradores(nom, ap)));
        if(!admin.isEmpty())
            tblAdministradores.setItems(admin);
        else 
            new Mensaje().show(Alert.AlertType.INFORMATION, "", "No hay coincidencias de la busqueda");
    }
    
    @FXML
    private void evtBtnAtras(ActionEvent event) {
        FlowController.getInstance().goView("Menu");
    }
    
    public void limpiar(){
        tfApellidos.clear();
        tfBuscarApellidos.clear();
        tfBuscarNombre.clear();
        tfCedula.clear();
        tfCorreo.clear();
        tfNombre.clear();
        tfUsuario.clear();
        cbEstado.setSelected(false);
        pfContrasena.clear();
        admin.clear();
        tblAdministradores.getItems().clear();
    }
    
    private void bind() {
      /*  tfApellidos.textProperty().bindBidirectional(adm.getApellidos());
        tfCedula.textProperty().bindBidirectional(adm.getCedula());
        tfCorreo.textProperty().bindBidirectional(adm.getCorreo());
        tfNombre.textProperty().bindBidirectional(adm.getNombre());
        tfUsuario.textProperty().bindBidirectional(adm.getUsuario());
        pfContrasena.textProperty().bindBidirectional(adm.getContrasena());*/
        //cbEstado.setSelected(false);
    }
    
    private void unBind() {
        tfApellidos.textProperty().unbindBidirectional(adm.getApellidos());
        tfCedula.textProperty().unbindBidirectional(adm.getCedula());
        tfCorreo.textProperty().unbindBidirectional(adm.getCorreo());
        tfNombre.textProperty().unbindBidirectional(adm.getNombre());
        tfUsuario.textProperty().unbindBidirectional(adm.getUsuario());
        pfContrasena.textProperty().unbindBidirectional(adm.getContrasena());
        //cbEstado.setSelected(false);
    }
    
    public String validarRequeridos() {
        Boolean validos = true;
        String invalidos = "";
        for (Node node : requeridos) {
            if (node instanceof JFXTextField && !((JFXTextField) node).validate()) {
                if (validos) {
                    invalidos += ((JFXTextField) node).getPromptText();
                } else {
                    invalidos += "," + ((JFXTextField) node).getPromptText();
                }
                validos = false;
            } else if (node instanceof JFXPasswordField && !((JFXPasswordField) node).validate()) {
                if (validos) {
                    invalidos += ((JFXPasswordField) node).getPromptText();
                } else {
                    invalidos += "," + ((JFXPasswordField) node).getPromptText();
                }
                validos = false;
            }
        }
        if (validos) {
            return "";
        } else {
            return "Campos requeridos o con problemas de formato [" + invalidos + "].";
        }
    }

    @FXML
    private void evtBtnEliminar(ActionEvent event) {
        if(adm.getId() != null){
            new Mensaje().show(Alert.AlertType.INFORMATION, "", admS.eliminarAdministrador(adm.getId()));
        }else{
            new Mensaje().show(Alert.AlertType.INFORMATION, "", "Primero debe seleccionar un administrador");
        }
        
    }
}
