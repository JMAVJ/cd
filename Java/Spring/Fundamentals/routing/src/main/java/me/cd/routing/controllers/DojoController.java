package me.cd.routing.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
    
    @RequestMapping(value="/{route}", method=RequestMethod.GET)
    public String dojo(@PathVariable("route") String route) {
        if (route.equals("dojo")) {
            return "Dojo";
        }
        if (route.equals("burbank-dojo")) {
            return "Burbank Dojo";
        }
        if (route.equals("san-jose")) {
            return "San José Dojo";
        }
        return "unknown route";
    }
}
