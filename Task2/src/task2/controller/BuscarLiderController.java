/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import task2.model.Administradordto;
import task2.util.Formato;

/**
 * FXML Controller class
 *
 * @author IVAN
 */
public class BuscarLiderController implements Initializable {

    @FXML private JFXTextField tf_cedula;
    @FXML private JFXTextField tf_nombre;
    @FXML private JFXTextField tf_apellido;
    @FXML private JFXButton btn_buscar;
    @FXML private JFXButton btn_aceptar;
    @FXML private JFXButton btn_limpiar;
    @FXML private TableView<Administradordto> tv_lideres;
    @FXML private TableColumn<Administradordto, String> col_Cedula;
    @FXML private TableColumn<Administradordto, String> col_Nombre;
    @FXML private TableColumn<Administradordto, String> col_Apellidos;
    ObservableList<Administradordto> lideres;
    Administradordto seleccionado;
    String ced, nom, ape;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        initVariables();
        Formato();
    }    

    /**
     * Se inicializa las columnas del tableView
     */
    public void initTable(){
        col_Cedula.setCellValueFactory(new PropertyValueFactory("cedula"));
        col_Nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        col_Apellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
    }
    
    /**
     * Se inicializan las variables
     */
    public void initVariables(){
        lideres = FXCollections.observableArrayList();
        seleccionado = new Administradordto();
    }
    
    /**
     * Se le da un formato a los text field
     */
    public void Formato(){
        tf_cedula.setTextFormatter(Formato.getInstance().cedulaFormat(30));
        tf_nombre.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
        tf_apellido.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
    }
    
    /**
     * Limpia los campos
     */
    public void Limpiar(){
        lideres.clear();
        seleccionado = new Administradordto();
        tf_cedula.clear();
        tf_nombre.clear();
        tf_apellido.clear();
    }
    
    /**
     * Verifica que campos estan vacios para hacer la busqueda
     */
    public void verificar(){
        ced = "%";
        nom = "%";
        ape = "%";
        if(tf_cedula.getText() != null || !tf_cedula.getText().isEmpty()){
            ced = tf_cedula.getText();
        }
        if(tf_nombre.getText() != null || !tf_nombre.getText().isEmpty()){
            nom = tf_nombre.getText();
        }
        if(tf_apellido.getText() != null || !tf_apellido.getText().isEmpty()){
            ape = tf_apellido.getText();
        }
    }
    
    @FXML
    private void accionBuscar(ActionEvent event) {
    }

    @FXML
    private void accionAceptar(ActionEvent event) {
    }

    @FXML
    private void accionTabla(MouseEvent event) {
    }

    @FXML
    private void accionLimpiar(ActionEvent event) {
        Limpiar();
    }
    
    
}
