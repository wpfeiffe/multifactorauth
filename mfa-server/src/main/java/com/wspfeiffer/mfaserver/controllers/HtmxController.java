package com.wspfeiffer.mfaserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("htmx")
public class HtmxController {

    @GetMapping("first")
    String getFirst(Model model) {
        model.addAttribute("appname", "MfaServer-HTMX");
        return "htmx-first";
    }
}
