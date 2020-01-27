package com.tyraka.server.services;

import com.tyraka.server.entities.Body;
import com.tyraka.server.repositories.BodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BodyServiceImpl implements BodyService {

    @Autowired
    private BodyRepository bodyRepository;

    @Override
    public Iterable<Body> listAllBodys() { return bodyRepository.findAll(); }

    @Override
    public Body getBodyById(Integer id) { return bodyRepository.findById(id).get(); }

    @Override
    public Body saveBody(Body entity) { return  bodyRepository.save(entity); }


    @Override
    public void deleteBody(Integer id) { bodyRepository.delete(getBodyById(id)); }
}
