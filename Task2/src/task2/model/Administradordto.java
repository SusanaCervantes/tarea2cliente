/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.model;

import controller.AdministradorDto;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Susana
 */
public class Administradordto {
    private Long id;
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellidos; 
    private SimpleStringProperty usuario; 
    private SimpleStringProperty contrasena;
    private SimpleStringProperty cedula; 
    private SimpleStringProperty correo; 
    private SimpleStringProperty estado;
    private Long version;

    public Administradordto(Long id, String nombre, String apellidos, String usuario, String contrasena, String cedula, String correo, String estado, Long version) {
        this.id = id;
    /*    this.nombre = nombre;
        this.apellidos = apellidos);
        this.usuario = usuario);
        this.contrasena = usuario);
        this.cedula = cedula);
        this.correo = correo);
        this.estado = estado);*/
        this.version = version;
    }
    
    public Administradordto(){
    
    }
    
    public Administradordto(AdministradorDto adm){
       /* this.id = adm.getId();
        this.nombre = adm.getNombre();
        this.apellidos = adm.getApellidos();
        this.usuario = adm.getAdmUsuario();
        this.contrasena = adm.getAdmContrasena();
        this.cedula = adm.getAdmCedula();
        this.correo = adm.getAdmCorreo();
        this.estado = adm.getAdmEstado();
        this.version = adm.getAdmVersion();*/
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

    public void setNombre(SimpleStringProperty nombre) {
        this.nombre = nombre;
    }

    public SimpleStringProperty getApellidos() {
        return apellidos;
    }

    public void setApellidos(SimpleStringProperty apellidos) {
        this.apellidos = apellidos;
    }

    public SimpleStringProperty getUsuario() {
        return usuario;
    }

    public void setUsuario(SimpleStringProperty usuario) {
        this.usuario = usuario;
    }

    public SimpleStringProperty getContrasena() {
        return contrasena;
    }

    public void setContrasena(SimpleStringProperty contrasena) {
        this.contrasena = contrasena;
    }

    public SimpleStringProperty getCedula() {
        return cedula;
    }

    public void setCedula(SimpleStringProperty cedula) {
        this.cedula = cedula;
    }

    public SimpleStringProperty getCorreo() {
        return correo;
    }

    public void setCorreo(SimpleStringProperty correo) {
        this.correo = correo;
    }

    public SimpleStringProperty getEstado() {
        return estado;
    }

    public void setEstado(SimpleStringProperty estado) {
        this.estado = estado;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
