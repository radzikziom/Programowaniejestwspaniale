package com.tyraka.server.controllers;


import com.tyraka.server.entities.Engine;
import com.tyraka.server.services.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "https://s434624.students.wmi.amu.edu.pl")
@RestController
@RequestMapping("/api")
public class EngineController {

    @Autowired
    private EngineService engineService;

    @RequestMapping(value = "/engines", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Engine> list(Model model) { return engineService.listAllEngines(); }

    @RequestMapping(value = "/engine", method = RequestMethod.POST)
    public ResponseEntity<Engine> create(@RequestBody @Valid @NotNull Engine engine) {
        engineService.saveEngine(engine);
        return ResponseEntity.ok().body(engine);
    }

    @RequestMapping(value = "/engine/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        engineService.deleteEngine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
