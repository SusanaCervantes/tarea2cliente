/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.service;

import controller.ProyectosController;
import controller.ProyectosController_Service;
import controller.ProyectosDto;
import java.util.ArrayList;
import java.util.List;
import task2.model.Proyectodto;


/**
 *
 * @author ivana
 */
public class ProyectoService {
    
    ProyectosController_Service pservice = new ProyectosController_Service();
    ProyectosController pcontroller = pservice.getProyectosControllerPort();
    
    
    public List<Proyectodto> getTodos(){
        ProyectosDto proDto = new ProyectosDto();
        List<ProyectosDto> list1 = pcontroller.getProyectos();
        List<Proyectodto> list2 = new ArrayList();
        for(ProyectosDto pro : list1){
            //list2.add(Proyectodto.DtoTodto(pro));
        }
        return list2;
    }
    
    public void Guardar(Proyectodto pro){
        
    }
}
