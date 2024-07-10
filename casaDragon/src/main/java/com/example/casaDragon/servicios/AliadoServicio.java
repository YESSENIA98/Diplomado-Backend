package com.example.casaDragon.servicios;


import com.example.casaDragon.models.Aliado;
import com.example.casaDragon.repositories.AliadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AliadoServicio {
    //inyectar repositorio
    @Autowired
    AliadoRepositorio aliadoRepositorio;

    //agregarUnAliado
    public Aliado agregarAliado (Aliado datosAliado) throws Exception {
        //llamar a las validaciones
        try{
            return aliadoRepositorio.save(datosAliado);

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscarTodosAliados
    public List<Aliado> buscarAliado() throws Exception {
        try{
            return aliadoRepositorio.findAll();

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
