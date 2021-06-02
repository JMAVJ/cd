package me.cd.dojos.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import me.cd.dojos.models.Ninja;
import me.cd.dojos.services.NinjaService;

@Controller
public class MainController {
    private final NinjaService ninjaService;

    public MainController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @RequestMapping("/")
    public String rootRedirect() {
        return "redirect:/page/1";
    }

    @RequestMapping("/page/{pageNumber}")
    public String index(Model model, @PathVariable("pageNumber") int pageNumber) {
        Page<Ninja> ninjas = ninjaService.ninjaPage(pageNumber);
        model.addAttribute("totalPages", ninjas.getTotalPages());
        model.addAttribute("ninjas", ninjas);
        return "index.jsp";
    }
}
