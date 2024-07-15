package com.example.casaDragon.mapas;

import com.example.casaDragon.DTO.AliadoDTO;
import com.example.casaDragon.models.Aliado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaAliado {
    @Mappings({
            @Mapping(source = "nombres", target = "nombres"),
            @Mapping(source = "ubicacion", target = "ubicacion")
    })

    public AliadoDTO mapearAliado(Aliado aliado);
    public List<AliadoDTO> mapearListaAliados(List<Aliado> listaAliados);
}
