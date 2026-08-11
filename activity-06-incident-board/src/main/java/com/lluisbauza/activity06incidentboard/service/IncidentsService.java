package com.lluisbauza.activity06incidentboard.service;

import com.lluisbauza.activity06incidentboard.factory.IncidentFactory;
import com.lluisbauza.activity06incidentboard.model.Incident;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentsService {

    private final IncidentFactory incidentFactory;

    public IncidentsService(IncidentFactory incidentFactory) {
        this.incidentFactory = incidentFactory;
    }

    private List<Incident> incidents = new ArrayList<>();

    public void addIncident(Incident incident) {
        var createdIncident = incidentFactory.createIncident(incident.getTitle(), incident.getCategory(), incident.getPriority());

        incidents.add(createdIncident);
    }

    public List<Incident> getIncidents() {
        return incidents;
    }
}
