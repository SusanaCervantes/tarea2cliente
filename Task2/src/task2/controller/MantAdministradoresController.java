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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import task2.service.AdministradorService;
import task2.util.FlowController;

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
    private TableView<?> tblAdministradores;
    @FXML
    private TableColumn<?, ?> tcCedula;
    @FXML
    private TableColumn<?, ?> tcNombre;
    @FXML
    private TableColumn<?, ?> tcApellidos;
    @FXML
    private JFXTextField tfBuscarNombre;
    @FXML
    private JFXTextField tfBuscarApellidos;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnAtras;
    
    AdministradorService admS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        admS = new AdministradorService();
    }    

    @Override
    public void initialize() {
        
    }

    @FXML
    private void evtBtnGuardar(ActionEvent event) {
        AdministradorDto adm = new AdministradorDto();
        adm.setNombre("Susana");
        adm.setApellidos("Cervantes");
        adm.setCedula("117050374");
        adm.setCorreo("susi0326@gmail.com");
        adm.setUsuario("su");
        adm.setContrasena("su");
        adm.setEstado("A");
        adm.setVersion(new Long(1));
        String respuesta = admS.guardarAdministrador(adm);
    }

    @FXML
    private void evtBtnLimpiar(ActionEvent event) {
    }

    @FXML
    private void evtTblAdministradores(MouseEvent event) {
    }

    @FXML
    private void evtBtnBuscar(ActionEvent event) {
    }
    
    @FXML
    private void evtBtnAtras(ActionEvent event) {
        FlowController.getInstance().goView("Menu");
    }
}
