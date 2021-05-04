package me.cd.date.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class HomeController {
    @RequestMapping("/")
    static String index() {
        return "index.jsp";
    }

    @RequestMapping("/date")
    static String date(Model model) {
        Date date = new Date();
        String formattedDate = new SimpleDateFormat("E, dd MM, yyyy").format(date);
        model.addAttribute("date", formattedDate);
        return "date.jsp";
    }

    @RequestMapping("/time")
    static String time(Model model) {
        Date date = new Date();
        String formattedTime = new SimpleDateFormat("hh:mm a").format(date);
        model.addAttribute("time", formattedTime);
        return "time.jsp";
    }

}