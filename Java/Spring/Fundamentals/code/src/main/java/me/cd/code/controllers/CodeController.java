package me.cd.code.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
    @RequestMapping("/")
    static String index() {
        return "index.jsp";
    }

    @RequestMapping(value="/check-code", method=RequestMethod.POST)
    static String checkCode(HttpSession session, @RequestParam(value="code") String code, RedirectAttributes redirectAttributes) {
        if (!code.equals("secret_code")) {
            session.setAttribute("authorized", false);
            redirectAttributes.addFlashAttribute("error", "wrong code");        
            return "redirect:/";
        }
        session.setAttribute("authorized", true);
        return "redirect:secret-page";
    }

    @RequestMapping("/secret-page")
    static String secretPage(HttpSession session) {
        try {
            if (!(boolean) session.getAttribute("authorized")) {
                return "redirect:/";
            }
        } catch (Exception NullPointerException) {
            session.setAttribute("authorized", false);
            return "redirect:/";
        }
        return "secret-page.jsp";
    }
}
