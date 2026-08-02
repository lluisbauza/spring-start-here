package com.lluisbauza.repository;

import com.lluisbauza.model.Incident;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IncidentRepository {

    List<Incident> incidents = new ArrayList<>();

    public void addIncident(Incident incident) {
        incidents.add(incident);
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

}
