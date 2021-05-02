package me.cd.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value="", method=RequestMethod.GET)
    public String helloHuman(@RequestParam(value="name", required=false) String name) {
        if (name == null) {
            return "<h1>Hello Human</h1>";
        }
        return "<h1>Hello " + name + "</h1>";
    }
}
