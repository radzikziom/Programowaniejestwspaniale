package com.tyraka.server.controllers;

import com.tyraka.server.entities.Plug;
import com.tyraka.server.services.PlugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@CrossOrigin(origins = "https://s434624.students.wmi.amu.edu.pl")
@RestController
@RequestMapping("/api")
public class PlugController {

    @Autowired
    private PlugService plugService;

    @RequestMapping(value = "plugs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Plug> list(Model model) { return plugService.listAllPlugs(); }

    @RequestMapping(value = "/plugs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Plug> show(@PathVariable Integer id, Model model) { return plugService.getPlugById(id); }

    @RequestMapping(value = "plug", method = RequestMethod.POST)
    public ResponseEntity<Plug> create(@RequestBody @Valid @NotNull Plug plug) {
        plugService.savePlug(plug);
        return ResponseEntity.ok().body(plug);
    }

    @RequestMapping(value = "/plug/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id, Model model) {
        plugService.deletePlug(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
