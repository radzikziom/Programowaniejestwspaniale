package com.tyraka.server.services;


import com.tyraka.server.entities.Engine;
import com.tyraka.server.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnginesServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Iterable<Engine> listAllEngines() { return engineRepository.findAll(); }

    @Override
    public Engine saveEngine(Engine entity) { return engineRepository.save(entity); }

    @Override
    public Engine getEngineById(Integer id) { return engineRepository.findById(id).get(); }

    @Override
    public void deleteEngine(Integer id) { engineRepository.delete(getEngineById(id)); }
}
