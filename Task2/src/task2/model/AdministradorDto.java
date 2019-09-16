/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Susana
 */
public class AdministradorDto{
    public Long id;
    public SimpleStringProperty nombre;
    public SimpleStringProperty apellidos; 
    public SimpleStringProperty usuario; 
    public SimpleStringProperty contrasena;
    public SimpleStringProperty cedula; 
    public SimpleStringProperty correo; 
    public SimpleStringProperty estado;
    public Long version;

    public AdministradorDto(Long id, String nombre, String apellidos, String usuario, String contrasena, String cedula, String correo, String estado, Long version) {
        this.id = id;
        this.nombre.set(nombre);
        this.apellidos.set(apellidos);
        this.usuario.set(usuario);
        this.contrasena.set(contrasena);
        this.cedula.set(cedula);
        this.correo.set(correo);
        this.estado.set(estado);
        this.version = version;
    }
    
    public AdministradorDto(){
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public String getUsuario() {
        return usuario.get();
    }

    public void setUsuario(String usuario) {
        this.usuario.set(usuario);
    }

    public String getContrasena() {
        return contrasena.get();
    }

    public void setContrasena(String contrasena) {
        this.contrasena.set(contrasena);
    }

    public String getCedula() {
        return cedula.get();
    }

    public void setCedula(String cedula) {
        this.cedula.set(cedula);
    }

    public String getCorreo() {
        return correo.get();
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
}
