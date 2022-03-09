package com.example.vuelos.service;


import com.example.vuelos.dao.VueloDao;
import com.example.vuelos.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VueloService {

    private final VueloDao vueloDao;

    @Autowired
    public VueloService(@Qualifier("postgres") VueloDao vueloDao) {
        this.vueloDao = vueloDao;
    }


    public int addVuelo(Vuelo vuelo){
        return vueloDao.insertVuelo(vuelo);

    }

    public List<Vuelo> getAllVuelo(){
        return vueloDao.selectAllVuelo();
    }

    public Optional<Vuelo> getVuelobyId(UUID id){
        return vueloDao.selectVuelobyId(id);
    }

    public int deleteVuelo(UUID id){
        return vueloDao.deleteVuelobyId(id);
    }

    public int updateVuelo(UUID id, Vuelo newVuelo){
        return vueloDao.updateVuelobyId(id, newVuelo);
    }
}
