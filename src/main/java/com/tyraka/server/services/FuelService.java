package com.tyraka.server.services;

import com.tyraka.server.entities.Fuel;

import java.util.Optional;

public interface FuelService {

    Iterable<Fuel> listAllFuels();

    Optional<Fuel> getFuelById(Integer id);

    Fuel saveFuel(Fuel entity);

    void deleteFuel(Integer id);
}
