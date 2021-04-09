package se.lexicon.teri.mvc_thymeleaf_exercises.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    List<String> contacts;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam("new-contact") String newContact, Model model) {
        if (contacts == null) {
            contacts = new ArrayList<>();
        }
        contacts.add(newContact);

        String confirmationMessage = "Contact added: " + newContact + ".";
        model.addAttribute("confirmation", confirmationMessage);
        return "contact-confirmation";
    }

    @GetMapping("/contact-list")
    public String contactList(Model model) {
        if (contacts == null) {
            contacts = new ArrayList<>();
        }
        model.addAttribute("contacts", contacts);
        return "show-contacts";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
