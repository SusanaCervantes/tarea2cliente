/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author IVAN
 */
public class Proyectodto {
    
    public SimpleStringProperty proId;
    public SimpleStringProperty proPatrocinador;
    public SimpleStringProperty proLtecnico;
    public SimpleStringProperty proFpInicio;
    public SimpleStringProperty proFpFinal;
    public SimpleStringProperty proFrInicio;
    public SimpleStringProperty proFrFinal;
    public SimpleStringProperty proEstado;
    public Long proVersion;
    public SimpleStringProperty proNombre;
    
    public Proyectodto(){
        proId = new SimpleStringProperty();
        proPatrocinador  = new SimpleStringProperty();
        proLtecnico = new SimpleStringProperty();
        proFpInicio = new SimpleStringProperty();
        proFpFinal = new SimpleStringProperty();
        proFrInicio = new SimpleStringProperty();
        proFrFinal = new SimpleStringProperty();
        proEstado = new SimpleStringProperty();
        proNombre = new SimpleStringProperty();
    }
    
    //public proyectodto(ProyectoDto pro){
        
    //}
}
