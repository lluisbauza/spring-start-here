package com.lluisbauza.activity06incidentboard.service;

import com.lluisbauza.activity06incidentboard.factory.IncidentFactory;
import com.lluisbauza.activity06incidentboard.model.Incident;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentsService {

    private final IncidentFactory incidentFactory;

    public IncidentsService(IncidentFactory incidentFactory) {
        this.incidentFactory = incidentFactory;
    }

    private List<Incident> incidents = new ArrayList<>();

    public void addIncident(Incident incident) {
        incidents.add(incident);
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public Optional<Incident> getIncidentById(int id) {

        for  (Incident incident : incidents) {
            if(incident.getId() == id) {
                return Optional.of(incident);
            }
        }

        return Optional.empty();
    }

    public List<Incident> getIncidentsByCategory(String category) {

        List<Incident> incidentsByCategory = new ArrayList<>();

        for(Incident incident : incidents) {
            if(incident.getCategory().equals(category)) {
                incidentsByCategory.add(incident);
            }
        }

        return incidentsByCategory;
    }
}
