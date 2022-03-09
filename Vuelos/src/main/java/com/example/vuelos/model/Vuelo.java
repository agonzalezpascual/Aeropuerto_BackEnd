package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Vuelo {

    UUID idVuelo;
    String piloto;
    int numPas;
    String origen;
    String destino;

    public Vuelo(@JsonProperty("idVuelo") UUID idVuelo, @JsonProperty("piloto") String piloto, @JsonProperty("numPas") int numPas, @JsonProperty("origen") String origen, @JsonProperty("destino") String destino) {
        this.idVuelo = idVuelo;
        this.piloto = piloto;
        this.numPas = numPas;
        this.origen = origen;
        this.destino = destino;
    }

    public UUID getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(UUID idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public int getNumPas() {
        return numPas;
    }

    public void setNumPas(int numPas) {
        this.numPas = numPas;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
