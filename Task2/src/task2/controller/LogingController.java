/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author IVAN
 */
public class LogingController extends Controller implements Initializable {
    
    private Label label;
    @FXML
    private ImageView imv_fondo;
    @FXML
    private ImageView imv_usu;
    @FXML
    private ImageView imv_pass;
    @FXML
    private JFXButton btn_Registrarse;
    @FXML
    private JFXButton btn_Acceder;
    @FXML
    private AnchorPane ach_root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AsignarImagenes();
        
    }    

    void AsignarImagenes(){
        imv_fondo.setImage(new Image("task2/resources/loging.jpg"));
        imv_usu.setImage(new Image("task2/resources/Usuario-48.png"));
        imv_pass.setImage(new Image("task2/resources/Contraseña-48.png"));
    }
    
    @Override
    public void initialize() {}

    @FXML
    private void accionRegistrarse(ActionEvent event) {
    }

    @FXML
    private void accion_Acceder(ActionEvent event) {
    }
    
}
