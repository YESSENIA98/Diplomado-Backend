package com.example.casaDragon.servicios;

import com.example.casaDragon.models.Dragon;
import com.example.casaDragon.repositories.DragonRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DragonServicio {
    //inyectar repositorio
    @Autowired
    DragonRepositorio dragonRepositorio;

    //agregarUnDragon
    public Dragon agregarDragon(Dragon datosDragon) throws Exception {
        //llamar a las validaciones
        try{
            return dragonRepositorio.save(datosDragon);

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //buscarTodosDragones
    public List<Dragon> buscarDragones() throws Exception {
        try{
            return dragonRepositorio.findAll();

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscarUnDragonPorLlavePrimaria

}
