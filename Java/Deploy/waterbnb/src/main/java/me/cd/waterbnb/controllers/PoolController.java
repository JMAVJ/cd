package me.cd.waterbnb.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.cd.waterbnb.models.Pool;
import me.cd.waterbnb.models.Review;
import me.cd.waterbnb.models.User;
import me.cd.waterbnb.services.PoolService;
import me.cd.waterbnb.services.UserService;

@Controller
@RequestMapping("/pools")
public class PoolController {
    private final PoolService poolService;
    private final UserService userService;

    public PoolController(PoolService poolService, UserService userService) {
        this.poolService = poolService;
        this.userService = userService;
    }
    
    @PostMapping("/new")
    public String newPool(@Valid @ModelAttribute("pool") Pool pool, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "dashboard.jsp";
        }
        poolService.add(pool, (Long) session.getAttribute("userId"));
        return "/host/dashboard";
    }

    @GetMapping("/{id}")
    public String pool(@PathVariable("id") Long id, Model model) {
        Pool p = poolService.findById(id);
        model.addAttribute("pool", p);
        return "pool.jsp";
    }

    @GetMapping("/{id}/review")
    public String review(@Valid @ModelAttribute("review") Review review, @PathVariable("id") Long poolId, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/guest/signin";
        }
        Pool p = poolService.findById(poolId);
        if (userId.equals(p.getHost().getId())) {
            return "redirect:/host/dashboard";
        }
        model.addAttribute("pool", p);
        return "review.jsp";
    }

    @PostMapping("/review")
    public String postReview(@Valid @ModelAttribute("review") Review review, @RequestParam("poolId") Long poolId, HttpSession session) {
        Pool pool = poolService.findById(poolId);
        User user = userService.findById((Long) session.getAttribute("userId"));
        poolService.addReview(user, pool, review);
        return "redirect:/pools/" + pool.getId();
    }

    @PostMapping("/edit")
    public String editPool(@Valid @ModelAttribute("updatedPool") Pool updatedPool, BindingResult result, @RequestParam("poolId") Long poolId, HttpSession session) {
        if (result.hasErrors()) {
            return "editPool.jsp";
        }
        Pool pool = poolService.findById(poolId);
        Long userId = (Long) session.getAttribute("userId");
        if (!userId.equals(pool.getHost().getId())) {
            return "redirect:/";
        }
        pool = poolService.update(pool, updatedPool);
        return "redirect:/pools/" + pool.getId();
    }
}
