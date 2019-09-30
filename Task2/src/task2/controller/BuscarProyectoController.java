/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.appcontext.AppContext;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
import task2.util.Mensaje;

/**
 * FXML Controller class
 *
 * @author IVAN
 */
public class BuscarProyectoController extends Controller implements Initializable {

    @FXML
    private BorderPane bp_bus_root;
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
    ObservableList<Proyectodto> lista;
    ObservableList<Proyectodto> lista1;
    Proyectodto proy;
    ProyectoService pservice;
    AdministradorService aservice;
    @FXML
    private JFXTextField tf_liderTecnico;
    @FXML
    private JFXTextField tf_patrocinador;
    @FXML
    private TableColumn<Proyectodto, String> col_lider;
    @FXML
    private TableColumn<Proyectodto, String> col_Patrocinador;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lista = FXCollections.observableArrayList();
        lista1 = FXCollections.observableArrayList();
        pservice = new ProyectoService();
        aservice = new AdministradorService();
        initTabla();
    }    

    @Override
    public void initialize() {
        Limpiar();
    }

    /**
     * Inicializa la tabla
     */
    public void initTabla(){
        col_Nombre.setCellValueFactory(new PropertyValueFactory("proNombre"));
        col_lider.setCellValueFactory(new PropertyValueFactory("proLtecnico"));
        col_Patrocinador.setCellValueFactory(new PropertyValueFactory("proPatrocinador"));
    }
    

    @FXML
    private void accionBuscar(ActionEvent event) {
       try{
            String nom = "%";
            String lidt = "%";
            String pat = "%";
            if(!tf_nombre.getText().isEmpty()){
                nom = tf_nombre.getText();
            }
            if(!tf_liderTecnico.getText().isEmpty()){
                lidt = tf_liderTecnico.getText();
            }
            if(!tf_patrocinador.getText().isEmpty()){
                pat = tf_patrocinador.getText();
            }
            lista = FXCollections.observableArrayList(pservice.filtrar2(nom, lidt, pat));
            Administradordto adm = (Administradordto) task2.util.AppContext.getInstance().get("Usuario");
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i).getAdmId().getCedula().equals(adm.getCedula())){
                    lista1.add(lista.get(i));
                }
            }
            if(!lista1.isEmpty()){
                tv_proyectos.setItems(lista1);
            }else{
                Mensaje men = new Mensaje();
                men.show(Alert.AlertType.INFORMATION, "INFORMATION", "SIN RESULTADOS");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
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
        if(event.getClickCount() == 2 && tv_proyectos.getSelectionModel().getSelectedItem() != null){
            proy = tv_proyectos.getSelectionModel().getSelectedItem(); 
            this.getStage().close();
        }
    }
    
    public Proyectodto getProyecto(){
        return proy;
    }
    
    public void setProyecto(){
        proy = null;
    }
    
    void Limpiar(){
        try{
            tf_liderTecnico.clear();
            tf_nombre.clear();
            tf_patrocinador.clear();
            lista.clear();
            lista1.clear();
        }catch(Exception ex){}
    }

}