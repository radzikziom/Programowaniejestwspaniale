package com.tyraka.server.services;

import com.tyraka.server.entities.Test;

public interface TestService {

    Iterable<Test> listAllTests();

    Test saveTest(Test entity);

    Test getTestById(Integer id);

    void deleteTest(Integer id);
}
