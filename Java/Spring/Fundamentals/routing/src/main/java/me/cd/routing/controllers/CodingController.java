package me.cd.routing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {

    @RequestMapping(value="", method=RequestMethod.GET)
    public String coding() {
        return "Hello World!";
    }
    
    @RequestMapping(value="/python", method=RequestMethod.GET)
    public String python() {
        return "Django";
    }

    @RequestMapping(value="/java", method=RequestMethod.GET)
    public String java() {
        return "Spring";
    }
}
