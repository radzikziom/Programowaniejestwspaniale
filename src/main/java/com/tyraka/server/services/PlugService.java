package com.tyraka.server.services;

import com.tyraka.server.entities.Plug;


import java.util.Optional;

public interface PlugService {

    Iterable<Plug> listAllPlugs();

    Optional<Plug> getPlugById(Integer id);

    Plug savePlug(Plug entity);

    void deletePlug(Integer id);
}
