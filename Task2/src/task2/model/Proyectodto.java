/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.model;


import controller.ProyectosDto;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import task2.model.Administradordto;

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
    public Administradordto admId;
    public Long proVersion;
    public SimpleStringProperty proNombre;
   // public List<Seguimientodto> seguimientosList;
    public List<Actividaddto> actividadList;
    
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
      //  this.seguimientosList = new ArrayList();
        this.actividadList = new ArrayList();
    }
    
    public Proyectodto(ProyectosDto pro){
        this();
        this.proId.set(pro.getProId().toString());
        this.proPatrocinador.set(pro.getProPatrocinador());
        this.proLtecnico.set(pro.getProLtecnico());
        this.proFpInicio.set(pro.getProFpInicio());
        this.proFpFinal.set(pro.getProFpFinal());
        this.proFrInicio.set(pro.getProFrInicio());
        this.proFrFinal.set(pro.getProFrFinal());
        this.proEstado.set(pro.getProEstado());
        //this.admId = new Administradordto(pro.getAdmId());
        this.proNombre.set(pro.getProNombre());
        //this.actividadList = pro.getActividadList()
    }
    
    public ProyectosDto DtoTodto(){
        ProyectosDto proy = new ProyectosDto();
        proy.setProId(Long.valueOf(this.getProId()));
        proy.setProPatrocinador(this.getProPatrocinador());
        proy.setProLtecnico(this.getProLtecnico());
        proy.setProFpInicio(this.getProFpInicio());
        proy.setProFpFinal(this.getProFpFinal());
        proy.setProFrInicio(this.getProFrInicio());
        proy.setProFrFinal(this.getProFrFinal());
        proy.setProEstado(this.getProEstado());
        //proy.setAdmId(this.getAdmId().AdministradordtoToDto(new AdministradorDto()));
        proy.setProNombre(this.getProNombre());
        return proy;
    }

    public String getProId() {
        return proId.get();
    }

    public void setProId(String proId) {
        this.proId.set(proId);
    }

    public String getProPatrocinador() {
        return proPatrocinador.get();
    }

    public void setProPatrocinador(String proPatrocinador) {
        this.proPatrocinador.set(proPatrocinador);
    }

    public String getProLtecnico() {
        return proLtecnico.get();
    }

    public void setProLtecnico(String proLtecnico) {
        this.proLtecnico.set(proLtecnico);
    }

    public String getProFpInicio() {
        return proFpInicio.get();
    }

    public void setProFpInicio(String proFpInicio) {
        this.proFpInicio.set(proFpInicio);
    }

    public String getProFpFinal() {
        return proFpFinal.get();
    }

    public void setProFpFinal(String proFpFinal) {
        this.proFpFinal.set(proFpFinal);
    }

    public String getProFrInicio() {
        return proFrInicio.get();
    }

    public void setProFrInicio(String proFrInicio) {
        this.proFrInicio.set(proFrInicio);
    }

    public String getProFrFinal() {
        return proFrFinal.get();
    }

    public void setProFrFinal(String proFrFinal) {
        this.proFrFinal.set(proFrFinal);
    }

    public String getProEstado() {
        return proEstado.get();
    }

    public void setProEstado(String proEstado) {
        this.proEstado.set(proEstado);
    }

    public Long getProVersion() {
        return proVersion;
    }

    public void setProVersion(Long proVersion) {
        this.proVersion = proVersion;
    }

    public String getProNombre() {
        return proNombre.get();
    }

    public void setProNombre(String proNombre) {
        this.proNombre.set(proNombre);
    }
/*    
    public List<Seguimientodto> getSeguimientosList() {
        return seguimientosList;
    }

    public void setSeguimientosList(List<Seguimientodto> seguimientosList) {
        this.seguimientosList = seguimientosList;
    }
*/    
    public List<Actividaddto> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividaddto> actividadList) {
        this.actividadList = actividadList;
    }

    public Administradordto getAdmId() {
        return admId;
    }

    public void setAdmId(Administradordto admId) {
        this.admId = admId;
    }

    
    
    
    
    
}
