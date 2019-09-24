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
import task2.model.Administradordto;

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
     
    public boolean log(String usuario, String contrasena){
        List<AdministradorDto> adms = port.getAdmiLogging(usuario, contrasena);
        List<Administradordto> adms2 = new ArrayList<>();
        
        for(AdministradorDto a: adms){
            adms2.add(new Administradordto(a));
        }
        
        if(!adms2.get(0).getCedula().isEmpty()){
            return true;
        }else{
            return false;
        }
        
        
    }
    
    
    public String eliminarAdministrador(Long id){
        return port.eliminarAdministrador(id);
    }
}
