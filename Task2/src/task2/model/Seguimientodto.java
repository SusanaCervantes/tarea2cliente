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
public class Seguimientodto {
    public Long id;
    public SimpleStringProperty detalle;
    public SimpleStringProperty fecha;
    public SimpleStringProperty porcentaje;
    public Long version;
           
    public Seguimientodto()
    {
    
    }
    
    /*public Seguimientodto(Seguimiento seg)
    {
        this.id = seg.getSegId();
        this.detalle = seg.getSegDetalle();
        this.fecha = seg.getSegFecha();
        this.porcentaje = seg.getSegPorcentaje().toString();
        this.version = seg.getSegVersion();
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle.get();
    }

    public void setDetalle(String detalle) {
        this.detalle.set(detalle);
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getPorcentaje() {
        return porcentaje.get();
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje.set(porcentaje);
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}