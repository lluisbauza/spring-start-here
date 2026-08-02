package com.lluisbauza.service;

import com.lluisbauza.model.Incident;
import com.lluisbauza.repository.IncidentRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class IncidentReportService {

    private final IncidentRepository incidentRepository;

    public IncidentReportService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
        System.out.println("LOG: IncidentReportService bean generated due to Lazy implementation.");
    }

    public void generateReport() {
        System.out.println();
        System.out.println("--- Generating Incident Report ---");
        System.out.println("Number of Incidents: " + incidentRepository.getIncidents().size());
    }
}
