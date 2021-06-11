package me.cd.waterbnb.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import me.cd.waterbnb.models.Pool;
import me.cd.waterbnb.models.User;
import me.cd.waterbnb.services.PoolService;
import me.cd.waterbnb.services.UserService;

@Controller
@RequestMapping("/host")
public class HostController {
    private final UserService userService;
    private final PoolService poolService;

    public HostController(UserService userService, PoolService poolService) {
        this.userService = userService;
        this.poolService = poolService;
    }
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User u = userService.findById((Long) session.getAttribute("userId"));
        model.addAttribute("user", u);
        model.addAttribute("pool", new Pool());
        return "dashboard.jsp";
    }

    @GetMapping("/pool/{id}")
    public String pool(@Valid @ModelAttribute("updatedPool") Pool updatedPool, @PathVariable("id") Long id, Model model) {
        Pool p = poolService.findById(id);
        model.addAttribute("pool", p);
        updatedPool.setDescription(p.getDescription());
        return "editPool.jsp";
    }
}
