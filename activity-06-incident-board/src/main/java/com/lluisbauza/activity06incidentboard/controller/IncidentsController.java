package com.lluisbauza.activity06incidentboard.controller;

import com.lluisbauza.activity06incidentboard.model.Incident;
import com.lluisbauza.activity06incidentboard.service.IncidentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IncidentsController {

    private final IncidentsService incidentsService;

    public IncidentsController(IncidentsService incidentsService) {
        this.incidentsService = incidentsService;
    }

    @GetMapping("/incidents")
    public String getIncidents(Model model) {

        var incidents = incidentsService.getIncidents();
        model.addAttribute("incidents", incidents);

        return "incidents.html";
    }

    @PostMapping("/incidents")
    public String postIncidents(
            @RequestParam String title,
            @RequestParam String category,
            @RequestParam String priority,
            Model model) {
        Incident incident = new Incident(title, category, priority);
        incidentsService.addIncident(incident);

        var incidents = incidentsService.getIncidents();
        model.addAttribute("incidents", incidents);

        return "incidents.html";
    }
}
