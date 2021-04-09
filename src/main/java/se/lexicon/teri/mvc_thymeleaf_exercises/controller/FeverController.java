package se.lexicon.teri.mvc_thymeleaf_exercises.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class FeverController {

//    24C = dead; 32C = medical emergency/see a doctor; 35C = hypothermia; 36.5C - 37.5C = normal; 37.5 = fever; 41C = medical emergency/see a doctor; 44C = dead

    @GetMapping("fever-check")
    public String checkFever() {
        return "fever-check";
    }

    @PostMapping("/fever-check")
    public String checkFever(@RequestParam("temp") double temp, Model model) {
        String resultMessage = "";
        String heading = "";

        if (temp <= 32.0) {
            heading = "Medical emergency!";
            resultMessage = "You have severe hypothermia. See a doctor immediately.";
        }
        if (temp > 32.0 && temp <= 35.0) {
            heading = "Your temperature is low";
            resultMessage = "You have hypothermia. Wrap yourself in blankets and drink a warm beverage.";
        }
        if (temp > 35.0 && temp <= 37.5) {
            heading = "Your temperature is normal";
            resultMessage = "Your body temperature is within the normal range.";
        }
        if (temp > 37.5 && temp <= 40.9) {
            heading = "Your temperature is high";
            resultMessage = "You have a fever. Drink lots of water and rest.";
        }
        if (temp > 40.9) {
            heading = "Medical emergency!";
            resultMessage = "You have a severe fever. See a doctor immediately.";
        }

        model.addAttribute("heading", heading);
        model.addAttribute("temp", temp);
        model.addAttribute("confirmation", resultMessage);
        return "fever-confirmation";
    }
}
