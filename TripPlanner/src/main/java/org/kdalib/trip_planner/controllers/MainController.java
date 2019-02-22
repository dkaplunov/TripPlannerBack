package org.kdalib.trip_planner.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String root () {

        return "This is root";
    }

    @RequestMapping (value = "/test", method = RequestMethod.GET)
    public String doTest () {
        return "test is ok";
    }

}
