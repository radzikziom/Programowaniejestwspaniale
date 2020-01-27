package com.tyraka.server.repositories;

import com.tyraka.server.entities.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Integer> {

    Iterable<Test> findAll();

    Test save(Test entity);
}
