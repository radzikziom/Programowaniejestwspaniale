package com.tyraka.server.repositories;

import com.tyraka.server.entities.Plug;
import org.springframework.data.repository.CrudRepository;

public interface PlugRepository extends CrudRepository<Plug, Integer> {

    Iterable<Plug> findAll();

    Plug save(Plug entity);
}
