package com.tyraka.server.repositories;

import com.tyraka.server.entities.Engine;
import org.springframework.data.repository.CrudRepository;

public interface EngineRepository extends CrudRepository<Engine, Integer> {

    Iterable<Engine> findAll();

    Engine save(Engine entity);
}
