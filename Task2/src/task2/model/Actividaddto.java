/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.model;

import javafx.beans.property.SimpleStringProperty;
import controller.ActividadDto;

/**
 *
 * @author Pablo-VE
 */
public class Actividaddto {
    public Long id;
    public SimpleStringProperty nombre;
    public SimpleStringProperty encargado; 
    public SimpleStringProperty fpinicio; 
    public SimpleStringProperty fpfinal;
    public SimpleStringProperty frinicio; 
    public SimpleStringProperty frfinal; 
    public SimpleStringProperty descripcion;
    public SimpleStringProperty estado;
    public Long orden;
    public Long version;
    public Proyectodto pro;

    public Actividaddto(Long id, SimpleStringProperty nombre, SimpleStringProperty encargado, SimpleStringProperty fpinicio, SimpleStringProperty fpfinal, SimpleStringProperty frinicio, SimpleStringProperty frfinal, SimpleStringProperty descripcion, SimpleStringProperty estado, Long orden, Long version, Proyectodto pro) {
        this.id = id;
        this.nombre = nombre;
        this.encargado = encargado;
        this.fpinicio = fpinicio;
        this.fpfinal = fpfinal;
        this.frinicio = frinicio;
        this.frfinal = frfinal;
        this.descripcion = descripcion;
        this.estado = estado;
        this.orden = orden;
        this.version = version;
        this.pro = pro;
    }

    public Actividaddto() {
        this.nombre = new SimpleStringProperty();
        this.encargado = new SimpleStringProperty();
        this.fpinicio = new SimpleStringProperty();
        this.fpfinal = new SimpleStringProperty();
        this.frinicio = new SimpleStringProperty();
        this.frfinal = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
        this.estado = new SimpleStringProperty();
        this.pro = new Proyectodto();

    }
    
    
    public Actividaddto(ActividadDto act){
        crearAct();
        if(act.getId() != null)
            this.id = act.getId();
        this.nombre.set(act.getNombre());
        this.encargado.set(act.getEncargado());
        this.fpinicio.set(act.getFpinicio());
        this.fpfinal.set(act.getFpfinal());
        this.frinicio.set(act.getFrinicio());
        this.frfinal.set(act.getFrfinal());
        this.descripcion.set(act.getDescripcion());
        this.estado.set(act.getEstado());
    }
    

    public void crearAct(){
        this.nombre = new SimpleStringProperty();
        this.encargado = new SimpleStringProperty();
        this.fpinicio = new SimpleStringProperty();
        this.fpfinal = new SimpleStringProperty();
        this.frinicio = new SimpleStringProperty();
        this.frfinal = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
        this.estado = new SimpleStringProperty();
        this.pro = new Proyectodto(); 
    }
    
    public ActividadDto ActividadToDto(ActividadDto act){
        act.setId(this.getId());
        act.setNombre(this.getNombre().get());
        act.setEncargado(this.getEncargado().get());
        act.setDescripcion(this.getDescripcion().get());
        act.setEstado(this.getEstado().get());
        act.setFpfinal(this.getFpfinal().get());
        act.setFpinicio(this.getFpinicio().get());
        act.setFrfinal(this.getFrfinal().get());
        act.setFrinicio(this.getFrinicio().get());
        act.setOrden(this.getOrden());
        act.setVersion(this.getVersion());
        
        return act;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleStringProperty getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public SimpleStringProperty getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado.set(encargado);
    }

    public SimpleStringProperty getFpinicio() {
        return fpinicio;
    }

    public void setFpinicio(String fpinicio) {
        this.fpinicio.set(fpinicio);
    }

    public SimpleStringProperty getFpfinal() {
        return fpfinal;
    }

    public void setFpfinal(String fpfinal) {
        this.fpfinal.set(fpfinal);
    }

    public SimpleStringProperty getFrinicio() {
        return frinicio;
    }

    public void setFrinicio(String frinicio) {
        this.frinicio.set(frinicio);
    }

    public SimpleStringProperty getFrfinal() {
        return frfinal;
    }

    public void setFrfinal(String frfinal) {
        this.frfinal.set(frfinal);
    }

    public SimpleStringProperty getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public SimpleStringProperty getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Proyectodto getPro() {
        return pro;
    }

    public void setPro(Proyectodto pro) {
        this.pro = pro;
    }

    
    
    
    
}
