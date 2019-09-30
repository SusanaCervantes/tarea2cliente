/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.service;

import controller.ActividadController;
import controller.ActividadController_Service;
import controller.ActividadDto;
import java.util.ArrayList;
import java.util.List;
import task2.model.Actividaddto;

/**
 *
 * @author Pablo-VE
 */
public class ActividadService {
    
    ActividadController_Service actC = new ActividadController_Service();
    ActividadController port = actC.getActividadControllerPort();
    
     public Actividaddto guardarActividad(Actividaddto act){
        ActividadDto actDto = new ActividadDto();
        actDto = act.ActividadToDto(actDto);
        actDto = port.guardarActividad(actDto);
        
        act = new Actividaddto(actDto);
        return act;
    }
     
     public List<Actividaddto> getActividades(Long proId){
        List<ActividadDto> actsDto = new ArrayList<>(); 
        List<Actividaddto> acts = new ArrayList<>(); 
        actsDto = port.getActividades(proId);
        for(ActividadDto a: actsDto){
            acts.add(new Actividaddto(a));
        }
        return acts;
    }
     
     public String eliminarAct(Long actId){
        return port.eliminarAct(actId);
    }
    
    
}
