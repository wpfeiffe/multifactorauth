package com.wspfeiffer.mfaserver.controllers;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("htmx")
public class HtmxController {

    @GetMapping("first")
    String getFirst(Model model) {
        model.addAttribute("appname", "MfaServer-HTMX");
        return "htmx-first";
    }

    @HxRequest("trigger-btn")
    @GetMapping("/populate-names")
    String populateNames (Model model) {
        model.addAttribute("names", List.of(
                "Bill Pfeiffer",
                "Deanna Pfeiffer",
                "Brian Pfeiffer",
                "Liam Pfeiffer"));
        return "populate-names";
    }
}
