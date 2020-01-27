package com.tyraka.server.services;

import com.tyraka.server.entities.Body;

public interface BodyService {

    Iterable<Body> listAllBodys();

    Body getBodyById(Integer id);

    Body saveBody(Body entity);

    void deleteBody(Integer id);
}
