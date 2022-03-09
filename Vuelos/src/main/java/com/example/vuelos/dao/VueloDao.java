package com.example.vuelos.dao;



import com.example.vuelos.model.Vuelo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VueloDao {

    int insertVuelo (UUID uuid, Vuelo vuelo);

    default int insertVuelo(Vuelo vuelo){
        UUID id = UUID.randomUUID();
        return insertVuelo(id, vuelo);
    }

    List<Vuelo> selectAllVuelo();

    int deleteVuelobyId (UUID uuid);

    int updateVuelobyId (UUID uuid,Vuelo vuelo);

    Optional<Vuelo> selectVuelobyId (UUID id);
}
