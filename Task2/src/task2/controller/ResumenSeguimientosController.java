/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import task2.model.Proyectodto;
import task2.model.Seguimientodto;
import task2.service.ProyectoService;
import task2.service.SeguimientoService;
import task2.util.AppContext;
import task2.util.FlowController;
import task2.util.Mensaje;

/**
 * FXML Controller class
 *
 * @author Susana
 */
public class ResumenSeguimientosController extends Controller implements Initializable {

    @FXML
    private TableView<Seguimientodto> tblSegPro;
    @FXML
    private TableColumn<Seguimientodto, String> tcProyecto;
    @FXML
    private TableColumn<Seguimientodto, String> tcSeg;
    @FXML
    private TableColumn<Seguimientodto, String> tcFecha;
    @FXML
    private TableColumn<Seguimientodto, String> tcPorcentaje;
    
    private List<Proyectodto> proyectos;
    private ObservableList<Seguimientodto> segs;
    private Seguimientodto seg;
    
    private ProyectoService ps;
    private SeguimientoService ss;
    
    DateTimeFormatter formatter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        tcProyecto.setCellValueFactory(x-> x.getValue().getProyecto().proNombre);
        tcSeg.setCellValueFactory(x-> x.getValue().detalle);
        tcFecha.setCellValueFactory(x-> x.getValue().fecha);
        tcPorcentaje.setCellValueFactory(x-> x.getValue().fecha);
        
        proyectos = new ArrayList<>();
        segs = FXCollections.observableArrayList();
        
        ps = new ProyectoService();
        ss = new SeguimientoService();
        
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    }    

    @Override
    public void initialize() {
        proyectos.clear();
        segs.clear();
        seg = new Seguimientodto();
        
        cargarTabla();
    }

    @FXML
    private void evtTblSegPro(MouseEvent event) {
        if(tblSegPro.getSelectionModel().getSelectedItem() != null){
            seg = tblSegPro.getSelectionModel().getSelectedItem();
        }
    }

    @FXML
    private void evtIrSeg(ActionEvent event) {
        if(seg.getId()!= null){
            AppContext.getInstance().set("resSeguimiento", seg);
            FlowController.getInstance().goView("SeguimientoProyectos");
        }else{
            new Mensaje().show(Alert.AlertType.NONE, "", "Primero debe seleccionar un elemento de la tabla");
        }
    }
    
    private void cargarTabla(){
        proyectos = ps.getActivos();        //los del administrador
        LocalDate min;
        if(proyectos != null){
            for(Proyectodto p: ps.getActivos()){
                List<Seguimientodto> aux = ss.getSeguimientos(new Long(p.getProId()));
                if(aux != null){
                    min = LocalDate.parse("2000-01-01", formatter);
                    Seguimientodto s = new Seguimientodto();
                    for(Seguimientodto sd: aux){
                        if(LocalDate.parse(sd.getFecha(), formatter).isAfter(min)){
                            s = sd;
                            min = LocalDate.parse(sd.getFecha(), formatter);
                        }
                    }
                    s.setProyecto(p);
                    segs.add(s);
                }
            }
        }
        tblSegPro.setItems(segs);
    }

    @FXML
    private void evtAtras(ActionEvent event) {
        FlowController.getInstance().goView("Menu");
    }
}
