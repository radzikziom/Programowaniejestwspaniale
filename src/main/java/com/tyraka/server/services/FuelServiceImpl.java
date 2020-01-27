package com.tyraka.server.services;

import com.tyraka.server.entities.Fuel;
import com.tyraka.server.repositories.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuelServiceImpl implements FuelService {

    @Autowired
    private FuelRepository fuelRepository;

    @Override
    public Iterable<Fuel> listAllFuels() { return fuelRepository.findAll(); }

    @Override
    public Optional<Fuel> getFuelById(Integer id) { return fuelRepository.findById(id); }

    @Override
    public Fuel saveFuel(Fuel entity) { return fuelRepository.save(entity); }

    @Override
    public void deleteFuel(Integer id) { fuelRepository.delete(getFuelById(id).get()); }
}
