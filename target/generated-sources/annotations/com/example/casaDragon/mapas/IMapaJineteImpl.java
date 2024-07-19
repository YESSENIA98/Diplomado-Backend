package com.example.casaDragon.mapas;

import com.example.casaDragon.DTO.JineteDTO;
import com.example.casaDragon.models.Jinete;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-19T11:26:39-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class IMapaJineteImpl implements IMapaJinete {

    @Override
    public JineteDTO mapearJinete(Jinete jinete) {
        if ( jinete == null ) {
            return null;
        }

        JineteDTO jineteDTO = new JineteDTO();

        jineteDTO.setNombres( jinete.getNombres() );
        jineteDTO.setEdad( jinete.getEdad() );

        return jineteDTO;
    }

    @Override
    public List<JineteDTO> mapearListaJinetes(List<Jinete> listaJinetes) {
        if ( listaJinetes == null ) {
            return null;
        }

        List<JineteDTO> list = new ArrayList<JineteDTO>( listaJinetes.size() );
        for ( Jinete jinete : listaJinetes ) {
            list.add( mapearJinete( jinete ) );
        }

        return list;
    }
}
