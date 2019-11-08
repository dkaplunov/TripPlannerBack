package org.kdalib.trip_planner.controllers;

import org.kdalib.trip_planner.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    AsyncService asyncService;

    @GetMapping
    public String root () {

        return "This is root";
    }

    @RequestMapping (value = "/test", method = RequestMethod.POST)
    public String doTest () {
        return "test is ok";
    }

    @RequestMapping (value = "/async", method = RequestMethod.POST)
    public String doAsync () throws Exception {
        asyncService.asyncMethod1(1);
        return "Async test is ok";
    }

}
