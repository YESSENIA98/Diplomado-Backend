package com.example.casaDragon.servicios;



import com.example.casaDragon.DTO.JineteDTO;
import com.example.casaDragon.helpers.MensajeServicios;
import com.example.casaDragon.mapas.IMapaJinete;
import com.example.casaDragon.models.Jinete;
import com.example.casaDragon.repositories.JineteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JineteServicio {
    //inyectar repositorio
    @Autowired
    JineteRepositorio jineteRepositorio;

    @Autowired
    IMapaJinete iMapaJinete;

    //agregarUnDragon
    public JineteDTO agregarJinete (Jinete datosJinete) throws Exception {
        //llamar a las validaciones
        try{
            return iMapaJinete.mapearJinete(jineteRepositorio.save(datosJinete));

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscarTodosJinetes
    public List<JineteDTO> buscarJinetes() throws Exception {
        try{
            return iMapaJinete.mapearListaJinetes(jineteRepositorio.findAll());

        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscarUnJinetePorLlavePrimaria
    public JineteDTO buscarJinetePorId(Integer idJinete) throws Exception {
        try {
            Optional<Jinete> jineteEncontrado = jineteRepositorio.findById(idJinete);
            if(jineteEncontrado.isPresent()) {
                return iMapaJinete.mapearJinete(jineteEncontrado.get());
            }else {
                throw new Exception(MensajeServicios.JINETE_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error) {
            throw new Exception((error.getMessage()));
        }
    }

    //editarInformaciónJinete
    public JineteDTO modificarJinete(Integer idJinete, Jinete datosNuevosJinete) throws Exception{
        try{
            //buscar jinete que me van a editar
            Optional<Jinete> jineteEncontrado = jineteRepositorio.findById(idJinete);
            if(jineteEncontrado.isPresent()){
                //Traer los datos del jinete que estan en la BD
                Jinete jinete = jineteEncontrado.get();

                //Guardo los datos nuevos del jinete utilizando el mismo objeto
                jinete.setEdad(datosNuevosJinete.getEdad());
                return iMapaJinete.mapearJinete(jineteRepositorio.save(jinete)); //actualizar a la bd

            }else{
                throw new Exception(MensajeServicios.JINETE_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //Eliminar Jinete
    public boolean eliminarJinete(Integer id) throws Exception {
        try{
            Optional<Jinete> jineteEncontrado = jineteRepositorio.findById(id);
            if(jineteEncontrado.isPresent()){
                jineteRepositorio.deleteById(id);
                return true;

            }else{
                throw new Exception(MensajeServicios.JINETE_NO_ENCONTRADO.getMensaje());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
