/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.model;

//import controller.SeguimientoDto;
import javafx.beans.property.SimpleStringProperty;
import controller.SeguimientoDto;


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
    public Proyectodto proyecto;

    public Seguimientodto() {
        detalle = new SimpleStringProperty();
        fecha = new SimpleStringProperty();
        porcentaje = new SimpleStringProperty();
        proyecto = new Proyectodto();
    }

    public SeguimientoDto toSeguimientoDto(SeguimientoDto seg) {
        //seg = new SeguimientoDto();
        seg.setId(this.getId());
        seg.setDetalle(this.getDetalle());
        seg.setFecha(this.getFecha());
        seg.setPorcentaje(this.getPorcentaje());
        seg.setVersion(this.getVersion());
        return seg;
    }

    public Seguimientodto(SeguimientoDto seg) {
        this();
        this.id = seg.getId();
        this.detalle.set(seg.getDetalle());
        this.fecha.set(seg.getFecha());
        this.porcentaje.set(seg.getPorcentaje());
    }

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

    public Proyectodto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyectodto proyecto) {
        this.proyecto = proyecto;
    }

}