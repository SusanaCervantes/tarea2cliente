/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.service;

import controller.AdministradorController;
import controller.AdministradorController_Service;
import controller.AdministradorDto;
import java.util.List;

/**
 *
 * @author Susana
 */
public class AdministradorService {
    AdministradorController_Service amdC = new AdministradorController_Service();
    AdministradorController port = amdC.getAdministradorControllerPort();
    
    public String guardarAdministrador(AdministradorDto adm){
        return port.guardarAdministrador(adm);
    }
    
    public List<AdministradorDto> getAdministradores(String nombre, String apellido){
        return port.getAdministradores(nombre, apellido);
    }
}
