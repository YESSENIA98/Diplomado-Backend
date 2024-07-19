package com.example.casaDragon.controladores;

import com.example.casaDragon.DTO.DragonDTO;
import com.example.casaDragon.models.Dragon;
import com.example.casaDragon.servicios.DragonServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("casadragonapi/v1/dragon")
@Tag(name="Servicios Dragon", description = "Servicios asociados a la tabla Dragon de la bd dragrones, se hace CRUD completo")
public class ControladorDragon {

    //el controlador necesita el servicio, se inyecta el servicio
    @Autowired
    DragonServicio dragonServicio;

    @PostMapping
    @Operation(
            summary = "Registra un dragon nuevo en la base de datos",
            description = "Al llevar nombres, edad, altura se registra con éxito el dragon"
    )
    @ApiResponses(
            value= {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Dragon creado con éxito en BD",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DragonDTO.class),
                                    examples = @ExampleObject(value = "{\"nombres\":\"Letti\", \"edad\":\"400\"}")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error al registrar el Dragon",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class),
                                    examples = @ExampleObject(value = "{\"error\":\"Datos invalidos\"}")
                            )
                    )
            }
    )

    //agregar un dragon
    public ResponseEntity<?> guardarDragon(@RequestBody Dragon datosClienteDragon) {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(dragonServicio.agregarDragon(datosClienteDragon));


        }catch (Exception error){
            Map<String, Object> mensajeError = new HashMap<>();
            mensajeError.put("error", error.getMessage());
            mensajeError.put("HoraError", LocalDateTime.now());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(mensajeError);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarDragones(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(dragonServicio.buscarDragones());

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDragon(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(dragonServicio.buscarDragonPorId(id));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> editarDragon(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarDragon(){
        return null;
    }
}
