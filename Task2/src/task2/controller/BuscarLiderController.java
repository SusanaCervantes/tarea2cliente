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
import task2.service.AdministradorService;
import task2.util.Formato;

/**
 *
 * @author ivana
 */
public class BuscarLiderController extends Controller implements Initializable{

    @FXML
    private JFXTextField tf_nombre;
    @FXML
    private JFXTextField tf_apellido;
    @FXML
    private JFXButton btn_buscar;
    @FXML
    private JFXButton btn_limpiar;
    @FXML
    private JFXButton btn_aceptar;
    @FXML
    private TableView<Administradordto> tv_lideres;
    @FXML
    private TableColumn<Administradordto, String> col_Cedula;
    @FXML
    private TableColumn<Administradordto, String> col_Nombre;
    @FXML
    private TableColumn<Administradordto, String> col_Apellidos;
    ObservableList<Administradordto> lideres;
    Administradordto seleccionado;
    String nom, ape;
    AdministradorService aservice;
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
        tf_nombre.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
        tf_apellido.setTextFormatter(Formato.getInstance().maxLengthFormat(30));
    }
    
    /**
     * Limpia los campos
     */
    public void Limpiar(){
        lideres.clear();
        seleccionado = new Administradordto();
        tf_nombre.clear();
        tf_apellido.clear();
    }
    
    /**
     * Verifica que campos estan vacios para hacer la busqueda
     */
    public void verificar(){
        nom = "%";
        ape = "%";
        if(tf_nombre.getText() != null || !tf_nombre.getText().isEmpty()){
            nom = tf_nombre.getText();
            nom = nom.toUpperCase();
        }
        if(tf_apellido.getText() != null || !tf_apellido.getText().isEmpty()){
            ape = tf_apellido.getText();
            ape = ape.toUpperCase();
        }
    }
    
    @Override
    public void initialize() {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aservice = new AdministradorService();
    }

    @FXML
    private void accionBuscar(ActionEvent event) {
        verificar();
        aservice.getAdministradores(nom, ape);
        
    }

    @FXML
    private void accionLimpiar(ActionEvent event) {
        Limpiar();
    }

    @FXML
    private void accionAceptar(ActionEvent event) {
            this.getStage().close();
    }

    @FXML
    private void accionTabla(MouseEvent event) {
        if(event.getClickCount() == 2 && tv_lideres.getSelectionModel().getSelectedItem() != null){
            seleccionado = tv_lideres.getSelectionModel().getSelectedItem();
        }
    }

    public Administradordto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado() {
        this.seleccionado = null;
    }
    
    
    
}
