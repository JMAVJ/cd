package me.cd.licenses.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.cd.licenses.models.Person;
import me.cd.licenses.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "newPerson.jsp";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "newPerson.jsp";
        }
        person = personService.add(person);
        return "redirect:/persons/" + person.getId();
    }

    @RequestMapping(value="/{id}")
    public String getPerson(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "person.jsp";
    }
}
