package com.tyraka.server.controllers;

import com.tyraka.server.entities.Body;
import com.tyraka.server.services.BodyService;
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
public class BodyController {

    @Autowired
    private BodyService bodyService;

    @RequestMapping(value = "/bodys", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Body> list(Model model) { return bodyService.listAllBodys(); }

    @RequestMapping(value = "/bodys/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Body show(@PathVariable Integer id, Model model) { return bodyService.getBodyById(id); }

    @RequestMapping(value = "/body", method = RequestMethod.POST)
    public ResponseEntity<Body> create(@RequestBody @Valid @NotNull Body body) {
        bodyService.saveBody(body);
        return ResponseEntity.ok().body(body);
    }

    @RequestMapping(value = "/body/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id, Model model) {
        bodyService.deleteBody(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
