package me.cd.languages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.cd.languages.models.Language;
import me.cd.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("languages", languageService.getAll());
        return "index.jsp";
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public String addLanguage(@RequestParam(name="name") String name, @RequestParam(name="creator") String creator, @RequestParam(name="version") String version) {
        Language language = new Language(name, creator, version);
        languageService.save(language);
        return "redirect:/languages";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String getLanguage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("language", languageService.getById(id));
        return "language.jsp";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteLanguage(@PathVariable("id") Long id) {
        languageService.deleteById(id);
        return "redirect:/languages";
    }

    @RequestMapping(value="/{id}/edit")
    public String editView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("language", languageService.getById(id));
        return "edit.jsp";
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String updateLanguage(@PathVariable("id") Long id, @RequestParam(name="name") String name, @RequestParam(name="creator") String creator, @RequestParam(name="version") String version) {
        Language newData = new Language(name, creator, version);
        Language language = languageService.update(id, newData);
        return "redirect:/languages/" + language.getId();
    }
}
