/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.service;



import controller.AdministradorDto;
import controller.ProyectosController;
import controller.ProyectosController_Service;
import controller.ProyectosDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import task2.model.Administradordto;
import task2.model.Proyectodto;


/**
 *
 * @author ivana
 */
public class ProyectoService {
    
    ProyectosController_Service pservice = new ProyectosController_Service();
    ProyectosController pcontroller = pservice.getProyectosControllerPort();
    
    
    public List<Proyectodto> getTodos(){
        List<ProyectosDto> list1 = pcontroller.getProyectos();
        if(list1 != null){
            List<Proyectodto> list2 = new ArrayList();
            Proyectodto proy;
            for(ProyectosDto pro : list1){
                proy = new Proyectodto(pro);
                list2.add(proy);
            }
            return list2;
        }else{
            return null;
        }
    }
    
    public Proyectodto Guardar(Proyectodto pro){
        ProyectosDto proy = pro.DtoTodto();
        System.out.println("L1"); 
        pro = new Proyectodto(pcontroller.guardarProyectos(proy));
        System.out.println("l2");
        return pro;
    }
    
    public Integer Eliminar(Long id){
       return pcontroller.eliminarProyecto(id); 
    }
    
    public List<Proyectodto> filtrar(Administradordto adm, String nom){
        List<Proyectodto> lista = new ArrayList();
        AdministradorDto admDto = new AdministradorDto();
        List<ProyectosDto> list = pcontroller.filter(adm.AdministradordtoToDto(admDto), nom);
        if(list != null){
            for(ProyectosDto pro: list){
                lista.add(new Proyectodto(pro));
            }
            return lista;
        }else{
            return null;
        }
    }
    
    /**
     * 
     * @param no nombre
     * @param lt lider tecnico
     * @param p patrocinador
     * @return 
     */
    public List<Proyectodto> filtrar2(String no, String lt, String p){
        System.out.println(no+" "+lt+" "+p+"\n");
        List<Proyectodto> lista = new ArrayList();
        AdministradorDto admDto = new AdministradorDto();
        List<ProyectosDto> list = pcontroller.filter2(no, lt, no);
        if(list != null){
            for(ProyectosDto pro: list){
                lista.add(new Proyectodto(pro));
            }
            return lista;
        }else{
            return null;
        }
    }
    
    public List<Proyectodto> getActivos(){
        List<Proyectodto> list1 = new ArrayList<>();
        list1 = getTodos(); 
        list1 = list1.stream().filter(x->x.getProEstado().equals("C")).collect(Collectors.toList());
        return list1;
    }
}
