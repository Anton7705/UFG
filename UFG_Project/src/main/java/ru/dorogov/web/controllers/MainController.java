package ru.dorogov.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/root")
    public String homeRoot (Model model) {
        model.addAttribute("title", "UfgProject");
        return "home";
    }
}
