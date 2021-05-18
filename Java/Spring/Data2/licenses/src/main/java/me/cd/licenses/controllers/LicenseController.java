package me.cd.licenses.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.cd.licenses.models.License;
import me.cd.licenses.services.LicenseService;
import me.cd.licenses.services.PersonService;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
    public final LicenseService licenseService;
    public final PersonService personService;

    public LicenseController(LicenseService licenseService, PersonService personService) {
        this.licenseService = licenseService;
        this.personService = personService;
    }
    
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String newLicense(Model model) {
        model.addAttribute("persons", personService.getAll());
        model.addAttribute("license", new License());
        return "newLicense.jsp";
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public String newLicense(@RequestParam("personId") Long personId, @RequestParam("state") String state, @RequestParam("expiration") String expiration) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedExpiration = format.parse(expiration);
            License license = new License(personService.findById(personId), state, parsedExpiration);
            license = licenseService.add(license);
            return "redirect:/persons/" + license.getPerson().getId();
        } catch (ParseException e) {
            return "redirect:/licenses/new";
        }
    }
}
