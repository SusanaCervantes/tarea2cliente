/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import task2.util.FlowController;

/**
 * FXML Controller class
 *
 * @author Susana
 */
public class MenuController extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void evtBtnAdministradores(ActionEvent event) {
        FlowController.getInstance().goView("MantAdministradores");
    }

    @FXML
    private void evtBtnProyectos(ActionEvent event) {
        FlowController.getInstance().goView("MantProyectos");
    }

    @FXML
    private void evtBtnActividad(ActionEvent event) {
        FlowController.getInstance().goView("ActividadProyectos");
    }

    @FXML
    private void evtBtnSeguimiento(ActionEvent event) {
        FlowController.getInstance().goView("SeguimientoProyectos");
    }

    @Override
    public void initialize() {
        
    }

    @FXML
    private void evtBtnResumen(ActionEvent event) {
        FlowController.getInstance().goView("ResumenSeguimientos");
    }
    
}
