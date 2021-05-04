package me.cd.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping("/")
    static String home(HttpSession session) {
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 0);
        } else {
            int actualCount = (int) session.getAttribute("counter");
            session.setAttribute("counter", actualCount + 1);
        }
        return "index.jsp";
    }

    @RequestMapping("/counter")
    static String counter() {
        return "counter.jsp";
    }
}