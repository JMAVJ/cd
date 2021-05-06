package me.cd.form.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping("/")
    static String index() {
        return "index.jsp";
    }

    @RequestMapping(value="/result", method=RequestMethod.POST)
    static String processData(@RequestBody MultiValueMap<String, String> formData, Model model) {
        Set<String> formKeys = formData.keySet();
        for (String key : formKeys) {
            model.addAttribute(key, formData.get(key).get(0));
        }
        return "result.jsp";
    }
}
