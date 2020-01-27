package com.tyraka.server.services;

import com.tyraka.server.entities.Plug;
import com.tyraka.server.repositories.PlugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class PlugServiceImpl implements PlugService {

    @Autowired
    private PlugRepository plugRepository;

    @Override
    public Iterable<Plug> listAllPlugs() { return plugRepository.findAll(); }

    @Override
    public Optional<Plug> getPlugById(Integer id) { return plugRepository.findById(id); }

    @Override
    public Plug savePlug(Plug entity) { return plugRepository.save(entity); }

    @Override
    public void deletePlug(Integer id) { plugRepository.delete(getPlugById(id).get());}

}