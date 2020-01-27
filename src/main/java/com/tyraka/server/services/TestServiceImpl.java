package com.tyraka.server.services;

import com.tyraka.server.entities.Test;
import com.tyraka.server.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public Iterable<Test> listAllTests() { return testRepository.findAll(); }

    @Override
    public Test saveTest(Test entity) { return testRepository.save(entity); }

    @Override
    public Test getTestById(Integer id) { return testRepository.findById(id).get(); }

    @Override
    public void deleteTest(Integer id) { testRepository.delete(getTestById(id)); }

}
