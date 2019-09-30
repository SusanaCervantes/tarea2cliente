﻿/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import task2.model.Administradordto;
import task2.service.AdministradorService;
import task2.util.FlowController;
import task2.util.Formato;
import task2.util.Mensaje;

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
    private JFXTextField txtUsuario;
    @FXML
    private JFXTextField txtContrasena;
    
    AdministradorService admS;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtUsuario.setTextFormatter(Formato.getInstance().letrasFormat(30));
        txtContrasena.setTextFormatter(Formato.getInstance().letrasFormat(30));
        txtUsuario.setText("");
        txtContrasena.setText("");
        AsignarImagenes();
        
    }    

    void AsignarImagenes(){
        imv_fondo.setImage(new Image("task2/resources/loging.jpg"));
        imv_usu.setImage(new Image("task2/resources/Usuario-48.png"));
        imv_pass.setImage(new Image("task2/resources/Contraseña-48.png"));
    }
    
    @Override
    public void initialize() {
    }

    @FXML
    private void accionRegistrarse(ActionEvent event) {
    }

    AdministradorService admS = new AdministradorService();
    
    @FXML
    private void accion_Acceder(ActionEvent event) {
        boolean ban=validar();
        if(!ban){
            new Mensaje().show(Alert.AlertType.WARNING, "", "Campos Vacios");
        }else{
            
            Administradordto acceder = admS.log(txtUsuario.getText(), txtContrasena.getText());
            if(acceder != null){
                admiLog = acceder;
                getStage().close();
                FlowController.getInstance().goMain();
                FlowController.getInstance().goView("Menu");
            }else{
                new Mensaje().show(Alert.AlertType.ERROR, "", "Usuario o contraseña incorrectos");
            }
        }
        
        
    }
    public Administradordto admiLog= new Administradordto();
    public boolean validar(){
        boolean ban=true;
        if(txtUsuario.getText().isEmpty()||txtUsuario.getText().equals("")||txtUsuario.getText().equals("%")){
            ban=false;
        }
        if(txtContrasena.getText().isEmpty()||txtContrasena.getText().equals("")||txtContrasena.getText().equals("%")){
            ban=false;
        }
        return ban;
    }
    
}
