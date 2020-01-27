package com.tyraka.server.controllers;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyraka.server.entities.Test;
import com.tyraka.server.models.ResultModel;
import com.tyraka.server.models.ResultsModel;
import com.tyraka.server.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;


@CrossOrigin(origins = "https://s434624.students.wmi.amu.edu.pl")
@RestController
@RequestMapping("/api")
public class TestController {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private TestService testService;

    @RequestMapping(value = "tests", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Test> list(Model model) { return testService.listAllTests(); }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Integer create(@RequestBody @Valid @NotNull Test test) {
        testService.saveTest(test);
        return test.getId();
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Test test = testService.getTestById(id);
        try
        {
            Files.deleteIfExists(Paths.get(test.getResultsPath()));
        }
        catch(NoSuchFileException e)
        {
            System.out.println("No such file/directory exists");
        }
        catch(IOException e)
        {
            System.out.println("Invalid permissions.");
        }
        testService.deleteTest(id);
        return new ResponseEntity<>((HttpStatus.OK));

    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> addResults(@PathVariable Integer id, @RequestBody @NotNull Object results) {
        try {
            Test test = testService.getTestById(id);
            String filePath = "/home/readouts/" + test.getId() + ".json";

            mapper.writeValue(new File(filePath), results);
            test.setResultsPath(filePath);
            testService.saveTest(test);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @RequestMapping(value = "/testResults/{id}", method = RequestMethod.GET)
    public List<ResultModel> getResults(@PathVariable Integer id) {
        Test test = testService.getTestById(id);
        File testFile = new File(test.getResultsPath());
        ResultsModel results;
        results = null;
        try {
            results = mapper.readValue(testFile, ResultsModel.class);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return results.getResults();
    }
}
