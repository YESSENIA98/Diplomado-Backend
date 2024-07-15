package com.example.casaDragon.servicios;


import com.example.casaDragon.DTO.AliadoDTO;
import com.example.casaDragon.helpers.MensajeServicios;
import com.example.casaDragon.mapas.IMapaAliado;
import com.example.casaDragon.models.Aliado;
import com.example.casaDragon.repositories.AliadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AliadoServicio {
    //inyectar repositorio
    @Autowired
    AliadoRepositorio aliadoRepositorio;

    @Autowired
    IMapaAliado iMapaAliado;

    //agregarUnAliado
    public AliadoDTO agregarAliado (Aliado datosAliado) throws Exception {
        //llamar a las validaciones
        try{
            return iMapaAliado.mapearAliado(aliadoRepositorio.save(datosAliado));

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscarTodosAliados
    public List<AliadoDTO> buscarAliados() throws Exception {
        try{
            return iMapaAliado.mapearListaAliados(aliadoRepositorio.findAll());

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscarUnAliadoPorLlavePrimaria
    public AliadoDTO buscarAliadoPorId(Integer idAliado) throws Exception {
        try {
            Optional<Aliado> aliadoEncontrado = aliadoRepositorio.findById(idAliado);
            if(aliadoEncontrado.isPresent()) {
                return iMapaAliado.mapearAliado(aliadoEncontrado.get());
            }else {
                throw new Exception(MensajeServicios.ALIADO_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error) {
            throw new Exception((error.getMessage()));
        }
    }

    //editarInformaciónAliado
    public AliadoDTO modificarAliado(Integer idAliado, Aliado datosNuevosAliado) throws Exception{
        try{
            //buscar aliado que me van a editar
            Optional<Aliado> aliadoEncontrado = aliadoRepositorio.findById(idAliado);
            if(aliadoEncontrado.isPresent()){
                //Traer los datos del aliado que estan en la BD
                Aliado aliado = aliadoEncontrado.get();

                //Guardo los datos nuevos del aliado utilizando el mismo objeto
                aliado.setNombres(datosNuevosAliado.getNombres());
                return iMapaAliado.mapearAliado(aliadoRepositorio.save(aliado)); //actualizar a la bd

            }else{
                throw new Exception(MensajeServicios.ALIADO_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //Eliminar aliado
    public boolean eliminarAliado(Integer id) throws Exception {
        try{
            Optional<Aliado> aliadoEncontrado = aliadoRepositorio.findById(id);
            if(aliadoEncontrado.isPresent()){
                aliadoRepositorio.deleteById(id);
                return true;

            }else{
                throw new Exception(MensajeServicios.ALIADO_NO_ENCONTRADO.getMensaje());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
