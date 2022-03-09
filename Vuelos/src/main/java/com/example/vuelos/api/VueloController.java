package com.example.vuelos.api;


import com.example.vuelos.model.Vuelo;
import com.example.vuelos.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/vuelo")
@RestController
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @PostMapping
    public void addVuelo(@NonNull @RequestBody Vuelo vuelo){
        vueloService.addVuelo(vuelo);

    }

    @GetMapping(path = "get")
    public List<Vuelo> getAllVuelo(){
        return vueloService.getAllVuelo();
    }

    @GetMapping(path = "get/{id}")
    public Vuelo getVuelobyId(@PathVariable("id") UUID id){
        return vueloService.getVuelobyId(id).orElse(null);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteVuelobyId(@PathVariable("id") UUID id){
        vueloService.deleteVuelo(id);
    }

    @PutMapping(path = "update/{id}")
    public void updateVuelobyId(@PathVariable("id") UUID id,@NonNull @RequestBody Vuelo newVuelo){
        vueloService.updateVuelo(id,newVuelo);
    }
}