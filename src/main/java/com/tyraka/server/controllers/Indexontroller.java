package com.tyraka.server.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Indexontroller {

    @RequestMapping(value = "", method = RequestMethod.GET)
    String index() { return "Welcome to tyraka app!"; }
}
