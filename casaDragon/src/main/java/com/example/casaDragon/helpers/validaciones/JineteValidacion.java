package com.example.casaDragon.helpers.validaciones;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component

public class JineteValidacion {
    //metodos que aplicaran las validaciones
    public boolean validarNombresJinete(String nombreJinete) throws Exception {
        //20 caracteres
        if(nombreJinete.length()>50){
            return false;
        }
        //el formato nombre tenga letras y espacion no numeros
        String expresionRegular="^[a-zA-Z\\s]+$";

        Pattern pattern=Pattern.compile(expresionRegular); //convierte una cadena en patron
        Matcher coincidencia=pattern.matcher(nombreJinete); //verifica que la cadena que voy a validar cumpla el patron
        if(!coincidencia.matches()){
            return false;
        }
        return true;
    }

    public boolean validarEdad(Integer edad){
        if(edad <= 0  || edad > 2000) {
            return false;
        }
        return true;
    }

    /*public boolean validarFechaMontura(localDate fechaMontura) {
        if(fechaMontura ) {
            return false;
        }
        return true;
    }*/

}
