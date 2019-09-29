/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.service;

import controller.SeguimientoController;
import controller.SeguimientoController_Service;
import controller.SeguimientoDto;
import java.util.ArrayList;
import java.util.List;
import task2.model.Seguimientodto;


/**
 *
 * @author Susana
 */

public class SeguimientoService {
    SeguimientoController_Service segC = new SeguimientoController_Service();
    SeguimientoController port = segC.getSeguimientoControllerPort();
    
    public Seguimientodto guardarSeguimiento(Seguimientodto seg){
        SeguimientoDto segDto = new SeguimientoDto();
        segDto = seg.toSeguimientoDto(segDto);
        segDto = port.guardarSeguimiento(segDto);
        
        seg = new Seguimientodto(segDto);
        return seg;
    }
    
    public List<Seguimientodto> getSeguimientos(Long proId){
        List<SeguimientoDto> segsDto = new ArrayList<>(); 
        List<Seguimientodto> segs = new ArrayList<>(); 
        segsDto = port.getSeguimientos(proId);
        for(SeguimientoDto s: segsDto){
            segs.add(new Seguimientodto(s));
        }
        return segs;
    }
    
    public String eliminarSeguimiento(Long segId){
        return port.eliminarSeguimiento(segId);
    }
}
