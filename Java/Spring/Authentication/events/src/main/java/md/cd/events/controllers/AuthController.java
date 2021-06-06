package md.cd.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import md.cd.events.models.User;
import md.cd.events.services.UserService;
import md.cd.events.validators.UserValidator;

@Controller
public class AuthController {
    private final UserService userService;
    private final UserValidator userValidator;

    public AuthController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/")
    public String auth(Model model, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/events";
        }
        model.addAttribute("user", new User());
        return "auth.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "auth.jsp";
        }
        User u = userService.register(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/events";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        if (!userService.authenticate(email, password)) {
            return "redirect:/";
        }
        User u = userService.findByEmail(email);
        session.setAttribute("userId", u.getId());
        return "redirect:/events";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
