package me.cd.dojos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.cd.dojos.models.Dojo;
import me.cd.dojos.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }
 
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newDojoView() {
        return "newDojo.jsp";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newDojo(@RequestParam("name") String name) {
        dojoService.add(name);
        return "redirect:/dojos/new";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String dojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.getById(id);
        model.addAttribute("dojo", dojo);
        return "dojo.jsp";
    }
}
