package com.tyraka.server.services;


import com.tyraka.server.entities.Engine;

public interface EngineService {

    Iterable<Engine> listAllEngines();

    Engine saveEngine(Engine entity);

    Engine getEngineById(Integer id);

    void deleteEngine(Integer id);
}
