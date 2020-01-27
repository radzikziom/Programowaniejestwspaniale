package com.tyraka.server.repositories;

import com.tyraka.server.entities.Fuel;
import org.springframework.data.repository.CrudRepository;

public interface FuelRepository extends CrudRepository <Fuel, Integer> {

    Iterable<Fuel> findAll();

    Fuel save(Fuel entity);
}

