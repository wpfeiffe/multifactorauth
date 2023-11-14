package com.wspfeiffer.mfaserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping ("/thymeleaf")
    public String getThymeleafPage(Model model) {
        model.addAttribute("appname", "MfaServer");
        return "thymeleaf";
    }
}
