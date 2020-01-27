package com.tyraka.server.repositories;

import com.tyraka.server.entities.Nozzle;
import org.springframework.data.repository.CrudRepository;

public interface NozzleRepository extends CrudRepository<Nozzle, Integer> {

    Iterable<Nozzle> findAll();

    Nozzle save(Nozzle entity);
}
