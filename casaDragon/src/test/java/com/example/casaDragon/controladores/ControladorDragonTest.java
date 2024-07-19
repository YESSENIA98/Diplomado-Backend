package com.example.casaDragon.controladores;

import com.example.casaDragon.DTO.DragonDTO;
import com.example.casaDragon.models.Dragon;
import com.example.casaDragon.servicios.DragonServicio;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ControladorDragonTest {

    @Mock
    private DragonServicio dragonServicio;

    @InjectMocks
    private ControladorDragon controladorDragon;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void guardarDragonDevuelveDrafonDTO() throws Exception {
        //arrage
        DragonDTO dragonDTO = new DragonDTO();
        //cuando algo se ejecuta, que retorno...
        when(dragonServicio.agregarDragon(any(Dragon.class))).thenReturn(dragonDTO);

        //act (donde llamo al metodo que quiero probar)
        Dragon dragon = new Dragon();
        ResponseEntity<?> respuesta = controladorDragon.guardarDragon(dragon);

        //assert
        assertEquals(HttpStatus.OK,respuesta.getStatusCode());
        assertEquals(dragonDTO, respuesta.getBody());
    }

    //falla
    @Test
    public void guardarDragonOcurreErrorDevuelveMensaje() throws Exception {
        //Arrage
        String mensajeError = "Revisa los nombres del dragon";
        when(dragonServicio.agregarDragon(any(Dragon.class))).thenThrow(new Exception(mensajeError));

        //act
        Dragon dragon = new Dragon();
        ResponseEntity<?> respuesta = controladorDragon.guardarDragon(dragon);

        //assert
        assertEquals(HttpStatus.BAD_REQUEST, respuesta.getStatusCode());
    }
}