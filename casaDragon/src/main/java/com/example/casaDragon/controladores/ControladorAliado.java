package com.example.casaDragon.controladores;

import com.example.casaDragon.models.Aliado;
import com.example.casaDragon.models.Jinete;
import com.example.casaDragon.servicios.AliadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("casadragonapi/v1/aliado")
public class ControladorAliado {
    //el controlador necesita el servicio, se inyecta el servicio
    @Autowired
    AliadoServicio aliadoServicio;

    @PostMapping
    //agregar un jinete
    public ResponseEntity<?> guardarAliado(@RequestBody Aliado datosClienteAliado) {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(aliadoServicio.agregarAliado(datosClienteAliado));


        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAliado(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(aliadoServicio.buscarAliadoPorId(id));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarAliados(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(aliadoServicio.buscarAliados());

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editarAliado(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarAliado(){
        return null;
    }
}
