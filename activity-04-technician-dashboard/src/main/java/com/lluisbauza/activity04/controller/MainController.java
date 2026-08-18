package com.lluisbauza.activity04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/incidents")
    public String incidents() {
        return "incidents.html";
    }

    @RequestMapping("/technicians")
    public String technicians() {
        return "technicians.html";
    }

}