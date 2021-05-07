package me.cd.gold.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

@Controller
public class MainController {
    @RequestMapping("/")
    static String root() {
        return "redirect:/gold";
    }

    @RequestMapping(value="/gold", method=RequestMethod.GET)
    static String index(HttpSession session) {
        if (session.getAttribute("gold") == null || session.getAttribute("activities") == null) {
            session.setAttribute("gold", 0);
            List<String> activity = new ArrayList<String>();
            session.setAttribute("activities", activity);
        }
        return "index.jsp";
    }

    @RequestMapping(value="/gold", method=RequestMethod.POST)
    static String gold(@RequestParam(name="place") String place, HttpSession session) {
        Random r = new Random();
        int actualGold = (int) session.getAttribute("gold");
        int goldEarned = 0;
        if (place.equals("farm")) {
            goldEarned = r.nextInt(20 - 10) + 10;
        } else if (place.equals("cave")) {
            goldEarned = r.nextInt(10 - 5) + 5;
        } else if (place.equals("house")) {
            goldEarned = r.nextInt(5 - 2) + 2;
        } else if (place.equals("casino")) {
            goldEarned = r.nextInt(50);
            if (!r.nextBoolean()) {
                goldEarned = -goldEarned;
            }
        }
        String currentActivity = "You entered a " + place + " and " + (goldEarned > 0 ? "earned " : "lost ") + goldEarned + " gold";
        List<String> activities = (ArrayList<String>) session.getAttribute("activities");
        activities.add(currentActivity);
        System.out.println(activities);
        session.setAttribute("activities", activities);
        session.setAttribute("gold", actualGold + goldEarned);
        return "redirect:/gold";
    }
}
