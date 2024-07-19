package com.example.casaDragon.mapas;

import com.example.casaDragon.DTO.DragonDTO;
import com.example.casaDragon.models.Dragon;
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
public class IMapaDragonImpl implements IMapaDragon {

    @Override
    public DragonDTO mapearDragon(Dragon dragon) {
        if ( dragon == null ) {
            return null;
        }

        DragonDTO dragonDTO = new DragonDTO();

        dragonDTO.setNombres( dragon.getNombres() );
        dragonDTO.setEdad( dragon.getEdad() );

        return dragonDTO;
    }

    @Override
    public List<DragonDTO> mapearListaDragones(List<Dragon> listaDragones) {
        if ( listaDragones == null ) {
            return null;
        }

        List<DragonDTO> list = new ArrayList<DragonDTO>( listaDragones.size() );
        for ( Dragon dragon : listaDragones ) {
            list.add( mapearDragon( dragon ) );
        }

        return list;
    }
}
