package me.cd.waterbnb.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.cd.waterbnb.models.TypeEnum;
import me.cd.waterbnb.models.User;
import me.cd.waterbnb.services.UserService;
import me.cd.waterbnb.validators.UserValidator;


@Controller
public class AuthController {
    private final UserService userService;
    private final UserValidator userValidator;

    public AuthController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/guest/signin")
    public String authView(@Valid @ModelAttribute("user") User user) {
        return "auth.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "auth.jsp";
        }
        userService.add(user);
        return "redirect:/guest/signin";
    }

    @PostMapping(value="/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        if (!userService.authenticate(email, password)) { 
            return "auth.jsp"; 
        }
        User u = userService.findByEmail(email);
        session.setAttribute("userId", u.getId());
        if (u.getUserType() == TypeEnum.HOST) {
            return "redirect:/host/dashboard";
        }
        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
