package com.tyraka.server.services;

import com.tyraka.server.entities.Nozzle;
import com.tyraka.server.repositories.NozzleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class NozzleServiceImpl implements NozzleService {

    @Autowired
    private NozzleRepository nozzleRepository;

    @Override
    public Iterable<Nozzle> listAllNozzles() { return nozzleRepository.findAll(); }

    @Override
    public Optional<Nozzle> getNozzleById(Integer id) { return nozzleRepository.findById(id); }

    @Override
    public Nozzle saveNozzle(Nozzle entity) { return nozzleRepository.save(entity); }

    @Override
    public void deleteNozzle(Integer id) { nozzleRepository.delete(getNozzleById(id).get()); }

}
