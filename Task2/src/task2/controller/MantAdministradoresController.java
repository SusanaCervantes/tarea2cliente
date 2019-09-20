/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.AdministradorDto;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
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
import task2.model.Administradordto;
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
    private JFXButton btnEliminar;
    @FXML
    private JFXButton btnLimpiar;
    @FXML
    private TableView<Administradordto> tblAdministradores;
    @FXML
    private TableColumn<Administradordto, String> tcCedula;
    @FXML
    private TableColumn<Administradordto, String> tcNombre;
    @FXML
    private TableColumn<Administradordto, String> tcApellidos;
    @FXML
    private JFXTextField tfBuscarNombre;
    @FXML
    private JFXTextField tfBuscarApellidos;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnAtras;
    
    AdministradorService admS;
    ObservableList<Administradordto> admin;
    List<Node> requeridos = new ArrayList<>();
    Administradordto adm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        admS = new AdministradorService();
        
        tcCedula.setCellValueFactory(x -> x.getValue().cedula);
        tcNombre.setCellValueFactory(x -> x.getValue().nombre);
        tcApellidos.setCellValueFactory(x-> x.getValue().apellidos);
        
        admin = FXCollections.observableArrayList();
        adm = new Administradordto();
        
        //nuevo();
        indicarRequeridos();
    }   
    
    public void indicarRequeridos() {
        requeridos.clear();
        requeridos.addAll(Arrays.asList(tfApellidos, tfCedula, tfCorreo, tfNombre, tfUsuario, pfContrasena));
    }
    
    public void nuevo(){
        unBind();
        adm = new Administradordto();
        bind();
    }

    @FXML
    private void evtBtnGuardar(ActionEvent event) {
        String invalidos = "";
        invalidos = validarRequeridos();
        System.out.println("invalidos "+ invalidos);
        if (tfApellidos.getText().isEmpty() || tfNombre.getText().isEmpty() || tfCedula.getText().isEmpty() || 
                tfCorreo.getText().isEmpty() || tfUsuario.getText().isEmpty() || pfContrasena.getText().isEmpty()){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar administrador", getStage(), "Campos requeridos o con problemas de formato");
        }else{
            //bind();
            adm.setApellidos(tfApellidos.getText());
            adm.setNombre(tfNombre.getText());
            adm.setCedula(tfCedula.getText());
            adm.setCorreo(tfCorreo.getText());
            adm.setUsuario(tfUsuario.getText());
            adm.setContrasena(pfContrasena.getText());
            adm.setEstado("I");
            adm = admS.guardarAdministrador(adm);
            if(adm == null){
                new Mensaje().show(Alert.AlertType.WARNING, "", "Ocurrio un error al guardar el administrador");
            }else{
                bind();
                new Mensaje().show(Alert.AlertType.INFORMATION, "", "Administrador guardado con exito");
            }
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
        admin = (FXCollections.observableArrayList((List<Administradordto>)admS.getAdministradores(nom, ap)));
        if(!admin.isEmpty())
            tblAdministradores.setItems(admin);
        else 
            new Mensaje().show(Alert.AlertType.INFORMATION, "", "No hay coincidencias de la busqueda");
    }

    @FXML
    private void evtBtnAtras(ActionEvent event) {
        FlowController.getInstance().goView("Menu");
    }

    @Override
    public void initialize() {
        
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
    
    private void bind() {
        tfApellidos.textProperty().bindBidirectional(adm.apellidos);
        tfCedula.textProperty().bindBidirectional(adm.cedula);
        tfCorreo.textProperty().bindBidirectional(adm.correo);
        tfNombre.textProperty().bindBidirectional(adm.nombre);
        tfUsuario.textProperty().bindBidirectional(adm.usuario);
        pfContrasena.textProperty().bindBidirectional(adm.contrasena);
        //cbEstado.setSelected(false);
    }
    
    private void unBind() {
        tfApellidos.textProperty().unbindBidirectional(adm.apellidos);
        tfCedula.textProperty().unbindBidirectional(adm.cedula);
        tfCorreo.textProperty().unbindBidirectional(adm.correo);
        tfNombre.textProperty().unbindBidirectional(adm.nombre);
        tfUsuario.textProperty().unbindBidirectional(adm.usuario);
        pfContrasena.textProperty().unbindBidirectional(adm.contrasena);
        //cbEstado.setSelected(false);
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
    
}
