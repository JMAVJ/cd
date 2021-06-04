package me.cd.views.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.cd.views.models.User;
import me.cd.views.services.UserService;

@Controller
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "registerPage.jsp";
        }
        userService.registerUser(user);
        User newUser = userService.findByEmail(user.getEmail());
        session.setAttribute("userId", newUser.getId());
        return "redirect:/home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        boolean isAuth = userService.authenticateUser(email, password);
        if (isAuth) {
            User user = userService.findByEmail(email);
            session.setAttribute("userId", user.getId());
            return "redirect:/home";
        }
        redirectAttributes.addFlashAttribute("error", "Wrong email or password");
        return "redirect:/login";
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        User user = userService.findUserById((Long) session.getAttribute("userId"));
        model.addAttribute("user", user);
        return "homePage.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
