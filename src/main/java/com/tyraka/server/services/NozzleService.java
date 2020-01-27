package com.tyraka.server.services;

import com.tyraka.server.entities.Nozzle;

import java.util.Optional;

public interface NozzleService {
    Iterable<Nozzle> listAllNozzles();

    Optional<Nozzle> getNozzleById(Integer id);

    Nozzle saveNozzle(Nozzle entity);

    void deleteNozzle(Integer id);
}
