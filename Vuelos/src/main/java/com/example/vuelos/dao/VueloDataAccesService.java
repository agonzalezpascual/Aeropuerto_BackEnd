package com.example.vuelos.dao;



import com.example.vuelos.model.Vuelo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class VueloDataAccesService implements VueloDao{


    private final JdbcTemplate jdbcTemplate;

    public VueloDataAccesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertVuelo(UUID uuid, Vuelo vuelo) {
        final String sql = "INSERT INTO vuelo (id, piloto, numPas, origen, destino) VALUES (?,?,?,?,?) ;";
        return jdbcTemplate.update(sql, uuid, vuelo.getPiloto(), vuelo.getNumPas(), vuelo.getOrigen(), vuelo.getDestino());
    }

    @Override
    public List<Vuelo> selectAllVuelo() {
        final String sql = "SELECT * FROM vuelo;";
        return jdbcTemplate.query(sql, (resulset, i) -> {
            UUID id = UUID.fromString(resulset.getString("id"));
            String piloto = resulset.getString("piloto");
            int numPas = Integer.parseInt(resulset.getString("numPas"));
            String destino = resulset.getString("destino");
            String origen = resulset.getString("origen");

            return new Vuelo(id, piloto, numPas, origen, destino);
        });
    }

    @Override
    public int deleteVuelobyId(UUID uuid) {
        final String sql = "DELETE FROM vuelo WHERE id = ? ;";
        return jdbcTemplate.update(sql, uuid);

    }

    @Override
    public int updateVuelobyId(UUID uuid, Vuelo vuelo) {
        final String sql = "UPDATE vuelo set origen = ?, destino = ? WHERE id = ?;";
        return jdbcTemplate.update(sql, vuelo.getOrigen(),vuelo.getDestino() ,uuid);
    }

    @Override
    public Optional<Vuelo> selectVuelobyId(UUID id) {
        final String sql = "SELECT * FROM vuelo where id = ?;";
        Vuelo vuelo = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resulset, i) -> {
            UUID uuid = UUID.fromString(resulset.getString("id"));
            String piloto = resulset.getString("piloto");
            int numPas = Integer.parseInt(resulset.getString("numPas"));
            String destino = resulset.getString("destino");
            String origen = resulset.getString("origen");

            return new Vuelo(uuid, piloto, numPas, origen, destino);
        });
        return Optional.ofNullable(vuelo);
    }
}
