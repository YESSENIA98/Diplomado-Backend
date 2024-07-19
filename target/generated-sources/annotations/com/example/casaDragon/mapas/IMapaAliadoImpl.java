package com.example.casaDragon.mapas;

import com.example.casaDragon.DTO.AliadoDTO;
import com.example.casaDragon.models.Aliado;
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
public class IMapaAliadoImpl implements IMapaAliado {

    @Override
    public AliadoDTO mapearAliado(Aliado aliado) {
        if ( aliado == null ) {
            return null;
        }

        AliadoDTO aliadoDTO = new AliadoDTO();

        aliadoDTO.setNombres( aliado.getNombres() );
        aliadoDTO.setUbicacion( aliado.getUbicacion() );

        return aliadoDTO;
    }

    @Override
    public List<AliadoDTO> mapearListaAliados(List<Aliado> listaAliados) {
        if ( listaAliados == null ) {
            return null;
        }

        List<AliadoDTO> list = new ArrayList<AliadoDTO>( listaAliados.size() );
        for ( Aliado aliado : listaAliados ) {
            list.add( mapearAliado( aliado ) );
        }

        return list;
    }
}
