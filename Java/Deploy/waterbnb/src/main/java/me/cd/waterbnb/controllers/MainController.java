package me.cd.waterbnb.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.cd.waterbnb.services.PoolService;


@Controller
public class MainController {
    public final PoolService poolService;

    public MainController(PoolService poolService) {
        this.poolService = poolService;
    }

    @GetMapping(value="/")
    public String home(HttpSession session) {
        return "index.jsp";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam("location") String location, Model model) {   
        model.addAttribute("pools", poolService.findByAddress(location));
        return "search.jsp";
    }
}
