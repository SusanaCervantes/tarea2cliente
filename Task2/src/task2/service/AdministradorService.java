/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.service;

import controller.AdministradorController;
import controller.AdministradorController_Service;
import controller.AdministradorDto;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import task2.model.Administradordto;
import task2.util.Mensaje;

/**
 *
 * @author Susana
 */
public class AdministradorService {
    AdministradorController_Service amdC = new AdministradorController_Service();
    AdministradorController port = amdC.getAdministradorControllerPort();
    
    public Administradordto guardarAdministrador(Administradordto adm){
        AdministradorDto adm1 = new AdministradorDto();
        adm1 = adm.AdministradordtoToDto(adm1);
        
        adm = new Administradordto(port.guardarAdministrador(adm1));
        return adm;
    }
    
    public List<Administradordto> getAdministradores(String nombre, String apellido){
        List<AdministradorDto> adms = port.getAdministradores(nombre, apellido);
        List<Administradordto> adms2 = new ArrayList<>();
        
        for(AdministradorDto a: adms){
            adms2.add(new Administradordto(a));
        }
        return adms2;
    }
     
    public Administradordto log(String usuario, String contrasena){
        
        //System.out.println("entra a log");
        List<AdministradorDto> adms = port.getAdmiLogging(usuario, contrasena);
        List<Administradordto> adms2 = new ArrayList<>();
         
        if(adms == null || adms.size()==0){
            return null;
        }
        
        for(AdministradorDto a: adms){
            adms2.add(new Administradordto(a));
        }
        
        if(adms2.get(0) != null){
            if(!adms2.get(0).getCedula().isEmpty()){
                return adms2.get(0);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    
    
    public String eliminarAdministrador(Long id){
        return port.eliminarAdministrador(id);
    }
}
