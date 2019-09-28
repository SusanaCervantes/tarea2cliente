/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.layout.BorderPane;
import task2.model.Administradordto;
import task2.model.Proyectodto;
import task2.service.AdministradorService;
import task2.service.ProyectoService;
import task2.util.FlowController;

/**
 * FXML Controller class
 *
 * @author IVAN
 */
public class BuscarProyectoController extends Controller implements Initializable {

    @FXML
    private BorderPane bp_bus_root;
    @FXML
    private JFXComboBox<Administradordto> cb_lider;
    @FXML
    private JFXButton btn_buscarLider;
    @FXML
    private JFXTextField tf_nombre;
    @FXML
    private JFXButton btn_buscar;
    @FXML
    private JFXButton btn_limpiar;
    @FXML
    private JFXButton btn_aceptar;
    @FXML
    private TableView<Proyectodto> tv_proyectos;
    @FXML
    private TableColumn<Proyectodto, String> col_Nombre;
    @FXML
    private TableColumn<Proyectodto, Administradordto> col_Lider;
    ObservableList<Proyectodto> lista;
    ObservableList<Administradordto> lista1;
    Proyectodto proy;
    ProyectoService pservice;
    AdministradorService aservice;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lista = FXCollections.observableArrayList();
        lista1 = FXCollections.observableArrayList();
        pservice = new ProyectoService();
        aservice = new AdministradorService();
    }    

    @Override
    public void initialize() {
        initTabla();
    }

    /**
     * Inicializa la tabla
     */
    public void initTabla(){
        col_Nombre.setCellValueFactory(new PropertyValueFactory("proNombre"));
        col_Lider.setCellValueFactory(new PropertyValueFactory("admId"));
    }
    
    @FXML
    private void accionBuscarLider(ActionEvent event) {
        BuscarLiderController blc = (BuscarLiderController)FlowController.getInstance().getController("BuscarLider");
        FlowController.getInstance().goViewInWindow("BuscarLider", Boolean.FALSE, Boolean.FALSE);
        
    }

    @FXML
    private void accionBuscar(ActionEvent event) {
        try{
            String nom = "%";
            if(!tf_nombre.getText().isEmpty()){
                nom = tf_nombre.getText();
            }
            pservice.filtrar(cb_lider.getValue(), nom);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void accionLimpiar(ActionEvent event) {
        lista.clear();
        
    }

    @FXML
    private void accionAceptar(ActionEvent event) {
        this.getStage().close();
    }

    @FXML
    private void accionTabla(MouseEvent event) {
        if(event.getClickCount() == 2 && tv_proyectos.getSelectionModel().getSelectedItem() != null){
            proy = tv_proyectos.getSelectionModel().getSelectedItem(); 
            this.getStage().close();
        }
    }
    
    public void LlenarLideres(){
        lista1.clear();
        lista1 = FXCollections.observableArrayList(aservice.getAdministradores("%", "%")); 
        cb_lider.setItems(lista1);
    }
    
    public Proyectodto getProyecto(){
        return proy;
    }
    
    public void setProyecto(){
        proy = null;
    }

}