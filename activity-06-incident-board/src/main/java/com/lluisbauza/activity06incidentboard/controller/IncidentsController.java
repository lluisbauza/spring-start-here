package com.lluisbauza.activity06incidentboard.controller;

import com.lluisbauza.activity06incidentboard.model.Incident;
import com.lluisbauza.activity06incidentboard.service.IncidentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class IncidentsController {

    private final IncidentsService incidentsService;

    public IncidentsController(IncidentsService incidentsService) {
        this.incidentsService = incidentsService;
    }

    @GetMapping("/incidents")
    public String getIncidents(
            @RequestParam(required = false) String category,
            Model model) {

        var incidents = incidentsService.getIncidents();

        if (category != null) {
            var incidentsByCategory = incidentsService.getIncidentsByCategory(category);
            model.addAttribute("incidents", incidentsByCategory);
        } else {
            model.addAttribute("incidents", incidents);
        }

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

    @GetMapping("/incidents/{id}")
    public String getIncidentById(@PathVariable int id, Model model) {

        Optional<Incident> incident = incidentsService.getIncidentById(id);

        if (incident.isPresent()) {
            model.addAttribute("incident", incident.get());
            return "incident.html";
        } else {
            return "notfound.html";
        }

    }
}
