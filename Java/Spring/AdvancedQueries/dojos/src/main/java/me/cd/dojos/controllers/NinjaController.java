package me.cd.dojos.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.cd.dojos.models.Ninja;
import me.cd.dojos.services.DojoService;
import me.cd.dojos.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newNinjaView(Model model) {
        model.addAttribute("ninja", new Ninja());
        model.addAttribute("dojos", dojoService.getAll());
        return "newNinja.jsp";
    }
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja) {
        Ninja newNinja = ninjaService.add(ninja);
        return "redirect:/dojos/" + newNinja.getDojo().getId();
    }
}
